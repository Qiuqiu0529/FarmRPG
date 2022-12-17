package Shop;

import Choice.BuyInventoryItem;
import Item.ItemTypes;
import Item.Weapon.WeaponAdapter;
import Item.Weapon.WeaponFactory;
import Item.Weapon.WeaponType;
import Mgr.SoundMgr;
import Other.Global;

public class WeaponShop extends ShopBase{
    public WeaponShop()
    {
        InitGoods();
    }

    public void VisitShop() throws InterruptedException
    {
        SoundMgr.GetInstance().PlayWeaponShopBGM();
        System.out.println("欢迎光临，这里是"+shopname);
        super.DisplayGoods();
    }


    public void InitGoods()
    {
        shopname="武器店";
        super.InitGoods();

        WeaponAdapter newbieSword=new WeaponAdapter();
        newbieSword.equippable=true;
        newbieSword.itemID=Global.newbieSword;
        newbieSword.itemName="新手剑";
        newbieSword.description="最基础的剑，攻击力一般";
        newbieSword.value=30;
        newbieSword.itemType=ItemTypes.Weapon;
        newbieSword.SetWeapon(WeaponFactory.GetInstance().GetWeapon(WeaponType.SWORD, 1));//level 1-5
        BuyInventoryItem buynewbieSword=new BuyInventoryItem(newbieSword);
        goods.add(buynewbieSword);


        WeaponAdapter newbieGun=new WeaponAdapter();
        newbieGun.equippable=true;
        newbieGun.itemID=Global.newbieGun;
        newbieGun.itemName="新手枪";
        newbieGun.description="最基础的枪，攻击力一般";
        newbieGun.value=30;
        newbieGun.itemType=ItemTypes.Weapon;
        newbieGun.SetWeapon(WeaponFactory.GetInstance().GetWeapon(WeaponType.GUN, 1));//level 1-5
        BuyInventoryItem buynewbieGun=new BuyInventoryItem(newbieGun);
        goods.add(buynewbieGun);


        WeaponAdapter normalSword=new WeaponAdapter();
        normalSword.equippable=true;
        normalSword.itemID=Global.normalSword;
        normalSword.itemName="普通剑";
        normalSword.description="稍微好一点的剑，攻击力一般";
        normalSword.value=100;
        normalSword.itemType=ItemTypes.Weapon;
        normalSword.SetWeapon(WeaponFactory.GetInstance().GetWeapon(WeaponType.SWORD, 2));//level 1-5
        BuyInventoryItem buynormalSword=new BuyInventoryItem(normalSword);
        buynormalSword.SetThread(3);
        goods.add(buynormalSword);


        WeaponAdapter normalGun=new WeaponAdapter();
        normalGun.equippable=true;
        normalGun.itemID=Global.normalGun;
        normalGun.itemName="普通枪";
        normalGun.description="稍微好一点的枪，攻击力一般,一次回合攻击两次";
        normalGun.value=100;
        normalGun.itemType=ItemTypes.Weapon;
        normalGun.SetWeapon(WeaponFactory.GetInstance().GetWeapon(WeaponType.GUN, 2));//level 1-5
        BuyInventoryItem buynormalGun=new BuyInventoryItem(normalGun);
        buynormalGun.SetThread(3);
        goods.add(buynormalGun);

        WeaponAdapter midSword=new WeaponAdapter();
        midSword.equippable=true;
        midSword.itemID=Global.midSword;
        midSword.itemName="中等剑";
        midSword.description="好一点的剑，攻击力还行";
        midSword.value=150;
        midSword.itemType=ItemTypes.Weapon;
        midSword.SetWeapon(WeaponFactory.GetInstance().GetWeapon(WeaponType.SWORD, 3));//level 1-5
        BuyInventoryItem buymidSword=new BuyInventoryItem(midSword);
        buymidSword.SetThread(7);
        goods.add(buymidSword);


        WeaponAdapter midGun=new WeaponAdapter();
        midGun.equippable=true;
        midGun.itemID=Global.midGun;
        midGun.itemName="中等枪";
        midGun.description="好一点的枪，攻击力还行,一次回合攻击两次";
        midGun.value=170;
        midGun.itemType=ItemTypes.Weapon;
        midGun.SetWeapon(WeaponFactory.GetInstance().GetWeapon(WeaponType.GUN, 3));//level 1-5
        BuyInventoryItem buymidGun=new BuyInventoryItem(midGun);
        buymidGun.SetThread(7);
        goods.add(buymidGun);

        WeaponAdapter superSword=new WeaponAdapter();
        superSword.equippable=true;
        superSword.itemID=Global.superSword;
        superSword.itemName="高级剑";
        superSword.description="高级的剑，攻击力很好";
        superSword.value=270;
        superSword.itemType=ItemTypes.Weapon;
        superSword.SetWeapon(WeaponFactory.GetInstance().GetWeapon(WeaponType.SWORD, 4));//level 1-5
        BuyInventoryItem buysuperSword=new BuyInventoryItem(superSword);
        buysuperSword.SetThread(10);
        goods.add(buysuperSword);


        WeaponAdapter superGun=new WeaponAdapter();
        superGun.equippable=true;
        superGun.itemID=Global.superGun;
        superGun.itemName="高级枪";
        superGun.description="高级的枪，攻击力很好,一次回合攻击三次";
        superGun.value=300;
        superGun.itemType=ItemTypes.Weapon;
        superGun.SetWeapon(WeaponFactory.GetInstance().GetWeapon(WeaponType.GUN, 4));//level 1-5
        BuyInventoryItem buysuperGun=new BuyInventoryItem(superGun);
        buysuperGun.SetThread(10);
        goods.add(buysuperGun);



        WeaponAdapter ultimateSword=new WeaponAdapter();
        ultimateSword.equippable=true;
        ultimateSword.itemID=Global.ultimateSword;
        ultimateSword.itemName="终极剑";
        ultimateSword.description="最好的剑，攻击力最强";
        ultimateSword.value=500;
        ultimateSword.itemType=ItemTypes.Weapon;
        ultimateSword.SetWeapon(WeaponFactory.GetInstance().GetWeapon(WeaponType.SWORD, 5));//level 1-5
        BuyInventoryItem buyultimateSword=new BuyInventoryItem(ultimateSword);
        buyultimateSword.SetThread(13);
        goods.add(buyultimateSword);


        WeaponAdapter ultimateGun=new WeaponAdapter();
        ultimateGun.equippable=true;
        ultimateGun.itemID=Global.ultimateGun;
        ultimateGun.itemName="终极枪";
        ultimateGun.description="最好的枪，攻击力最强,一次回合攻击三次";
        ultimateGun.value=600;
        ultimateGun.itemType=ItemTypes.Weapon;
        ultimateGun.SetWeapon(WeaponFactory.GetInstance().GetWeapon(WeaponType.GUN, 5));//level 1-5
        BuyInventoryItem buyultimateGun=new BuyInventoryItem(ultimateGun);
        buyultimateGun.SetThread(13);
        goods.add(buyultimateGun);
    }
}
