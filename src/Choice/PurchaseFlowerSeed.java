package Choice;

import Mgr.InputMgr;
import Player.Player;

public class PurchaseFlowerSeed extends ChoiceConsumeMoney{

    Player player;
    private int seedNum;

    public PurchaseFlowerSeed(Player player){
        this.player=player;
        needMoney=5;
        description="购买花种";
    }

    public void Choose() throws InterruptedException{

        System.out.println(Player.playername+"选择购买花种，请输入购买个数");
        seedNum= InputMgr.GetInstance().GetInputInt(0,999);
        int i=seedNum;
        while(i!=0){
            super.Choose();
            i--;
        }

    }


}
