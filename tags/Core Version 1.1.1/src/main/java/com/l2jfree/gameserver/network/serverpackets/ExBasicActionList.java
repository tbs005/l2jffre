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
package com.l2jfree.gameserver.network.serverpackets;

/**
 *
 * @author  KenM
 */
public class ExBasicActionList extends L2GameServerPacket
{
    private static final String _S__FE_5E_EXBASICACTIONLIST = "[S] FE:5F ExBasicActionList";

    private final int[] _actionIds;

    public static final ExBasicActionList DEFAULT_ACTION_LIST = new ExBasicActionList();

    private ExBasicActionList()
    {
        this(ExBasicActionList.getDefaultActionList());
    }

    public ExBasicActionList(int... actionIds)
    {
        _actionIds = actionIds;
    }

    public static int[] getDefaultActionList()
    {
        int count1 = 62; // 0 <-> (count1 - 1)
        int count2 = 51; // 1000 <-> (1000 + count2 - 1)
        int[] actionIds = new int[count1 + 1 + 51];
        for (int i = 0; i < actionIds.length; i++)
        {
            actionIds[i] = 0 + i;
        }
        for (int i = 1000; i < 1000+count2; i++)
        {
            actionIds[i - 1000 + count1] = i;
        }
        return actionIds;
    }

    /**
     * @see com.l2jfree.gameserver.serverpackets.L2GameServerPacket#writeImpl()
     */
    @Override
    protected void writeImpl()
    {
        writeC(0xfe);
        writeH(0x5f);
        writeD(_actionIds.length);
        for (int i = 0; i < _actionIds.length; i++)
        {
            writeD(_actionIds[i]);
        }
    }

    /**
     * @see com.l2jfree.gameserver.serverpackets.L2GameServerPacket#getType()
     */
    @Override
    public String getType()
    {
        return _S__FE_5E_EXBASICACTIONLIST;
    }
}
