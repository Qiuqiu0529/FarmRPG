import java.util.List;

public class InventoryMgr {
    public static List<Inventory> registeredInventories;
    public static Inventory FindInventory(String inventoryName) {
        if (inventoryName == null) {
            return null;
        }
        for (Inventory inventory : registeredInventories) {
            if ((inventory.inventoryName == inventoryName)) {
                return inventory;
            }
        }

        return null;
    }
}
