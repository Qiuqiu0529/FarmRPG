package Item.Buff;

import Player.EnergyController;

public class EnergyBuff extends Buff{
    public EnergyBuff(int contitime) {
        super(contitime);
    }
    public EnergyBuff(int contitime,int addAmount)
    {
        super(contitime);
        amount=addAmount;
    }

    public void AddBuff() throws InterruptedException
    {
        super.AddBuff();
        EnergyController.GetInstance().EarnEnergy(amount);
    }
    
}
