package Farm;

import Item.ItemTypes;
import Mgr.FarmMgr;
import Other.Global;

// 蔬菜种子
public class VegetableSeed extends Seed{
    @Override
    public void plant() throws InterruptedException{
        isPlanted=true;
        System.out.println("蔬菜种子被种下...\n");
        Vegetable vegetable=new Vegetable(new VegetableSeed());
        FarmMgr.GetInstance().vegetables.add(vegetable);
    }

    public boolean Use() throws InterruptedException
    {
        isPlanted=true;
        usable = false;
        System.out.println("蔬菜种子被种下...");
        Vegetable vegetable=new Vegetable(new VegetableSeed());
        FarmMgr.GetInstance().vegetables.add(vegetable);
        return true;
    }

    public VegetableSeed(){
        itemID = Global.vegetableSeed;
        itemName="VegetableSeed";
        itemType= ItemTypes.Seed;
        usable=true;
        consumable=true;
        value=1;
        description="蔬菜种子";

        mature=5;
    }

}
