package Mgr;
import Choice.ChooseHairStyle;
import Choice.IChoice;
import Other.Global;
import Player.ColorType;
import Player.ConstellationType;
import Player.HairStyleType;

import java.util.ArrayList;
import java.util.List;

public class ChoiceMgr {
    static List<IChoice> realchoices;
    private static volatile ChoiceMgr instance;

    private ChoiceMgr() 
    {
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        } else {
            realchoices=new ArrayList<>();
            instance=this;
        }
    }

    public static ChoiceMgr GetInstance() {
        var result = instance;
        if (result == null) {
            synchronized (ChoiceMgr.class) {
                result = instance;
                if (result == null) {
                    instance = result = new ChoiceMgr();
                }
            }
        }
        return result;
    }

    public int Choose(List<IChoice> choices) throws InterruptedException
    {
        return Choose(choices,"");
    }

    public int Choose(List<IChoice> choices,String chooseDescription) throws InterruptedException
    {
        Thread.sleep(300);
        realchoices.clear();
       // System.out.println( choices.size());
        for (IChoice iChoice : choices) {
            if (iChoice.CanChoose()) {
                realchoices.add(iChoice);
            }
        }
        System.out.println("————————————————————————");
        for (int i = 0; i < realchoices.size(); ++i) {
            System.out.print("选择"+chooseDescription + Integer.toString(i));
            realchoices.get(i).ChoiceInfo();
        }
        System.out.println("————————————————————————");

        int choice = InputMgr.GetInstance().GetInputInt(0, realchoices.size());
        realchoices.get(choice).Choose();
        return choice;
    }

    public HairStyleType ChooseHair()throws InterruptedException
    {
        System.out.println("选择头发样式");
        Choose(Global.hairstylechoices);
        return Global.choosehairStyleType;
    }

    public ColorType ChooseColor(String obj)throws InterruptedException
    {
        System.out.println("选择"+obj+"的颜色");
        Choose(Global.colorchoices);
        return Global.chooseColorType;
    }

    public ConstellationType ChooseConstellation()throws InterruptedException
    {
        System.out.println("选择星座");
        Choose(Global.constellationchoices);
        return Global.chooseConstellationType;
    }

  


}
