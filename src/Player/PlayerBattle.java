package Player;

import java.util.ArrayList;
import java.util.List;

import Item.Dice;
import Item.Buff.Buff;

public class PlayerBattle {
    List<Buff> buffs;
    int lucky=2;
    public PlayerBattle()
    {
        buffs=new ArrayList<>();
    }
    //攻击、道具、装备、逃跑
    //战斗流程，选择攻击，oneroundup，攻击  
    //选择道具，选择道具、oneroundup
    //选择装备，选择装备，oneroundup，攻击
    //选择逃跑，掷骰子，概率逃跑

    public void OneRoundUp() throws InterruptedException //加buff，后执行攻击
    {
        for (Buff buff : buffs) {
            buff.AddBuff();
        }
        buffs.removeIf(s -> s.continueTime==0);//用完就丢
    }

    public boolean Escape()//类极乐迪斯科判定
    {
        return Dice.Determine(lucky, 9);
    }//概率为容易

    

    
} 
