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

    private ForestMgr() throws InterruptedException{
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        }
        else{
            Init();
        }
    }

    public static ForestMgr GetInstance() throws InterruptedException{
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

    public void Init() throws InterruptedException
    {
        allmonsters=new ArrayList<>();
        battlemonsters=new ArrayList<>();
        choices=new ArrayList<>();

        choices.add(new PlayerReturn());
        choices.add(new PlayerRestInForest(Player.getInstance()));
        choices.add(new PlayerMoveInForest(Player.getInstance(), "上",0, 1));
        choices.add(new PlayerMoveInForest(Player.getInstance(), "下",0, -1));
        choices.add(new PlayerMoveInForest(Player.getInstance(), "左",-1, 0));
        choices.add(new PlayerMoveInForest(Player.getInstance(), "右",1, 0));
        instance=this;
    }

    public int GetBattleMonsterCount() {
        return battlemonsters.size();
    }


    public void StartAdventure() throws InterruptedException
    {
        SoundMgr.GetInstance().PlayForestBGM();
        Player.getInstance().InitPlayerPosInForest();
        ForestChoice();
    }

    public void ForestChoice() throws InterruptedException
    {
        System.out.println("在森林" +Player.playername+"决定");
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
