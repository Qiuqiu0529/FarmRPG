package Mgr;
import Choice.IChoice;
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
        Thread.sleep(300);
        realchoices.clear();
        System.out.println("————————————————————————");
       // System.out.println( choices.size());

        for (IChoice iChoice : choices) {
            if (iChoice.CanChoose()) {
                realchoices.add(iChoice);
            }
        }
        
        for (int i = 0; i < realchoices.size(); ++i) {
            System.out.print("选择" + Integer.toString(i));
            realchoices.get(i).ChoiceInfo();
        }
        System.out.println("————————————————————————");

        int choice = InputMgr.GetInstance().GetInputInt(0, realchoices.size());
        realchoices.get(choice).Choose();
        return choice;
    }
}
