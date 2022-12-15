package Choice;

import Item.InventoryItem;
import Mgr.InputMgr;
import Mgr.SoundMgr;
import Player.MoneyPresenter;

public class BuyInventoryItem extends ChoiceConsumeMoney {
    InventoryItem item;

    public BuyInventoryItem(InventoryItem inventoryItem) {
        item = inventoryItem;
        needMoney = (int) (item.value);
    }

    public boolean CanChoose() {
        return true;
    }

    public void ChoiceInfo() {
        System.out.println("购买" + item.itemName + "X1 " + "需要花费: " + Integer.toString(needMoney));
    }

    public void Choose() throws InterruptedException {
        System.out.println("你要购买的数量为(1-100)：");
        int amount = InputMgr.GetInstance().GetInputInt(1, 101);
        if (MoneyPresenter.GetInstance().HasEnoughMoney(amount * needMoney)) {
            MoneyPresenter.GetInstance().SpendMoney(amount * needMoney);
            item.TargetInventory().AddItem(item, amount);
            SoundMgr.GetInstance().PlayCoinSound();
        }else
        {
            System.out.println("金钱不足，购买失败。");
        }
        item.TargetInventory().DebugInventory();
    }
}
