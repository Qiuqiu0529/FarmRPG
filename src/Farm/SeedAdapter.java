package Farm;

import Item.InventoryItem;

public class SeedAdapter extends InventoryItem {
    Seed seed;

    public final boolean Use() throws InterruptedException{
        seed.plant(); //将种子种下去
        return true;
    }

    public void setSeed(Seed seed)
    {
        this.seed = seed;
    }

}
