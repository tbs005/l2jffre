/*
 * This program is free software; you can redistribute it and/or modify
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
package net.sf.l2j.gameserver.clientpackets;

import java.nio.ByteBuffer;

import net.sf.l2j.Config;
import net.sf.l2j.gameserver.model.L2World;
import net.sf.l2j.gameserver.model.actor.instance.L2PcInstance;
import net.sf.l2j.gameserver.network.L2GameClient;
import net.sf.l2j.gameserver.serverpackets.FriendRecvMsg;
import net.sf.l2j.gameserver.serverpackets.SystemMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Recieve Private (Friend) Message - 0xCC
 * 
 * Format: c SS
 * 
 * S: Message
 * S: Receiving Player
 * 
 * @author Tempy
 * 
 */
public class RequestSendFriendMsg extends ClientBasePacket
{
    private static final String _C__CC_REQUESTSENDMSG = "[C] CC RequestSendMsg";
	private static Log _logChat = LogFactory.getLog("chat");
    
    private String _message;
    private String _reciever;
    
    public RequestSendFriendMsg(ByteBuffer buf, L2GameClient client)
    {
        super(buf, client);
        _message = readS();
        _reciever = readS();
    }

    void runImpl()
    {
    	L2PcInstance activeChar = getClient().getActiveChar();
        if (activeChar == null) return;
        
        L2PcInstance targetPlayer = L2World.getInstance().getPlayer(_reciever);
        
        if (targetPlayer == null && _message != null && activeChar != null) 
        {
        	activeChar.sendPacket(new SystemMessage(SystemMessage.PLAYER_NOT_ONLINE));
        	return;
        }
        
		if (Config.LOG_CHAT) 
		{
			_logChat.info("PRIV_MSG" + "[" + activeChar.getName() + " to "+ _reciever +"]" + _message);
		}
        
        FriendRecvMsg frm = new FriendRecvMsg(activeChar.getName(), _reciever, _message);
        targetPlayer.sendPacket(frm);
    }

    public String getType()
    {
        return _C__CC_REQUESTSENDMSG;
    }
}
