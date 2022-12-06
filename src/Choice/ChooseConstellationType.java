package Choice;

import Other.Global;
import Player.ConstellationType;

public class ChooseConstellationType  implements IChoice{
    ConstellationType constellationType =ConstellationType.Libra;
    public ChooseConstellationType( ConstellationType constellationType)
    {
        this.constellationType=constellationType;
    }

    public boolean CanChoose()
    {
       return true;
    }

    public void ChoiceInfo()
    {
        System.out.println(Global.starMap.get(constellationType));
    }
 
    public void Choose() throws InterruptedException
    {
        Global.chooseConstellationType=constellationType;
    }

    
}
