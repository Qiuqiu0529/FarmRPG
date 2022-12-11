package Farm;

// 抽象工厂的实现
public class SeedShop implements SeedFactory{
    @Override
    public FlowerSeed createFlowerSeed(){
        return new FlowerSeed();
    }

    @Override
    public VegetableSeed createVegetableSeed(){
        return new VegetableSeed();
    }
}
