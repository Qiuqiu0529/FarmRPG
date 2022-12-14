package Farm;

import Mgr.FarmMgr;

public class Flower extends Plant{
    @Override
    public void grow(){
        System.out.println("鲜花正在生长...");
        age++;
    }

    public Flower(FlowerSeed flowerSeed){
        type="Flower";
        mature= flowerSeed.mature;
    }
}
