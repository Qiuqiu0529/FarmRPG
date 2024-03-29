package Farm;

import Mgr.FarmMgr;

public class Flower extends Plant{


    public Flower(FlowerSeed flowerSeed){
        type="Flower";
        mature= flowerSeed.mature;
        price = 5;
        api = new flowerGrow();
    }

    public Flower(Flower flower)
    {
        age = flower.age;
        type = flower.type;
        mature = flower.mature;
    }

    public void GetAgeToMature()
    {
        if(age < mature)
        {
            System.out.println("一朵鲜花还有"+Integer.toString(mature-age)+"天成熟");
        }
        else
        {
            System.out.println("一朵鲜花已经成熟");
        }
    }

}
