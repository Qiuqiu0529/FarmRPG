package Choice;

import Item.InventoryItem;
import Mgr.InputMgr;

public class UseInventoryItem implements IChoice{
    InventoryItem item;

    public UseInventoryItem(InventoryItem inventoryItem) {
        item = inventoryItem;
    }

    public boolean CanChoose() {
        return !InventoryItem.IsNull(item)&&item.quantity>0;
    }

    public void ChoiceInfo() {
        System.out.println("使用" + item.itemName+"(总数:"+Integer.toString(item.quantity)+")");
        System.out.println(item.itemName+"  "+item.description);
    }

    public void Choose() throws InterruptedException {
        System.out.println("要使用的数量为(1-100)：");
        int amount = InputMgr.GetInstance().GetInputInt(1, 101);
        for(int i=0;i<amount;++i)
        {
            if (item.quantity>=item.consumequantity)
            //实际amount是使用次数，在item里有个consumequantity（一次使用消耗数量，默认为1），如果总量够，这次choice使用物品数为amount*consumequantity
             {
                item.TargetInventory().UseItem(item,item.TargetInventory().GetItemIndex(item));
            } 
        }
        item.TargetInventory().DebugInventory();
    }
}
