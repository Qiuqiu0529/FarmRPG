package Item.Potion;

import Item.Buff.EnergyBuff;
import Player.PlayerBattle;

public class EnergyPotion implements IPotion {
    public void Drink() throws InterruptedException {
        EnergyBuff energyBuff=new EnergyBuff(1, 5);
        PlayerBattle.GetInstance().AddEnergyBuff(energyBuff);
    }
}