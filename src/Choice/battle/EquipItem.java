package Choice.battle;

import Choice.IChoice;
import Item.InventoryItem;

public class EquipItem implements IChoice{
    InventoryItem item;

    public EquipItem(InventoryItem inventoryItem) {
        item = inventoryItem;
    }

    public boolean CanChoose() {
        return !InventoryItem.IsNull(item)&&item.quantity>0;
    }

    public void ChoiceInfo() {
        System.out.println("装备" + item.itemName);
        System.out.println(item.itemName + item.description);
    }

    public void Choose() throws InterruptedException {
        item.TargetInventory().EquipItem(item,item.TargetInventory().GetItemIndex(item));
        item.TargetInventory().DebugInventory();
    }
}
