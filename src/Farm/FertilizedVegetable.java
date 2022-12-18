package Farm;

//装饰器设计模式，增加价格不影响原先的object
public class FertilizedVegetable extends Vegetable{
    public FertilizedVegetable(Vegetable vegetable)
    {
        super(vegetable);
        price = 15;
    }
}
