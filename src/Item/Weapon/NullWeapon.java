package Item.Weapon;

import javax.xml.crypto.Data;

public final class NullWeapon extends WeaponBase{
    public float WeaponAttack(float actorAdd)
    {
        return actorAdd;
    }

    public NullWeapon()
    {
        weapondata=new WeaponAttackData(0, 0, 0, 0, 1);
    }
}
