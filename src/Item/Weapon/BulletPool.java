package Item.Weapon;

import java.util.Random;

import Item.Pool.ObjectPool;

public class BulletPool extends ObjectPool<Bullet> {
    WeaponAttackData gunBulletData;
    // 有的枪品质不稳定，有的还可以，调参即可

    public BulletPool(WeaponAttackData data) {
        this.gunBulletData = data;
        InitPool(5);
    }

    protected Bullet Create() {
        return new Bullet(new Random().nextInt(gunBulletData.minAttackAmount, gunBulletData.maxAttackAmount),
                new Random().nextInt(gunBulletData.minthread, gunBulletData.maxthread));
    }
}