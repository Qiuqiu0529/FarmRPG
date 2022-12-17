package Battle;

public interface IBattleMember {
    public void JoinBattle(IBattleMediator battleMediator);
    public void OneRoundUp() throws InterruptedException;
    public void BattleAction(BattleAction action,float amount);
    public void Act(BattleAction action);
}