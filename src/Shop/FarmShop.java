package Shop;

import Choice.BuyInventoryItem;
import Farm.SeedAdapter;
import Farm.SeedShop;
import Other.Global;

public class FarmShop extends ShopBase{
    public void InitGoods()
    {
        shopname = "农场商店";
        super.InitGoods();

        SeedAdapter f = new SeedAdapter();
        f.itemID = Global.flowerSeed;
        f.itemName = "鲜花种子";
        f.description = "可以用来种花";
        f.value = 3;
        f.setSeed(new SeedShop().createFlowerSeed());
        BuyInventoryItem buyF = new BuyInventoryItem(f);
        goods.add(buyF);

        SeedAdapter v = new SeedAdapter();
        v.itemID = Global.vegetableSeed;
        v.itemName = "蔬菜种子";
        v.description = "可以用来种蔬菜";
        v.value = 5;
        v.setSeed(new SeedShop().createVegetableSeed());
        BuyInventoryItem buyV = new BuyInventoryItem(v);
        goods.add(buyV);
    }

    public FarmShop(){InitGoods();}

    public void VisitShop() throws InterruptedException
    {
        System.out.println("欢迎来到"+shopname);
        super.DisplayGoods();
    }

}
