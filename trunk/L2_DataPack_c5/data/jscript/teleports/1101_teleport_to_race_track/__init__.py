#
# Created by DraX on 2005.07.27. updated by DrLecter.
#
import sys

from net.sf.l2j.gameserver.model.actor.instance import L2PcInstance
from net.sf.l2j.gameserver.model.quest          import State
from net.sf.l2j.gameserver.model.quest          import QuestState
from net.sf.l2j.gameserver.model.quest.jython   import QuestJython as JQuest

TRISHA	     = 30059
CLARISSA     = 30080
VALENTIA     = 30177
ESMERALDA    = 30233
BELLA        = 30256
RICHLIN	     = 30320
ELISA        = 30848
FLAUEN       = 30899
TATIANA	     = 31275
ILYANA	     = 31320
RACE_MANAGER = 30995
BILIA        = 31964
MINERVA      = 30836
VERONA       = 30727


class Quest (JQuest) :

 def __init__(self,id,name,descr): JQuest.__init__(self,id,name,descr)

 def onTalk (Self,npc,st):

   npcId = npc.getNpcId()

   ###################
   # Start Locations #
   ###################

   # Gludin Village
   if npcId == RICHLIN: 
     st.getPlayer().teleToLocation(12661,181687,-3560)
     st.setState(STARTED)
     st.set("id","1")     
     return

   # Gludio Castle Town
   if npcId == BELLA: 
     st.getPlayer().teleToLocation(12661,181687,-3560)
     st.setState(STARTED)
     st.set("id","2")     
     return

   # Dion Castle Town
   if npcId == TRISHA: 
     st.getPlayer().teleToLocation(12661,181687,-3560)
     st.setState(STARTED)
     st.set("id","3")     
     return

   # Giran Castle Town
   if npcId == CLARISSA: 
     st.getPlayer().teleToLocation(12661,181687,-3560)
     st.setState(STARTED)
     st.set("id","4")     
     return

   # Heine
   if npcId == FLAUEN: 
     st.getPlayer().teleToLocation(12661,181687,-3560)
     st.setState(STARTED)
     st.set("id","5")     
     return

   # Town of Oren
   if npcId == VALENTIA: 
     st.getPlayer().teleToLocation(12661,181687,-3560)
     st.setState(STARTED)
     st.set("id","6")     
     return

   # Town of Aden
   if npcId == ELISA: 
     st.getPlayer().teleToLocation(12661,181687,-3560)
     st.setState(STARTED)
     st.set("id","7")     
     return

   # Hunters Village
   if npcId == ESMERALDA: 
     st.getPlayer().teleToLocation(12661,181687,-3560)
     st.setState(STARTED)
     st.set("id","8")     
     return

   # Rune Town
   if npcId == ILYANA: 
     st.getPlayer().teleToLocation(12661,181687,-3560)
     st.setState(STARTED)
     st.set("id","9")     
     return

   # Goddard Castle Town
   if npcId == TATIANA: 
     st.getPlayer().teleToLocation(12661,181687,-3560)
     st.setState(STARTED)
     st.set("id","10")     
     return

   # Ivory Tower
   if npcId == VERONA: 
     st.getPlayer().teleToLocation(12661,181687,-3560)
     st.setState(STARTED)
     st.set("id","11")     
     return

   # Private Hardins Academy
   if npcId == MINERVA: 
     st.getPlayer().teleToLocation(12661,181687,-3560)
     st.setState(STARTED)
     st.set("id","12")     
     return

   # Schuttgart
   if npcId == BILIA: 
     st.getPlayer().teleToLocation(12661,181687,-3560)
     st.setState(STARTED)
     st.set("id","13")
     return


   ############################
   # Monster Derby Race Track #
   ############################
   
   # back to Gludin Village
   if npcId == RACE_MANAGER and st.getInt("id") == 1:
     st.getPlayer().teleToLocation(-80826,149775,-3043)
     st.exitQuest(1)
     return
   
   # back to Gludio Castle Town
   if npcId == RACE_MANAGER and st.getInt("id") == 2:
     st.getPlayer().teleToLocation(-12672,122776,-3116)
     st.exitQuest(1)
     return
  
   # back to Dion Castle Town
   if npcId == RACE_MANAGER and st.getInt("id") == 3:
     st.getPlayer().teleToLocation(15670,142983,-2705)
     st.exitQuest(1)
     return

   # back to Giran Castle Town
   if npcId == RACE_MANAGER and st.getInt("id") == 4:
     st.getPlayer().teleToLocation(83400,147943,-3404)
     st.exitQuest(1)
     return

   # back to Heine
   if npcId == RACE_MANAGER and st.getInt("id") == 5:
     st.getPlayer().teleToLocation(111409,219364,-3545)
     st.exitQuest(1)
     return

   # back to Town of Oren
   if npcId == RACE_MANAGER and st.getInt("id") == 6:
     st.getPlayer().teleToLocation(82956,53162,-1495)
     st.exitQuest(1)
     return

   # back to Town of Aden
   if npcId == RACE_MANAGER and st.getInt("id") == 7:
     st.getPlayer().teleToLocation(146331,25762,-2018)
     st.exitQuest(1)
     return

   # back to Hunters Village
   if npcId == RACE_MANAGER and st.getInt("id") == 8:
     st.getPlayer().teleToLocation(116819,76994,-2714)
     st.exitQuest(1)
     return

   # back to Rune Village
   if npcId == RACE_MANAGER and st.getInt("id") == 9:
     st.getPlayer().teleToLocation(43835,-47749,-792)
     st.exitQuest(1)
     return

   # back to Goddard Castle Town
   if npcId == RACE_MANAGER and st.getInt("id") == 10:
     st.getPlayer().teleToLocation(147930,-55281,-2728)
     st.exitQuest(1)
     return

   # back to Ivory Tower
   if npcId == RACE_MANAGER and st.getInt("id") == 11:
     st.getPlayer().teleToLocation(85335,16177,-3694)
     st.exitQuest(1)
     return

   # back to Hardins
   if npcId == RACE_MANAGER and st.getInt("id") == 12:
     st.getPlayer().teleToLocation(105857,109763,-3202)
     st.exitQuest(1)
     return

   # back to Schuttgart
   if npcId == RACE_MANAGER and st.getInt("id") == 13:
     st.getPlayer().teleToLocation(87386,-143246,-1293)
     st.exitQuest(1)
     return


QUEST       = Quest(1101,"1101_teleport_to_race_track","Teleports")
CREATED     = State('Start',     QUEST)
STARTED     = State('Started',   QUEST)
COMPLETED   = State('Completed', QUEST)

QUEST.setInitialState(CREATED)

QUEST.addStartNpc(TRISHA)
QUEST.addStartNpc(CLARISSA)
QUEST.addStartNpc(VALENTIA)
QUEST.addStartNpc(ESMERALDA)
QUEST.addStartNpc(BELLA)
QUEST.addStartNpc(RICHLIN)
QUEST.addStartNpc(ELISA)
QUEST.addStartNpc(FLAUEN)
QUEST.addStartNpc(ILYANA)
QUEST.addStartNpc(TATIANA)
QUEST.addStartNpc(BILIA)

CREATED.addTalkId(TRISHA)
CREATED.addTalkId(CLARISSA)
CREATED.addTalkId(VALENTIA)
CREATED.addTalkId(ESMERALDA)
CREATED.addTalkId(BELLA)
CREATED.addTalkId(RICHLIN)
CREATED.addTalkId(ELISA)
CREATED.addTalkId(FLAUEN)
CREATED.addTalkId(ILYANA)
CREATED.addTalkId(TATIANA)
CREATED.addTalkId(BILIA)

STARTED.addTalkId(RACE_MANAGER)

print "importing teleport data: 1101_teleport_to_race_track"
