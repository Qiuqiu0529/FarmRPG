package Choice;

import Other.Global;
import Player.HairStyleType;

public class ChooseHairStyle implements IChoice{
    HairStyleType hairStyleType=HairStyleType.LongHair;
    public ChooseHairStyle( HairStyleType hairStyleType)
    {
        this.hairStyleType=hairStyleType;
    }

    public boolean CanChoose()
    {
       return true;
    }

    public void ChoiceInfo()
    {
        System.out.println(Global.hairmap.get(hairStyleType));
    }

    public void Choose() throws InterruptedException
    {
        Global.choosehairStyleType=hairStyleType;
    }
}
