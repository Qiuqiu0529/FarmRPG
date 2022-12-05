package Choice;

import Player.EnergyPresenter;

public class ChoiceCosumeEnergy implements IChoice{

    protected int needEnergy=2;//需要消耗的精力
    protected String description="";//选项描述
    public boolean CanChoose()
    {
       return EnergyPresenter.GetInstance().HasEnoughEnergy(needEnergy);
    }

    public void ChoiceInfo()
    {
        System.out.println(description+"（消耗精力"+Integer.toString(needEnergy)+"）");
    }
 
    public void Choose() throws InterruptedException
    {
        EnergyPresenter.GetInstance().SpendEnergy(needEnergy);
    }
    
}
