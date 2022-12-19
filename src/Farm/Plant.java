package Farm;

import Item.InventoryItem;

public abstract class Plant  {
    public PlantApi api;

    protected String type;
    protected int price;
    protected int mature;
    protected int age=0;
    public boolean isMature()
    {
        if(age >= mature)
            return true;
        else
            return false;
    }

    public int getPrice(){return price;}

    public abstract void GetAgeToMature();
}
