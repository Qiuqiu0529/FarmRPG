package Farm;

import Item.ItemTypes;

//工厂模式的实现
public class vSeedShop implements SeedFactory{
    @Override
    public Seed create() {
        VegetableSeed v = new VegetableSeed();
        v.itemName = "植物种子";
        v.targetInventoryName = "MainInventory";
        v.itemType = ItemTypes.Seed;
        return v;
    }
}
