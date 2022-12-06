package Item;

import java.time.temporal.TemporalUnit;

public class InventoryItem implements Cloneable {// prototype，代表背包里的物体
    public String itemID;
    public String itemName;
    public ItemClasses itemClass;
    public String targetInventoryName = "MainInventory";

    public boolean usable = false;//可以被使用
    public boolean consumable = false;//可以被消耗,可以被消耗就可以送
    public int consumequantity = 1;//一次消耗多少
    public int quantity = 1;//数量
    public boolean equippable = false;//可以被装备
    public String targetEquipmentInventoryName="EquipmentInventory";//目标装备槽（属性为equipment的背包）
    public boolean saleable = true;//可以被贩卖

    public float value;//价值
    public String description;//描述

    public int maxStack = 1;// 一格物品最多能叠的数量，在考虑要不要一个格子能放无限多的同类物品orz

    protected Inventory _targetInventory = null;
    protected Inventory _targetEquipmentInventory = null;

    protected ItemExtention unitExtension = null;

    public ItemExtention GetItemExtention(String extensionName)
    {
        return null;
    }

    // public Object prefab;// 实际的物体,也许不会出现

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

    public boolean Pick() throws InterruptedException{
        return true;
    }// 捡起，加入背包

    public boolean Use() throws InterruptedException{
        return true;
    }// 使用

    public boolean Equip() throws InterruptedException{
        return true;
    }// 装备

    public boolean UnEquip() throws InterruptedException{
        return true;
    }// 取消装备

    public boolean Give() throws InterruptedException{
        return true;
    }// 可以送给某人

}
