package Choice;

import Item.InventoryItem;
import Item.InventoryMgr;
import Player.MoneyPresenter;

public class BuyInventoryItem extends ChoiceConsumeMoney{
    InventoryItem item;
    public BuyInventoryItem(InventoryItem inventoryItem)
    {
        item=inventoryItem;
        needMoney=(int) (item.value*item.quantity);
    }

    public boolean CanChoose()
    {
       return super.CanChoose();
    }

    public void ChoiceInfo()
    {
        System.out.println("购买"+item.itemName+"  X"+Integer.toString(item.quantity)+"需要花费: "+Integer.toString(needMoney));
    }
    public void Choose() throws InterruptedException
    {
        MoneyPresenter.GetInstance().SpendMoney(needMoney);
        item.TargetInventory().AddItem(item, item.quantity);
    }
}
