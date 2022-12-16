package Item.Weapon;

public class Gun extends WeaponBase{
    BulletPool bulletPool;
    int bulletAmountEachTime=2;

    public Gun(WeaponAttackData data,int bulletAmountEachTime)
    {
        weapondata=data;
        this.bulletAmountEachTime=bulletAmountEachTime;
        bulletPool=new BulletPool(weapondata);
    }
    public void WeaponAttack(float actorAdd)//一个回合多次攻击
    {
        for(int i=0;i<bulletAmountEachTime;++i)
        {
            float amount=bulletPool.GetPoolObj().BulletAttackAmount();
            
            
        }
    }
}
