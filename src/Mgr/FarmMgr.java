package Mgr;
import java.util.ArrayList;
import java.util.List;

import Choice.IChoice;
import Choice.PlayerMoveInForest;
import Choice.PlayerRestInForest;
import Choice.PlayerReturn;
import Farm.Plant;
import Farm.Seed;
import Farm.Vegetable;
import Player.Player;

public class FarmMgr {

    // 种植单例
    private static volatile FarmMgr instance;

    // 选择列表
    public static List<IChoice> choices;

    // 花
    public static List<Plant> flowers;

    // 蔬菜
    public static List<Vegetable> vegetables;

    public FarmMgr getInstance(){
        return instance;
    }


}
