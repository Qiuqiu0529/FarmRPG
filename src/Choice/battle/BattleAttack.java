package Choice.battle;

import Battle.BattleAction;
import Choice.ChoiceConsumeEnergy;
import Player.PlayerBattle;

public class BattleAttack extends ChoiceConsumeEnergy{
    PlayerBattle playerBattle;
    public BattleAttack(PlayerBattle playerBattle)
    {
        this.playerBattle=playerBattle;
        needEnergy=1;
        description="攻击";
    }

    public void Choose() throws InterruptedException
    {
        super.Choose();
        playerBattle.Act(BattleAction.ATTACK);
    }

}
