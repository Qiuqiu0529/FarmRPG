package Choice;

import Player.EnergyPresenter;

public class ChoiceCosumeEnergy implements IChoice{

    protected int needEnergy=2;
    protected String description="";
    public boolean CanChoose()
    {
       return EnergyPresenter.GetInstance().HasEnoughEnergy(needEnergy);
    }

    public void ChoiceInfo()
    {
        System.out.println(description+"（消耗精力"+Integer.toString(needEnergy)+"）");
    }
    public void Choose()
    {
        EnergyPresenter.GetInstance().SpendEnergy(needEnergy);
    }
    
}
