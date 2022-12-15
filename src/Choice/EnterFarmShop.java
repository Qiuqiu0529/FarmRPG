package Choice;

import Mgr.SeedShopMgr;
import Player.Player;

public class EnterFarmShop extends ChoiceConsumeEnergy{
    public EnterFarmShop()
    {
        needEnergy = 1;
        description ="进入了种子商店";
    }

    public void Choose() throws InterruptedException
    {
        super.Choose();
        System.out.println(Player.playername+"进入了种子商店" );
        SeedShopMgr.GetInstance().ShopChoice();
    }
}
