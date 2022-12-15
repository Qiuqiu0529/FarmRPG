package Item.Potion;

import Item.Buff.HealthBuff;
import Player.PlayerBattle;

public class HealingPotion implements IPotion {
    public void Drink() throws InterruptedException {
       HealthBuff healthBuff=new HealthBuff(1,10);
       PlayerBattle.GetInstance().AddHealthBuff(healthBuff);
    }
}