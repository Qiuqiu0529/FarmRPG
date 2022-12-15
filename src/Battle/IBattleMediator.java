package Battle;

import javax.swing.Action;

public interface IBattleMediator {
    public void AddMember(IBattleMember battleMember);
    public void Act(IBattleMember battleMember,Action action,float amount);
}