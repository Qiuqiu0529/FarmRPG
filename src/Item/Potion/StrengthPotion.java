package Item.Potion;

import Item.InventoryItem;

public class StrengthPotion extends InventoryItem implements Potion {
    public void Drink() throws InterruptedException {

    }

    public boolean Use() throws InterruptedException{
        Drink();
        return true;
    }

}
