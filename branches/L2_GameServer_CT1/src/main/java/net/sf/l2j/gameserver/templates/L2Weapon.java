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
package net.sf.l2j.gameserver.templates;

import java.io.IOException;
import java.util.List;

import javolution.util.FastList;
import net.sf.l2j.gameserver.datatables.SkillTable;
import net.sf.l2j.gameserver.handler.ISkillHandler;
import net.sf.l2j.gameserver.handler.SkillHandler;
import net.sf.l2j.gameserver.model.L2Character;
import net.sf.l2j.gameserver.model.L2Effect;
import net.sf.l2j.gameserver.model.L2ItemInstance;
import net.sf.l2j.gameserver.model.L2Skill;
import net.sf.l2j.gameserver.model.L2Skill.SkillType;
import net.sf.l2j.gameserver.model.actor.instance.L2NpcInstance;
import net.sf.l2j.gameserver.model.actor.instance.L2PcInstance;
import net.sf.l2j.gameserver.model.quest.Quest;
import net.sf.l2j.gameserver.skills.Env;
import net.sf.l2j.gameserver.skills.conditions.ConditionGameChance;
import net.sf.l2j.gameserver.skills.funcs.Func;
import net.sf.l2j.gameserver.skills.funcs.FuncTemplate;

/**
 * This class is dedicated to the management of weapons.
 * 
 * @version $Revision: 1.4.2.3.2.5 $ $Date: 2005/04/02 15:57:51 $
 */
public final class L2Weapon  extends L2Item
{
	private final int _soulShotCount;
	private final int _spiritShotCount;
	private final int _pDam;
	private final int _rndDam;
	private final int _critical;
	private final double _hitModifier;
	private final int _avoidModifier;
	private final int _shieldDef;
	private final double _shieldDefRate;
	private final int _atkSpeed;
	private final int _atkReuse;
	private final int _mpConsume;
	private final int _mDam;
	private String _races;
	private String _classes;
	private String _sIds;
	private String _sLvls;
	private final int _sex;
	private FastList<Integer> _racesAllowed = null;
	private FastList<Integer> _classesAllowed = null;
	private FastList<Integer> _sId = null;
	private FastList<Integer> _sLvl = null;
    
	private FastList<L2Skill> _itemSkills = null;
    private L2Skill _enchant4Skill = null; // skill that activates when item is enchanted +4 (for duals)
    private final int _changeWeaponId;

    // Attached skills for Special Abilities
    protected L2Skill[] _skillsOnCast;
    protected L2Skill[] _skillsOnCrit;
    
    /**
     * Constructor for Weapon.<BR><BR>
     * <U><I>Variables filled :</I></U><BR>
     * <LI>_soulShotCount & _spiritShotCount</LI>
     * <LI>_pDam & _mDam & _rndDam</LI>
     * <LI>_critical</LI>
     * <LI>_hitModifier</LI>
     * <LI>_avoidModifier</LI>
     * <LI>_shieldDes & _shieldDefRate</LI>
     * <LI>_atkSpeed & _AtkReuse</LI>
     * <LI>_mpConsume</LI>
     * <LI>_races & _classes & _sex</LI>
     * <LI>_sIds & _sLvls</LI>
     * @param type : L2ArmorType designating the type of armor
     * @param set : StatsSet designating the set of couples (key,value) characterizing the weapon
     * @see L2Item constructor
     */
	public L2Weapon(L2WeaponType type, StatsSet set)
	{
		super(type, set);
		_soulShotCount   = set.getInteger("soulshots");
		_spiritShotCount = set.getInteger("spiritshots");
		_pDam            = set.getInteger("p_dam");
		_rndDam          = set.getInteger("rnd_dam");
		_critical        = set.getInteger("critical");
		_hitModifier     = set.getDouble("hit_modify");
		_avoidModifier   = set.getInteger("avoid_modify");
		_shieldDef       = set.getInteger("shield_def");
		_shieldDefRate   = set.getDouble("shield_def_rate");
		_atkSpeed        = set.getInteger("atk_speed");
		_atkReuse		= set.getInteger("atk_reuse", initAtkReuse(type));
		_mpConsume       = set.getInteger("mp_consume");
		_mDam            = set.getInteger("m_dam");
		_races         = set.getString("races");
		_classes       = set.getString("classes");
		_sex           = set.getInteger("sex");
		_sIds          = set.getString("item_skill_id");
		_sLvls         = set.getString("item_skill_lvl");
		
		if (_races.length()>0)
		{
			try
			{
				int _checker = Integer.parseInt(_races);
				if (_checker != -1) { _racesAllowed = new FastList<Integer>(); _racesAllowed.add(_checker); }
			}
			catch (Throwable t)
			{
				_racesAllowed = new FastList<Integer>();
		        for (String id : _races.split(",")) 
		        	_racesAllowed.add(Integer.parseInt(id));
			}
		}
		if (_classes.length()>0)
		{
			try
			{
				int _checker = Integer.parseInt(_classes);
				if (_checker != -1) { _classesAllowed = new FastList<Integer>(); _classesAllowed.add(_checker); }
			}
			catch (Throwable t)
			{
				_classesAllowed = new FastList<Integer>();
				for (String id : _classes.split(",")) 
	                _classesAllowed.add(Integer.parseInt(id));
			}
		}
		if (_sIds.length()>0 && _sLvls.length()>0)
		{
			try
			{
				int _checker = Integer.parseInt(_sIds);
				if (_checker > 0) { _sId = new FastList<Integer>(); _sId.add(_checker); }
			}
			catch (Throwable t)
			{
				_sId = new FastList<Integer>();
				for (String id : _sIds.split(",")) 
	                _sId.add(Integer.parseInt(id));
			}
			try
			{
				int _checker = Integer.parseInt(_sLvls);
				if (_checker > 0) { _sLvl = new FastList<Integer>(); _sLvl.add(_checker); }
			}
			catch (Throwable t)
			{
				_sLvl = new FastList<Integer>();
				for (String id : _sLvls.split(",")) 
	                _sLvl.add(Integer.parseInt(id));
			}
		}
		
		if (_sId != null && _sLvl != null)
		{
			_itemSkills = new FastList<L2Skill>();
			for (int i = 0; i < _sId.size(); i++)
				if (_sId.get(i) > 0 && _sLvl.get(i) > 0) // Some people might try to experiment with negative skills lol
					if (SkillTable.getInstance().getInfo(_sId.get(i),_sLvl.get(i)) != null)
						_itemSkills.add(SkillTable.getInstance().getInfo(_sId.get(i),_sLvl.get(i)));
					else System.out.println("Adding: id "+String.valueOf(_sId.get(i))+" lvl "+String.valueOf(_sLvl.get(i))+"skill is NULL");
				else System.out.println("Adding: id "+String.valueOf(_sId.get(i))+" lvl "+String.valueOf(_sLvl.get(i))+"skill id/level value is NEGATIVE");
		}
		_sId = null; _sLvl = null; //not needed any longer
		if (_itemSkills != null && _itemSkills.size() < 1) _itemSkills = null; //if negative/wrong skill id(s)/level(s)
       
		int sId = set.getInteger("enchant4_skill_id");
		int sLv = set.getInteger("enchant4_skill_lvl");
		if(sId > 0 && sLv > 0)
		    _enchant4Skill = SkillTable.getInstance().getInfo(sId, sLv);
       
		sId = set.getInteger("onCast_skill_id");
		sLv = set.getInteger("onCast_skill_lvl");
		int sCh = set.getInteger("onCast_skill_chance");
		if(sId > 0 && sLv > 0 && sCh > 0)
		{
		    L2Skill skill = SkillTable.getInstance().getInfo(sId, sLv);
		    skill.attach(new ConditionGameChance(sCh),true);
		    attachOnCast(skill);
		}
       
		sId = set.getInteger("onCrit_skill_id");
		sLv = set.getInteger("onCrit_skill_lvl");
		sCh = set.getInteger("onCrit_skill_chance");
		if(sId > 0 && sLv > 0 && sCh > 0)
		{
		    L2Skill skill = SkillTable.getInstance().getInfo(sId, sLv);
		    skill.attach(new ConditionGameChance(sCh),true);
		    attachOnCrit(skill);
		}
		_changeWeaponId     = set.getInteger("change_weaponId");
	}
	
	private int initAtkReuse(L2WeaponType type)
	{
		// http://www.l2p.bravehost.com/endL2P/misc.html
		// Normal bows have a base Weapon Delay of 1500 - Like Draconic Bow (atkSpd == 293)
		// Yumi bows have a base Weapon Delay of 820 - Like Soul Bow (atkSpd == 227)
		
		if (type == L2WeaponType.BOW)
		{
			if (_atkSpeed == 293)
				return 1500;
			if (_atkSpeed == 227)
				return 820;
		}
		else if (type == L2WeaponType.CROSSBOW)
		{
			return 1200;
		}

		return 0;
	}
	
	/**
	 * Returns the type of Weapon
	 * @return L2WeaponType
	 */
	public L2WeaponType getItemType()
	{
		return (L2WeaponType)super._type;
	}

	/**
	 * Returns the ID of the Etc item after applying the mask.
	 * @return int : ID of the Weapon
	 */
	public int getItemMask()
	{
		return getItemType().mask();
	}
	
	/**
	 * Returns the quantity of SoulShot used.
	 * @return int
	 */
	public int getSoulShotCount()
	{
		return _soulShotCount;
	}
	
	/**
	 * Returns the quatity of SpiritShot used.
	 * @return int
	 */
	public int getSpiritShotCount()
	{
		return _spiritShotCount;
	}
	
	/**
	 * Returns the physical damage.
	 * @return int
	 */
	public int getPDamage()
	{
		return _pDam;
	}
	
	/**
	 * Returns the random damage inflicted by the weapon
	 * @return int
	 */
	public int getRandomDamage()
	{
		return _rndDam;
	}
	
	/**
	 * Returns the attack speed of the weapon
	 * @return int
	 */
	public int getAttackSpeed()
	{
		return _atkSpeed;
	}
	
	/**
	 * Return the Attack Reuse Delay of the L2Weapon.<BR><BR>
	 * @return int
	 */
	public int getAttackReuseDelay()
	{
		return _atkReuse;
	}
	
	/**
	 * Returns the avoid modifier of the weapon
	 * @return int
	 */
	public int getAvoidModifier()
	{
		return _avoidModifier;
	}
	
	/**
	 * Returns the rate of critical hit
	 * @return int
	 */
	public int getCritical()
	{
		return _critical;
	}
	
	/**
	 * Returns the hit modifier of the weapon
	 * @return double
	 */
	public double getHitModifier()
	{
		return _hitModifier;
	}
	
	/**
	 * Returns the magical damage inflicted by the weapon
	 * @return int
	 */
	public int getMDamage()
	{
		return _mDam;
	}
	
	/**
	 * Returns the MP consumption with the weapon
	 * @return int
	 */
	public int getMpConsume()
	{
		return _mpConsume;
	}
	
	/**
	 * Returns the shield defense of the weapon
	 * @return int
	 */
	public int getShieldDef()
	{
		return _shieldDef;
	}
	
	/**
	 * Returns the rate of shield defense of the weapon
	 * @return double
	 */
	public double getShieldDefRate()
	{
		return _shieldDefRate;
	}

    /** 
     * Returns passive skill linked to that weapon
     * @return
     */
	public FastList<L2Skill> getSkills()
	{
	    return _itemSkills;
	}
    /**
     * Returns skill that player get when has equiped weapon +4  or more  (for duals SA)
     * @return
     */
	public L2Skill getEnchant4Skill()
	{
	    return _enchant4Skill;
	}

	/**
	* Returns the Id in wich weapon this weapon can be changed
	* @return
	*/
	public int getChangeWeaponId()
	{
		return _changeWeaponId;
	}

	/**
	 * Returns array of Func objects containing the list of functions used by the weapon 
	 * @param instance : L2ItemInstance pointing out the weapon
	 * @param player : L2Character pointing out the player
	 * @return Func[] : array of functions
	 */
	public Func[] getStatFuncs(L2ItemInstance instance, L2Character player)
    {
    	List<Func> funcs = new FastList<Func>();
    	if (_funcTemplates != null)
    	{
    		for (FuncTemplate t : _funcTemplates) {
		    	Env env = new Env();
		    	env.player = player;
		    	env.item = instance;
		    	Func f = t.getFunc(env, instance);
		    	if (f != null)
		    		funcs.add(f);
    		}
    	}
    	return funcs.toArray(new Func[funcs.size()]);
    }

    /**
     * Returns effects of skills associated with the item to be triggered onHit.
     * @param caster : L2Character pointing out the caster
     * @param target : L2Character pointing out the target
     * @param crit : boolean tells whether the hit was critical
     * @return L2Effect[] : array of effects generated by the skill
     */
    public L2Effect[] getSkillEffects(L2Character caster, L2Character target, boolean crit)
    {
        if (_skillsOnCrit == null || !crit)
            return _emptyEffectSet;
        List<L2Effect> effects = new FastList<L2Effect>();

        for (L2Skill skill : _skillsOnCrit)
        {
            // check if this skill can affect the target
            if (!target.checkSkillCanAffectMyself(skill)) // TODO: a check for skills  like pdam with an effect
                continue;
            
            if (!skill.checkCondition(caster, target, true)) 
                continue; // Skill condition not met
            
            if (target.getFirstEffect(skill.getId()) != null)
                target.getFirstEffect(skill.getId()).exit();
                //target.removeEffect(target.getEffect(skill.getId()));
            for (L2Effect e:skill.getEffects(caster, target))
                effects.add(e);
        }
        if (effects.size() == 0)
            return _emptyEffectSet;
        return effects.toArray(new L2Effect[effects.size()]);
    }
    
    /**
     * Returns effects of skills associated with the item to be triggered onCast.
     * @param caster : L2Character pointing out the caster
     * @param target : L2Character pointing out the target
     * @param trigger : L2Skill pointing out the skill triggering this action
     * @return L2Effect[] : array of effects generated by the skill
     */
    public L2Effect[] getSkillEffects(L2Character caster, L2Character target, L2Skill trigger)
    {
        if (_skillsOnCast == null)
            return _emptyEffectSet;
        List<L2Effect> effects = new FastList<L2Effect>();

        for (L2Skill skill : _skillsOnCast)
        {
            if (trigger.isOffensive() != skill.isOffensive()) 
                continue; // Trigger only same type of skill

            if (trigger.getId() >= 1320 && trigger.getId() <= 1322)
                continue; // No buffing with Common and Dwarven Craft

            if (target.isRaid() && (skill.getSkillType() == SkillType.CONFUSION || skill.getSkillType() == SkillType.MUTE || skill.getSkillType() == SkillType.PARALYZE || skill.getSkillType() == SkillType.ROOT)) 
                continue; // These skills should not work on RaidBoss

            if (trigger.isToggle() && skill.getSkillType() == SkillType.BUFF)
                continue; // No buffing with toggle skills
            
            if (!skill.checkCondition(caster, target, true))
                continue; // Skill condition not met
            
                //target.removeEffect(target.getEffect(skill.getId()));
            try
            {
                // Get the skill handler corresponding to the skill type
                ISkillHandler handler = SkillHandler.getInstance().getSkillHandler(skill.getSkillType());

                L2Character[] targets = new L2Character[1];
                targets[0] = target;
                
                // Launch the magic skill and calculate its effects
                if (handler != null)
                    handler.useSkill(caster, skill, targets);
                else
                    skill.useSkill(caster, targets);
                if ((caster instanceof L2PcInstance) && (target instanceof L2NpcInstance))
                {
                	Quest[] quests = ((L2NpcInstance)target).getTemplate().getEventQuests(Quest.QuestEventType.MOB_TARGETED_BY_SKILL);
                	if (quests != null)
                		for (Quest quest: quests)
                			quest.notifySkillUse ( (L2NpcInstance) target, (L2PcInstance) caster, skill);
                }
            }
            catch (IOException e)
            {
            }
        }
        if (effects.size() == 0)
            return _emptyEffectSet;
        return effects.toArray(new L2Effect[effects.size()]);
    }

    /**
     * Add the L2Skill skill to the list of skills generated by the item triggered by critical hit
     * @param skill : L2Skill
     */
    public void attachOnCrit(L2Skill skill)
    {
        if (_skillsOnCrit == null)
        {
            _skillsOnCrit = new L2Skill[]{skill};
        }
        else
        {
            int len = _skillsOnCrit.length;
            L2Skill[] tmp = new L2Skill[len+1];
            // Definition : arraycopy(array source, begins copy at this position of source, array destination, begins copy at this position in dest,
            //                        number of components to be copied)
            System.arraycopy(_skillsOnCrit, 0, tmp, 0, len);
            tmp[len] = skill;
            _skillsOnCrit = tmp;
        }
    }

    /**
     * Add the L2Skill skill to the list of skills generated by the item triggered by casting spell
     * @param skill : L2Skill
     */
    public void attachOnCast(L2Skill skill)
    {
        if (_skillsOnCast == null)
        {
            _skillsOnCast = new L2Skill[]{skill};
        }
        else
        {
            int len = _skillsOnCast.length;
            L2Skill[] tmp = new L2Skill[len+1];
            // Definition : arraycopy(array source, begins copy at this position of source, array destination, begins copy at this position in dest,
            //                        number of components to be copied)
            System.arraycopy(_skillsOnCast, 0, tmp, 0, len);
            tmp[len] = skill;
            _skillsOnCast = tmp;
        }
    }
    
    /** 
     * Returns true if player can equip the item
     * @param raceId: player's race
     * @param classId: player's class
     * @param isFemale: player's sex
     * @return boolean: ability to equip
     */
    public boolean allowEquip(int raceId, int classId, boolean isFemale)
    {
    	return allowEquipForRace(raceId) && allowEquipForClass(classId) && allowEquipForSex(isFemale);
    }
    
    public boolean allowEquipForRace(int raceId)
    {
    	if (_racesAllowed == null) return true;
    	else if (_racesAllowed.contains(raceId)) return true;
    	return false;
    }
    
    public boolean allowEquipForClass(int classId)
    {
    	if (_classesAllowed == null) return true;
    	else if (_classesAllowed.contains(classId)) return true;
    	return false;
    }
    
    public boolean allowEquipForSex(boolean isFemale)
    {
    	int serial;
    	if (isFemale) serial = 1; else serial = 0;
    	if (_sex == -1) return true;
    	else return (serial == _sex);
    }
}
