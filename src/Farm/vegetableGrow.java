package Farm;

public class vegetableGrow implements PlantApi{
    @Override
    public void grow(Plant plant)
    {
        plant.age++;
        System.out.println("一颗蔬菜已经生长了"+Integer.toString(plant.age)+"天");
    }
    public  vegetableGrow(){}
}
