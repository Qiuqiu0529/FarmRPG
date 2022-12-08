package Farm;

// 定义抽象种子类
// 种子和具体的种子解耦，使用了桥接模式(bridge)
public abstract class Seed {

    protected Plant plant;

    protected int mature;

    protected boolean isPlanted=false;

    public void setPlant(Plant plant){
        this.plant=plant;
    }

    // 抽象种植函数
    public abstract void plant();

}



