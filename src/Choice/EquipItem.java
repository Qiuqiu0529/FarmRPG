package Choice;

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
        
        // for(int i=0;i<amount;++i)
        // {
        //     if (item.quantity>=item.consumequantity)
        //     //实际amount是使用次数，在item里有个consumequantity（一次使用消耗数量，默认为1），如果总量够，这次choice使用物品数为amount*consumequantity
        //      {
        //         item.TargetInventory().UseItem(item,item.TargetInventory().GetItemIndex(item));
        //     } 
        // }
        item.TargetInventory().DebugInventory();
    }
}
