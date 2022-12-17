package Battle;

public interface IBattleMediator {
    public void AddMember(BattleMemberBase battleMember);
    public void RemoveMember(BattleMemberBase battleMember) throws InterruptedException ;
    public void Act(BattleMemberBase battleMember,BattleAction action,float amount) throws InterruptedException;

    public boolean BattleISEND();
}