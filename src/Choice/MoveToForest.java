package Choice;

import Mgr.ForestMgr;
import Player.Player;

public class MoveToForest extends ChoiceCosumeEnergy{
    public MoveToForest()
    {
        needEnergy=5;
        description="去森林冒险";
    }

    public void Choose()
    {
        super.Choose();
        System.out.println(Player.playername+"来到了森林" );
        ForestMgr.GetInstance().PlayerAdVenture();
    }
}
