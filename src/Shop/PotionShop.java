package Shop;

import Choice.BuyInventoryItem;
import Choice.DefaultChoice;
import Item.Potion.PotionAdapter;
import Item.Potion.PotionFactory;
import Item.Potion.PotionType;
import Mgr.SoundMgr;
import Other.Global;
import Player.Player;

public class PotionShop extends ShopBase{
    public PotionShop()
    {
        InitGoods();
    }

    public void VisitShop() throws InterruptedException
    {
        SoundMgr.GetInstance().PlayPotionShop();
        System.out.println("欢迎来到"+shopname);
        super.DisplayGoods();
    }

    public void InitGoods()
    {
        shopname="药水店";
        goods.add(new DefaultChoice("什么都不买",
        Player.playername+"离开了"+shopname));

        PotionAdapter heal=new PotionAdapter();
        heal.itemID=Global.healingPotion;
        heal.itemName="一次性治愈药水";
        heal.description="只能使用一回合，一次性回复10点生命值。";
        heal.value=20;
        heal.SetPotion(PotionFactory.GetInstance().GetInstance(PotionType.HEALING));
        BuyInventoryItem buyheal=new BuyInventoryItem(heal);
        goods.add(buyheal);










    }
}
