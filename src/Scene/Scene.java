package Scene;

import NPC.NPC;
import Mgr.ChoiceMgr;
import Choice.IChoice;

import java.util.ArrayList;
import java.util.List;

public abstract class Scene implements iScene{
    NPC hostNpc = null;
    String description = "";
    String background = "";
    List<IChoice> choices;
    String oldState = "";
    
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

    public abstract void MakeGenerlaChoices();
    public abstract void MakeHiddenChoices(int num);

    public void MakeChoices() {
        String state = hostNpc.GetState();
        int favorNum=0;
        if (state.equals(FavorStatus.frendly.name())) {
            favorNum = 1;
        }
        else if (state.equals(FavorStatus.hospitality.name())) {
            favorNum = 2;
        }
        else if (state.equals(FavorStatus.love.name())) {
            favorNum = 3;
        }
        ClearChoices();
        MakeGenerlaChoices();
        MakeHiddenChoices(favorNum);
    }

    public void StartVisit() throws InterruptedException
    {
        //SoundMgr.GetInstance().PlayTownBGM();
        SceneChoice();
    }

    public void SceneChoice() throws InterruptedException
    {
        Thread.sleep(1000);
        System.out.println(background);
        if (!oldState.equals(hostNpc.GetState())) {
            MakeChoices();
            oldState = hostNpc.GetState();
        }
        int i = ChoiceMgr.GetInstance().Choose(choices);
        if(i!=0)
        {
            SceneChoice();
        }
    }

}
