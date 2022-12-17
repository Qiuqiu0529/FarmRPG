package Monster;

import Battle.BattleMemberBase;

public class Monster extends BattleMemberBase implements IMonster//implements IBattleMember
{
    MonsterMovement monsterMovement;

    public void SetMoveSpeed(int xSpeed,int ySpeed)
    {
        monsterMovement=new MonsterMovement(xSpeed,ySpeed);
    }

    public void MonsterMove() throws InterruptedException
    {
        monsterMovement.Move();
    }
    public void Action()
    {

    }
    public void Hit(float amount)
    {

    }
    public void Death()
    {

    }
}
