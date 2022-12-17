package Actor;

import Item.Weapon.NullWeapon;
import Item.Weapon.WeaponBase;

public class AttackWithWeapon implements IAttack {// 使用武器装饰攻击
    Attack decorated;
    WeaponBase weapon;

    public AttackWithWeapon(float base) {
        decorated = new Attack(base);
        weapon = new NullWeapon();
    }

    public AttackWithWeapon(float base, WeaponBase weapon) {
        decorated = new Attack(base);
        this.weapon = weapon;
    }

    public void ChangeBuffAttack(float change) {
        decorated.ChangeBuffAttack(change);
    }

    public Attack GetAttack() {
        return decorated;
    }

    public void ChangeBase(float change) {
        decorated.ChangeBase(change);
    }

    public AttackWithWeapon(Attack decor, WeaponBase weapon) {
        decorated = decor;
        this.weapon = weapon;
    }

    public void SetWeapon(WeaponBase weapon) {
        this.weapon = weapon;
    }

    public float GiveAttack() {
        return weapon.WeaponAttack(decorated.GiveAttack());// 攻击为基础+武器
    }

    public int GetEachAttackCount() {
        return weapon.GetEachAttackCount();
    }

}
