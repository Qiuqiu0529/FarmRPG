package Choice;

import Item.InventoryItem;

public class LookInventoryItem implements IChoice{
    InventoryItem item;
    public LookInventoryItem(InventoryItem inventoryItem)
    {
        item=inventoryItem;
    }
    public boolean CanChoose()
    {
       return !InventoryItem.IsNull(item);
    }
    public void ChoiceInfo()
    {
        System.out.println(item.itemName+"  X"+Integer.toString(item.quantity));
    }
    public void Choose() throws InterruptedException
    {
        System.out.println(item.itemName+item.description);
    }
}
