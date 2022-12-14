package Item.Weapon;

public class Gun implements Iweapon{
    BulletPool bulletPool;
    int bulletAmountEachTime=2;

    public Gun(WeaponAttackData data,int bulletAmountEachTime)
    {
        this.bulletAmountEachTime=bulletAmountEachTime;
        bulletPool=new BulletPool(data);
    }
    public void WeaponAttack(float actorAdd)
    {
        for(int i=0;i<bulletAmountEachTime;++i)
        {
            
        }

    }
  

}
