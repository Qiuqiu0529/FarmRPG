package Farm;

import Mgr.FarmMgr;

// 花种子
public class FlowerSeed extends Seed{
    @Override
    public void plant(){
        isPlanted=true;
        System.out.println("鲜花种子被种下...\n");
        Flower flower = new Flower(new FlowerSeed());
        new FarmMgr().getInstance().flowers.add(flower);
    }

    public FlowerSeed(){
        mature=3;
    }
}
