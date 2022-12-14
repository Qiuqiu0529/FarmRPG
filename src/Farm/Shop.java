package Farm;

import Item.Inventory;
import Item.InventoryMgr;

// 面向用户的种子商店
public class Shop {
    private SeedFactory factory;

    public Shop(SeedFactory factory){
        this.factory=factory;
    }


    public void buyFlowerSeeds(int seedNum){
        // 抽象工厂生产种子后，放入背包中
        FlowerSeed flowerseed=factory.createFlowerSeed();
        Inventory backpack= InventoryMgr.FindInventory("Main");
        backpack.AddItem(flowerseed,seedNum);
    }

    public void buyVegetableSeeds(int seedNum){
        // 抽象工厂生产种子后，放入背包中
        VegetableSeed vegetableSeed=factory.createVegetableSeed();
        Inventory backpack=InventoryMgr.FindInventory("Main");
        backpack.AddItem(vegetableSeed,seedNum);
    }
}
