package Item.Potion;

import java.util.Optional;

import Item.InventoryItem;
import Item.ItemExtention;

public class PotionAdapter  extends InventoryItem implements Potion{

    public void Drink() throws InterruptedException {

    }

    public boolean Use() throws InterruptedException{
        Drink();
        return true;
    }//让 Adapter 覆盖 Adaptee 的某些行为，因为 Adapter 是 Adaptee 的子类。

    public ItemExtention getUnitExtension(String extensionName) {

        if (extensionName.equals("Potion")) {
          return this;
        }
        return super.GetItemExtention(extensionName);
      }

}
