package Scene;

import java.util.ArrayList;
import java.util.List;

import Choice.EnterShop;
import Choice.IChoice;
import Mgr.ChoiceMgr;
import Mgr.ShopMgr;
import Mgr.SoundMgr;
import Choice.PlayerReturn;
import Choice.PlayerWalkInTown;
import Choice.TownToScene;
import Player.Player;
import Shop.ShopType;

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
        choices.add(new TownToScene(Player.getInstance(), Florist.GetInstance()));
        SceneProxy.GetInstance().SetScene(Cafe.GetInstance());
        choices.add(new TownToScene(Player.getInstance(), SceneProxy.GetInstance()));
        choices.add(new EnterShop(ShopMgr.GetInstance().GetInstance(ShopType.POTION)));
        choices.add(new EnterShop(ShopMgr.GetInstance().GetInstance(ShopType.SEED)));
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
        Thread.sleep(1000);
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
