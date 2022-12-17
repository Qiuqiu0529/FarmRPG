package Battle;

public interface IBattleMediator {
    public void AddMember(BattleMemberBase battleMember);
    public void RemoveMember(BattleMemberBase battleMember);
    public void Act(BattleMemberBase battleMember,BattleAction action,float amount) throws InterruptedException;
}