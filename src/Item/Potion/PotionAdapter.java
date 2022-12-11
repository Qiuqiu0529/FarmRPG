package Item.Potion;
import Item.InventoryItem;
import Item.ItemExtention;

public class PotionAdapter  extends InventoryItem {
    IPotion potion;
    public final boolean Use() throws InterruptedException{
        potion.Drink();
        return true;
    }//背包里的药水adapter，实际的药水adaptertee。

    public ItemExtention getUnitExtension(String extensionName) {

        if (extensionName.equals("Potion")) {
          return potion;
        }
        return super.GetItemExtention(extensionName);
      }

}
