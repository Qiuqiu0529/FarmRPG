package Item;

public class InventoryIterator implements Iterator<InventoryItem> {
    private final Inventory inventory;
    private int index;
    private final ItemTypes itemType;

    public InventoryIterator(Inventory inventory, ItemTypes itemType) {
        this.inventory = inventory;
        this.itemType=itemType;
        this.index = -1;
      }

    @Override
    public boolean hasNext() {
        return FindNextIdx() != -1;
    }

    @Override
    public InventoryItem next() {
        index = FindNextIdx();
        if ( index != -1) {
            return inventory.GetItem(index);
        }
        return null;
    }

    private int FindNextIdx() {
        var tempIdx = index;
        while (true) {
            tempIdx++;
            if (tempIdx >= inventory.content.size()) {
                tempIdx = -1;
                break;
            }
            if (inventory.GetItem(index).itemType.equals(itemType)) {
                break;
            }
        }
        return tempIdx;
    }
}
