package Choice;

import Shop.ShopBase;

public class EnterShop implements IChoice{
    ShopBase shop;

    public EnterShop(ShopBase shop)
    {
        this.shop=shop;
    }
    public boolean CanChoose()
    {
        return true;
    }

    public void ChoiceInfo()
    {
        System.out.println("进入"+shop.shopname);
    }
    public void Choose() throws InterruptedException
    {
        shop.VisitShop();
    }

}
