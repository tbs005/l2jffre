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
package net.sf.l2j.gameserver.network;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.util.concurrent.RejectedExecutionException;

import net.sf.l2j.Config;
import net.sf.l2j.gameserver.ThreadPoolManager;
import net.sf.l2j.gameserver.network.L2GameClient.GameClientState;
import net.sf.l2j.gameserver.network.clientpackets.*;
import net.sf.l2j.tools.util.Util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mmocore.network.HeaderInfo;
import org.mmocore.network.IClientFactory;
import org.mmocore.network.IMMOExecutor;
import org.mmocore.network.IPacketHandler;
import org.mmocore.network.MMOConnection;
import org.mmocore.network.ReceivablePacket;
import org.mmocore.network.TCPHeaderHandler;

/**
 * Stateful Packet Handler<BR>
 * The Stateful approach prevents the server from handling inconsistent packets, examples:<BR>
 * <li>Clients sends a MoveToLocation packet without having a character attached. (Potential errors handling the packet).</li>
 * <li>Clients sends a RequestAuthLogin being already authed. (Potential exploit).</li>
 * <BR><BR>
 * Note: If for a given exception a packet needs to be handled on more then one state, then it should be added to all these states.
 * @author  KenM
 */
public final class L2GamePacketHandler extends TCPHeaderHandler<L2GameClient> implements IPacketHandler<L2GameClient>, IClientFactory<L2GameClient>,
		IMMOExecutor<L2GameClient>
{
	/**
	* @param subHeaderHandler
	*/
	public L2GamePacketHandler()
	{
		super(null);
	}

	private static final Log	_log	= LogFactory.getLog(L2GamePacketHandler.class.getName());

	// implementation
	public ReceivablePacket<L2GameClient> handlePacket(ByteBuffer buf, L2GameClient client)
	{
		int opcode = buf.get() & 0xFF;

		ReceivablePacket<L2GameClient> msg = null;
		GameClientState state = client.getState();

		switch (state)
		{
		case CONNECTED:
			switch (opcode)
			{
			case 0x00:
				_log.warn("Client " + client.toString() + " is trying to connect using Interlude Client");
				break;
			case 0x0e:
				msg = new ProtocolVersion();
				break;
			case 0x48:
				msg = new AuthLogin();
				break;
			default:
				printDebug(opcode, buf, state, client);
				break;
			}
			break;
		case AUTHED:
			switch (opcode)
			{
			case 0x00:
				msg = new Logout();
				break;
			case 0x95:
				msg = new CharacterCreate();
				break;
			case 0x10:
				msg = new CharacterDelete();
				break;
			case 0x12:
				msg = new CharacterSelected();
				break;
			case 0xc4:
				msg = new NewCharacter();
				break;
			case 0x67:
				msg = new RequestPledgeCrest();
				break;
			case 0x7b:
				msg = new CharacterRestore();
				break;
			case 0xbe:
				int id2 = -1;
				if (buf.remaining() >= 2)
				{
					id2 = buf.getShort() & 0xffff;
				}
				else
				{
					_log.warn("Client: " + client.toString() + " sent a 0xd0 without the second opcode.");
					break;
				}

				// single packet
				if (id2 == 0x41)
				{
					msg = new CharacterPrevState();
				}
				else
				{
					this.printDebugDoubleOpcode(opcode, id2, buf, state, client);
				}

				break;
			default:
				this.printDebug(opcode, buf, state, client);
				break;
			}
			break;
		case IN_GAME:
			switch (opcode)
			{
			case 0x00:
				break;
			case 0x01:
				msg = new AttackRequest();
				break;
			case 0x03:
				msg = new RequestStartPledgeWar();
				break;
			case 0x04:
				msg = new RequestRestart();
				break;
			case 0x05:
				msg = new RequestMagicSkillUse();
				break;
			case 0x06:
				msg = new RequestReplyStopPledgeWar();
				break;
			case 0x07:
				msg = new RequestSurrenderPledgeWar();
				break;
			case 0x08:
				msg = new SetPrivateStoreListBuy();
				break;
			case 0x09:
				msg = new RequestSetPledgeCrest();
				break;
			case 0x0b:
				msg = new RequestGiveNickName();
				break;
			case 0x0f:
				msg = new MoveBackwardToLocation();
				break;
			case 0x11:
				break;
			case 0x12:
				break;
			case 0x13:
				msg = new GameGuardReply();
				break;
			case 0x14:
				break;
			case 0x16:
				msg = new RequestUnEquipItem(); // confirm
				break;
			case 0x17:
				break;
			case 0x19:
				msg = new RequestDropItem();
				break;
			case 0x1a:
				msg = new TradeRequest();
				break;
			case 0x1b:
				msg = new AddTradeItem();
				break;
			case 0x1c:
				msg = new TradeDone();
				break;
			case 0x1f:
				break;
			case 0x22:
				msg = new RequestLinkHtml();
				break;
			case 0x23:
				break;
			case 0x24:
				msg = new RequestBBSwrite();
				break;
			case 0x26:
				msg = new RequestPrivateStoreQuitSell();
				break;
			case 0x27:
				msg = new RequestAnswerJoinPledge();
				break;
			case 0x28:
				msg = new RequestWithdrawalPledge();
				break;
			case 0x29:
				msg = new RequestOustPledgeMember();
				break;
			case 0x2b:
				msg = new RequestBypassToServer();
				break;
			case 0x2c:
				msg = new SetPrivateStoreListSell();
				break;
			case 0x2d:
				msg = new Say2();
				break;

			case 0x2e:
				msg = new RequestAllyInfo();
				break;
			case 0x2f:
				msg = new RequestCrystallizeItem();
				break;
			case 0x30: // t1 ??
				msg = new RequestPrivateStoreManageSell();
				break;
			case 0x31: // t1 ??
				break;
			//                  case 0x32:
			//                      msg = new RequestPrivateStoreManageCancel(data, _client);
			//                      break;
			case 0x34:
				msg = new RequestSocialAction();
				break;
			case 0x35:
				msg = new ChangeMoveType2();
				break;
			case 0x36:
				msg = new ChangeWaitType2();
				break;
			case 0x37:
				msg = new RequestDestroyItem();
				break;
			case 0x39:
				break;
			case 0x3a:
				msg = new RequestBuyItem();
				break;
			case 0x3b:
				if (Config.ALLOW_WAREHOUSE)
					msg = new SendWareHouseDepositList();
				break;
			case 0x3c:
				msg = new SendWareHouseWithDrawList();
				break;
			case 0x3d:
				break;
			case 0x3f:
				break;
			case 0x40: // t1 ??
				break;
			case 0x42:
				msg = new RequestJoinParty();
				break;
			case 0x43:
				msg = new MoveBackwardToLocation();
				break;
			case 0x44:
				msg = new RequestWithDrawalParty();
				break;
			case 0x45:
				msg = new RequestOustPartyMember();
				break;
			case 0x46:
				// RequestDismissParty
				break;
			case 0x47:
				msg = new CannotMoveAnymore();
				break;
			case 0x48:
				msg = new RequestTargetCanceld();
				break;
			case 0x49:
				break;
			case 0x4d:
				msg = new Appearing();
				break;
			case 0x4f:
				msg = new DummyPacket();
				break;
			case 0x50:
				break;
			case 0x52:
				msg = new MoveWithDelta();
				break;
			case 0x53:
				msg = new RequestGetOnVehicle();
				break;
			case 0x54:
				msg = new RequestGetOffVehicle();
				break;
			case 0x55:
				msg = new AnswerTradeRequest();
				break;
			case 0x56:
				break;
			case 0x57:
				break;
			case 0x58:
				msg = new RequestSiegeInfo();
				break;
			case 0x59: // t1 ??
				msg = new ValidatePosition();
				break;
			//					case 0x5a:
			//						// RequestSEKCustom
			//						break;
			//						THESE ARE NOW TEMPORARY DISABLED
			case 0x5b:
				//new StartRotating();
				break;
			case 0x5c:
				//new FinishRotating();
				break;
			case 0x5e:
				msg = new RequestShowBoard();
				break;
			case 0x5f:
				msg = new RequestEnchantItem();
				break;
			case 0x60:
				break;
			case 0x62:
				msg = new RequestQuestList();
				break;
			case 0x63:
				msg = new RequestQuestAbort();
				break;
			case 0x64:
				msg = new RequestShowMiniMap();
				break;
			case 0x65:
				msg = new RequestPledgeInfo();
				break;
			case 0x66:
				msg = new RequestPledgeExtendedInfo();
				break;
			case 0x67:
				msg = new RequestPledgeCrest();
				break;
			case 0x6c:
				msg = new RequestGmList();
				break;
			case 0x6f:
				msg = new RequestHennaEquip();
				break;
			case 0x73: // send when talking to trainer npc, to show list of available skills
				msg = new RequestAquireSkillInfo();//  --> [s] 0xa4;
				break;
			case 0x74:
				break;
			case 0x75:
				msg = new RequestMoveToLocationInVehicle();
				break;
			case 0x76:
				msg = new CannotMoveAnymoreInVehicle();
				break;
			case 0x77:
				msg = new RequestFriendInvite();
				break;
			case 0x78:
				msg = new RequestAnswerFriendInvite();
				break;
			case 0x79:
				msg = new RequestFriendList();
				break;
			case 0x7a:
				msg = new RequestFriendDel();
				break;
			case 0x7c: // send when a skill to be learned is selected
				msg = new RequestAquireSkill();
				break;
			case 0x7d:
				msg = new RequestDeleteMacro();
				break;
			case 0x7e:
				msg = new RequestGMCommand();
				break;
			case 0x7f:
				msg = new RequestPartyMatchConfig();
				break;
			case 0x80:
				msg = new ValidatePosition();
				break;
			case 0x81:
				// Do nothing ??
				break;
			//                      case 0x82:
			//                      // RequestPrivateStoreList
			//                      break;
			case 0x83:
				msg = new RequestPrivateStoreBuy();
				break;
			case 0x85:
				msg = new RequestTutorialLinkHtml();
				break;
			case 0x86:
				msg = new RequestTutorialPassCmdToServer();
				break;
			case 0x87:
				msg = new RequestTutorialQuestionMark();
				break;
			case 0x88:
				msg = new RequestTutorialClientEvent();
				break;
			case 0x89:
				msg = new RequestPetition();
				break;
			case 0x8a:
				msg = new RequestPetitionCancel();
				break;
			case 0x8b:
				msg = new RequestUserCommand();
				break;
			case 0x8c:
				msg = new RequestJoinAlly();
				break;
			case 0x8d:
				msg = new RequestAnswerJoinAlly();
				break;
			case 0x8e:
				msg = new AllyLeave();
				break;
			case 0x8f:
				msg = new AllyDismiss();
				break;
			case 0x90:
				msg = new RequestDismissAlly();
				break;
			case 0x91:
				msg = new Action();
				break;
			case 0x92:
				msg = new RequestAllyCrest();
				break;
			case 0x93:
				msg = new SetPrivateStoreMsgSell();
				break;
			case 0x94:
				msg = new RequestPetUseItem();
				break;
			case 0x95:
				msg = new RequestGiveItemToPet();
				break;
			case 0x96:
				break;
			case 0x97:
				break;
			case 0x98:
				msg = new RequestPetGetItem();
				break;
			case 0x99:
				msg = new RequestShortCutDel();
				break;
			case 0x9a:
				break;
			//					case 0x92:
			//						// RequestPrivateStoreBuyManageCancel
			//						break;
			case 0x9c:
				break;
			case 0x9d:
				break;
			//					case 0x95:
			//						// RequestPrivateStoreBuyList
			//						break;
			case 0x9e:
				msg = new RequestPrivateStoreQuitBuy();
				break;
			case 0x9f:
				msg = new RequestPrivateStoreSell();
				break;
			//					case 0x97:
			//						// SendTimeCheckPacket
			//						break;
			//					case 0x98:
			//						// RequestStartAllianceWar
			//						break;
			//					case 0x99:
			//						// ReplyStartAllianceWar
			//						break;
			//					case 0x9a:
			//						// RequestStopAllianceWar
			//						break;
			//					case 0x9b:
			//		 				// ReplyStopAllianceWar
			//						break;
			//					case 0x9c:
			//						// RequestSurrenderAllianceWar
			//						break;
			case 0xa2:
				msg = new SendBypassBuildCmd();
				break;
			case 0xa6:
				msg = new UseItem();
				break;
			case 0xa7:
				msg = new RequestPackageSendableItemList();
				break;
			case 0xa8:
				msg = new RequestPackageSend();
				break;
			case 0xa9:
				msg = new RequestBlock();
				break;
			case 0xaa:
				msg = new Logout();
				break;
			case 0xab:
				msg = new RequestSiegeAttackerList();
				break;
			case 0xac:
				msg = new RequestShortCutReg();
				break;
			case 0xad:
				msg = new RequestJoinSiege();
				break;
			case 0xae:
				msg = new RequestConfirmSiegeWaitingList();
				break;
			//					case 0xaf:
			//						// RequestSetCastleSiegeTime
			//						break;
			case 0xb0:
				msg = new RequestSkillList();
				break;
			//					case 0xb1:
			//						// NetPing
			//						break;
			case 0xb3:
				break;
			case 0xb4:
				msg = new SnoopQuit();
				break;
			case 0xb5: // we still need this packet to handle BACK button of craft dialog
				msg = new RequestRecipeBookOpen();
				break;
			case 0xb6:
				msg = new RequestRestartPoint();
				break;
			case 0xb7:
				msg = new RequestRecipeItemMakeInfo();
				break;
			case 0xb8:
				msg = new RequestRecipeItemMakeSelf();
				break;
			case 0xb9:
				msg = new RequestActionUse();
			    	break;
			case 0xba:
				msg = new RequestMakeMacro();
				break;
			case 0xbb:
				msg = new RequestRecipeShopListSet();
				break;
			case 0xbc:
				msg = new RequestRecipeShopManageQuit();
				break;
			case 0xbd:
				int id6 = -1;
				if (buf.remaining() >= 2)
				{
					id6 = buf.getShort() & 0xffff;
				}
				else
				{
					_log.warn("Client: " + client.toString() + " sent a 0xbd without the second opcode.");
					break;
				}
					System.out.println("bd : " + id6);
				switch (id6)
				{
				case 291:
					msg = new EnterWorld();
					break;
				default:
					this.printDebugDoubleOpcode(opcode, id6, buf, state, client);
					break;
				}
				break;
			case 0xbe:
				int id4 = -1;
				if (buf.remaining() >= 2)
				{
					id4 = buf.getShort() & 0xffff;
				}
				else
				{
					_log.warn("Client: " + client.toString() + " sent a 0xbe without the second opcode.");
					break;
				}
					System.out.println("be : " + id4);
				switch (id4)
				{
				case 0x0c:
					msg = new RequestCursedWeaponLocation();
					break;
				case 0x0e:
					msg = new RequestSaveInventoryOrder();
					break;
				case 0x28:
					msg = new RequestCursedWeaponList();
					break;
				case 0x3a:
					msg = new RequestKeyMapping();
					break;
				case 0x44:
					msg = new RequestManorList();
					break;
				case 0x49:
					msg = new RequestFortressSiegeInfo();
					break;
				default:
					this.printDebugDoubleOpcode(opcode, id4, buf, state, client);
					break;
				}
				break;
			case 0xbf:
				msg = new RequestItemList();
				break;
			case 0xc0:
				msg = new RequestRecipeShopManagePrev();
				break;
			case 0xc1:
				msg = new ObserverReturn();
				break;
			case 0xc2:
				msg = new RequestEvaluate();
				break;
			case 0xc3:
				msg = new RequestHennaList();
				break;
			case 0xc4:
				msg = new NewCharacter();
				break;
			case 0xcc:
				// Clan Privileges
				msg = new RequestPledgePower();
				break;
			case 0xcd:
				break;
			case 0xce:
				break;
			// Manor
			case 0xcf:
				msg = new RequestBuyProcure();
				break;
			case 0xc5:
				msg = new RequestBuySeed();
				break;
			case 0xc6:
				msg = new DlgAnswer();
				break;
			case 0xc7:
				msg = new RequestWearItem();
				break;
			case 0xc8:
				msg = new RequestSSQStatus();
				break;
			case 0xcb:
				msg = new SetPrivateStoreMsgBuy();
				break;
			case 0x6b:
				msg = new RequestSendFriendMsg();
				break;
			case 0x6d: // MSN dialogs so that you dont see them in the console.
				break;
			case 0x6e: //record video
				msg = new RequestRecordInfo();
				break;

			case 0xd0:
				int id2 = -1;
				if (buf.remaining() >= 2)
				{
					id2 = buf.getShort() & 0xffff;
				}
				else
				{
					_log.warn("Client: " + client.toString() + " sent a 0xd0 without the second opcode.");
					break;
				}

				switch (id2)
				{
				case 0x01:
					//msg = new RequestManorList();
					break;
				case 0x02:
					msg = new RequestProcureCropList();
					break;
				case 0x03:
					msg = new RequestSetSeed();
					break;
				case 0x04:
					msg = new RequestSetCrop();
					break;
				case 0x05:
					msg = new RequestWriteHeroWords();
					break;
				case 0x06:
					msg = new RequestExAskJoinMPCC();
					break;
				case 0x07:
					msg = new RequestExAcceptJoinMPCC();
					break;
				case 0x08:
					msg = new RequestExOustFromMPCC();
					break;
				case 0x09:
					msg = new RequestOustFromPartyRoom();
					break;
				case 0x0a:
					msg = new RequestDismissPartyRoom();
					break;
				case 0x0b:
					msg = new RequestWithdrawPartyRoom();
					break;
				case 0x0c:
					msg = new RequestChangePartyLeader();
					break;
				case 0x0d:
					msg = new RequestAutoSoulShot();
					break;
				case 0x0e:
					msg = new RequestExEnchantSkillInfo();
					break;
				case 0x0f:
					msg = new RequestExEnchantSkill();
					break;
				case 0x10:
					msg = new RequestExPledgeCrestLarge();
					break;
				case 0x11:
					msg = new RequestExSetPledgeCrestLarge();
					break;
				case 0x12:
					msg = new RequestPledgeSetAcademyMaster();
					break;
				case 0x13:
					msg = new RequestPledgePowerGradeList();
					break;
				case 0x14:
					msg = new RequestPledgeMemberPowerInfo();
					break;
				case 0x15:
					msg = new RequestPledgeSetMemberPowerGrade();
					break;
				case 0x16:
					msg = new RequestPledgeMemberInfo();
					break;
				case 0x17:
					msg = new RequestPledgeWarList();
					break;
				case 0x18:
					msg = new RequestExFishRanking();
					break;
				case 0x19:
					msg = new RequestPCCafeCouponUse();
					break;
				case 0x1b:
					msg = new RequestDuelStart();
					break;
				case 0x1c:
					msg = new RequestDuelAnswerStart();
					break;
				case 0x1e:
					msg = new RequestExRqItemLink();
					break;
				case 0x21:
					//msg = new RequestKeyMapping();
					break;
				case 0x22:
					// TODO implement me (just disabling warnings for this packet)
					break;
				case 0x24:
					msg = new RequestSaveInventoryOrder();
					break;
				case 0x25:
					msg = new RequestExitPartyMatchingWaitingRoom();
					break;
				case 0x26:
					msg = new RequestConfirmTargetItem();
					break;
				case 0x27:
					msg = new RequestConfirmRefinerItem();
					break;
				case 0x28:
					msg = new RequestConfirmGemStone();
					break;
				case 0x29:
					msg = new RequestOlympiadObserverEnd();
					break;
				case 0x2a:
					msg = new RequestCursedWeaponList();
					break;
				case 0x2b:
					msg = new RequestCursedWeaponLocation();
					break;
				case 0x2c:
					msg = new RequestPledgeReorganizeMember();
					break;
				case 0x2e:
					msg = new RequestExMPCCShowPartyMembersInfo();
					break;
				case 0x2f:
					msg = new RequestOlympiadMatchList();
					break;
				case 0x30:
					msg = new RequestAskJoinPartyRoom();
					break;
				case 0x31:
					msg = new AnswerJoinPartyRoom();
					break;
				case 0x32:
					msg = new RequestListPartyMatchingWaitingRoom();
					break;
				case 0x33:
					msg = new RequestExEnchantSkillSafe();
					break;
				case 0x34:
					msg = new RequestExEnchantSkillUntrain();
					break;
				case 0x35:
					msg = new RequestExEnchantSkillRouteChange();
					break;
				case 0x36:
					msg = new ExGetOnAirShip();
					break;
				case 0x3f:
					msg = new RequestAllCastleInfo();
					break;
				case 0x40:
					msg = new RequestAllFortressInfo();
					break;
				case 0x41:
					msg = new RequestAllAgitInfo();
					break;
				case 0x42:
					msg = new RequestFortressSiegeInfo();
					break;
				case 0x43:
					msg = new RequestGetBossRecord();
					break;
				case 0x44:
					msg = new RequestRefine();
					break;
				case 0x45:
					msg = new RequestConfirmCancelItem();
					break;
				case 0x46:
					msg = new RequestRefineCancel();
					break;
				case 0x47:
					msg = new RequestExMagicSkillUseGround();
					break;
				case 0x48:
					msg = new RequestDuelSurrender();
					break;
				case 0x49:
					msg = new RequestExEnchantSkillInfoDetail();
					break;
				default:
					this.printDebugDoubleOpcode(opcode, id2, buf, state, client);
					break;
				}
				break;
			/*case 0xee:
				msg = new RequestChangePartyLeader(data, _client);
				break;*/
			default:
				this.printDebug(opcode, buf, state, client);
				break;
			}
			break;
		}
		return msg;
	}

	private void printDebug(int opcode, ByteBuffer buf, GameClientState state, L2GameClient client)
	{
		int size = buf.remaining();
		_log.warn("Unknown Packet: " + Integer.toHexString(opcode) + " on State: " + state.name() + " Client: " + client.toString());
		byte[] array = new byte[size];
		buf.get(array);
		_log.warn(Util.printData(array, size));
	}

	private void printDebugDoubleOpcode(int opcode, int id2, ByteBuffer buf, GameClientState state, L2GameClient client)
	{
		int size = buf.remaining();
		_log.warn("Unknown Packet: " + Integer.toHexString(opcode) + ":" + Integer.toHexString(id2) + " on State: " + state.name() + " Client: "
				+ client.toString());
		byte[] array = new byte[size];
		buf.get(array);
		_log.warn(Util.printData(array, size));
	}

	// impl
	public L2GameClient create(MMOConnection<L2GameClient> con)
	{
		return new L2GameClient(con);
	}

	public void execute(ReceivablePacket<L2GameClient> rp)
	{
		try
		{
			if (rp.getClient().getState() == GameClientState.IN_GAME)
			{
				ThreadPoolManager.getInstance().executePacket(rp);
			}
			else
			{
				ThreadPoolManager.getInstance().executeIOPacket(rp);
			}
		}
		catch (RejectedExecutionException e)
		{
			// if the server is shutdown we ignore
			if (!ThreadPoolManager.getInstance().isShutdown())
			{
				_log.fatal("Failed executing: " + rp.getClass().getSimpleName() + " for Client: " + rp.getClient().toString());
			}
		}
	}

	/**
	 * @see org.mmocore.network.TCPHeaderHandler#handleHeader(java.nio.channels.SelectionKey, java.nio.ByteBuffer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public HeaderInfo handleHeader(SelectionKey key, ByteBuffer buf)
	{
		if (buf.remaining() >= 2)
		{
			int dataPending = (buf.getShort() & 0xffff) - 2;
			L2GameClient client = ((MMOConnection<L2GameClient>) key.attachment()).getClient();
			return this.getHeaderInfoReturn().set(0, dataPending, false, client);
		}
		else
		{
			L2GameClient client = ((MMOConnection<L2GameClient>) key.attachment()).getClient();
			return this.getHeaderInfoReturn().set(2 - buf.remaining(), 0, false, client);
		}
	}
}
