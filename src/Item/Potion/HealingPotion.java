package Item.Potion;

import Item.Buff.HealthBuff;
import Player.PlayerBattle;

public class HealingPotion  extends PotionBase implements IPotion {
    public HealingPotion(int contitime, int addAmount) {
        super(contitime, addAmount);
    }

    public void Drink() throws InterruptedException {
       HealthBuff healthBuff=new HealthBuff(continueTime, amount);
       PlayerBattle.GetInstance().AddHealthBuff(healthBuff);
    }
}