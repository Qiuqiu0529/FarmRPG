package Choice;

import Player.Player;
import Scene.TownScene;

public class MoveToTown extends ChoiceConsumeEnergy{
    public MoveToTown()
    {
        needEnergy=1;
        description="去小镇上";
    }

    public void Choose() throws InterruptedException
    {
        super.Choose();
        Player.getInstance().MoveInScene();
        System.out.println(Player.playername+"来到了小镇" );
        TownScene.GetInstance().StartVisit();
    }
}
