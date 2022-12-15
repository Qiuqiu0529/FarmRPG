package Monster;

import Actor.Movement;
import Mgr.ForestMgr;

public class MonsterMovement extends Movement {
    int moveSpeedX = 1;
    int moveSpeedY = 1;

    public void Move() throws InterruptedException {
        if (CanMove(moveSpeedX, moveSpeedY)
                && ForestMgr.GetInstance().OccupyGrid(posX, posY, moveSpeedX, moveSpeedY)) {
            MoveUpdate(moveSpeedX, moveSpeedY);
        }
        else
        {
            

        }
    }

    public void InitPos()// 怪物初始位置随机
    {

    }

}
