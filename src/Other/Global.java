package Other;

import java.util.HashMap;

import Player.ColorType;
import Player.HairStyleType;
import Mgr.GameMgr;

public class Global {
    public static int healingPotion=210;
    public static int strengthPotion=211;
    public static int energyPotion=212;
    public static int criticalHitPotion=213;
    public static int continueHealing=214;
    public static int continueStrength=215;
    public static int continueEnergy=216;
    public static int continueCritical=217;

    public static HashMap<HairStyleType,String> hairmap=new HashMap<>();
    public static HashMap<ColorType,String> cMap=new HashMap<>();
    public static HashMap<GameMgr.TimePeriod,String> tMap=new HashMap<>();

    public Global()
    {
        tMap.put(GameMgr.TimePeriod.Morning, "上午");
        tMap.put(GameMgr.TimePeriod.Afternoon, "下午");
        tMap.put(GameMgr.TimePeriod.Night, "晚上");

        hairmap.put(HairStyleType.LongHair, "长发");
        hairmap.put(HairStyleType.ShortHair, "短发");
        hairmap.put(HairStyleType.LongCurlyHair, "长卷发");
        hairmap.put(HairStyleType.ShortCurlyHair, "短卷发");
       
        cMap.put(ColorType.Black, "黑色");
        cMap.put(ColorType.Grey, "灰色");
        cMap.put(ColorType.Blue, "蓝色");
        cMap.put(ColorType.Pink, "粉色");
        cMap.put(ColorType.Red, "红色");
        cMap.put(ColorType.Yellow, "黄色");
        cMap.put(ColorType.Orange, "橙色");
        cMap.put(ColorType.Green, "绿色");
        cMap.put(ColorType.Purple, "紫色");

    }

}
