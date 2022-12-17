package Choice.battle;

import Battle.BattleAction;
import Choice.ChoiceConsumeEnergy;
import Player.PlayerBattle;

public class BattleEscape extends ChoiceConsumeEnergy{
    PlayerBattle playerBattle;
    public BattleEscape(PlayerBattle playerBattle)
    {
        this.playerBattle=playerBattle;
        needEnergy=0;
        description="逃跑";
    }

    public void Choose() throws InterruptedException
    {
        super.Choose();
        playerBattle.Act(BattleAction.ESCAPE);
    }

}
