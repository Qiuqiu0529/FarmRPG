package Battle;

public interface IBattleMember {
    public void JoinBattle(IBattleMediator battleMediator);
    public void BattleAction(BattleAction action,float amount);
    public void Act(BattleAction action);
}