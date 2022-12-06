package Choice;

import Other.Global;
import Player.ColorType;

public class ChooseColor implements IChoice{
    ColorType colorType=ColorType.Black;
    public ChooseColor(ColorType colorType)
    {
        this.colorType=colorType;
    }

    public boolean CanChoose()
    {
       return true;
    }

    public void ChoiceInfo()
    {
        System.out.println(Global.cMap.get(colorType));
    }
 
    public void Choose() throws InterruptedException
    {
        Global.chooseColorType=colorType;
    }

}
