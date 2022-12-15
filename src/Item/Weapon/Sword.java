package Item.Weapon;

import java.util.Random;

import Item.Dice;

public class Sword implements Iweapon{
    WeaponAttackData swordData;

    public Sword(WeaponAttackData data)
    {
        swordData=data;
    }

    public void WeaponAttack(float actorAdd)//一个回合一次攻击
    {
        boolean cretical=Dice.Determine(0, swordData.maxthread);
        float amount=0;
        if(cretical)
        { 
            amount=swordData.maxAttackAmount;
            System.out.println("暴击，伤害值为"+Float.toString(amount));
        }
        else
        {
            boolean normal=Dice.Determine(0, swordData.minthread);
            if(normal)
            {
                amount=new Random().nextInt(swordData.minAttackAmount, swordData.maxAttackAmount);
                System.out.println("打中了，伤害值为"+Float.toString(amount));
            }
            else
            {
                System.out.println("未打中");
            }
        }
    }
    
}
