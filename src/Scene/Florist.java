package Scene;

import NPC.Alice;
import NPC.NPC;
import Mgr.ChoiceMgr;
import Player.Player;
import Choice.IChoice;
import Choice.PlayerReturn;

import java.util.ArrayList;
import java.util.List;

public class Florist extends Scene {
    private static volatile Florist instance;
    
    private Florist() throws InterruptedException{
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        } else {
            Init() ;
        }
    }

    public static Florist GetInstance() throws InterruptedException {
        var result = instance;
        if (result == null) {
            synchronized (Florist.class) {
                result = instance;
                if (result == null) {
                    instance = result = new Florist();
                }
            }
        }
        return result;
    }
    
    public iScene GetScene() throws InterruptedException{
        return GetInstance();
    }
    
    public void Init() throws InterruptedException
    {
        choices = new ArrayList<>();
        hostNpc = Alice.GetInstance();
        MakeChoices();
        description = "街边的花店";
        background = "在花店，你遇到了见习插花师Alice。你想：";
        instance = this;
    }

    public void MakeChoices() {
        super.MakeChoices();
        ClearChoices();
        choices.add(new PlayerReturn());
        for (int i = 0; i <= 2+favorNum; i++) {
            choices.add(hostNpc.GetChoice(i));
        }
    }
    
}
