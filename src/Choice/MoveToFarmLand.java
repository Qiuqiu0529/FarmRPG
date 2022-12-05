package Choice;

import Player.Player;

public class MoveToFarmLand extends ChoiceCosumeEnergy{
    public MoveToFarmLand()
    {
        needEnergy=3;
        description="去农田耕作";
    }

    public void Choose() throws InterruptedException
    {
        super.Choose();
        Player.getInstance().MoveInScene();
    }
    
}
