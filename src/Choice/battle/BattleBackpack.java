package Choice.battle;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Element;
import javax.lang.model.util.ElementScanner14;

import Choice.ChoiceConsumeEnergy;
import Choice.DefaultChoice;
import Choice.IChoice;
import Mgr.ChoiceMgr;
import Player.PlayerBattle;

public class BattleBackpack  extends ChoiceConsumeEnergy{
    List<IChoice> choices;
    PlayerBattle playerBattle;
    public BattleBackpack(PlayerBattle playerBattle)
    {
        this.playerBattle=playerBattle;
        choices=new ArrayList<>();
        needEnergy=0;
        description="背包";
        choices.add(new DefaultChoice("返回",
        ""));
        choices.add(new DefaultChoice("装备",
        "药水"));

    }
  
    public void Choose() throws InterruptedException
    {
        int i=ChoiceMgr.GetInstance().Choose(choices);
        if(i==0)
        {
            playerBattle.ChooseAction();
        }
        else if(i==1)
        {

        }
        else 
        {
            
        }


    }

}