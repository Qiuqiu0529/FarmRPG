package Choice;

import Item.InventoryItem;
import Mgr.InputMgr;

public class UseInventoryItem {
    InventoryItem item;

    public UseInventoryItem(InventoryItem inventoryItem) {
        item = inventoryItem;
    }

    public boolean CanChoose() {
        return !InventoryItem.IsNull(item);
    }

    public void ChoiceInfo() {
        System.out.println("使用" + item.itemName);
    }

    public void Choose() throws InterruptedException {
        System.out.println("要使用的数量为(1-100)：");
        int amount = InputMgr.GetInstance().GetInputInt(1, 101);
        for(int i=0;i<amount;++i)
        {
            if (item.quantity>=item.consumequantity)
             {
                item.TargetInventory().UseItem(item.itemName);
            } 
        }

        item.TargetInventory().DebugInventory();
    }
}
