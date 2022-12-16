package Choice;

import Item.InventoryMgr;
import Item.ItemTypes;
import Mgr.ChoiceMgr;

import java.util.ArrayList;
import java.util.List;

public class Plant extends ChoiceConsumeEnergy{
    public Plant()
    {
        needEnergy = 3;
        description = "开始耕种";
    }

    public void Choose() throws InterruptedException
    {
        super.Choose();
        System.out.println("开始耕作啦");
        List<IChoice> list = InventoryMgr.GetInstance().FindInventory("MainInventory").ChooseInventoryUse(ItemTypes.Seed);
        List<IChoice> choices = new ArrayList<>();
        choices.add(new PlayerReturn());
        for (int i = 0; i< list.size();i++)
        {
            choices.add(list.get(i));
        }

        int i = ChoiceMgr.GetInstance().Choose(choices);
        if(i != 0)
        {
            i = ChoiceMgr.GetInstance().Choose(choices);
        }
    }
}
