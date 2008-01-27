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
package net.sf.l2j.gameserver.model.zone;

import java.lang.reflect.Constructor;
import java.util.StringTokenizer;

import javolution.util.FastList;
import javolution.util.FastMap;

import net.sf.l2j.gameserver.datatables.SkillTable;
import net.sf.l2j.gameserver.lib.Rnd;
import net.sf.l2j.gameserver.model.L2Character;
import net.sf.l2j.gameserver.model.L2Object;
import net.sf.l2j.gameserver.model.L2Skill;
import net.sf.l2j.gameserver.model.Location;
import net.sf.l2j.gameserver.model.zone.form.Shape;
import net.sf.l2j.gameserver.network.SystemMessageId;
import net.sf.l2j.gameserver.network.serverpackets.SystemMessage;

import org.w3c.dom.Node;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class L2Zone
{
	protected static Log _log = LogFactory.getLog(L2Zone.class.getName());

	public static enum ZoneType
	{
		Arena,
		Boss,
		Castle,
		CastleDef,
		CastleHQ,
		Clanhall,
		Default,
		Derby,
		Fishing,
		Jail,
		Mothertree,
		Siege,
		Stadium,
		Town,
		Water
	}

	// Overridden in siege zones, jail zone and town zone
	public static enum PvpSettings
	{
		GENERAL,
		ARENA,
		PEACE
	}

	public static enum RestartType
	{
		CHAOTIC,
		OWNER
		// Others are handled by mapregion manager
	}
	
	public static enum Boss
	{
		ANTHARAS,
		BAIUM,
		VALAKAS,
		SAILREN,
		FOURSEPULCHERS,
		LILITH,
		ANAKIM,
		ZAKEN,
		SUNLIGHTROOM,
		VANHALTER
	}

	public static final int FLAG_PVP = 1;
	public static final int FLAG_PEACE = 2;
	public static final int FLAG_SIEGE = 4;
	public static final int FLAG_MOTHERTREE = 8;
	public static final int FLAG_CLANHALL = 16;
	public static final int FLAG_NOESCAPE = 32;
	public static final int FLAG_NOLANDING = 64;
	public static final int FLAG_WATER = 128;
	public static final int FLAG_JAIL = 256;
	public static final int FLAG_MONSTERTRACK = 512;
	public static final int FLAG_STADIUM = 1024;
	public static final int FLAG_SUNLIGHTROOM = 1024;
	
	protected int _id;
	protected String _name;

	protected Shape[] _shapes;
	protected Shape[] _exShapes;
	protected FastMap<Integer, L2Character> _characterList;

	protected FastMap<RestartType, FastList<Location>> _restarts;

	protected int _castleId;
	protected int _clanhallId;
	protected int _townId;
	//protected int _redirectId;
	//protected int _taxById;

	protected ZoneType _type;
	protected PvpSettings _pvp;
	protected Boss _boss;
	
	protected boolean _noEscape, _noLanding;

	protected SystemMessage _onEnterMsg, _onExitMsg;
	
	protected int _abnormal;

	protected boolean _exitOnDeath;

	protected FastList<L2Skill> _applyEnter, _applyExit, _removeEnter, _removeExit;

	public L2Zone()
	{
		// Constructor
		_characterList = new FastMap<Integer, L2Character>();
	}

	protected void register()
	{
	}

	public int getId()
	{
		return _id;
	}

	public String getName()
	{
		return _name;
	}

	public String getClassName()
	{
		//String[] parts = this.getClass().toString().split(".");
		//return parts[parts.length-1];
        return getClass().toString();
	}

	public int getCastleId()
	{
		return _castleId;
	}

	public int getTownId()
	{
		return _townId;
	}

	/*public int getRedirectId()
	{
		return _redirectId;
	}

	public int getTaxById()
	{
		return _taxById;
	}*/

	public int getClanhallId()
	{
		return _clanhallId;
	}

	public FastMap<RestartType, FastList<Location>> getRestartMap()
	{
		if (_restarts == null)
			_restarts = new FastMap<RestartType, FastList<Location>>();

		return _restarts;
	}

	public Location getRestartPoint(RestartType type)
	{
		if(_restarts.containsKey(type) && !_restarts.get(type).isEmpty())
		{
			FastList<Location> rts = _restarts.get(type);
			return rts.get(Rnd.nextInt(rts.size()-1));
		}

		// No restartpoint defined
		return null;
	}

	public void revalidateInZone(L2Character character)
	{
		if (isInsideZone(character))
		{
			if (!_characterList.containsKey(character.getObjectId()))
			{
				_characterList.put(character.getObjectId(), character);
				onEnter(character);
			}
		}
		else
		{
			if (_characterList.containsKey(character.getObjectId()))
			{
				_characterList.remove(character.getObjectId());
				onExit(character);
			}
		}
	}

	protected abstract void onEnter(L2Character cha);
	protected abstract void onExit(L2Character character);
	public abstract void onDieInside(L2Character character);
	public abstract void onReviveInside(L2Character character);

	public FastMap<Integer, L2Character> getCharactersInside()
	{
		return _characterList;
	}

	public void removeCharacter(L2Character character)
	{
		if (_characterList.containsKey(character.getObjectId()))
		{
			_characterList.remove(character.getObjectId());
			onExit(character);
		}
	}

	public boolean isCharacterInZone(L2Character character)
	{
		return _characterList.containsKey(character.getObjectId());
	}

	/**
	 * Checks if the given coordinates are within the zone
	 * @param x
	 * @param y
	 * @param z
	 */
	public boolean isInsideZone(int x, int y)
	{
		boolean inside = false;
		for(Shape sh : _shapes)
		{
			if(sh.contains(x, y))
			{
				inside = true;
				break;
			}
		}

		if(_exShapes != null)
		{
			for(Shape sh : _exShapes)
			{
				if(sh.contains(x, y))
				{
					inside = false;
					break;
				}
			}
		}
		return inside;
	}

	/**
	 * Checks if the given coordinates are within the zone
	 * @param x
	 * @param y
	 * @param z
	 */
	public boolean isInsideZone(int x, int y, int z)
	{
		boolean inside = false;
		for(Shape sh : _shapes)
		{
			if(sh.contains(x, y, z))
			{
				inside = true;
				break;
			}
		}

		if(_exShapes != null)
		{
			for(Shape sh : _exShapes)
			{
				if(sh.contains(x, y, z))
				{
					inside = false;
					break;
				}
			}
		}
		return inside;
	}

	/**
	 * Checks if the given obejct is inside the zone.
	 *
	 * @param object
	 */
	public boolean isInsideZone(L2Object object)
	{
		return isInsideZone(object.getX(), object.getY(), object.getZ());
	}

	public double getDistanceToZone(L2Object object)
	{
		return getDistanceToZone(object.getX(), object.getY());
	}

	public double getDistanceToZone(int x, int y)
	{
		double dist = Double.MAX_VALUE;
		for(Shape sh : _shapes)
		{
			dist = Math.min(dist, sh.getDistanceToZone(x, y));
		}
		return dist;
	}

	public int getMiddleX()
	{
		if(_shapes.length == 0)
			throw new NullPointerException();

		int sum = 0;
		for(Shape sh : _shapes)
		{
			sum += sh.getMiddleX();
		}
		return (int)(sum / _shapes.length);
	}

	public int getMiddleY()
	{
		if(_shapes.length == 0)
			throw new NullPointerException();

		int sum = 0;
		for(Shape sh : _shapes)
		{
			sum += sh.getMiddleY();
		}
		return (int)(sum / _shapes.length);
	}

	public boolean intersectsRectangle(int ax, int bx, int ay, int by)
	{
		for(Shape sh : _shapes)
		{
			if(sh.intersectsRectangle(ax, bx, ay, by))
				return true;
		}
		return false;
	}

	public int getMaxZ(L2Object obj)
	{
		return getMaxZ(obj.getX(), obj.getY(), obj.getZ());
	}

	public int getMinZ(L2Object obj)
	{
		return getMinZ(obj.getX(), obj.getY(), obj.getZ());
	}

	public int getMaxZ(int x, int y, int z)
	{
		for(Shape sh : _shapes)
		{
			if(sh.contains(x, y))
				return sh.getMaxZ();
		}
		return z;
	}

	public int getMinZ(int x, int y, int z)
	{
		for(Shape sh : _shapes)
		{
			if(sh.contains(x, y))
				return sh.getMinZ();
		}
		return z;
	}

	public Location getRandomLocation()
	{
		if(_shapes.length == 0)
			throw new NullPointerException();
		
		return _shapes[Rnd.nextInt(_shapes.length)].getRandomLocation();
	}

	public static L2Zone parseZone(Node zn)
	{
		String type = "Default";
		String name = "";
		int id = 0;
		L2Zone zone = null;
		Class<?> clazz;
		Constructor<?> constructor;
		try
		{
			id = Integer.parseInt(zn.getAttributes().getNamedItem("id").getNodeValue());
			Node tn = zn.getAttributes().getNamedItem("type");
			Node nn = zn.getAttributes().getNamedItem("name");
			if(tn != null)
				type = tn.getNodeValue();

			name = (nn != null) ? nn.getNodeValue() : new Integer(id).toString();

			clazz = Class.forName("net.sf.l2j.gameserver.model.zone.L2"+type+"Zone");
			constructor = clazz.getConstructor();
			zone = (L2Zone)constructor.newInstance();
		}
		catch (Exception e)
		{
			_log.error("Cannot create a L2"+type+"Zone for id "+id);
			return null;
		}

		zone._id = id;
		zone._type = ZoneType.valueOf(type);
		zone._name = name;

		FastList<Shape> shapes = new FastList<Shape>();
		FastList<Shape> exShapes = new FastList<Shape>();
		for (Node n = zn.getFirstChild(); n != null; n = n.getNextSibling())
		{
			if ("shape".equalsIgnoreCase(n.getNodeName()))
			{
				Shape sh = Shape.parseShape(n, id);
				if(sh != null)
				{
					if(sh.isExclude())
						exShapes.add(sh);
					else
						shapes.add(sh);
				}
				else
					return null;
			}
			else if ("entity".equalsIgnoreCase(n.getNodeName()))
			{
				try
				{
					zone.parseEntity(n);
				}
				catch(Exception nfe)
				{
					_log.error("Cannot parse entity for zone "+zone.getName()+" ("+zone.getId()+")");
					return null;
				}
			}
			else if ("settings".equalsIgnoreCase(n.getNodeName()))
			{
				try
				{
					zone.parseSettings(n);
				}
				catch(Exception e)
				{
					_log.error("Cannot parse settings for zone "+zone.getName()+" ("+zone.getId()+")");
					return null;
				}
			}
			else if ("msg".equalsIgnoreCase(n.getNodeName()))
			{
				try
				{
					zone.parseMessages(n);
				}
				catch(Exception e)
				{
					_log.error("Cannot parse messages for zone "+zone.getName()+" ("+zone.getId()+")");
					return null;
				}
			}
			else if ("skill".equalsIgnoreCase(n.getNodeName()))
			{
				try
				{
					zone.parseSkills(n);
				}
				catch(Exception e)
				{
					_log.error("Cannot parse skills for zone "+zone.getName()+" ("+zone.getId()+")");
					return null;
				}
			}
			else if ("restart_chaotic".equalsIgnoreCase(n.getNodeName()))
			{
				try
				{
					zone.parseRestart(n, RestartType.CHAOTIC);
				}
				catch(Exception e)
				{
					_log.error("Cannot parse chaotic restart point for zone "+zone.getName()+" ("+zone.getId()+")");
					return null;
				}
			}
			else if ("restart_owner".equalsIgnoreCase(n.getNodeName()))
			{
				try
				{
					zone.parseRestart(n, RestartType.OWNER);
				}
				catch(Exception e)
				{
					_log.error("Cannot parse owner restart point for zone "+zone.getName()+" ("+zone.getId()+")");
					return null;
				}
			}
		}
		zone._shapes = shapes.toArray(new Shape[shapes.size()]);
		if(exShapes.size() > 0)
			zone._exShapes = exShapes.toArray(new Shape[exShapes.size()]);
		shapes.clear();
		exShapes.clear();

		zone.register();

		return zone;
	}

	private void parseRestart(Node n, RestartType t) throws Exception
	{
		Node xn = n.getAttributes().getNamedItem("x");
		Node yn = n.getAttributes().getNamedItem("y");
		Node zn = n.getAttributes().getNamedItem("z");
		
		int x = Integer.parseInt(xn.getNodeValue());
		int y = Integer.parseInt(yn.getNodeValue());
		int z = Integer.parseInt(zn.getNodeValue());

		if(!getRestartMap().containsKey(t))
			getRestartMap().put(t, new FastList<Location>());

		getRestartMap().get(t).add(new Location(x, y, z));
	}

	private void parseEntity(Node n) throws Exception
	{
		Node castle = n.getAttributes().getNamedItem("castleId");
		Node clanhall = n.getAttributes().getNamedItem("clanhallId");
		//Node redirect = n.getAttributes().getNamedItem("redirect");
		//Node taxById = n.getAttributes().getNamedItem("taxById");
		Node town = n.getAttributes().getNamedItem("townId");
		
		this._castleId = (castle != null) ? Integer.parseInt(castle.getNodeValue()) : -1;
		this._clanhallId = (clanhall != null) ? Integer.parseInt(clanhall.getNodeValue()) : -1;
		//this._redirectId = (redirect != null) ? Integer.parseInt(redirect.getNodeValue()) : -1;
		//this._taxById = (taxById != null) ? Integer.parseInt(taxById.getNodeValue()) : -1;
		this._townId = (town != null) ? Integer.parseInt(town.getNodeValue()) : -1;
	}

	private void parseSettings(Node n) throws Exception
	{
		Node pvp = n.getAttributes().getNamedItem("pvp");
		Node nolanding = n.getAttributes().getNamedItem("nolanding");
		Node noescape = n.getAttributes().getNamedItem("noescape");
		Node boss = n.getAttributes().getNamedItem("boss");
		Node abnorm = n.getAttributes().getNamedItem("abnormal");
		Node exitOnDeath = n.getAttributes().getNamedItem("exitOnDeath");
		
		this._pvp = (pvp != null) ? PvpSettings.valueOf(pvp.getNodeValue().toUpperCase()) : PvpSettings.GENERAL;
		this._noLanding = (nolanding != null) ? Boolean.parseBoolean(nolanding.getNodeValue()) : false;
		this._noEscape = (noescape != null) ? Boolean.parseBoolean(noescape.getNodeValue()) : false;
		this._abnormal = (abnorm != null) ? Integer.parseInt(abnorm.getNodeValue()) : 0;
		this._exitOnDeath = (exitOnDeath != null) ? Boolean.parseBoolean(exitOnDeath.getNodeValue()) : false;
		if(boss != null)
			this._boss = Boss.valueOf(boss.getNodeValue().toUpperCase());
	}

	private void parseMessages(Node n) throws Exception
	{
		Node enter = n.getAttributes().getNamedItem("onEnter");
		Node exit = n.getAttributes().getNamedItem("onExit");
		int msg = -1;

		if(enter != null)
		{
			String onEnter = enter.getNodeValue();

			try
			{
				msg = Integer.parseInt(onEnter);
			}
			catch(NumberFormatException nfe){}
			
			if(msg != -1)
				_onEnterMsg = new SystemMessage(SystemMessageId.getSystemMessageId(msg));
			else
				_onEnterMsg = SystemMessage.sendString(onEnter);
		}
		else
			_onEnterMsg = null;

		if(exit != null)
		{
			String onExit = exit.getNodeValue();
			msg = -1;
			try
			{
				msg = Integer.parseInt(onExit);
			}
			catch(NumberFormatException nfe){}
			
			if(msg != -1)
				_onExitMsg = new SystemMessage(SystemMessageId.getSystemMessageId(msg));
			else
				_onExitMsg = SystemMessage.sendString(onExit);
		}
		else
			_onExitMsg = null;
	}

	private void parseSkills(Node n) throws Exception
	{
		Node aen = n.getAttributes().getNamedItem("applyEnter");
		Node aex = n.getAttributes().getNamedItem("applyExit");
		Node ren = n.getAttributes().getNamedItem("removeEnter");
		Node rex = n.getAttributes().getNamedItem("removeExit");
		
		if(aen != null)
		{
			_applyEnter = new FastList<L2Skill>();
			parseApplySkill(_applyEnter, aen.getNodeValue());
		}
		if(aex != null)
		{
			_applyExit = new FastList<L2Skill>();
			parseApplySkill(_applyExit, aex.getNodeValue());
		}
		if(ren != null)
		{
			_applyEnter = new FastList<L2Skill>();
			parseRemoveSkill(_removeEnter, ren.getNodeValue());
		}
		if(rex != null)
		{
			_applyExit = new FastList<L2Skill>();
			parseRemoveSkill(_removeExit, rex.getNodeValue());
		}
	}
	
	private void parseApplySkill(FastList<L2Skill> list, String set)
	{
		StringTokenizer st = new StringTokenizer(set, ";");
		while(st.hasMoreTokens())
		{
			StringTokenizer st2 = new StringTokenizer(st.nextToken(), ",");
			int skillId = Integer.parseInt(st2.nextToken());
			int level = Integer.parseInt(st2.nextToken());

			L2Skill skill = SkillTable.getInstance().getInfo(skillId, level);
			
			if(skill != null)
				list.add(skill);
		}
	}

	private void parseRemoveSkill(FastList<L2Skill> list, String set)
	{
		StringTokenizer st = new StringTokenizer(set, ";");
		while(st.hasMoreTokens())
		{
			int skillId = Integer.parseInt(st.nextToken());
			L2Skill skill = SkillTable.getInstance().getInfo(skillId, 1);
			if(skill != null)
				list.add(skill);
		}
	}
}