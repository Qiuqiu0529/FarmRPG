package Choice;

import Mgr.FarmMgr;
import Mgr.SoundMgr;
import Player.MoneyController;

public class FertilizeChoice extends ChoiceConsumeMoney{
    public FertilizeChoice() throws InterruptedException
    {
        description ="花钱给农场施肥,农场里现有的鲜花作物售价会变为10，蔬菜会变为15";
        needMoney = 20;
    }

    public void Choose() throws InterruptedException
    {
        if (MoneyController.GetInstance().HasEnoughMoney(needMoney)) {
            MoneyController.GetInstance().SpendMoney(needMoney);
            FarmMgr.GetInstance().FertilizePlants();
            SoundMgr.GetInstance().PlayCoinSound();
        } else {
            System.out.println("金钱不足，购买失败。");
        }
    }

}
