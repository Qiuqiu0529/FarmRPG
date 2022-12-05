package Item;

import java.time.temporal.TemporalUnit;

public class InventoryItem implements Cloneable {// prototype，代表背包里的物体
    public String itemID;
    public String itemName;
    public ItemClasses itemClass;
    public String targetInventoryName = "MainInventory";

    public boolean usable = false;
    public boolean consumable = false;
    public int consumequantity = 1;
    public int quantity = 1;
    public boolean equippable = false;
    public String targetEquipmentInventoryName;
    public boolean saleable = true;

    public float value;

    public String description;
    public int maxStack = 1;// 一类物品最多能叠的数量

    protected Inventory _targetInventory = null;
    protected Inventory _targetEquipmentInventory = null;
    public Object prefab;// 实际的物体

    public Inventory TargetInventory() {
        if (targetInventoryName == null) {
            return null;
        }
        _targetInventory = InventoryMgr.FindInventory(targetInventoryName);
        return _targetInventory;
    }

    public Inventory TargetEquipmentInventory() {
        if (targetEquipmentInventoryName == null) {
            return null;
        }
        _targetEquipmentInventory = InventoryMgr.FindInventory(targetEquipmentInventoryName);
        return _targetEquipmentInventory;
    }

    public static boolean IsNull(InventoryItem item) {
        if (item == null) {
            return true;
        }
        if (item.itemID == null) {
            return true;
        }
        if (item.itemID == "") {
            return true;
        }
        return false;
    }

    @Override
    public InventoryItem clone() {
        InventoryItem cloneitem = null;
        try {
            cloneitem = (InventoryItem) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return cloneitem;
    }

    public boolean Pick() {
        return true;
    }// 捡起，加入背包

    public boolean Use() {
        return true;
    }// 使用

    public boolean Equip() {
        return true;
    }// 装备

    public boolean UnEquip() {
        return true;
    }// 取消装备

}
