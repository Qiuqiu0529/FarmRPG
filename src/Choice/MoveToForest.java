package Choice;

import Mgr.ForestMgr;
import Player.Player;

public class MoveToForest extends ChoiceConsumeEnergy{
    public MoveToForest()
    {
        needEnergy=5;
        description="去森林冒险";
    }

    public void Choose() throws InterruptedException
    {
        super.Choose();
        Player.getInstance().MoveInScene();
        System.out.println(Player.playername+"来到了森林" );
        ForestMgr.GetInstance().StartAdventure();
    }
}
