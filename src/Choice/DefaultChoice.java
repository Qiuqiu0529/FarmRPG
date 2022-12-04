package Choice;

import Player.EnergyPresenter;

public class DefaultChoice implements IChoice{
    public boolean CanChoose()
    {
       return true;
    }
    public void ChoiceInfo()
    {
        System.out.println("什么都不做（消耗精力0）");
    }
    public void Choose()
    {
        EnergyPresenter.GetInstance().SpendEnergy(0 );
        System.out.println("你选择什么都不做，悠闲地渡过了一段时光。");
    }
}
