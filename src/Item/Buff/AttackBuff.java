package Item.Buff;

public class AttackBuff extends Buff {// 防御力持续一段时间增加

    int addattack = 3;
    boolean first = true;

    public AttackBuff(int contitime) {
        super(contitime);
    }

    public AttackBuff(int contitime, int addAmount) {
        super(contitime);
        addattack=addAmount;
    }

    public void AddBuff() throws InterruptedException {
        super.AddBuff();
        if (first) {
            first = false;
        }
        if (continueTime <= 0) {
            CancleBuff();
        }
    }

    public void CancleBuff() throws InterruptedException {

    }

}