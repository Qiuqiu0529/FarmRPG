package Item;

import java.util.ArrayList;
import java.util.List;

import Item.Inventory.InventoryTypes;

public class InventoryMgr {
    public static List<Inventory> registeredInventories;

    public Inventory FindInventory(String inventoryName) {
        if (inventoryName == null) {
            return null;
        }
        //System.out.println(inventoryName);
        for (Inventory inventory : registeredInventories) {
            if ((inventory.inventoryName == inventoryName)) {
                return inventory;
            }
        }
        return null;
    }

    private static volatile InventoryMgr instance;

    private InventoryMgr() {
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        } else {
            instance=this;
            InitAllInventory();

        }
    }

    public static InventoryMgr GetInstance() {
        var result = instance;
        if (result == null) {
            synchronized (InventoryMgr.class) {
                result = instance;
                if (result == null) {
                    instance = result = new InventoryMgr();
                }
            }
        }
        return result;
    }

    public void InitAllInventory() {
        registeredInventories = new ArrayList<>();
    }

    public void AddInventory()
    {
        Inventory main=new Inventory();
        main.inventoryType=InventoryTypes.Main;
        Inventory equipment=new Inventory("EquipmentInventory");
        equipment.inventoryType=InventoryTypes.Equipment;
       // System.out.println(registeredInventories.size());
    }

    public void RegisterInventory(Inventory inventory) 
    {
        registeredInventories.add(inventory);
    }

}
