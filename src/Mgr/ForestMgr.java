package Mgr;

import java.util.ArrayList;
import java.util.List;

import Choice.IChoice;
import Choice.PlayerMoveInForest;
import Choice.PlayerRestInForest;
import Choice.PlayerReturn;
import Monster.IMonster;
import Player.Player;

public class ForestMgr {
    public static List<IMonster> allmonsters;// 当前森林里所有的怪物
    public static List<IMonster> battlemonsters;// 一次战斗的所有怪物
    private static volatile ForestMgr instance;
    static List<IChoice> choices;

    public static int monsterCountRestrict=3;//一次战斗最多几个敌人

    private ForestMgr() {
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        }
        else{
            Init();
        }
    }

    public static ForestMgr GetInstance() {
        var result = instance;
        if (result == null) {
            synchronized (ForestMgr.class) {
                result = instance;
                if (result == null) {
                    instance = result = new ForestMgr();
                }
            }
        }
        return result;
    }

    public void Init()
    {
        allmonsters=new ArrayList<>();
        battlemonsters=new ArrayList<>();
        choices=new ArrayList<>();
        PlayerReturn playerReturn=new PlayerReturn();
        PlayerRestInForest playerRestInForest=new PlayerRestInForest(Player.getInstance());
        PlayerMoveInForest playerMoveUpForest=new PlayerMoveInForest(Player.getInstance(), "上",0, 1);
        PlayerMoveInForest playerMoveDownForest=new PlayerMoveInForest(Player.getInstance(), "下",0, -1);
        PlayerMoveInForest playerMoveLeftForest=new PlayerMoveInForest(Player.getInstance(), "左",-1, 0);
        PlayerMoveInForest playerMoveRightForest=new PlayerMoveInForest(Player.getInstance(), "右",1, 0);
        choices.add(playerReturn);
        choices.add(playerRestInForest);
        choices.add(playerMoveUpForest);
        choices.add(playerMoveDownForest);
        choices.add(playerMoveLeftForest);
        choices.add(playerMoveRightForest);
    }

    public int GetBattleMonsterCount() {
        return battlemonsters.size();
    }


    public void StartAdventure()
    {
        SoundMgr.GetInstance().PlayForestBGM();
        Player.getInstance().InitPlayerPosInForest();
        ForestChoice();
    }

    public void ForestChoice()
    {
        int i=ChoiceMgr.GetInstance().Choose(choices);
        if(i!=0)
        {
            ForestChoice();
        }
    }

    public void UpdatePos()
    {
        for (IMonster monster : allmonsters) {
            monster.MoveUpdate();
        }
    }

    public void KillMoster(IMonster monster)
    {
        allmonsters.remove(monster);
        battlemonsters.remove(monster);
        if(battlemonsters.size()==0)
        {
            Victory();
        }
    }

    public void Victory()
    {
        SoundMgr.GetInstance().PlayVictorySound();
    }

    public void Escape()
    {
        battlemonsters.clear();
    }
}
