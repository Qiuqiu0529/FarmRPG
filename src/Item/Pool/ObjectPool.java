package Item.Pool;

import java.util.HashSet;
import java.util.Set;

public abstract class ObjectPool<T> {
    private final Set<T> available = new HashSet<>();
    private final Set<T> inUse = new HashSet<>();

    protected abstract T Create();

    public synchronized T GetPoolObj() {
        if (available.isEmpty()) {
            available.add(Create());
        }
        var instance = available.iterator().next();
        available.remove(instance);
        inUse.add(instance);
        return instance;
    }

    public synchronized void ReturnInPool(T instance) {
        inUse.remove(instance);
        available.add(instance);
    }

    public void InitPool(int initsize)
    {
        for(int i=0;i<initsize;++i)
        {
            available.add(Create());
        }
    }
}
