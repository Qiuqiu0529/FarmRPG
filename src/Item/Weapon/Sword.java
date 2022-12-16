package Item.Weapon;

import java.util.Random;

import Item.Dice;

public class Sword extends WeaponBase{
    
    public Sword(WeaponAttackData data)
    {
        weapondata=data;
    }

    public void WeaponAttack(float actorAdd)//一个回合一次攻击
    {
        boolean cretical=Dice.Determine(0, weapondata.maxthread);
        float amount=0;
        if(cretical)
        { 
            amount=weapondata.maxAttackAmount;
            System.out.println("暴击，伤害值为"+Float.toString(amount));
        }
        else
        {
            boolean normal=Dice.Determine(0, weapondata.minthread);
            if(normal)
            {
                amount=new Random().nextInt(weapondata.minAttackAmount, weapondata.maxAttackAmount);
                System.out.println("打中了，伤害值为"+Float.toString(amount));
            }
            else
            {
                System.out.println("未打中");
            }
        }
    }
    
}
