package Battle;

public interface IBattleMember {
    public void JoinBattle(IBattleMediator battleMediator) throws InterruptedException;
    public void OneRoundUp() throws InterruptedException;
    public void BattleAction(BattleAction action,float amount) throws InterruptedException;//battle调用
    public void Act(BattleAction action) throws InterruptedException;//自己的行为
}