package Monster;

import java.util.Random;

import Actor.Movement;
import Item.Dice;
import Mgr.ForestMgr;

public class MonsterMovement extends Movement {
    int moveSpeedX = 1;
    int moveSpeedY = 1;

    public MonsterMovement(int speedX ,int speedY )
    {
        moveSpeedX=speedX;
        moveSpeedY=speedY;
    }

    public void Move() throws InterruptedException {
        if (CanMove(moveSpeedX, moveSpeedY)
                && ForestMgr.GetInstance().OccupyGrid(posX+moveSpeedX, posY+moveSpeedY)) {
            ForestMgr.GetInstance().UnOccupy(posX, posY);
            MoveUpdate(moveSpeedX, moveSpeedY);
        } else {
            if (Dice.Determine(0, 8)) {//换个方向
                moveSpeedX *= -1;
            } else {
                moveSpeedY *= -1;
            }
        }
    }

    public void InitPos() throws InterruptedException// 怪物初始位置随机
    {
        int x = Dice.Roll(0, maxposX);
        int y = Dice.Roll(0, maxposY);
        if (ForestMgr.GetInstance().OccupyGrid(posX, posY)) {
            posX=x;
            posY=y;
        }
        else
        {
            InitPos();//再找个位置
        }
    }

}
