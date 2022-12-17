package Other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Choice.ChooseColor;
import Choice.ChooseConstellationType;
import Choice.ChooseHairStyle;
import Choice.IChoice;
import Player.ColorType;
import Player.ConstellationType;
import Player.HairStyleType;
import Mgr.GameMgr;

public class Global {

    public static String flowerSeed = "110";
    public static String vegetableSeed = "111";
    public static String flower = "112";
    public static String vegetable = "113";

    public static String healingPotion="210";
    public static String strengthPotion="211";
    public static String energyPotion="212";
    public static String defencePotion="213";
    public static String continueHealing="214";
    public static String continueStrength="215";
    public static String continueEnergy="216";
    public static String continueDefence="217";

    public static String newbieSword="310";
    public static String newbieGun="311";
    public static String normalSword="312";
    public static String normalGun="313";
    public static String midSword="314";
    public static String midGun="315";
    public static String superSword="316";
    public static String superGun="317";
    public static String ultimateSword="318";
    public static String ultimateGun="319";

    public static HashMap<HairStyleType,String> hairmap=new HashMap<>();
    public static HashMap<ColorType,String> cMap=new HashMap<>();
    public static HashMap<GameMgr.TimePeriod,String> tMap=new HashMap<>();
    public static HashMap<ConstellationType,String> starMap=new HashMap<>();


    public static List<IChoice> hairstylechoices=new ArrayList<>();
    public static List<IChoice> colorchoices=new ArrayList<>();
    public static List<IChoice> constellationchoices=new ArrayList<>();
    
    public static ColorType chooseColorType;
    public static ConstellationType chooseConstellationType;
    public static HairStyleType choosehairStyleType;

    public Global()
    {
        tMap.put(GameMgr.TimePeriod.Morning, "上午");
        tMap.put(GameMgr.TimePeriod.Afternoon, "下午");
        tMap.put(GameMgr.TimePeriod.Night, "晚上");

        hairmap.put(HairStyleType.LongHair, "长发");
        hairmap.put(HairStyleType.ShortHair, "短发");
        hairmap.put(HairStyleType.LongCurlyHair, "长卷发");
        hairmap.put(HairStyleType.ShortCurlyHair, "短卷发");

        hairstylechoices.add(new ChooseHairStyle(HairStyleType.LongHair));
        hairstylechoices.add(new ChooseHairStyle(HairStyleType.ShortHair));
        hairstylechoices.add(new ChooseHairStyle(HairStyleType.LongCurlyHair));
        hairstylechoices.add(new ChooseHairStyle(HairStyleType.ShortCurlyHair));

        
       
        cMap.put(ColorType.Black, "黑色");
        cMap.put(ColorType.Grey, "灰色");
        cMap.put(ColorType.Blue, "蓝色");
        cMap.put(ColorType.Pink, "粉色");
        cMap.put(ColorType.Red, "红色");
        cMap.put(ColorType.Yellow, "黄色");
        cMap.put(ColorType.Orange, "橙色");
        cMap.put(ColorType.Green, "绿色");
        cMap.put(ColorType.Purple, "紫色");

        colorchoices.add(new ChooseColor(ColorType.Black));
        colorchoices.add(new ChooseColor(ColorType.Grey));
        colorchoices.add(new ChooseColor(ColorType.Blue));
        colorchoices.add(new ChooseColor(ColorType.Pink));
        colorchoices.add(new ChooseColor(ColorType.Red));
        colorchoices.add(new ChooseColor(ColorType.Yellow));
        colorchoices.add(new ChooseColor(ColorType.Orange));
        colorchoices.add(new ChooseColor(ColorType.Green));
        colorchoices.add(new ChooseColor(ColorType.Purple));


        starMap.put(ConstellationType.Aries, "白羊座");
        starMap.put(ConstellationType.Taurus, "金牛座");
        starMap.put(ConstellationType.Gemini, "双子座");
        starMap.put(ConstellationType.Cancer, "巨蟹座");
        starMap.put(ConstellationType.Leo, "狮子座");
        starMap.put(ConstellationType.Virgo, "处女座");

        starMap.put(ConstellationType.Libra, "天秤座");
        starMap.put(ConstellationType.Scorpio, "天蝎座");
        starMap.put(ConstellationType.Sagittarius, "射手座");
        starMap.put(ConstellationType.Capricorn, "摩羯座");
        starMap.put(ConstellationType.Aquarius, "水瓶座");
        starMap.put(ConstellationType.Pisces, "双鱼座");

        constellationchoices.add(new ChooseConstellationType(ConstellationType.Aries));
        constellationchoices.add(new ChooseConstellationType(ConstellationType.Taurus));
        constellationchoices.add(new ChooseConstellationType(ConstellationType.Gemini));
        constellationchoices.add(new ChooseConstellationType(ConstellationType.Cancer));
        constellationchoices.add(new ChooseConstellationType(ConstellationType.Leo));
        constellationchoices.add(new ChooseConstellationType(ConstellationType.Virgo));

        constellationchoices.add(new ChooseConstellationType(ConstellationType.Libra));
        constellationchoices.add(new ChooseConstellationType(ConstellationType.Scorpio));
        constellationchoices.add(new ChooseConstellationType(ConstellationType.Sagittarius));
        constellationchoices.add(new ChooseConstellationType(ConstellationType.Capricorn));
        constellationchoices.add(new ChooseConstellationType(ConstellationType.Aquarius));
        constellationchoices.add(new ChooseConstellationType(ConstellationType.Pisces));

    }

}
