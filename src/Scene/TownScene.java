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
    static List<IChoice> choices;
    Scene scene;

    private TownScene() throws InterruptedException{
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        }
        else{
            Init();
        }
    }

    public static TownScene GetInstance() throws InterruptedException{
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
        choices=new ArrayList<>();
        choices.add(new PlayerReturn());
        choices.add(new PlayerWalkInTown(Player.getInstance()));
        choices.add(new TownToScene(Player.getInstance(), Florist.GetInstance()));
        instance=this;
    }

    public void StartVisit() throws InterruptedException
    {
        SoundMgr.GetInstance().PlayTownBGM();
        TownChoice();
    }

    public void TownChoice() throws InterruptedException
    {
        System.out.println(Player.playername+"在小镇上，打算：");
        int i=ChoiceMgr.GetInstance().Choose(choices);
        if(i!=0)
        {
            TownChoice();
        }
    }
}
