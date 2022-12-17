package Item.Weapon;

import Item.Dice;

public class Bullet {
    float attackAmount=1;
    float hitthread=5;//两个骰子点数大于等于hitthread，5为容易打中
    BulletPool bulletPool;
    public Bullet(float aAmount,float thread,BulletPool bulletPool)
    {
        attackAmount=aAmount;
        hitthread=thread;
        this.bulletPool=bulletPool;
    }

    public float BulletAttackAmount()
    {
        boolean canhit=Dice.Determine(0, hitthread);
        if(!canhit)
        {
            System.out.println("未打中");
            return 0;
        }
        System.out.println("打中了，子弹伤害值为"+Float.toString(attackAmount));
        bulletPool.ReturnInPool(this);//回收子弹
        return attackAmount;
    }
}