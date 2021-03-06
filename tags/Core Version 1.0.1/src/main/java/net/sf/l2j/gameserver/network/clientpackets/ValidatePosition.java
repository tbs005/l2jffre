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
package net.sf.l2j.gameserver.network.clientpackets;

import net.sf.l2j.Config;
import net.sf.l2j.gameserver.GeoData;
import net.sf.l2j.gameserver.TaskPriority;
import net.sf.l2j.gameserver.geoeditorcon.GeoEditorListener;
import net.sf.l2j.gameserver.instancemanager.SiegeManager;
import net.sf.l2j.gameserver.model.actor.instance.L2PcInstance;
import net.sf.l2j.gameserver.model.entity.Siege;
import net.sf.l2j.gameserver.model.mapregion.TeleportWhereType;
import net.sf.l2j.gameserver.model.zone.L2Zone;
import net.sf.l2j.gameserver.network.SystemMessageId;
import net.sf.l2j.gameserver.network.serverpackets.PartyMemberPosition;
import net.sf.l2j.gameserver.network.serverpackets.SystemMessage;
import net.sf.l2j.gameserver.network.serverpackets.ValidateLocation;
import net.sf.l2j.gameserver.network.serverpackets.ValidateLocationInVehicle;
import net.sf.l2j.tools.random.Rnd;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * This class ...
 *
 * @version $Revision: 1.13.4.7 $ $Date: 2005/03/27 15:29:30 $
 */
public class ValidatePosition extends L2GameClientPacket
{
    private final static Log _log = LogFactory.getLog(ValidatePosition.class.getName());
    private static final String _C__48_VALIDATEPOSITION = "[C] 48 ValidatePosition";

    /** urgent messages, execute immediatly */
    public TaskPriority getPriority() { return TaskPriority.PR_HIGH; }

    private int _x;
    private int _y;
    private int _z;
    private int _heading;
    @SuppressWarnings("unused")
    private int _data;
    /**
     * packet type id 0x48
     * format:      cddddd
     * @param decrypt
     */
    @Override
    protected void readImpl()
    {
        try
        {
            _x  = readD();
            _y  = readD();
            _z  = readD();
            _heading  = readD();
            _data  = readD();
        }
        catch(Throwable t)
        {
        	int location[][] = {
        		{ 46934,51467,-2977 },		{ 9745,15606,-4574 },		{ -80826,149775,-3043 },
        		{ 15670,142983,-2705 },		{ -44836,-112524,-235 },	{ 115113,-178212,-901 },
        		{ -84318,244579,-3730 },	{ 46934,51467,-2977 },		{ 9745,15606,-4574 },
        		{ -12672,122776,-3116 }},
        		i = Rnd.get(10);
        	_x = location[i][0];
        	_y = location[i][1];
        	_z = location[i][2];
        	_heading = 0;
        	getClient().getActiveChar().teleToLocation(_x, _y, _z);
        }
    }

    @Override
    protected void runImpl()
    {
        L2PcInstance activeChar = getClient().getActiveChar();
        if (activeChar == null || activeChar.isTeleporting()) return;

        if (Config.GEODATA
                && (activeChar.isInOlympiadMode() || activeChar.isInsideZone(L2Zone.FLAG_SIEGE))
                && !activeChar.isFlying()
                && GeoData.getInstance().hasGeo(_x, _y))
        {
            // check Z coordinate sent by client
            short geoHeight = GeoData.getInstance().getSpawnHeight(_x, _y, activeChar.getZ()-30, activeChar.getZ()+30, activeChar.getObjectId());
            if (Math.abs(geoHeight - _z) > 15)
            {
                // causes mild flashing in the middle of a drop from a castle wall for example
                _z = geoHeight;
                // System.out.println("Spawnheight validation diff="+Math.abs(geoHeight - _z));
            }
        }

        if (Config.COORD_SYNCHRONIZE > 0)
        {
            activeChar.setClientX(_x);
            activeChar.setClientY(_y);
            activeChar.setClientZ(_z);
            activeChar.setClientHeading(_heading);
            int realX = activeChar.getX();
            int realY = activeChar.getY();
            // int realZ = activeChar.getZ();

            double dx = _x - realX;
            double dy = _y - realY;
            double diffSq = (dx*dx + dy*dy);

            /*
            if (_log.isDebugEnabled() )
            {
            	int dxs = (_x - activeChar._lastClientPosition.x);
            	int dys = (_y - activeChar._lastClientPosition.y);
            	int dist = (int)Math.sqrt(dxs*dxs + dys*dys);
            	int heading = dist > 0 ? (int)(Math.atan2(-dys/dist, -dxs/dist) * 10430.378350470452724949566316381) + 32768 : 0;
                _log.debug("Client X:" + _x + ", Y:" + _y + ", Z:" + _z + ", H:" + _heading + ", Dist:" + activeChar.getLastClientDistance(_x, _y, _z));
                _log.debug("Server X:" + realX + ", Y:" + realY + ", Z:" + realZ + ", H:" + activeChar.getHeading() + ", Dist:" + activeChar.getLastServerDistance(realX, realY, realZ));
			}
			*/

            if (diffSq > 0 && diffSq < 250000) // if too large, messes observation
            {
                if ((Config.COORD_SYNCHRONIZE & 1) == 1
                    && (!activeChar.isMoving() // character is not moving, take coordinates from client
                    || !activeChar.validateMovementHeading(_heading))) // Heading changed on client = possible obstacle
                {
                    if (_log.isDebugEnabled()) _log.debug(activeChar.getName() + ": Synchronizing position Client --> Server" + (activeChar.isMoving()?" (collision)":" (stay sync)"));
                    if (diffSq < 2500) // 50*50 - attack won't work fluently if even small differences are corrected
                    	activeChar.getPosition().setXYZ(realX, realY, _z);
                    else
                    	activeChar.getPosition().setXYZ(_x, _y, _z);
                    activeChar.setHeading(_heading);
                }
                else if ((Config.COORD_SYNCHRONIZE & 2) == 2
                        && diffSq > 10000) // more than can be considered to be result of latency
                {
                    if (_log.isDebugEnabled())  _log.debug(activeChar.getName() + ": Synchronizing position Server --> Client");
                    if (activeChar.isInBoat())
                    {
                        sendPacket(new ValidateLocationInVehicle(activeChar));
                    }
                    else
                    {
                    	activeChar.sendPacket(new ValidateLocation(activeChar));
                    }
                }
            }
            activeChar.setLastClientPosition(_x, _y, _z);
            activeChar.setLastServerPosition(activeChar.getX(), activeChar.getY(), activeChar.getZ());
        }
        else if (Config.COORD_SYNCHRONIZE == -1)
        {
            activeChar.setClientX(_x);
            activeChar.setClientY(_y);
            activeChar.setClientZ(_z);
            activeChar.setClientHeading(_heading); // No real need to validate heading.
            int realX = activeChar.getX();
            int realY = activeChar.getY();
            int realZ = activeChar.getZ();

            double dx = _x - realX;
            double dy = _y - realY;
            double diffSq = (dx*dx + dy*dy);
            if (diffSq < 250000)
                 activeChar.getPosition().setXYZ(realX,realY,_z);


            if (_log.isDebugEnabled())
            {
                _log.debug("client pos: "+ _x + " "+ _y + " "+ _z +" head "+ _heading);
                _log.debug("server pos: "+ realX + " "+realY+ " "+realZ +" head "+activeChar.getHeading());
            }

            if (Config.DEVELOPER)
            {
                if (diffSq > 1000000) {
                    if (_log.isDebugEnabled()) _log.info("client/server dist diff "+ (int)Math.sqrt(diffSq));
                    if (activeChar.isInBoat())
                    {
                        sendPacket(new ValidateLocationInVehicle(activeChar));
                    }
                    else
                    {
                    	activeChar.sendPacket(new ValidateLocation(activeChar));
                    }
                }
            }
        }
		if(activeChar.getParty() != null)
			activeChar.getParty().broadcastToPartyMembers(activeChar,new PartyMemberPosition(activeChar));

		if (!activeChar.isInWater() && !activeChar.isFlying())
			activeChar.isFalling(true,0); // Check if the L2Character isFalling

		if (Config.ACCEPT_GEOEDITOR_CONN)
		{
			if (GeoEditorListener.getInstance().getThread() != null
				&& GeoEditorListener.getInstance().getThread().isWorking()
				&& GeoEditorListener.getInstance().getThread().isSend(activeChar))
			{
				GeoEditorListener.getInstance().getThread().sendGmPosition(_x,_y,(short)_z);
			}
		}

		// [L2J_JP ADD START SANDMAN]
		// if this is a castle that is currently being sieged, and the rider is NOT a castle owner
		// he cannot flying.
		// castle owner is the leader of the clan that owns the castle where the pc is
		if ((!Config.ALT_FLYING_WYVERN_IN_SIEGE) && (activeChar.getMountType() == 2))
		{
            Siege siege = SiegeManager.getInstance().getSiege(activeChar.getClan());
            if (siege != null
	            && (!(activeChar.getClan().getHasCastle() == siege.getCastle().getCastleId()) &&
                    (activeChar.getClan().getLeaderId() == activeChar.getObjectId())))

		    {
		        SystemMessage sm = new SystemMessage(SystemMessageId.AREA_CANNOT_BE_ENTERED_WHILE_MOUNTED_WYVERN);
		        activeChar.sendPacket(sm);
                sm = null;
		        activeChar.teleToLocation(TeleportWhereType.Town);
		    }
		}
    }

    /* (non-Javadoc)
     * @see net.sf.l2j.gameserver.clientpackets.ClientBasePacket#getType()
     */
    @Override
    public String getType()
    {
        return _C__48_VALIDATEPOSITION;
    }

    @Deprecated
    public boolean equal(ValidatePosition pos)
    {
        return _x == pos._x && _y == pos._y && _z == pos._z && _heading == pos._heading;
    }
}