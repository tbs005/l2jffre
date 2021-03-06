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
package com.l2jfree.gameserver.taskmanager;

import javolution.util.FastMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.l2jfree.gameserver.ThreadPoolManager;
import com.l2jfree.gameserver.model.L2Character;
import com.l2jfree.gameserver.model.L2Summon;
import com.l2jfree.gameserver.model.actor.instance.L2CubicInstance;
import com.l2jfree.gameserver.model.actor.instance.L2PcInstance;
import com.l2jfree.gameserver.network.serverpackets.AutoAttackStop;

/**
 * This class ...
 * 
 * @version $Revision: $ $Date: $
 * @author  Luca Baldi
 */
public class AttackStanceTaskManager
{
	protected static Log					_log				= LogFactory.getLog(AttackStanceTaskManager.class.getName());

	protected FastMap<L2Character, Long>	_attackStanceTasks	= new FastMap<L2Character, Long>().setShared(true);

	private static AttackStanceTaskManager	_instance;

	public AttackStanceTaskManager()
	{
		ThreadPoolManager.getInstance().scheduleAiAtFixedRate(new FightModeScheduler(), 0, 1000);
	}

	public static AttackStanceTaskManager getInstance()
	{
		if (_instance == null)
			_instance = new AttackStanceTaskManager();

		return _instance;
	}

	public void addAttackStanceTask(L2Character actor)
	{
		_attackStanceTasks.put(actor, System.currentTimeMillis());
		if (actor instanceof L2Summon)
		{
			L2Summon summon = (L2Summon) actor;
			actor = summon.getOwner();
		}
		if (actor instanceof L2PcInstance)
		{
			L2PcInstance player = (L2PcInstance) actor;
			for (L2CubicInstance cubic : player.getCubics().values())
				if (cubic.getId() != L2CubicInstance.LIFE_CUBIC)
					cubic.doAction();
		}
	}

	public void removeAttackStanceTask(L2Character actor)
	{
		_attackStanceTasks.remove(actor);
	}

	public boolean getAttackStanceTask(L2Character actor)
	{
		return _attackStanceTasks.containsKey(actor);
	}

	private class FightModeScheduler implements Runnable
	{
		protected FightModeScheduler()
		{
			// Do nothing
		}

		public void run()
		{
			Long current = System.currentTimeMillis();
			if (_attackStanceTasks != null)
				synchronized (this)
				{
					for (L2Character actor : _attackStanceTasks.keySet())
					{
						if ((current - _attackStanceTasks.get(actor)) > 15000)
						{
							actor.broadcastPacket(new AutoAttackStop(actor.getObjectId()));
							actor.getAI().setAutoAttacking(false);
							_attackStanceTasks.remove(actor);
						}
					}
				}
		}
	}
}
