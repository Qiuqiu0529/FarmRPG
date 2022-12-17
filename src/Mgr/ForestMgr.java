package Mgr;

import java.util.ArrayList;
import java.util.List;

import Battle.Battle;
import Choice.IChoice;
import Choice.PlayerMoveInForest;
import Choice.PlayerRestInForest;
import Choice.PlayerReturn;
import Monster.Monster;
import Player.Player;
import Player.PlayerBattle;

public class ForestMgr implements IPlayerMoveObserver{
    public static List<Monster> allmonsters;// 当前森林里所有的怪物
    public static List<Monster> battlemonsters;// 一次战斗的所有怪物
    private static volatile ForestMgr instance;
    static List<IChoice> choices;
    static List<Integer> occupyGrid = new ArrayList<>(100);// 森林为100格子
    public static int monsterCountRestrict = 1;// 一次战斗最多几个敌人
    Battle battle=new Battle();

    private ForestMgr() throws InterruptedException {
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        } else {
            instance = this;
            Init();
        }
    }

    public static ForestMgr GetInstance() throws InterruptedException {
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

    public void Init() throws InterruptedException {
        allmonsters = new ArrayList<>();
        battlemonsters = new ArrayList<>();
        choices = new ArrayList<>();
        choices.add(new PlayerReturn());
        choices.add(new PlayerRestInForest(Player.getInstance()));
        choices.add(new PlayerMoveInForest(Player.getInstance(), "上", 0, 1));
        choices.add(new PlayerMoveInForest(Player.getInstance(), "下", 0, -1));
        choices.add(new PlayerMoveInForest(Player.getInstance(), "左", -1, 0));
        choices.add(new PlayerMoveInForest(Player.getInstance(), "右", 1, 0));

        Player.getInstance().SetMoveObservers(this);

    }

    public int GetBattleMonsterCount() {
        return battlemonsters.size();
    }

    public void StartAdventure() throws InterruptedException {
        SoundMgr.GetInstance().PlayForestBGM();
        for (Integer tempInteger : occupyGrid) {
            tempInteger = 0;
        } // 格子只能被monsterCountRestrict个怪物占据，玩家可以进入有怪物的格子开始战斗

         // 生成怪物

         //更新位置
        Player.getInstance().InitPlayerPosInForest();
       
        ForestChoice();
    }

    public boolean OccupyGrid(int x, int y) {
        int temp = occupyGrid.get(x * 10 + y);
        if (temp < monsterCountRestrict) {
            occupyGrid.set(x * 10 + y , temp + 1);
            return true;
        }
        return false;
    }

    public void UnOccupy(int x, int y) {
        int temppre = occupyGrid.get(x * 10 + y);
        occupyGrid.set(x * 10 + y, temppre - 1);
    }

    public void ForestChoice() throws InterruptedException {
        System.out.println("在森林" + Player.playername + "决定");
        int i = ChoiceMgr.GetInstance().Choose(choices);
        if (i != 0&&!GameMgr.GetInstance().endadayearly) {
            ForestChoice();
        }
    }

     public void UpdatePos(int posx,int posy) throws InterruptedException
    {
        for (Monster monster : allmonsters) {
            monster.MonsterMove();
            if(monster.MeetPlayer(posx, posy))
            {
                battlemonsters.add(monster);
            }
        }
        if(battlemonsters.size()!=0)
        {
            StartBattle();
        }
    }

    public void StartBattle() throws InterruptedException
    {
        battle.AddMember(PlayerBattle.GetInstance());
        for (Monster monster : battlemonsters) {
            battle.AddMember(monster);
        }
        battlemonsters.clear();
        battle.StartBattle();
    }

    public void KillMoster(Monster monster) {//一只怪物倒下，除了从战斗member中删除外，还要在森林里删除
        allmonsters.remove(monster);
    }

}
