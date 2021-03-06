/*
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.l2j.gameserver.network.serverpackets;

import net.sf.l2j.gameserver.model.actor.instance.L2PcInstance;

public class CharSelected extends L2GameServerPacket
{
	private static final String _S__0B_activeCharRSELECTED = "[S] 0b CharSelected [sdsddddddddddffdqdddddddddddd ddddddddddddddddddddddddddd ff ddd c hh d]";
	private L2PcInstance _activeChar;
	private int _sessionId;

	/**
	 * @param _activeCharracters
	 */
	public CharSelected(L2PcInstance cha, int sessionId)
	{
		_activeChar = cha;
		_sessionId = sessionId;
	}

	@Override
	protected final void writeImpl()
	{
		writeC(0x0b);

		writeS(_activeChar.getName());
		writeD(_activeChar.getCharId());
		writeS(_activeChar.getTitle());
		writeD(_sessionId);
		writeD(_activeChar.getClanId());
		writeD(0x00);  //??
		writeD(_activeChar.getAppearance().getSex()? 1 : 0);
		writeD(_activeChar.getRace().ordinal());
		writeD(_activeChar.getClassId().getId());
		writeD(0x01); // active ??
		writeD(_activeChar.getX());	
		writeD(_activeChar.getY());	
		writeD(_activeChar.getZ());	

		writeF(_activeChar.getStatus().getCurrentHp());  
		writeF(_activeChar.getStatus().getCurrentMp());  
		writeD(_activeChar.getSp());
		writeQ(_activeChar.getExp());
		writeD(_activeChar.getLevel());
		writeD(_activeChar.getKarma());
		writeD(0x0);	//?
		writeD(_activeChar.getINT()); 
		writeD(_activeChar.getStat().getSTR()); 
		writeD(_activeChar.getStat().getCON()); 
		writeD(_activeChar.getStat().getMEN()); 
		writeD(_activeChar.getStat().getDEX()); 
		writeD(_activeChar.getStat().getWIT()); 
		
		writeD(0x00);
		writeD(0x00);

		writeD(_activeChar.getClassId().getId());
		writeD(0x00);
		writeD(0x00);
		writeD(0x00);
		writeD(0x00); 
        
        writeB(new byte[64]);
 
	}

	/* (non-Javadoc)
	 * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#getType()
	 */
	@Override
	public String getType()
	{
		return _S__0B_activeCharRSELECTED;
	}
}
