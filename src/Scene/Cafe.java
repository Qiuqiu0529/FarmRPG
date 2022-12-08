package Scene;

import NPC.Alice;
import NPC.NPC;
import Mgr.ChoiceMgr;
import Player.Player;
import Choice.IChoice;
import Choice.PlayerReturn;
import Choice.ChoiceFavor;
import java.util.Random;

import java.util.ArrayList;
import java.util.List;

public class Cafe extends Scene {
    private static volatile Cafe instance;
    int generalChoices = 6;
    List<IChoice> allChoices;
    Random r;
    
    private Cafe() throws InterruptedException{
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        } else {
            Init() ;
        }
    }

    public static Cafe GetInstance() throws InterruptedException {
        var result = instance;
        if (result == null) {
            synchronized (Cafe.class) {
                result = instance;
                if (result == null) {
                    instance = result = new Cafe();
                }
            }
        }
        return result;
    }
    
    public void Init() throws InterruptedException
    {
        choices = new ArrayList<>();
        hostNpc = Alice.GetInstance();
        r = new Random();
        description = "咖啡店";
        background = "你在咖啡馆里坐下，紧张地等待着。\n...五分钟后，你等来了心心念念的她。";
        instance = this;
    }

    public void MakeGenerlaChoices() {
        choices.add(new PlayerReturn());
        choices.add(hostNpc.GetChoice(generalChoices));
    }

    public void MakeHiddenChoices(int num) {
        if (num == 3) {
            choices.add(hostNpc.GetChoice(generalChoices + 1));
        } else {
            choices.add(hostNpc.GetChoice(generalChoices + 2));
            if (r.nextBoolean()) {
                choices.add(hostNpc.GetChoice(generalChoices + 3));
            } else {
                choices.add(hostNpc.GetChoice(generalChoices + 4));
            }
        }
    }

    @Override
    public void SceneChoice() throws InterruptedException
    {
        System.out.println(background);
        if (!oldState.equals(hostNpc.GetState())) {
            MakeChoices();
            oldState = hostNpc.GetState();
        }
        int i = ChoiceMgr.GetInstance().Choose(choices);
        if(i!=0)
        {
            System.out.println("你们在咖啡店道别。\n"+Player.playername+"离开了咖啡店。");
        }
    }
    
}
