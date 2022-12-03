package Choice;

import Player.EnergyPresenter;

public class ChoiceCosumeEnergy implements IChoice{

    int needEnergy=2;
    String description="";
    public boolean CanChoose()
    {
       return EnergyPresenter.GetInstance().HasEnoughEnergy(needEnergy);
    }

    public void ChoiceInfo()
    {
        System.out.println(description);
    }
    public void Choose()
    {
        EnergyPresenter.GetInstance().SpendEnergy(needEnergy);
    }
    
}
