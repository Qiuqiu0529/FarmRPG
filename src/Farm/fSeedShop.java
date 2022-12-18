package Farm;

import Item.ItemTypes;

//工厂模式的具体实现
public class fSeedShop implements SeedFactory{
    @Override
    public Seed create() {
        FlowerSeed f = new FlowerSeed();
        f.itemName = "鲜花种子";
        f.targetInventoryName = "MainInventory";
        f.itemType= ItemTypes.Seed;
        return f;
    }
}
