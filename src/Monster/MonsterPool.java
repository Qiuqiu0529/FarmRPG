package Monster;

import Actor.AttackWithWeapon;
import Actor.Health;
import Item.Dice;
import Item.Pool.ObjectPool;
import Item.Weapon.WeaponBase;
import Item.Weapon.WeaponFactory;
import Item.Weapon.WeaponType;

public class MonsterPool extends ObjectPool<Monster> {
    int total = 0;

    public MonsterPool(int i) {
        InitPool(i);
    }

    protected Monster Create() {// 待写
        Monster temp = new Monster();
        temp.name = "Monster" + Integer.toString(total);

        int xspeed = Dice.Roll(-3, 4);// -3 3
        int yspeed = Dice.Roll(-3, 4);
        temp.SetMoveSpeed(xspeed, yspeed);

        Health health = new Health(Dice.Roll(10 + total, 10 + total * 3));
        temp.SetHealth(health);

        AttackWithWeapon attackWithWeapon = new AttackWithWeapon(3 + Dice.Roll(0, total + 1));

        if (Dice.Determine(0, 6)) {
            int weapontype = Dice.Roll(0, 2);
            WeaponBase wBase = WeaponFactory.GetInstance().GetWeapon(weapontype > 0 ? WeaponType.SWORD : WeaponType.GUN,
                    Dice.Roll(1,(total/2+1)>5?5:(total/2+1)));// 终极武器只能买
            attackWithWeapon.SetWeapon(wBase);
        }

        ++total;

        return temp;
    }
}