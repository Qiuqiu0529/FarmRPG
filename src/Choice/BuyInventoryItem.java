package Choice;

import Item.Dice;
import Item.InventoryItem;
import Mgr.InputMgr;
import Mgr.SoundMgr;
import Player.MoneyPresenter;
import Player.Player;

public class BuyInventoryItem extends ChoiceConsumeMoney {
    InventoryItem item;
    int thread = 1;// 能够买的概率，加点抽卡感觉

    public BuyInventoryItem(InventoryItem inventoryItem) {
        item = inventoryItem;
        needMoney = (int) (item.value);
    }

    public boolean CanChoose() {
        return Dice.Determine(Player.lucky, thread);// thread类极乐迪斯科
    }

    public void SetThread(int thread) {
        this.thread = thread;
    }

    public void ChoiceInfo() {
        System.out.println("购买" + item.itemName  + "  每份需要花费: " + Integer.toString(needMoney));
        System.out.println(item.itemName + item.description);
    }

    public void Choose() throws InterruptedException {
        System.out.println("你要购买的数量为(1-100)：");
        int amount = InputMgr.GetInstance().GetInputInt(1, 101);
        if (MoneyPresenter.GetInstance().HasEnoughMoney(amount * needMoney)) {
            MoneyPresenter.GetInstance().SpendMoney(amount * needMoney);
            item.TargetInventory().AddItem(item, amount);
            SoundMgr.GetInstance().PlayCoinSound();
        } else {
            System.out.println("金钱不足，购买失败。");
        }
        item.TargetInventory().DebugInventory();
    }
}
