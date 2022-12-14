package Farm;

import Item.ItemTypes;
import Mgr.FarmMgr;

// 花种子
public class FlowerSeed extends Seed{
    @Override
    public void plant() throws InterruptedException {
        isPlanted=true;
        System.out.println("鲜花种子被种下...");
        Flower flower = new Flower(new FlowerSeed());
        FarmMgr.GetInstance().flowers.add(flower);
    }

    public FlowerSeed(){
        // TODO 缺少itemID
        itemName="FlowerSeed";
        itemType= ItemTypes.Seed;
        usable=true;
        consumable=true;
        value=3;
        description="花种子";

        mature=3;
    }
}
