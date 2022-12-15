package Item.Potion;

import Item.Buff.EnergyBuff;
import Player.PlayerBattle;

public class EnergyPotion extends PotionBase implements IPotion {

    public EnergyPotion(int contitime, int addAmount) {
        super(contitime, addAmount);
        //TODO Auto-generated constructor stub
    }

    public void Drink() throws InterruptedException {
        EnergyBuff energyBuff=new EnergyBuff(continueTime, amount);
        PlayerBattle.GetInstance().AddEnergyBuff(energyBuff);
    }
}