package Battle;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Action;

public class Battle implements IBattleMediator {
    public List<BattleMemberBase> battleMembers=new ArrayList<>();
    public boolean playerturn=true;

    public void EndBattle()
    {
        battleMembers.clear();
    }

    public void AddMember(BattleMemberBase battleMember)
    {
        battleMembers.add(battleMember);

    }
    public void Act(BattleMemberBase battleMember,Action action,float amount)
    {
        
    }
}
