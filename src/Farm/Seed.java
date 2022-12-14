package Farm;

import Item.InventoryItem;

// 定义抽象种子类
// 种子和具体的种子解耦，使用了桥接模式(bridge)
public abstract class Seed extends InventoryItem {

    protected int mature;

    protected boolean isPlanted=false;

    // 抽象种植函数
    public abstract void plant() throws InterruptedException;

}



