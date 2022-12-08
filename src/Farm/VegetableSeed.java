package Farm;

import Mgr.FarmMgr;

// 蔬菜种子
public class VegetableSeed extends Seed{
    @Override
    public void plant(){
        isPlanted=true;
        System.out.println("蔬菜种子被种下...\n");
        Vegetable vegetable=new Vegetable(new VegetableSeed());
        new FarmMgr().getInstance().vegetables.add(vegetable);
    }

    public VegetableSeed(){
        mature=5;
    }

}
