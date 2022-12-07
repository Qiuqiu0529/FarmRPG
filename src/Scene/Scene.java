package Scene;

import NPC.NPC;
import Mgr.ChoiceMgr;
import Player.Player;
import Choice.IChoice;

import java.util.ArrayList;
import java.util.List;

public abstract class Scene implements iScene{
    NPC hostNpc = null;
    String description = "";
    String background = "";
    List<IChoice> choices;
    int favorNum = 0;
    
    public enum FavorStatus {
        general, frendly, hospitality, love  //0-30, 30-60, 60-90, 90--
    };

    public void ClearChoices() {
        if (!choices.isEmpty()) {
            choices.clear();
        } 
    }

    public String GetDescription() {
        return description;
    }

    public void MakeChoices() {
        String state = hostNpc.GetState();
        if (state.equals(FavorStatus.frendly.name())) {
            favorNum = 1;
        }
        else if (state.equals(FavorStatus.hospitality.name())) {
            favorNum = 2;
        }
        else if (state.equals(FavorStatus.love.name())) {
            favorNum = 3;
        }
        
    }

    public void StartVisit() throws InterruptedException
    {
        //SoundMgr.GetInstance().PlayTownBGM();
        SceneChoice();
    }

    public void SceneChoice() throws InterruptedException
    {
        System.out.println(background);
        var oldState = hostNpc.GetState();
        int i = ChoiceMgr.GetInstance().Choose(choices);
        if(i!=0)
        {
            if (!oldState.equals(hostNpc.GetState())) {
                MakeChoices();
            }
            SceneChoice();
        }
    }

}
