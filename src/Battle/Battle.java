package Battle;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Action;

import Item.Dice;
import Mgr.SoundMgr;
import Player.MoneyPresenter;
import Player.Player;
import Player.PlayerBattle;

public class Battle implements IBattleMediator {
    public List<BattleMemberBase> battlePlayerMembers=new ArrayList<>();
    public List<BattleMemberBase> battleMonstersMembers=new ArrayList<>();
    public boolean playerturn=true;
    public boolean endBattle=false;
    float moneybonus=0;

    public void EndBattle()
    {
        endBattle=true;
        battlePlayerMembers.clear();
        battleMonstersMembers.clear();
        System.out.println("战斗结束");
    }

    public void Victory()
    {
        System.out.println(Player.playername+"胜利");
        SoundMgr.GetInstance().PlayVictorySound();
        System.out.println("战斗奖励");
        MoneyPresenter.GetInstance().EarnMoney(moneybonus);
        EndBattle();
    }

    public void Fail()
    {
        System.out.println(Player.playername+"输了");
        SoundMgr.GetInstance().PlayFailureSound();
        System.out.println("损失金钱");
        MoneyPresenter.GetInstance().LoseMoney(Dice.RollF(0.1f, 0.5f));
        EndBattle();
    }

    public void AddMember(BattleMemberBase battleMember)
    {
        if(battleMember instanceof PlayerBattle)
        {
            battlePlayerMembers.add(battleMember);
        }
        else
        {
            battleMonstersMembers.add(battleMember);
        }
    }

    public void RemoveMember(BattleMemberBase battleMember)
    {
        if(battleMember instanceof PlayerBattle)
        {
            battlePlayerMembers.remove(battleMember);
        }
        else
        {
            battleMonstersMembers.remove(battleMember);
            //if()
        }
    }

    public void Act(BattleMemberBase battleMember,Action action,float amount)
    {
        
    }

    public void StartBattle() throws InterruptedException
    {
        System.out.println("触发战斗");
        System.out.println("当前怪物数量："+ Integer.toString(battleMonstersMembers.size()));
        endBattle=false;
        moneybonus=30;
        if(Dice.Determine(Player.lucky, 5))
        {
            playerturn=true;
        }
        else
        {
            playerturn=false;
        }
        EachTurn();
    }

    public void EachTurn() throws InterruptedException
    {
        if(playerturn)
        {
            for (BattleMemberBase bMemberBase: battlePlayerMembers) {
                bMemberBase.OneRoundUp();
            }
        }
        else
        {
            for (BattleMemberBase bMemberBase: battleMonstersMembers) {
                bMemberBase.OneRoundUp();
            }
        }

        playerturn=!playerturn;
        if(!endBattle)
        {
            EachTurn();
        }
    }
}
