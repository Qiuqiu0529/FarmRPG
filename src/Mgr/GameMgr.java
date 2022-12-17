package Mgr;

import Player.MoneyPresenter;
import Player.Player;
import java.util.ArrayList;
import java.util.List;
import Choice.MoveToFarmLand;
import Choice.MoveToForest;
import Choice.MoveToTown;
import Other.Global;
import Choice.DefaultChoice;
import Choice.IChoice;

public class GameMgr {
    private static volatile GameMgr instance;
    static List<IChoice> choices;
    static int day = 0;

    public enum TimePeriod {
        Morning, Afternoon, Night
    };
    
    TimePeriod timePeriod;
    boolean endadayearly;

    private GameMgr() {
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        } else {
            
            instance=this;
            RunGame();
            InitChoices();
        }
    }

    public static GameMgr GetInstance() {
        var result = instance;
        if (result == null) {
            synchronized (GameMgr.class) {
                result = instance;
                if (result == null) {
                    instance = result = new GameMgr();
                }
            }
        }
        return result;
    }

    protected volatile GameStatus status;

    public boolean IsGameRunning() {
        return status == GameStatus.RUNNING;
    }

    public void RunGame() {
        status = GameStatus.RUNNING;
    }

    public void StopGame() {
        status = GameStatus.STOPPED;
    }

    public void InitChoices()// 初始化最大的流程,最大的一层选择，每个时间段的选择
    {
        choices=new ArrayList<>();
        choices.add(new DefaultChoice("什么都不做（消耗精力0）",
        Player.playername+"选择什么都不做，悠闲地渡过了一段时光。"));
        choices.add(new MoveToFarmLand());
        choices.add(new MoveToForest());
        choices.add(new MoveToTown());
      
    }

    public void DisplayChoice() throws InterruptedException {
        System.out.println("现在是" + Global.tMap.get(timePeriod)+"，"+Player.playername+"选择");
        ChoiceMgr.GetInstance().Choose(choices);
    }

    public void ADay() throws InterruptedException {
        day++;
        System.out.println("第"+Integer.toString(day)+"天开始");
        SoundMgr.GetInstance().PlayNormalBGM();
        endadayearly=false;
        timePeriod = TimePeriod.Morning;
        Player.getInstance().SetIdle();
        DisplayChoice();
        if(!endadayearly)
        {
            timePeriod = TimePeriod.Afternoon;
            DisplayChoice();
        }
        if(!endadayearly)
        {
            timePeriod = TimePeriod.Night;
            DisplayChoice();
        }
        if(!endadayearly)
        {
            EndADay();
        }
        else
        {
            EndDayEarly();
        }
    }

    public void EndADay() throws InterruptedException {
        MoneyPresenter.GetInstance().CheckDebt();
        if(IsGameRunning())
        {
            Player.getInstance().SetSleep();
            Thread.sleep(300);
            FarmMgr.GetInstance().PlantsGrow();
            ADay();
        }
    }

    public void EndDayEarly() throws InterruptedException
    {
        Player.getInstance().SetComa();
        System.out.println("这一天提前结束");
        MoneyPresenter.GetInstance().CheckDebt();
        if (IsGameRunning()) {
            Thread.sleep(500);
            FarmMgr.GetInstance().PlantsGrow();
            ADay();
        }
    }

    public int GetDay() {
        return day;
    }
    public int GetTimePeriod() {
        return timePeriod.ordinal();
    }
}
