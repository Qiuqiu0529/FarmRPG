package Choice;

import Mgr.FarmMgr;
import Player.Player;

public class MoveToFarmLand extends ChoiceConsumeEnergy{
    public MoveToFarmLand()
    {
        needEnergy=3;
        description="去农田耕作";
    }

    // 进入农场选项
    public void Choose() throws InterruptedException
    {
        super.Choose();
        Player.getInstance().MoveInScene();
        System.out.println(Player.playername+"开始种植");
        FarmMgr.GetInstance().StartFarm();
    }
    
}
