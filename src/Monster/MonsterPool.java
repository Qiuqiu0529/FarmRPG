package Monster;

import Actor.AttackWithWeapon;
import Actor.Defence;
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

        Health health = new Health(Dice.Roll(10 + total, 11 + total * 2));
        temp.SetHealth(health);

        AttackWithWeapon attackWithWeapon = new AttackWithWeapon(3 + Dice.Roll(0, total + 1));

        if (Dice.Determine(0, 6)) {
            int weapontype = Dice.Roll(0, 2);
            WeaponBase wBase = WeaponFactory.GetInstance().GetWeapon(weapontype > 0 ? WeaponType.SWORD : WeaponType.GUN,
                    Dice.Roll(1,(total/2+2)>5?5:(total/3+2)));// 终极武器只能买
            attackWithWeapon.SetWeapon(wBase);
        }
        temp.SetAttack(attackWithWeapon);

        Defence defence=new Defence(Dice.Roll(1, 2 + Dice.Roll(0, total + 1)));
        temp.SetDefence(defence);

        ++total;

        return temp;
    }
}