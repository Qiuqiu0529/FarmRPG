package Choice;

import Player.MoneyController;

public class ChoiceConsumeMoney implements IChoice{

    protected int needMoney=2;//需要消耗的金钱
    protected String description="";//选项描述
    public boolean CanChoose()
    {
       return MoneyController.GetInstance().HasEnoughMoney(needMoney);
    }

    public void ChoiceInfo()
    {
        System.out.println(description+"（消耗金钱"+Integer.toString(needMoney)+"）");
    }
 
    public void Choose() throws InterruptedException
    {
        MoneyController.GetInstance().SpendMoney(needMoney);
    }
    
}
