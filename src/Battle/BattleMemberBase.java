package Battle;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Element;

import Actor.AttackWithWeapon;
import Actor.Defence;
import Actor.Health;
import Item.Dice;
import Item.Buff.AttackBuff;
import Item.Buff.Buff;
import Item.Buff.DefenceBuff;
import Item.Buff.EnergyBuff;
import Item.Buff.HealthBuff;
import Item.Weapon.WeaponBase;
import Mgr.SoundMgr;
import Player.Player;
import Player.PlayerBattle;

public class BattleMemberBase implements IBattleMember {
    protected IBattleMediator iBattleMediator;

    protected List<Buff> buffs = new ArrayList<>();
    protected Health health;
    protected AttackWithWeapon attack;
    protected Defence defence;
    public String name = "";
    protected boolean defencethisRound = false;

    public void JoinBattle(IBattleMediator battleMediator) throws InterruptedException {
        this.iBattleMediator = battleMediator;
        battleMediator.AddMember(this);
    }

    public void BattleAction(BattleAction action, float amount) throws InterruptedException {// 回应
        switch (action) {
            case ATTACK:
                if (defencethisRound || (Dice.Determine(0, 9))) {
                    System.out.println(name + "触发防御");
                    amount = defence.DefenceAttack(amount);
                    System.out.println("防御后伤害值：" + Float.toString(amount));
                }
                health.MinusHealth(amount);
                if (health.GetCurrentHealth() <= 0) {
                    System.out.println(name + "生命值归零，倒下");
                    Fall();
                }
                break;
            case SKILL:
                int i=Dice.Roll(0, 3);
                if(i==0)
                {
                    System.out.println(name + "获得治愈buff");
                    AddHealthBuff(new HealthBuff(Dice.Roll(1, 4), Dice.Roll(5, 10)));
                }
                else if(i==1)
                {
                    System.out.println(name + "获得攻击buff");
                    AddAttackBuff(new AttackBuff(Dice.Roll(1, 4), Dice.Roll(3, 7)));
                }
                else
                {
                    System.out.println(name + "获得防御buff");
                    AddDefenceBuff(new DefenceBuff(Dice.Roll(1, 4), Dice.Roll(3, 7)));
                }
                break;
            default:
                break;
        }
    }

    public void Act(BattleAction action) throws InterruptedException {// 主动
        switch (action) {
            case ESCAPE:
                if (CanEscape()) {
                    System.out.println(name + "逃跑成功");
                    SoundMgr.GetInstance().PlayEscapeSound();
                    iBattleMediator.Act(this, action, 0);
                } else {
                    System.out.println(name + "逃跑失败");
                }
                break;
            case ATTACK:
                for (int i = 0; i < attack.GetEachAttackCount(); ++i) {
                    float attckcount = attack.GiveAttack();
                    iBattleMediator.Act(this, action, attckcount);
                }
                break;
            case DEFENCE:
                defencethisRound = true;// 下一次对方攻击时百分百防御
                break;
            case SKILL:
                iBattleMediator.Act(this, action, 0);// 施加技能
                break;
            default:
                break;
        }
    }

    public boolean CanEscape()// 类极乐迪斯科判定
    {
        return Dice.Determine(Player.lucky, 9);
    }// 概率为容易

    public void LevelUp()// 升级一下
    {
        int healthchange = Dice.Roll(0, 3) + 1;
        health.ChangeBase(healthchange);
        System.out.println(name + "生命值增加" + Integer.toString(healthchange));

        int attackchange = Dice.Roll(0, 3) + 1;
        attack.ChangeBase(attackchange);
        System.out.println(name + "攻击值增加" + Integer.toString(attackchange));

        int defencechange = Dice.Roll(0, 3) + 1;
        defence.ChangeBase(defencechange);
        System.out.println(name + "防御值增加" + Integer.toString(defencechange));
    }

    public void OneRoundUp() throws InterruptedException // 加buff，后继续操作,子类里拓展
    {
        for (Buff buff : buffs) {
            buff.AddBuff();
        }
        buffs.removeIf(s -> s.continueTime <= 0);// 用完就丢,
        defencethisRound = false;
    }

    public void Fall() throws InterruptedException// 倒下
    {
        iBattleMediator.RemoveMember(this);
    }

    public void SetHealth(Health health) {
        this.health = health;
    }

    public void SetAttack(AttackWithWeapon attack) {
        this.attack = attack;
    }

    public void SetDefence(Defence defence) {
        this.defence = defence;
    }

    public void AddHealthBuff(HealthBuff healthBuff) throws InterruptedException {
        healthBuff.SetHealth(health);
        AddBuff(healthBuff);
    }

    public void AddEnergyBuff(EnergyBuff energyBuff) throws InterruptedException {// player限定
        if (this instanceof PlayerBattle) {
            AddBuff(energyBuff);
        }
    }

    public void AddAttackBuff(AttackBuff attackBuff) throws InterruptedException {
        attackBuff.SetAttack(attack.GetAttack());
        attackBuff.AddBuff();
        buffs.add(attackBuff);// 下一回合再取消
    }

    public void AddDefenceBuff(DefenceBuff defenceBuff) throws InterruptedException {
        defenceBuff.SetDefence(defence);
        defenceBuff.AddBuff();
        buffs.add(defenceBuff);// 下一回合再取消
    }

    public void AddBuff(Buff buff) throws InterruptedException {
        buff.AddBuff();
        if (buff.continueTime > 0) {
            buffs.add(buff);
        }
    }

    public void SetWeapon(WeaponBase wBase) {
        attack.SetWeapon(wBase);
    }

}
