package Farm;

// 抽象工厂的实现
public class SeedShop implements SeedFactory{
    @Override
    public FlowerSeed createFlowerSeed(int num){
        FlowerSeed f = new FlowerSeed();
        f.quantity = num;
        f.itemName = "鲜花种子";
        f.targetInventoryName = "MainInventory";
        return f;
    }

    @Override
    public VegetableSeed createVegetableSeed(int num)
    {
        VegetableSeed v = new VegetableSeed();
        v.quantity = num;
        v.itemName = "植物种子";
        v.targetInventoryName = "MainInventory";
        return v;

    }
}
