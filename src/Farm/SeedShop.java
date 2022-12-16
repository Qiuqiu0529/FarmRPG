package Farm;

// 抽象工厂的实现
public class SeedShop implements SeedFactory{
    @Override
    public FlowerSeed createFlowerSeed(){
        FlowerSeed f = new FlowerSeed();
        f.itemName = "鲜花种子";
        f.targetInventoryName = "MainInventory";
        return f;
    }

    @Override
    public VegetableSeed createVegetableSeed()
    {
        VegetableSeed v = new VegetableSeed();
        v.itemName = "植物种子";
        v.targetInventoryName = "MainInventory";
        return v;

    }
}
