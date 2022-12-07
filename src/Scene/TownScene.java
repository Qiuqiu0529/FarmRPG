package Scene;

import java.util.ArrayList;
import java.util.List;

import Choice.IChoice;
import Mgr.ChoiceMgr;
import Mgr.SoundMgr;
import Choice.PlayerReturn;
import Choice.PlayerWalkInTown;
import Choice.TownToScene;
import Player.Player;

public class TownScene {
    private static volatile TownScene instance;
    List<IChoice> choices;

    private TownScene() throws InterruptedException{
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        }
        else{
            Init();
        }
    }

    public static TownScene GetInstance() throws InterruptedException {
        var result = instance;
        if (result == null) {
            synchronized (TownScene.class) {
                result = instance;
                if (result == null) {
                    instance = result = new TownScene();
                }
            }
        }

        return result;
    }
    
    public void Init() throws InterruptedException
    {
        choices = new ArrayList<>();
        instance = this;
    }
    
    public void MakeChoices() throws InterruptedException
    {
        ClearChoices();
        choices.add(new PlayerReturn());
        choices.add(new PlayerWalkInTown(Player.getInstance()));
        SceneProxy.GetInstance().SetScene(Florist.GetInstance());
        choices.add(new TownToScene(Player.getInstance(), SceneProxy.GetInstance()));
    }

    public void ClearChoices() {
        if (!choices.isEmpty()) {
            choices.clear();
        }
    }

    public void StartVisit() throws InterruptedException
    {
        SoundMgr.GetInstance().PlayTownBGM();
        MakeChoices();
        TownChoice();
    }

    public void TownChoice() throws InterruptedException
    {
        System.out.println(Player.playername+"在小镇上，打算：");
        int i=ChoiceMgr.GetInstance().Choose(choices);
        if(i!=0)
        {
            if (i > 1) {
                MakeChoices();
            }
            TownChoice();
        }
    }
}
