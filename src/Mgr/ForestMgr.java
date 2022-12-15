package Mgr;

import java.util.ArrayList;
import java.util.List;

import Choice.IChoice;
import Choice.PlayerMoveInForest;
import Choice.PlayerRestInForest;
import Choice.PlayerReturn;
import Monster.IMonster;
import Player.Player;

public class ForestMgr implements IPlayerMoveObserver{
    public static List<IMonster> allmonsters;// 当前森林里所有的怪物
    public static List<IMonster> battlemonsters;// 一次战斗的所有怪物
    private static volatile ForestMgr instance;
    static List<IChoice> choices;
    static List<Integer> occupyGrid=new ArrayList<>(100);//森林为100格子
    public static int monsterCountRestrict=1;//一次战斗最多几个敌人

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
        instance=this;
        allmonsters=new ArrayList<>();
        battlemonsters=new ArrayList<>();
        choices=new ArrayList<>();
        Player.getInstance().SetMoveObservers(this);
        choices.add(new PlayerReturn());
        choices.add(new PlayerRestInForest(Player.getInstance()));
        choices.add(new PlayerMoveInForest(Player.getInstance(), "上",0, 1));
        choices.add(new PlayerMoveInForest(Player.getInstance(), "下",0, -1));
        choices.add(new PlayerMoveInForest(Player.getInstance(), "左",-1, 0));
        choices.add(new PlayerMoveInForest(Player.getInstance(), "右",1, 0));
    }

    public int GetBattleMonsterCount() {
        return battlemonsters.size();
    }


    public void StartAdventure() throws InterruptedException
    {
        SoundMgr.GetInstance().PlayForestBGM();
        for (Integer occupy : occupyGrid) {
            occupy=0;
        }//格子只能被monsterCountRestrict个怪物占据
        Player.getInstance().InitPlayerPosInForest();
        //生成怪物
        ForestChoice();
    }
  
    public boolean OccupyGrid(int x,int y,int changex,int changey)
    {
        int temp=occupyGrid.get((x+changex)*10+y+changey);
        if( temp< monsterCountRestrict)
        {
            occupyGrid.set((x+changex)*10+y+changey,temp+1);
            UnOccupy(x, y);
            return true;
        }
        return false;
    }

    public void UnOccupy(int x,int y)
    {
        int temppre=occupyGrid.get(x*10+y);
        occupyGrid.set(x*10+y,temppre-1);
    }


    public void ForestChoice() throws InterruptedException
    {
        System.out.println("在森林" +Player.playername+"决定");
        int i=ChoiceMgr.GetInstance().Choose(choices);
        if(i!=0)
        {
            //触发事件
            ForestChoice();
        }
    }
    public void UpdatePos(int posx,int posy)
    {
        for (IMonster monster : allmonsters) {
            monster.MonsterMove();
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
