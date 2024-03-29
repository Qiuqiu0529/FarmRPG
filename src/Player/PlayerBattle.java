package Player;

import java.util.ArrayList;
import java.util.List;

import Actor.AttackWithWeapon;
import Actor.Defence;
import Actor.Health;
import Battle.BattleMemberBase;
import Choice.IChoice;
import Choice.battle.BattleAttack;
import Choice.battle.BattleBackpack;
import Choice.battle.BattleDefence;
import Choice.battle.BattleEscape;
import Mgr.ChoiceMgr;
import Mgr.SoundMgr;

public class PlayerBattle extends BattleMemberBase implements PlayerMaker {

    // 攻击、背包、防御、逃跑
    private static volatile PlayerBattle instance;
    static List<IChoice> choices=new ArrayList<>();

    private PlayerBattle() {
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        } else {
            instance = this;
            name=Player.playername;
            SetHealth(new Health(100));
            SetAttack(new AttackWithWeapon(5));
            SetDefence(new Defence(2));
            choices.add(new BattleAttack(this));
            choices.add(new BattleDefence(this));
            choices.add(new BattleBackpack(this));
            choices.add(new BattleEscape(this));
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

    public void OneRoundUp() throws InterruptedException {
        super.OneRoundUp();
        System.out.println(Player.playername + "决定");
        ChooseAction();
    }

    public void ChooseAction() throws InterruptedException
    {
        ChoiceMgr.GetInstance().Choose(choices);
    }

    
    public void Fall() throws InterruptedException // 倒下
    {
        SoundMgr.GetInstance().PlayPlayerFallSound();
        iBattleMediator.RemoveMember(this);
    }

}
