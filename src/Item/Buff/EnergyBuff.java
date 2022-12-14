package Item.Buff;

import Player.EnergyPresenter;

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
        EnergyPresenter.GetInstance().EarnEnergy(amount);
    }
    
}
