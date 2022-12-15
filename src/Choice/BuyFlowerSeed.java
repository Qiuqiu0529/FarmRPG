package Choice;

import Farm.FlowerSeed;
import Farm.SeedShop;
import Farm.Shop;
import Mgr.InputMgr;
import Player.MoneyPresenter;
import Player.Player;

public class BuyFlowerSeed extends ChoiceConsumeMoney{
    FlowerSeed flowerSeed;

    public BuyFlowerSeed()
    {
        description = "准备购买鲜花种子";
    }

    public boolean CanChoose()
    {
        return !super.CanChoose();
    }

    public void ChoiceInfo()
    {
        System.out.println("购买鲜花种子，单价3元");
    }
    public void Choose() throws InterruptedException
    {

        System.out.println(Player.playername+"准备购买鲜花种子，请输入准备购买的数量" );
        int n = InputMgr.GetInstance().GetInputInt(1,999);
        needMoney = (int)(n * new FlowerSeed().value);
        SeedShop s = new SeedShop();
        flowerSeed = s.createFlowerSeed(n);
        MoneyPresenter.GetInstance().SpendMoney(needMoney);
        flowerSeed.TargetInventory().AddItem(flowerSeed, flowerSeed.quantity);


    }
}
