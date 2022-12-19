package Farm;

public class flowerGrow implements PlantApi{
    @Override
    public void grow(Plant plant)
    {
        plant.age++;
        System.out.println("一朵鲜花已经生长了"+Integer.toString(plant.age)+"天");
    }
    public flowerGrow(){}
}
