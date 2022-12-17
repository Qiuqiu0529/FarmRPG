package Item.Weapon;

import Item.Dice;

public class WeaponFactory {

    private static volatile WeaponFactory instance;

    public static WeaponFactory GetInstance() {
        var result = instance;
        if (result == null) {
            synchronized (WeaponFactory.class) {
                result = instance;
                if (result == null) {
                    instance = result = new WeaponFactory();
                }
            }
        }
        return result;
    }

    public WeaponBase GetWeapon(WeaponType type, int level)// level 1-5
    {
        WeaponAttackData data=
        new WeaponAttackData(level*2+1, level*2+7+Dice.Roll(0, level), 
        7-level, 15-level,
        1);
        WeaponBase temp=new WeaponBase();
        switch (type) {
            case SWORD:
                temp=new Sword(data);
                break;
            case GUN:
                data.attackCountEachTurn=level/2 +1;
                temp=new Gun(data);
                break;
            default:
                break;
        }
        return temp;
    }

}
