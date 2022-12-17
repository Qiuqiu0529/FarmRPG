package Battle;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Action;

import Item.Dice;
import Mgr.SoundMgr;
import Player.Player;
import Player.PlayerBattle;

public class Battle implements IBattleMediator {
    public List<BattleMemberBase> battlePlayerMembers=new ArrayList<>();
    public List<BattleMemberBase> battleMonstersMembers=new ArrayList<>();
    public boolean playerturn=true;
    public boolean endBattle=false;

    public void EndBattle()
    {
        endBattle=true;
        battlePlayerMembers.clear();
        battleMonstersMembers.clear();
        System.out.println("战斗结束");
    }

    public void Victory()
    {
        SoundMgr.GetInstance().PlayVictorySound();
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
        }
    }

    public void Act(BattleMemberBase battleMember,Action action,float amount)
    {
        
    }

    public void StartBattle()
    {
        System.out.println("触发战斗");
        System.out.println("当前怪物数量："+ Integer.toString(battleMonstersMembers.size()));
        endBattle=false;
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

    public void EachTurn()
    {
        if(playerturn)
        {

        }
        else
        {

        }

        ToggleTurn();
    }

    public void ToggleTurn()
    {
        playerturn=!playerturn;
        if(!endBattle)
        {
            EachTurn();
        }
    }
}
