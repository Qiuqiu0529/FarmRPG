package Mgr;

import Player.MoneyPresenter;
import Player.Player;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import Choice.MoveToFarmLand;
import Choice.MoveToForest;
import Choice.DefaultChoice;
import Choice.IChoice;

public class GameMgr {
    private static volatile GameMgr instance;
    static List<IChoice> choices;
    static List<IChoice> realchoices;
    static int day = 0;

    enum TimePeriod {
        Morning, Afternoon, Night
    };
    HashMap<TimePeriod,String> tMap=new HashMap<>();

    TimePeriod timePeriod;
    boolean endadayearly;

    private GameMgr() {
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        } else {
            
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
        realchoices=new ArrayList<>();
        DefaultChoice defaultChoice = new DefaultChoice();
        MoveToFarmLand choiceMoveToFarmLand = new MoveToFarmLand();
        MoveToForest choiceMoveToForest = new MoveToForest();

        choices.add(defaultChoice);
        choices.add(choiceMoveToFarmLand);
        choices.add(choiceMoveToForest);
        tMap.put(TimePeriod.Morning, "上午");
        tMap.put(TimePeriod.Afternoon, "下午");
        tMap.put(TimePeriod.Night, "晚上");
    }

    public void DisplayChoice() {
        day++;
        System.out.println("现在是" + tMap.get(timePeriod)+"，"+Player.playername+"选择");
        realchoices.clear();
        System.out.println("————————————————————————");

        for (IChoice iChoice : choices) {
            if (iChoice.CanChoose()) {
                realchoices.add(iChoice);
            }
        }
        for (int i = 0; i < realchoices.size(); ++i) {
            System.out.print("选择" + Integer.toString(i));
            realchoices.get(i).ChoiceInfo();
        }
        System.out.println("————————————————————————");

        int choice = InputMgr.GetInstance().GetInputInt(0, realchoices.size());
        realchoices.get(choice).Choose();
    }

    public void ADay() {
        System.out.println("第"+Integer.toString(day)+"天开始");
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

    public void EndADay() {
        MoneyPresenter.GetInstance().CheckDebt();
        if(IsGameRunning())
        {
            Player.getInstance().SetSleep();
            ADay();
        }
    }

    public void EndDayEarly()
    {
        System.out.println("这一天提前结束");
        MoneyPresenter.GetInstance().CheckDebt();
        if(IsGameRunning())
        {
            Player.getInstance().SetComa();
            ADay();
        }
    }

}
