package Player;
import Actor.Movement;

public class PlayerMovement extends Movement{
    String dir;
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
    }

    public void InitPos()
    {
        System.out.println("可移动地区大小为" + Integer.toString(Movement.GetMaxPosX())+" X "+Integer.toString(Movement.GetMaxPosY()));
        UpdatePos();
    }

}
