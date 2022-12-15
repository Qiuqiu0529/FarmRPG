package Battle;

public class BattleMemberBase implements IBattleMember{
    protected IBattleMediator iBattleMediator;

    public void JoinBattle(IBattleMediator battleMediator)
    {
        this.iBattleMediator=battleMediator;
    }

    public void BattleAction(BattleAction action,float amount)
    {

    }

    public void Act(BattleAction action)
    {

    }
    
}
