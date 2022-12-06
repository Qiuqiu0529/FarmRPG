package Item.Buff;

import Player.EnergyPresenter;

public class EnergyBuff extends Buff{
    int addenergy=3;
    public EnergyBuff(int contitime) {
        super(contitime);
    }
    public EnergyBuff(int contitime,int addAmount)
    {
        super(contitime);
        addenergy=addAmount;
    }

    public void AddBuff() throws InterruptedException
    {
        super.AddBuff();
        EnergyPresenter.GetInstance().EarnEnergy(addenergy);
    }
    
}
