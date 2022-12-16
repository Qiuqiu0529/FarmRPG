package Shop;

import Choice.BuyInventoryItem;
import Choice.DefaultChoice;
import Item.ItemTypes;
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
        SoundMgr.GetInstance().PlayPotionShopBGM();
        System.out.println("欢迎来到"+shopname);
        super.DisplayGoods();
    }

    public void InitGoods()
    {
        shopname="药水店";
        super.InitGoods();

        PotionAdapter heal=new PotionAdapter();
        heal.itemID=Global.healingPotion;
        heal.itemName="一次性治愈药水";
        heal.description="只能使用一回合，一次性回复10点生命值。";
        heal.value=20;
        heal.itemType=ItemTypes.Potion;
        heal.SetPotion(PotionFactory.GetInstance().GetInstance(PotionType.HEALING));
        BuyInventoryItem buyheal=new BuyInventoryItem(heal);
        goods.add(buyheal);

        PotionAdapter healcontinue=new PotionAdapter();
        healcontinue.itemID=Global.continueHealing;
        healcontinue.itemName="持续治愈药水";
        healcontinue.description="持续作用三回合，一次回复10点生命值。这次用不完下次再用。";
        healcontinue.value=70;
        healcontinue.itemType=ItemTypes.Potion;
        healcontinue.SetPotion(PotionFactory.GetInstance().GetInstance(PotionType.CONTINUEHEALING));
        BuyInventoryItem buycontinueheal=new BuyInventoryItem(healcontinue);
        buycontinueheal.SetThread(10);//购买概率偏低，默认为1，总是可以购买
        goods.add(buycontinueheal);
        

    }
}
