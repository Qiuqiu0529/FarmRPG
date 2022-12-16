package Farm;

import Item.InventoryItem;

public abstract class Plant  {

    protected String type;
    protected int mature;
    protected int age=0;
    public abstract void grow();
    public boolean isMature()
    {
        if(age >= mature)
            return true;
        else
            return false;
    }

    public abstract void GetAgeToMature();
}
