package Mgr;

import Choice.BuyFlowerSeed;
import Choice.IChoice;
import Choice.PlayerReturn;
import Farm.SeedShop;
import Player.Player;

import java.util.ArrayList;
import java.util.List;

public class SeedShopMgr {
    // 种植单例
    private static volatile SeedShopMgr instance;

    // 选择列表
    public static List<IChoice> choices;

    private SeedShopMgr() throws InterruptedException{
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        }
        else{
            instance=this;
            Init();
        }
    }

    public static SeedShopMgr GetInstance() throws InterruptedException
    {
        var result=instance;
        if(result==null){
            synchronized (FarmMgr.class){
                result=instance;
                if(result==null){
                    instance=result=new SeedShopMgr();
                }
            }
        }
        return result;

    }

    public void Init()
    {
        choices=new ArrayList<>();
        choices.add(new PlayerReturn());
        choices.add(new BuyFlowerSeed());
    }

    public void ShopChoice() throws InterruptedException
    {
        System.out.println("在种子商店里" + Player.playername+"决定");
        int i = ChoiceMgr.GetInstance().Choose(choices);
        if(i != 0)
        {
            ShopChoice();
        }
    }


}
