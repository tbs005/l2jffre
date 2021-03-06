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

import com.l2jfree.gameserver.handler.AdminCommandHandler;
import com.l2jfree.gameserver.handler.IAdminCommandHandler;
import com.l2jfree.gameserver.model.actor.instance.L2PcInstance;

/**
 *
 * @author  poltomb
 */
public class AdminSummon implements IAdminCommandHandler
{
	protected static Log			_log			= LogFactory.getLog(AdminSummon.class.getName());

	public static final String[]	ADMIN_COMMANDS	=
													{ "admin_summon" };

	/**
	 * @see net.sf.l2j.gameserver.handler.IAdminCommandHandler#getAdminCommandList()
	 */
	@Override
	public String[] getAdminCommandList()
	{

		return ADMIN_COMMANDS;
	}

	/**
	 * @see net.sf.l2j.gameserver.handler.IAdminCommandHandler#useAdminCommand(java.lang.String, net.sf.l2j.gameserver.model.actor.instance.L2PcInstance)
	 */
	@Override
	public boolean useAdminCommand(String command, L2PcInstance activeChar)
	{
		int id;
		int count = 1;
		String[] data = command.split(" ");
		try
		{
			id = Integer.parseInt(data[1]);
			if (data.length > 2)
			{
				count = Integer.parseInt(data[2]);
			}
		}
		catch (NumberFormatException nfe)
		{
			activeChar.sendMessage("Incorrect format for command 'summon'");
			return false;
		}

		String subCommand;
		if (id < 1000000)
		{
			subCommand = "admin_create_item";
			IAdminCommandHandler ach = AdminCommandHandler.getInstance().getAdminCommandHandler(subCommand);
			ach.useAdminCommand(subCommand + " " + id + " " + count, activeChar);
		}
		else
		{
			subCommand = "admin_spawn";
			IAdminCommandHandler ach = AdminCommandHandler.getInstance().getAdminCommandHandler(subCommand);

			activeChar.sendMessage("This is only a temporary spawn.  The mob(s) will NOT respawn.");
			id -= 1000000;
			ach.useAdminCommand(subCommand + " " + id + " " + count, activeChar);
		}
		return true;
	}
}