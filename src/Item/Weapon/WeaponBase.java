package Item.Weapon;

public class WeaponBase implements Iweapon{
    WeaponAttackData weapondata;
    public float WeaponAttack(float actorAdd)
    {
        return actorAdd;
    }

    public int AttackEachTurn()
    {
        return weapondata.attackCountEachTurn;
    }
}
