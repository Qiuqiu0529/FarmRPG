package Monster;

import Battle.BattleAction;
import Battle.BattleMemberBase;
import Battle.IBattleMediator;
import Item.Dice;
import Item.Buff.Buff;
import Mgr.ForestMgr;
import Mgr.SoundMgr;

public class Monster extends BattleMemberBase implements IMonster// implements IBattleMember
{
    MonsterMovement monsterMovement;
    int bonusmoney = 10;

    public void SetMoveSpeed(int xSpeed, int ySpeed) {
        monsterMovement = new MonsterMovement(xSpeed, ySpeed);
    }

    public void MonsterMove() throws InterruptedException {
        monsterMovement.Move();
    }

    public boolean MeetPlayer(int x, int y) {
        return monsterMovement.GetPosX() == x && monsterMovement.GetPosY() == y;
    }

    public void InitPos() throws InterruptedException
    {
        monsterMovement.InitPos();
    }
    
    public void SetBonusMoney() {
        this.bonusmoney = 7+(int) (3*attack.GiveAttack());
    }


    public int GetBonuseMoney()
    {
        return bonusmoney;
    }



    public void JoinBattle(IBattleMediator battleMediator) throws InterruptedException
    {
        super.JoinBattle(battleMediator);
        SetBonusMoney();
        for (Buff buff : buffs) {
            buff.CancleBuff();
        }
    }

    public void OneRoundUp() throws InterruptedException {
        super.OneRoundUp();
        if(Dice.Determine(0, 11))
        {
            Act(BattleAction.SKILL);
        }
        else 
        {
            if(Dice.Determine(0, 5))
            {
                Act(BattleAction.ATTACK);
            }
            else
            {
                Act(BattleAction.DEFENCE);
            }
        }
    }

    public void BeHit()
    {
        SoundMgr.GetInstance().PlayMonsterDamageSound();
    }


   

    public void Fall() throws InterruptedException// 倒下
    {
        SoundMgr.GetInstance().PlayMonsterDiedSound();
        iBattleMediator.RemoveMember(this);
        ForestMgr.GetInstance().KillMoster(this);
    }

}
