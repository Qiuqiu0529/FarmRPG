package Farm;

public class Vegetable extends Plant {

    public Vegetable(VegetableSeed vegetableSeed){
        type="Vegetable";
        mature= vegetableSeed.mature;
        price = 10;
        api = new vegetableGrow();
    }

    public Vegetable(Vegetable vegetable)
    {
        age = vegetable.age;
        type = vegetable.type;
        mature = vegetable.mature;
    }

    public void GetAgeToMature()
    {
        if(age < mature)
        {
            System.out.println("一颗蔬菜还有"+Integer.toString(mature-age)+"天成熟");
        }
        else
        {
            System.out.println("一颗蔬菜已经成熟");
        }
    }
}
