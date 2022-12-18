package Mgr;
import java.util.ArrayList;
import java.util.List;

//import Choice.EnterFarmShop;
import Choice.*;
import Farm.FertilizedFlower;
import Farm.FertilizedVegetable;
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
            flowers = new ArrayList<>();
            vegetables = new ArrayList<>();
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
        choices.add(new Plant());
        choices.add(new GainCrops());
        choices.add(new GetCropInfo());
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

    public void PlantsGrow()
    {
        if(flowers.size() > 0)
            System.out.println("鲜花正在生长");
        for(int i = 0;i<flowers.size();i++)
        {
            flowers.get(i).grow();
        }
        if(vegetables.size() >0)
            System.out.println("蔬菜正在生长");
        for(int i =0;i<vegetables.size();i++)
        {
            vegetables.get(i).grow();
        }
    }

    public int CountPlants()
    {
        return flowers.size()+vegetables.size();
    }

    public void FertilizePlants()
    {
        List<FertilizedFlower> Flist = new ArrayList<>();
        List<FertilizedVegetable> Vlist = new ArrayList<>();
        for(int i=0;i<flowers.size();i++)
        {
            FertilizedFlower f = new FertilizedFlower(flowers.get(i));
            Flist.add(f);
        }
        flowers.clear();//替换成施过肥的
        flowers.addAll(Flist);
        for(int i =0;i<vegetables.size();i++)
        {
            FertilizedVegetable v = new FertilizedVegetable(vegetables.get(i));
            Vlist.add(v);
        }
        vegetables.clear();
        vegetables.addAll(Vlist);

        System.out.println("已经给所有植物施过肥啦");
    }

}
