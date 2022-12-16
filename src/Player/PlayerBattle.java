package Player;

import java.util.ArrayList;
import java.util.List;

import Actor.AttackWithWeapon;
import Actor.Defence;
import Actor.Health;
import Battle.BattleMemberBase;
import Item.Dice;
import Item.Buff.AttackBuff;
import Item.Buff.Buff;
import Item.Buff.DefenceBuff;
import Item.Buff.EnergyBuff;
import Item.Buff.HealthBuff;
import Item.Weapon.WeaponBase;

public class PlayerBattle extends BattleMemberBase{

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
            health=new PlayerHealth();
            attack=new AttackWithWeapon(5);
            defence=new Defence(2);
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


    public boolean CanEscape()//类极乐迪斯科判定
    {
        return Dice.Determine(Player.lucky, 9);
    }//概率为容易




} 
