package Actor;

import Item.Weapon.Iweapon;

public class AttackWithWeapon implements IAttack{//使用武器装饰攻击
    Attack decorated;
    Iweapon wIweapon;
    
    public AttackWithWeapon(Attack decor,Iweapon weapon)
    {
        decorated=decor;
        wIweapon=weapon;
    }

    public void GiveAttack()
    {
        wIweapon.WeaponAttack(decorated.GetCurrentAttack());
    }
    
}
