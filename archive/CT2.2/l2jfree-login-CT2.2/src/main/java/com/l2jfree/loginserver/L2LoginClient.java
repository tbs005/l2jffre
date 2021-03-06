/* This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 *
 * http://www.gnu.org/copyleft/gpl.html
 */
package com.l2jfree.loginserver;

import java.io.IOException;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.security.interfaces.RSAPrivateKey;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mmocore.network.ISocket;
import org.mmocore.network.MMOConnection;
import org.mmocore.network.SelectorThread;

import com.l2jfree.loginserver.beans.SessionKey;
import com.l2jfree.loginserver.crypt.LoginCrypt;
import com.l2jfree.loginserver.manager.LoginManager;
import com.l2jfree.loginserver.serverpackets.LoginFail;
import com.l2jfree.loginserver.serverpackets.PlayFail;
import com.l2jfree.tools.math.ScrambledKeyPair;
import com.l2jfree.tools.random.Rnd;

/**
 * Represents a client connected into the LoginServer
 * 
 * @author KenM
 */
public class L2LoginClient extends MMOConnection<L2LoginClient>
{
	private static final Log _log = LogFactory.getLog(L2LoginClient.class);
	
	public static enum LoginClientState
	{
		CONNECTED,
		AUTHED_GG,
		AUTHED_LOGIN;
	}
	
	private LoginClientState _state = LoginClientState.CONNECTED;
	
	// Crypt
	private LoginCrypt _loginCrypt;
	private final ScrambledKeyPair _scrambledPair;
	private final byte[] _blowfishKey;
	
	private String _account;
	private int _accessLevel;
	private int _lastServerId;
	private int _age;
	private SessionKey _sessionKey;
	private final int _sessionId = Rnd.nextInt(Integer.MAX_VALUE);
	private boolean _joinedGS;
	private final String _ip;
	
	public L2LoginClient(SelectorThread<L2LoginClient> selectorThread, ISocket socket, SelectionKey key)
	{
		super(selectorThread, socket, key);
		
		_ip = getSocket().getInetAddress().getHostAddress();
		
		_scrambledPair = LoginManager.getInstance().getScrambledRSAKeyPair();
		_blowfishKey = LoginManager.getInstance().getBlowfishKey();
	}
	
	private LoginCrypt getLoginCrypt()
	{
		if (_loginCrypt == null)
		{
			_loginCrypt = new LoginCrypt();
			_loginCrypt.setKey(_blowfishKey);
		}
		
		return _loginCrypt;
	}
	
	public String getIp()
	{
		return _ip;
	}
	
	/**
	 * @see com.l2jserver.mmocore.interfaces.MMOClient#decrypt(java.nio.ByteBuffer, int)
	 */
	@Override
	public boolean decrypt(ByteBuffer buf, int size)
	{
		boolean ret = false;
		try
		{
			ret = getLoginCrypt().decrypt(buf.array(), buf.position(), size);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			closeNow();
			return false;
		}
		
		if (!ret)
		{
			byte[] dump = new byte[size];
			System.arraycopy(buf.array(), buf.position(), dump, 0, size);
			_log.warn("Wrong checksum from client: " + toString());
			closeNow();
		}
		
		return ret;
	}
	
	/**
	 * @see com.l2jserver.mmocore.interfaces.MMOClient#encrypt(java.nio.ByteBuffer, int)
	 */
	@Override
	public boolean encrypt(ByteBuffer buf, int size)
	{
		final int offset = buf.position();
		try
		{
			size = getLoginCrypt().encrypt(buf.array(), offset, size);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return false;
		}
		
		buf.position(offset + size);
		return true;
	}
	
	public LoginClientState getState()
	{
		return _state;
	}
	
	public void setState(LoginClientState state)
	{
		_state = state;
	}
	
	public byte[] getBlowfishKey()
	{
		return _blowfishKey;
	}
	
	public byte[] getScrambledModulus()
	{
		return _scrambledPair.getScrambledModulus();
	}
	
	public RSAPrivateKey getRSAPrivateKey()
	{
		return (RSAPrivateKey)_scrambledPair.getPair().getPrivate();
	}
	
	public String getAccount()
	{
		return _account;
	}
	
	public void setAccount(String account)
	{
		_account = account;
	}
	
	public void setAccessLevel(int accessLevel)
	{
		_accessLevel = accessLevel;
	}
	
	public int getAccessLevel()
	{
		return _accessLevel;
	}
	
	public void setLastServerId(int lastServerId)
	{
		_lastServerId = lastServerId;
	}
	
	public int getLastServerId()
	{
		return _lastServerId;
	}

	public void setAge(int year, int month, int day) {
	    Calendar dateOfBirth = new GregorianCalendar(year, month-1, day);
	    Calendar today = Calendar.getInstance();
	    int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
	    dateOfBirth.add(Calendar.YEAR, age);
	    if (today.before(dateOfBirth))
	        age--;

		_age = age;
	}

	public int getAge() {
		return _age;
	}
	
	public int getSessionId()
	{
		return _sessionId;
	}
	
	public void setSessionKey(SessionKey sessionKey)
	{
		_sessionKey = sessionKey;
	}
	
	public boolean hasJoinedGS()
	{
		return _joinedGS;
	}
	
	public void setJoinedGS(boolean val)
	{
		_joinedGS = val;
	}
	
	public SessionKey getSessionKey()
	{
		return _sessionKey;
	}

	public void closeLogin(int reason)
	{
		close(new LoginFail(reason));
	}

	public void closeLoginGame(int reason)
	{
		close(new PlayFail(reason));
	}

	public void closeBanned()
	{
		close(new LoginFail(getAccessLevel(), true));
	}

	//public static int failcode = 100;

	public void closeBanned(int timeLeft)
	{
		//if (timeLeft == -1) {
			closeLogin(LoginFail.REASON_IP_RESTRICTED);
			//-45 to 200 = nothing
			//closeLogin(failcode);
			//failcode++;
			//_log.info(failcode);
		/*}
		else {
			close(new LoginFail(LoginFail.REASON_TEMP_BAN));
			close(new SystemMessage(LoginFail.REASON_TEMP_BAN).addNumber(timeLeft));
		}*/
	}

	public InetAddress getInetAddress()
	{
		return getSocket().getInetAddress();
	}
	
	@Override
	public void onDisconnection()
	{
		if (_log.isDebugEnabled())
			_log.info("onDisconnection: " + this);
		
		// If player was not on GS, don't forget to remove it from authed login on LS
		if (getState() == LoginClientState.AUTHED_LOGIN && !hasJoinedGS())
		{
			LoginManager.getInstance().removeAuthedLoginClient(getAccount());
		}
	}
	
	@Override
	protected void onForcedDisconnection()
	{
		if (_log.isDebugEnabled())
			_log.info("onForcedDisconnection: " + this);
	}
	
	@Override
	public String toString()
	{
		InetAddress address = getSocket().getInetAddress();
		if (getState() == LoginClientState.AUTHED_LOGIN)
			return "[" + getAccount() + " (" + (address == null ? "disconnected" : address.getHostAddress()) + ")]";
		else
			return "[" + (address == null ? "disconnected" : address.getHostAddress()) + "]";
	}
}
