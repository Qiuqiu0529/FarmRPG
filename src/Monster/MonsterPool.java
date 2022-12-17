package Monster;
import Item.Pool.ObjectPool;

public class MonsterPool  extends ObjectPool<Monster> {
    public MonsterPool(int i)
    {
        InitPool(i);
    }

    protected Monster Create() {//待写
       
    }
}