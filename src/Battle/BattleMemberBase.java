package Battle;

import java.util.ArrayList;
import java.util.List;

import Actor.Attack;
import Actor.AttackWithWeapon;
import Actor.Defence;
import Actor.Health;
import Item.Buff.AttackBuff;
import Item.Buff.Buff;
import Item.Buff.DefenceBuff;
import Item.Buff.EnergyBuff;
import Item.Buff.HealthBuff;
import Item.Weapon.WeaponBase;

public class BattleMemberBase implements IBattleMember{
    protected IBattleMediator iBattleMediator;

    protected List<Buff> buffs=new ArrayList<>();
    protected Health health;
    protected AttackWithWeapon attack;
    protected Defence defence;

    public void JoinBattle(IBattleMediator battleMediator)
    {
        this.iBattleMediator=battleMediator;
        battleMediator.AddMember(this);
    }

    public void BattleAction(BattleAction action,float amount)
    {

    }

    public void Act(BattleAction action)
    {

    }

    public void OneRoundUp() throws InterruptedException //加buff，后继续操作
    {
        for (Buff buff : buffs) {
            buff.AddBuff();
        }
        buffs.removeIf(s -> s.continueTime==0);//用完就丢
    }

    public void SetHealth(Health health)
    {
        this.health=health;
    }

    public void SetAttack(AttackWithWeapon attack)
    {
        this.attack=attack;
    }

    public void SetDefence(Defence defence)
    {
        this.defence=defence;
    }

    public void AddHealthBuff(HealthBuff healthBuff)
    {
        healthBuff.SetHealth(health);
        buffs.add(healthBuff);
    }

    public void AddEnergyBuff(EnergyBuff energyBuff)
    {
        buffs.add(energyBuff);
    }

    public void AddAttackBuff(AttackBuff attackBuff)
    {
        attackBuff.SetAttack(attack.GetAttack());
        buffs.add(attackBuff);
    }

    public void AddDefenceBuff(DefenceBuff defenceBuff)
    {
        defenceBuff.SetDefence(defence);
        buffs.add(defenceBuff);
    }

    public void SetWeapon(WeaponBase wBase)
    {
        attack.SetWeapon(wBase);
    }
    
}
