package Farm;

import Item.ItemTypes;
import Mgr.FarmMgr;

// 蔬菜种子
public class VegetableSeed extends Seed{
    @Override
    public void plant() throws InterruptedException{
        isPlanted=true;
        System.out.println("蔬菜种子被种下...\n");
        Vegetable vegetable=new Vegetable(new VegetableSeed());
        FarmMgr.GetInstance().vegetables.add(vegetable);
    }

    public VegetableSeed(){
        // TODO 缺少itemID
        itemName="VegetableSeed";
        itemType= ItemTypes.Seed;
        usable=true;
        consumable=true;
        value=1;
        description="蔬菜种子";

        mature=5;
    }

}
