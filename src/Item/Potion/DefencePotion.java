package Item.Potion;

import Item.Buff.DefenceBuff;
import Player.PlayerBattle;

public class DefencePotion extends PotionBase implements IPotion {

    public DefencePotion(int contitime, int addAmount) {
        super(contitime, addAmount);
    }

    public void Drink() throws InterruptedException {
        DefenceBuff defenceBuff=new DefenceBuff(continueTime,amount);
        PlayerBattle.GetInstance().AddDefenceBuff(defenceBuff);
    }
    
}
