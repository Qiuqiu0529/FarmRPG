package Farm;

//装饰器设计模式，增加价格不影响原先的object
public class FertilizedFlower extends Flower{
    public FertilizedFlower(Flower flower)
    {
        super(flower);
        price = 10;
        api = new flowerGrow();
    }
}
