package Farm;

// 抽象工厂接口
public interface SeedFactory {
    FlowerSeed createFlowerSeed(int num);
    VegetableSeed createVegetableSeed(int num);
}
