package Item;
import java.util.Random;

public class Dice {

    public static int RollTwoDice()
    {
        int dice=new Random().nextInt(6)+1;//1-6
        int diceone=new Random().nextInt(6)+1;//1-6
        return dice+diceone;
    }

    public static boolean Determine(int add,int threadhold)//类极乐迪斯科判定
    {
        int i=RollTwoDice();
        if(i<2)
        {
            return false;
        }
        if(i==12)
        {
            return true;
        }
        i+=add;
        if(i>=threadhold)
        {
            return true;
        }
        return false;
    }

}
