package Battle;

import javax.swing.Action;

public interface IBattleMediator {
    public void AddMember(BattleMemberBase battleMember);
    public void Act(BattleMemberBase battleMember,Action action,float amount);
}