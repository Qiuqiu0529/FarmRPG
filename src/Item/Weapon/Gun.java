package Item.Weapon;

import Mgr.SoundMgr;

public class Gun extends WeaponBase{
    BulletPool bulletPool;

    public Gun(WeaponAttackData data)
    {
        weapondata=data;
        bulletPool=new BulletPool(weapondata);
        type=WeaponType.GUN;
    }
    public float WeaponAttack(float actorAdd)
    {
        SoundMgr.GetInstance().
        PlayGunSound();
        float amount=bulletPool.GetPoolObj().BulletAttackAmount();
        return actorAdd+amount;
    }
}
