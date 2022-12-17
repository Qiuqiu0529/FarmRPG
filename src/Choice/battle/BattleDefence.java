package Choice.battle;

import Battle.BattleAction;
import Choice.ChoiceConsumeEnergy;
import Player.PlayerBattle;

public class BattleDefence extends ChoiceConsumeEnergy{
    PlayerBattle playerBattle;
    public BattleDefence(PlayerBattle playerBattle)
    {
        this.playerBattle=playerBattle;
        needEnergy=0;
        description="防御";
    }

    public void Choose() throws InterruptedException
    {
        super.Choose();
        playerBattle.Act(BattleAction.DEFENCE);
    }

}