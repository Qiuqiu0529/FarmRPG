package Shop;

import Choice.BuyInventoryItem;
import Item.ItemTypes;
import Item.Potion.PotionAdapter;
import Item.Potion.PotionFactory;
import Item.Potion.PotionType;
import Mgr.SoundMgr;
import Other.Global;

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


        PotionAdapter energy=new PotionAdapter();
        energy.itemID=Global.energyPotion;
        energy.itemName="一次性回复药水";
        energy.description="只能使用一回合，一次性回复5点精力。";
        energy.value=20;
        energy.itemType=ItemTypes.Potion;
        energy.SetPotion(PotionFactory.GetInstance().GetInstance(PotionType.ENERGY));
        BuyInventoryItem buyenergy=new BuyInventoryItem(energy);
        goods.add(buyenergy);

        PotionAdapter energycontinue=new PotionAdapter();
        energycontinue.itemID=Global.continueEnergy;
        energycontinue.itemName="持续回复药水";
        energycontinue.description="持续作用三回合，一次回复5点精力。";
        energycontinue.value=70;
        energycontinue.itemType=ItemTypes.Potion;
        energycontinue.SetPotion(PotionFactory.GetInstance().GetInstance(PotionType.CONTINUEENERGY));
        BuyInventoryItem buycontinueenergy=new BuyInventoryItem(energycontinue);
        buycontinueenergy.SetThread(10);//购买概率偏低，默认为1，总是可以购买
        goods.add(buycontinueenergy);


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
        healcontinue.description="持续作用三回合，一次回复10点生命值。";
        healcontinue.value=70;
        healcontinue.itemType=ItemTypes.Potion;
        healcontinue.SetPotion(PotionFactory.GetInstance().GetInstance(PotionType.CONTINUEHEALING));
        BuyInventoryItem buycontinueheal=new BuyInventoryItem(healcontinue);
        buycontinueheal.SetThread(10);//购买概率偏低，默认为1，总是可以购买
        goods.add(buycontinueheal);



        PotionAdapter strength=new PotionAdapter();
        strength.itemID=Global.strengthPotion;
        strength.itemName="一次性增强攻击药水";
        strength.description="只能使用一回合，一次增加5点攻击。";
        strength.value=20;
        strength.itemType=ItemTypes.Potion;
        strength.SetPotion(PotionFactory.GetInstance().GetInstance(PotionType.ATTACK));
        BuyInventoryItem buystrength=new BuyInventoryItem(strength);
        goods.add(buystrength);

        PotionAdapter strengthcontinue=new PotionAdapter();
        strengthcontinue.itemID=Global.continueStrength;
        strengthcontinue.itemName="持续增强攻击药水";
        strengthcontinue.description="增加7点攻击，持续作用三回合。";
        strengthcontinue.value=100;
        strengthcontinue.itemType=ItemTypes.Potion;
        strengthcontinue.SetPotion(PotionFactory.GetInstance().GetInstance(PotionType.CONTINUEATTACK));
        BuyInventoryItem buycontinuestrength=new BuyInventoryItem(strengthcontinue);
        buycontinuestrength.SetThread(10);//购买概率偏低，默认为1，总是可以购买
        goods.add(buycontinuestrength);
        

        PotionAdapter defence=new PotionAdapter();
        defence.itemID=Global.defencePotion;
        defence.itemName="一次性防御药水";
        defence.description="只能使用一回合，一次性增加5点防御。";
        defence.value=20;
        defence.itemType=ItemTypes.Potion;
        defence.SetPotion(PotionFactory.GetInstance().GetInstance(PotionType.DEFENCE));
        BuyInventoryItem buydefence=new BuyInventoryItem(defence);
        goods.add(buydefence);

        PotionAdapter defencecontinue=new PotionAdapter();
        defencecontinue.itemID=Global.continueDefence;
        defencecontinue.itemName="持续防御药水";
        defencecontinue.description="增加7点防御，持续作用三回合。";
        defencecontinue.value=80;
        defencecontinue.itemType=ItemTypes.Potion;
        defencecontinue.SetPotion(PotionFactory.GetInstance().GetInstance(PotionType.CONTINUEDEFENCE));
        BuyInventoryItem buycontinuedefence=new BuyInventoryItem(defencecontinue);
        buycontinuedefence.SetThread(10);//购买概率偏低，默认为1，总是可以购买
        goods.add(buycontinuedefence);

    }
}
