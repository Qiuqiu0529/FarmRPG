package Choice;

import Shop.ShopBase;

public class EnterShop extends ChoiceConsumeEnergy{
    ShopBase shop;

    public EnterShop(ShopBase shop)
    {
        description="进入"+shop.shopname;
        this.shop=shop;
    }
    public void Choose() throws InterruptedException
    {
        super.Choose();
        shop.VisitShop();
    }

}
