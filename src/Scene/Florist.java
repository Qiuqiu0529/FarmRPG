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
    int generalChoices = 3;
    
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
    
    public void Init() throws InterruptedException
    {
        choices = new ArrayList<>();
        hostNpc = Alice.GetInstance();
        description = "街边的花店";
        background = "在花店，"+Player.playername+"遇到了见习插花师Alice。你想：";
        instance = this;
    }

    public void MakeGenerlaChoices() {
        choices.add(new PlayerReturn());
        for (int i = 0; i < generalChoices; i++) {
            choices.add(hostNpc.GetChoice(i));
        }
    }
    public void MakeHiddenChoices(int num) {
        for (int i = 0; i < num; i++) {
            choices.add(hostNpc.GetChoice(i+generalChoices));
        }
    }
    
}
