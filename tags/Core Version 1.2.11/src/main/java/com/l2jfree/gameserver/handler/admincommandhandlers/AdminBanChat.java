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
package com.l2jfree.gameserver.handler.admincommandhandlers;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.l2jfree.Config;
import com.l2jfree.gameserver.handler.IAdminCommandHandler;
import com.l2jfree.gameserver.model.L2Object;
import com.l2jfree.gameserver.model.L2World;
import com.l2jfree.gameserver.model.actor.instance.L2PcInstance;
import com.l2jfree.gameserver.model.restriction.AvailableRestriction;
import com.l2jfree.gameserver.model.restriction.ObjectRestrictions;
import com.l2jfree.gameserver.model.restriction.RestrictionBindClassException;

/**
 * This class handles following admin commands:
 * - admin_banchat = Imposes a chat ban on the specified player/target.
 * - admin_unbanchat = Removes any chat ban on the specified player/target.
 * 
 * Uses:
 * admin_banchat [<player_name>] [<ban_duration>]
 * admin_unbanchat [<player_name>]
 * 
 * If <player_name> is not specified, the current target player is used.
 * 
 * @version $Revision: 1.1.6.3 $ $Date: 2005/04/11 10:06:06 $
 */
public class AdminBanChat implements IAdminCommandHandler
{
	private final static Log		_log			= LogFactory.getLog(AdminBan.class.getName());
	private static final String[]	ADMIN_COMMANDS	=
													{ "admin_banchat", "admin_unbanchat" };
	private static final int		REQUIRED_LEVEL	= Config.GM_BAN_CHAT;

	public boolean useAdminCommand(String command, L2PcInstance activeChar)
	{
		if (!Config.ALT_PRIVILEGES_ADMIN)
		{
			if (!(checkLevel(activeChar.getAccessLevel())))
			{
				_log.info("Not required level for " + activeChar.getName());
				return false;
			}
		}

		String[] cmdParams = command.split(" ");
		long banLength = -1;

		L2Object targetObject = null;
		L2PcInstance targetPlayer = null;

		if (cmdParams.length > 1)
		{
			targetPlayer = L2World.getInstance().getPlayer(cmdParams[1]);

			if (cmdParams.length > 2)
			{
				try
				{
					banLength = Integer.parseInt(cmdParams[2]);
				}
				catch (NumberFormatException nfe)
				{
				}
			}
		}
		else
		{
			if (activeChar.getTarget() != null)
			{
				targetObject = activeChar.getTarget();

				if (targetObject != null && targetObject instanceof L2PcInstance)
					targetPlayer = (L2PcInstance) targetObject;
			}
		}

		if (targetPlayer == null)
		{
			activeChar.sendMessage("Incorrect parameter or target.");
			return false;
		}

		if (command.startsWith("admin_banchat"))
		{
			String banLengthStr = "";

			if (banLength > -1)
			{
				try
				{
					ObjectRestrictions.getInstance().addRestriction(targetPlayer, AvailableRestriction.PlayerChat);
					ObjectRestrictions.getInstance().timedRemoveRestriction(targetPlayer.getObjectId(),
							AvailableRestriction.PlayerChat, banLength * 60000,
							targetPlayer.getName() + "'s chat ban has now been lifted.");
				}
				catch (RestrictionBindClassException e)
				{
					e.getMessage();
				}
					
				banLengthStr = " for " + banLength + " minutes.";
			}
			else
			{
				try
				{
					ObjectRestrictions.getInstance().addRestriction(targetPlayer, AvailableRestriction.PlayerChat);
				}
				catch (RestrictionBindClassException e)
				{
					e.getMessage();
				}
			}

			activeChar.sendMessage(targetPlayer.getName() + " is now chat banned" + banLengthStr + ".");
			targetPlayer.setChatBanned(true);
		}
		else if (command.startsWith("admin_unbanchat"))
		{
			ObjectRestrictions.getInstance().removeRestriction(targetPlayer, AvailableRestriction.PlayerChat);
			activeChar.sendMessage(targetPlayer.getName() + "'s chat ban has now been lifted.");
		}

		return true;
	}

	public String[] getAdminCommandList()
	{
		return ADMIN_COMMANDS;
	}

	private boolean checkLevel(int level)
	{
		return (level >= REQUIRED_LEVEL);
	}
}
