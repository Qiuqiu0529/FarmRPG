package Mgr;
import Player.MoneyPresenter;

import java.sql.Time;
import java.util.List;

import Choice.ChoiceMoveToFarmLand;
import Choice.ChoiceMoveToForest;
import Choice.DefaultChoice;
import Choice.IChoice;
import Player.EnergyPresenter;

public class GameMgr {
    private static volatile GameMgr instance;
    static List<IChoice> choices;
    static List<IChoice> realchoices;
    static int day=1;
    enum TimePeriod{Morning,Afternoon,Night,SleepTime};
    TimePeriod timePeriod;

    private GameMgr() {
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        }
        else
        {
            System.out.println("第一天开始");
            timePeriod=TimePeriod.Morning;
            RunGame();
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

    public void StopGame()
    {
        status = GameStatus.STOPPED;
    }

    public void InitChoices()
    {
        DefaultChoice defaultChoice=new DefaultChoice();
        ChoiceMoveToFarmLand choiceMoveToFarmLand=new ChoiceMoveToFarmLand();
        ChoiceMoveToForest choiceMoveToForest=new ChoiceMoveToForest();
        choices.add(defaultChoice);
        choices.add(choiceMoveToFarmLand);
        choices.add(choiceMoveToForest);
    }




    public void DisplayChoice()
    {
        realchoices.clear();
        for (IChoice iChoice : choices) {
            if(iChoice.CanChoose())
            {
                realchoices.add(iChoice);
            }
        }
        for(int i=0;i<realchoices.size();++i)
        {
            System.out.print("选择"+Integer.toString(i));
            realchoices.get(i).ChoiceInfo();
        }
        
    }



    public void EndADay()
    {
        MoneyPresenter.GetInstance().CheckDebt();


    }
}
