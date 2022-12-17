package Item.Weapon;

import java.util.Random;

import Item.Dice;
import Mgr.SoundMgr;

public class Sword extends WeaponBase{
    
    public Sword(WeaponAttackData data)
    {
        weapondata=data;
    }

    public float WeaponAttack(float actorAdd)//一个回合一次攻击
    {
        SoundMgr.GetInstance().
        PlaySwordSound();
        boolean cretical=Dice.Determine(0, weapondata.maxthread);
        float amount=actorAdd;
        if(cretical)
        { 
            amount+=weapondata.maxAttackAmount;
            System.out.println("暴击，伤害值为"+Float.toString(amount));
        }
        else
        {
            boolean normal=Dice.Determine(0, weapondata.minthread);
            if(normal)
            {
                amount+=new Random().nextInt(weapondata.minAttackAmount, weapondata.maxAttackAmount);
                System.out.println("打中了，伤害值为"+Float.toString(amount));
            }
            else
            {
                System.out.println("未打中");
                return 0;
            }
        }
        return amount;
    }
    
}
