package Item.Potion;

import Item.Buff.AttackBuff;
import Player.PlayerBattle;

public class StrengthPotion extends PotionBase implements IPotion {
    public StrengthPotion(int contitime, int addAmount) {
        super(contitime, addAmount);
        // TODO Auto-generated constructor stub
    }

    public void Drink() throws InterruptedException {
        AttackBuff attackBuff=new AttackBuff(continueTime,amount);
        PlayerBattle.GetInstance().AddAttackBuff(attackBuff);
    }
}