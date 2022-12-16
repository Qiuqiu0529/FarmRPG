package Farm;

public class Vegetable extends Plant {
    @Override
    public void grow(){
        age++;
        System.out.println("一颗蔬菜已经生长了"+Integer.toString(age)+"天");
    }

    public Vegetable(VegetableSeed vegetableSeed){
        type="Vegetable";
        mature= vegetableSeed.mature;
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
