package Item.Potion;

import Item.ItemExtention;

public interface IPotion extends ItemExtention{//为了方便，只有player能使用药水
    public void Drink() throws InterruptedException;
}