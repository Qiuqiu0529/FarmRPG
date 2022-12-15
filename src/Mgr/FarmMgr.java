package Mgr;
import java.util.ArrayList;
import java.util.List;

//import Choice.EnterFarmShop;
import Choice.IChoice;
import Choice.PlayerReturn;
import Farm.Flower;
import Farm.Vegetable;
import Player.Player;

public class FarmMgr {

    // 种植单例
    private static volatile FarmMgr instance;

    // 选择列表
    public static List<IChoice> choices;

    // 花
    public static List<Flower> flowers;

    // 蔬菜
    public static List<Vegetable> vegetables;

    private FarmMgr() throws InterruptedException{
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        }
        else{
            instance=this;
            Init();
        }
    }

    public static FarmMgr GetInstance() throws InterruptedException
    {
        var result=instance;
        if(result==null){
            synchronized (FarmMgr.class){
                result=instance;
                if(result==null){
                    instance=result=new FarmMgr();
                }
            }
        }
        return result;

    }

    public void Init() throws InterruptedException
    {
        choices=new ArrayList<>();
        choices.add(new PlayerReturn());
        //choices.add(new EnterFarmShop());
    }

    public void StartFarm() throws InterruptedException
    {
        SoundMgr.GetInstance().PlayFarmBGM();
        FarmChoice();
    }

    private void FarmStore() throws InterruptedException{
        System.out.println("欢迎来到农场！请购买需要的种子");
        // 输出选项以及购买逻辑处理

    }

    private void FarmChoice() throws InterruptedException
    {
        System.out.println("在农场里" + Player.playername+"决定");
        int i=ChoiceMgr.GetInstance().Choose(choices);
        if(i!=0)
        {
            FarmChoice();
        }
    }
}
