package Battle;

import java.util.ArrayList;
import java.util.List;

import Item.Dice;
import Mgr.GameMgr;
import Mgr.SoundMgr;
import Player.MoneyPresenter;
import Player.Player;
import Player.PlayerMaker;

public class Battle implements IBattleMediator {
    public List<BattleMemberBase> battlePlayerMembers = new ArrayList<>();
    public List<BattleMemberBase> battleMonstersMembers = new ArrayList<>();
    public boolean playerturn = true;
    public boolean endBattle = false;//dirty flag
    float moneybonus = 0;

    public void EndBattle() {
        endBattle = true;
        battlePlayerMembers.clear();
        battleMonstersMembers.clear();
        System.out.println("战斗结束");
    }

    public void Victory() throws InterruptedException {
        Thread.sleep(100);
        System.out.println(Player.playername + "胜利");
        SoundMgr.GetInstance().PlayVictorySound();
        if (Dice.Determine(Player.lucky, 10)) {
            Thread.sleep(100);
            if (Dice.Determine(0, 12)) {
                Player.lucky += 1;
                System.out.println(Player.playername+"幸运值+1");
            }
            Thread.sleep(100);
            for (BattleMemberBase bMemberBase : battlePlayerMembers) {
                System.out.println(bMemberBase.name+"变强了");
                bMemberBase.LevelUp();
            }
        }
        Thread.sleep(200);
        System.out.println("战斗奖励");
        MoneyPresenter.GetInstance().EarnMoney(moneybonus);
        Thread.sleep(200);
        EndBattle();
        Thread.sleep(200);
    }

    public void Fail() throws InterruptedException {
        Thread.sleep(100);
        System.out.println(Player.playername + "输了");
        SoundMgr.GetInstance().PlayFailureSound();
        if (Dice.Determine(0, 10)) {
            Thread.sleep(100);
            if (Dice.Determine(0, 12)) {
                Player.lucky -= 1;
                System.out.println(Player.playername+"幸运值-1");
            }
            Thread.sleep(100);
            for (BattleMemberBase bMemberBase : battleMonstersMembers) {
                System.out.println(bMemberBase.name+"变强了");
                bMemberBase.LevelUp();
            }
        }
        Thread.sleep(200);
        System.out.println("损失金钱");
        MoneyPresenter.GetInstance().LoseMoney(Dice.RollF(0.1f, 0.5f));
        Thread.sleep(200);
        EndBattle();
        Thread.sleep(200);
        GameMgr.GetInstance().EndDayEarly();//提前结束一天
    }

    public void AddMember(BattleMemberBase battleMember) {
        if (battleMember instanceof PlayerMaker) {
            battlePlayerMembers.add(battleMember);
        } else {
            battleMonstersMembers.add(battleMember);
        }
    }

    public void RemoveMember(BattleMemberBase battleMember) throws InterruptedException {
        if (battleMember instanceof PlayerMaker) {
            battlePlayerMembers.remove(battleMember);
            if (battlePlayerMembers.size() == 0) {
                Fail();
            }
        } else {
            battleMonstersMembers.remove(battleMember);
            if (battleMonstersMembers.size() == 0) {
                Victory();
            }
        }
    }
    public boolean BattleISEND()
    {
        return endBattle;
    }

    public void Act(BattleMemberBase battleMember, BattleAction action, float amount) throws InterruptedException {
        switch (action) {
            case ESCAPE:
                EndBattle();
                break;
            case ATTACK:
                if (playerturn) {
                    int i=Dice.Roll(0, battleMonstersMembers.size());
                    battleMonstersMembers.get(i).BattleAction(action, amount);
                } else {
                    int i=Dice.Roll(0, battlePlayerMembers.size());
                    battlePlayerMembers.get(i).BattleAction(action, amount);
                }
                break;
            case SKILL:
                if (!playerturn) {
                    int i=Dice.Roll(0, battleMonstersMembers.size());
                    battleMonstersMembers.get(i).BattleAction(action, amount);
                }
                break;
            default:
                break;
        }
    }

    public void Addbonus(float add) {
        moneybonus += add;
    }

    public void StartBattle() throws InterruptedException {
        System.out.println("触发战斗");
        Player.getInstance().SetBattle();
        SoundMgr.GetInstance().PlayBattleBGM();
        System.out.println("当前怪物数量：" + Integer.toString(battleMonstersMembers.size()));
        for (BattleMemberBase bMemberBase : battleMonstersMembers) {
            System.out.println(bMemberBase.name);
        }
        endBattle = false;
        moneybonus = 20;
        if (Dice.Determine(Player.lucky, 5)) {
            playerturn = true;
        } else {
            playerturn = false;
        }
        EachTurn();
    }

    public void EachTurn() throws InterruptedException {
        Thread.sleep(1000);
        if (playerturn) {
            System.out.println(Player.playername + "方出手");
            for (int i = 0; i < battlePlayerMembers.size(); i++) {
                battlePlayerMembers.get(i).OneRoundUp();
            }
        } else {
            System.out.println("怪物方出手");
            for (int i = 0; i < battleMonstersMembers.size(); i++) {
                battleMonstersMembers.get(i).OneRoundUp();
            }
        }

        playerturn = !playerturn;
        if (!endBattle) {
            EachTurn();
        }
    }
}
