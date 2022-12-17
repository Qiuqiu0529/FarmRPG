package Battle;

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
    }

    public void Choose() throws InterruptedException {
        
        
        item.TargetInventory().DebugInventory();
    }
}
