package Player;

import java.util.ArrayList;
import java.util.List;

import Item.Dice;
import Item.Buff.Buff;
import Item.Buff.EnergyBuff;
import Item.Buff.HealthBuff;

public class PlayerBattle {
    List<Buff> buffs;
    PlayerHealth playerHealth=new PlayerHealth();
    int lucky=2;
    //攻击、道具、装备、逃跑
    //战斗流程，选择攻击，oneroundup，攻击  
    //选择道具，选择道具、oneroundup
    //选择装备，选择装备，oneroundup，攻击
    //选择逃跑，掷骰子，概率逃跑


    private static volatile PlayerBattle instance;

    private PlayerBattle() {
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        } else {
           
            instance=this;
            buffs=new ArrayList<>();
        }
    }

    public static PlayerBattle GetInstance() {
        var result = instance;
        if (result == null) {
            synchronized (PlayerBattle.class) {
                result = instance;
                if (result == null) {
                    instance = result = new PlayerBattle();
                }
            }
        }
        return result;
    }
    


    public void OneRoundUp() throws InterruptedException //加buff，后执行攻击
    {
        for (Buff buff : buffs) {
            buff.AddBuff();
        }
        buffs.removeIf(s -> s.continueTime==0);//用完就丢
    }

    public boolean CanEscape()//类极乐迪斯科判定
    {
        return Dice.Determine(lucky, 9);
    }//概率为容易


    public void HealthRestore()
    {

    }

    public void AddHealthBuff(HealthBuff healthBuff)
    {
        healthBuff.SetHealth(playerHealth);
        buffs.add(healthBuff);
    }

    public void AddEnergyBuff(EnergyBuff energyBuff)
    {
        buffs.add(energyBuff);
    }

} 
