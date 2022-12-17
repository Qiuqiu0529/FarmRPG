package Item.Weapon;

public class Gun extends WeaponBase{
    BulletPool bulletPool;

    public Gun(WeaponAttackData data,int bulletAmountEachTime)
    {
        weapondata=data;
        bulletPool=new BulletPool(weapondata);
    }
    public float WeaponAttack(float actorAdd)
    {
        float amount=bulletPool.GetPoolObj().BulletAttackAmount();
        if(amount==0)
        {
            return 0;
        }
        return actorAdd+amount;
    }
}
