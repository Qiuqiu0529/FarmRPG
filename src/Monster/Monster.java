package Monster;

import Battle.BattleMemberBase;

public class Monster extends BattleMemberBase implements IMonster// implements IBattleMember
{
    MonsterMovement monsterMovement;
    int bonusmoney = 10;

    public void SetBonusMoney(int bonus) {
        this.bonusmoney = bonus;
    }

    public void SetMoveSpeed(int xSpeed, int ySpeed) {
        monsterMovement = new MonsterMovement(xSpeed, ySpeed);
    }

    public void MonsterMove() throws InterruptedException {
        monsterMovement.Move();
    }

    public boolean MeetPlayer(int x, int y) {
        return monsterMovement.GetPosX() == x && monsterMovement.GetPosY() == y;
    }

    public void Action() {

    }

    public void Hit(float amount) {

    }

    public void Fall() {
        super.Fall();

    }
}
