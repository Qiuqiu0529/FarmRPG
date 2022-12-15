package Item.Weapon;

public class Gun implements Iweapon{
    BulletPool bulletPool;
    int bulletAmountEachTime=2;

    public Gun(WeaponAttackData data,int bulletAmountEachTime)
    {
        this.bulletAmountEachTime=bulletAmountEachTime;
        bulletPool=new BulletPool(data);
    }
    public void WeaponAttack(float actorAdd)//一个回合多次攻击
    {
        for(int i=0;i<bulletAmountEachTime;++i)
        {
            float amount=bulletPool.GetPoolObj().BulletAttackAmount();
            
            
        }
    }
}
