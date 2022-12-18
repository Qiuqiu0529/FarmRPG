package Item;

import java.util.ArrayList;
import java.util.List;

import Choice.IChoice;
import Choice.UseInventoryItem;
import Choice.UseInventoryItemOnce;

public class Inventory {// 物品可以加入背包、移出背包、装备（或解除装备如果物体可装备）、被丢弃
    public String inventoryName = "MainInventory";

    public static enum InventoryTypes {
        Main, Equipment
    }// 装备和消耗品

    public List<InventoryItem> content = new ArrayList<>();

    public InventoryTypes inventoryType = InventoryTypes.Main;

    public void Regesiter() {
        InventoryMgr.GetInstance().RegisterInventory(this);
    }

    public Inventory() {
        Regesiter();
    }

    public Inventory(String name) {
        inventoryName = name;
        Regesiter();
    }

    public boolean AddItem(InventoryItem itemToAdd, int quantity) {
        if (itemToAdd == null) {
            System.out.println("需要加入的物品不存在");
            return false;
        }
        List<Integer> list = InventoryContains(itemToAdd.itemID);

        if (list.size() > 0 && itemToAdd.maxStack > 1) {
            for (int i = 0; i < list.size(); i++) {
                if (content.get(list.get(i)).quantity < itemToAdd.maxStack) {
                    content.get(list.get(i)).quantity += quantity;
                    if (content.get(list.get(i)).quantity > itemToAdd.maxStack)// 加过头
                    {
                        InventoryItem restToAdd = itemToAdd;
                        int tempquality = content.get(list.get(i)).quantity - itemToAdd.maxStack;
                        content.get(list.get(i)).quantity = itemToAdd.maxStack;
                        AddItem(restToAdd, tempquality);
                    }
                    return true;
                }
            }
        } // 已在里面，加数量

        while (quantity > 0) {
            if (quantity > itemToAdd.maxStack) {
                AddItem(itemToAdd, itemToAdd.maxStack);
                quantity -= itemToAdd.maxStack;
            } else {
                AddItemToArray(itemToAdd, quantity);
                quantity = 0;
            }
        }
        return true;

    }

    protected Boolean AddItemToArray(InventoryItem itemToAdd, int quantity) {
        int i = 0;
        while (i < content.size()) {
            if (InventoryItem.IsNull(content.get(i))) {
                content.set(i, itemToAdd.clone());// 加入背包的是clone
                content.get(i).quantity = quantity;
                return true;
            }
            i++;
        }
        content.add(itemToAdd.clone());
        content.get(i).quantity = quantity;
        return true;
    }

    public boolean AddItemAt(InventoryItem itemToAdd, int quantity, int destinationIndex) {
        if (!InventoryItem.IsNull(content.get(destinationIndex))) {
            return false;
        }

        int tempQuantity = quantity;
        if (tempQuantity > itemToAdd.maxStack) {
            tempQuantity = itemToAdd.maxStack;
        }
        content.set(destinationIndex, itemToAdd.clone());
        content.get(destinationIndex).quantity = tempQuantity;
        return true;
    }

    public void DebugInventory() {
        System.out.println("DebugInventory");
        System.out.println("背包格子数（用完后设null，格子仍然存在，新物体进来优先填null格子");
        System.out.println(content.size());
        for (int i = 0; i < content.size(); i++) {
            if (!InventoryItem.IsNull(content.get(i))) {
                System.out.println(content.get(i).itemName + Integer.toString(content.get(i).quantity));
            }
        }
    }

    public List<Integer> InventoryContains(String searchedItemID)// 查找具体物品
    {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < content.size(); i++) {
            if (!InventoryItem.IsNull(content.get(i))) {
                if (content.get(i).itemID == searchedItemID) {
                    list.add(i);
                }
            }
        }
        return list;
    }

    public List<Integer> InventoryContains(ItemTypes itemType)// 查找一类物品
    {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < content.size(); i++) {
            if (!InventoryItem.IsNull(content.get(i))) {
                if (content.get(i).itemType == itemType) {
                    list.add(i);
                }
            }
        }
        return list;
    }

    public List<IChoice> ChooseInventoryUse(ItemTypes itemType)// 查找一类物品
    {
        List<IChoice> uselist = new ArrayList<>();
        for (int i = 0; i < content.size(); i++) {
            if (!InventoryItem.IsNull(content.get(i))) {
                if (content.get(i).itemType == itemType) {
                    UseInventoryItem useInventoryItem = new UseInventoryItem(content.get(i));
                    uselist.add(useInventoryItem);
                }
            }
        }
        return uselist;
    }

    public List<IChoice> ChooseInventoryEquip()// 查找装备
    {
        List<IChoice> uselist = new ArrayList<>();
        for (int i = 0; i < content.size(); i++) {
            if (!InventoryItem.IsNull(content.get(i))) {
                if (content.get(i).itemType == ItemTypes.Weapon) {
                    Choice.battle.EquipItem wItem=new Choice.battle.EquipItem(content.get(i));
                    uselist.add(wItem);
                }
            }
        }
        return uselist;
    }

    public List<IChoice> ChooseInventorySingle(ItemTypes itemType)// 查找只能用一次的
    {
        List<IChoice> uselist = new ArrayList<>();
        for (int i = 0; i < content.size(); i++) {
            if (!InventoryItem.IsNull(content.get(i))) {
                if (content.get(i).itemType == itemType) {
                    UseInventoryItemOnce useInventoryItem = new UseInventoryItemOnce(content.get(i));
                    uselist.add(useInventoryItem);
                }
            }
        }
        return uselist;
    }

    public InventoryItem GetItem(int i) {
        if (i < 0 || i >= content.size()) {
            System.out.println("超过背包范围");
            return null;
        }
        if (InventoryItem.IsNull(content.get(i))) {
            System.out.println("物品不存在");
            return null;
        }
        return content.get(i);
    }

    public Iterator<InventoryItem> iterator(ItemTypes itemType)// 迭代法查找一类物品
    {
        return new InventoryIterator(this, itemType);
    }

    public Integer GetQuantity(String searchedItemID) {
        List<Integer> list = InventoryContains(searchedItemID);
        int total = 0;
        for (Integer integer : list) {
            total += content.get(integer).quantity;
        }
        return total;
    }

    public Integer GetItemIndex(InventoryItem item) {
        int i = content.indexOf(item);
        return i;
    }

    protected boolean RemoveItemFromArray(int i) {
        if (i < content.size()) {
            content.set(i, null);
            return true;
        }
        return false;
    }

    public boolean RemoveItem(int i, int quantity) {
        if (i < 0 || i >= content.size()) {
            System.out.println("超过背包范围");
            return false;
        }
        if (InventoryItem.IsNull(content.get(i))) {
            System.out.println("物品不存在");
            return false;
        }

        quantity = Math.max(0, quantity);
        content.get(i).quantity -= quantity;
        if (content.get(i).quantity <= 0) {
            Boolean suppressionSuccessful = RemoveItemFromArray(i);
            return suppressionSuccessful;
        } else {
            return true;
        }
    }

    public boolean RemoveItemByID(String itemID, int quantity) {
        if (quantity < 1) {
            System.out.println("移除物品数量不能小于1");
            return false;
        }

        if (itemID == null || itemID == "") {
            System.out.println("需要移除的物品不存在");
            return false;
        }
        int quantityLeftToRemove = quantity;

        List<Integer> list = InventoryContains(itemID);
        for (Integer integer : list) {
            int quantityAtIndex = content.get(integer).quantity;
            RemoveItem(integer, quantityLeftToRemove);
            quantityLeftToRemove -= quantityAtIndex;
            if (quantityLeftToRemove <= 0) {
                return true;
            }
        }

        return true;
    }

    public boolean UseItem(InventoryItem item, int index) throws InterruptedException {
        if (InventoryItem.IsNull(item)) {
            return false;
        }
        if (!item.usable) {
            return false;
        }
        if (item.Use()) {
            if (item.consumable) {
                RemoveItem(index, item.consumequantity);
            }
        }
        return true;
    }

    public boolean UseItem(String itemName) throws InterruptedException {
        List<Integer> list = InventoryContains(itemName);
        if (list.size() > 0) {
            UseItem(content.get(list.get(list.size() - 1)), list.get(list.size() - 1));
            return true;
        } else {
            return false;
        }
    }

    public void EmptyInventory() {
        content = new ArrayList<>(content.size());
    }

    public void EquipItem(InventoryItem item, int index) throws InterruptedException {
        if (inventoryType == Inventory.InventoryTypes.Main) {
            InventoryItem oldItem = null;
            if (InventoryItem.IsNull(item)) {
                return;
            }
            if (!item.equippable) {
                return;
            }
            if (item.TargetEquipmentInventory() == null) {
                System.out.println("目标装备者为空");
                return;
            }

            if (!item.Equip()) {
                return;
            }
            // 只能装备一个，替换
            if (item.TargetEquipmentInventory().content.size() == 1) {
                if (!InventoryItem.IsNull(item.TargetEquipmentInventory().content.get(0))) {
                    oldItem = item.TargetEquipmentInventory().content.get(0).clone();
                    item.TargetEquipmentInventory().EmptyInventory();
                }
            }

            item.TargetEquipmentInventory().AddItem(item.clone(), item.quantity);
            RemoveItem(index, item.quantity);// 从当前背包装备、背包里的物品数量减去

            if (oldItem != null) {
                oldItem.UnEquip();
                AddItem(oldItem, oldItem.quantity);
            }
        }
    }

    public void DropItem(InventoryItem item, int index) throws InterruptedException {
        if (InventoryItem.IsNull(item)) {
            return;
        }

        if (this.inventoryName == item.targetEquipmentInventoryName) {
            if (item.UnEquip()) {
                DestroyItem(index);
            }
        } else {
            DestroyItem(index);
        }

    }

    public void GiveItem(InventoryItem item, int index) throws InterruptedException {
        if (InventoryItem.IsNull(item)) {
            return;
        }

        if (this.inventoryName == item.targetEquipmentInventoryName) {
            if (item.UnEquip()) {
                if (item.Give()) {
                    DestroyItem(index);
                }

            }
        } else {
            if (item.Give()) {
                DestroyItem(index);
            }
        }
    }

    public boolean DestroyItem(int i) {
        content.set(i, null);
        return true;
    }

    public void DestroyItem(InventoryItem item, int index) {
        if (InventoryItem.IsNull(item)) {
            return;
        }
        DestroyItem(index);
    }

    public void UnEquipItem(InventoryItem item, int index) throws InterruptedException {
        if (InventoryItem.IsNull(item)) {
            return;
        }
        if (inventoryType != InventoryTypes.Equipment) {
            return;
        }
        if (!item.UnEquip()) {
            return;
        }
        if (item.TargetInventory() != null) {
            if (item.TargetInventory().AddItem(item, item.quantity)) {
                DestroyItem(index);
            }
        }
    }

}
