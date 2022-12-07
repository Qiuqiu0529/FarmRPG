package Choice;

import Player.Player;
import Scene.iScene;

public class TownToScene extends ChoiceCosumeEnergy{
    Player player;
    iScene scene;
    public TownToScene(Player player,iScene scene)
    {
        this.player = player;
        this.scene = scene;
        needEnergy=1;
        description="前往"+scene.GetDescription();
    }
    public void Choose() throws InterruptedException
    {
        super.Choose();
        System.out.println(Player.playername + "来到了"+scene.GetDescription());
        scene.GetScene().StartVisit();
    }
}