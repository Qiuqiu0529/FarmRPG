package Item.Buff;

import Actor.Attack;

public class AttackBuff extends Buff {//攻击力持续一段时间增加

    boolean first = true;
    Attack attack;

    public AttackBuff(int contitime) {
        super(contitime);
    }
    public void SetAttack(Attack attack)
    {
       this.attack=attack;
    }

    public AttackBuff(int contitime, int addAmount) {
        super(contitime);
        amount=addAmount;
    }

    public void AddBuff() throws InterruptedException {
        super.AddBuff();
        if (first) {
            attack.ChangeBuffAttack(amount);
            first = false;
        }
        if (continueTime <= 0) {
            CancleBuff();
        }
    }

    public void CancleBuff() throws InterruptedException {
        attack.ChangeBuffAttack(-amount);
    }

}