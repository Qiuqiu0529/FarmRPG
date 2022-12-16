package Player;
import java.util.ArrayList;
import java.util.List;

import Actor.Movement;
import Mgr.IPlayerMoveObserver;

public class PlayerMovement extends Movement{
    String dir;
    List<IPlayerMoveObserver> observers=new ArrayList<>();

    public void AddObserver(IPlayerMoveObserver observer)
    {
        observers.add(observer);
    }

    public void RemoveObserver(IPlayerMoveObserver observer)
    {
        observers.remove(observer);
    }

    public void MoveUpdate(int x,int y)
    {
       super.MoveUpdate(x, y);
       System.out.println(Player.playername+"向" + dir+"移动了一格");
       UpdatePos();
    }
    public void SetDir(String dir)
    {
        this.dir=dir;
    }

    public void UpdatePos()
    {
        System.out.println(Player.playername+"当前位置 " + Integer.toString(posX)+"，"+Integer.toString(posY));
        NotifyObservers();
    }

    public void InitPos()
    {
        System.out.println("可移动地区大小为" + Integer.toString(Movement.GetMaxPosX())+" X "+Integer.toString(Movement.GetMaxPosY()));
        UpdatePos();
    }

    public void NotifyObservers()
    {
        for (var obs : observers) {
            obs.UpdatePos(posX, posY);
          }

    }

}
