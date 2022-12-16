package Choice;

import Mgr.FarmMgr;

public class GetCropInfo extends ChoiceConsumeEnergy{
    public GetCropInfo()
    {
        needEnergy = 0;
        description ="查看当前农场已经种植的作物情况";
    }

    public void Choose() throws InterruptedException
    {
        FarmMgr farmMgr = FarmMgr.GetInstance();
        for(int i =0;i<farmMgr.flowers.size();i++)
        {
            farmMgr.flowers.get(i).GetAgeToMature();
        }
        for(int i =0;i<farmMgr.vegetables.size();i++)
        {
            farmMgr.vegetables.get(i).GetAgeToMature();
        }
    }
}
