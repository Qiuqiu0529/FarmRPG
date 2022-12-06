package Item.Potion;

import Item.InventoryItem;

public class NormalPotionAdapter  extends InventoryItem implements Potion {
    public void Drink() throws InterruptedException {

    }

    public boolean Use() throws InterruptedException{
        Drink();
        return true;
    }//让 Adapter 覆盖 Adaptee 的某些行为，因为 Adapter 是 Adaptee 的子类。

}
