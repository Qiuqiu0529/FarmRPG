package Choice;

import Item.InventoryItem;

public class UseInventoryItemOnce implements IChoice{
    InventoryItem item;

    public UseInventoryItemOnce(InventoryItem inventoryItem) {
        item = inventoryItem;
    }

    public boolean CanChoose() {
        return !InventoryItem.IsNull(item)&&item.quantity>0;
    }

    public void ChoiceInfo() {
        System.out.println("使用" + item.itemName);
        System.out.println(item.description);
    }

    public void Choose() throws InterruptedException {
       
        item.TargetInventory().UseItem(item,item.TargetInventory().GetItemIndex(item));
        item.TargetInventory().DebugInventory();
    }
}
