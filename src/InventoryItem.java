public class InventoryItem implements Cloneable{//prototype
    public String itemID;
    public String itemName;
    public ItemClasses itemClass;
    public String targetInventoryName = "MainInventory";

    public boolean usable = false;
    public boolean consumable = false;
    public int quality = 1;
    public boolean equippable = false;
    public boolean saleable = true;
    public float value;

    public String description;
    public int maxStack = 1;// 一类物品的数量

    protected Inventory _targetInventory = null;

    public Inventory TargetInventory(String playerID) {
        if (targetInventoryName == null) {
            return null;
        }
        _targetInventory = InventoryMgr.FindInventory(targetInventoryName);
        return _targetInventory;
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
    protected InventoryItem clone() {
        InventoryItem cloneitem = null;
        try {
            cloneitem  = (InventoryItem) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return cloneitem;
    }

}
