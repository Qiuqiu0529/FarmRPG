package Item.Potion;


import Item.InventoryItem;

public class HealingPotion extends InventoryItem implements Potion {
    public void Drink() throws InterruptedException {

    }

    public boolean Use() throws InterruptedException{
        Drink();
        return true;
    }

}
