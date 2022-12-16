package Shop;

import Mgr.SoundMgr;

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






    }
}
