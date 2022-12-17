package Item.Weapon;

public class WeaponBase implements Iweapon{
    protected WeaponAttackData weapondata;
    protected WeaponType type=WeaponType.SWORD;
    public float WeaponAttack(float actorAdd)
    {
        return actorAdd;
    }


    public int GetEachAttackCount()
    {
        return weapondata.attackCountEachTurn;
    }
}
