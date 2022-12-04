package Player;
import Actor.Movement;

public class PlayerMovement extends Movement{
    public void MoveUp()
    {
        MoveUpdate(0, 1);
        System.out.println(Player.playername+"向上移动一格");
    }
    public void MoveDown()
    {
        MoveUpdate(0, -1);
        System.out.println(Player.playername+"向下移动一格");

    }
    public void MoveLeft()
    {
        MoveUpdate(-1, 0);
        System.out.println(Player.playername+"向左移动一格");
    }

    public void MoveRight()
    {
        MoveUpdate(1, 0);
        System.out.println(Player.playername+"向右移动一格");
    }

    public void UpdatePos()
    {
        System.out.println(Player.playername+"当前位置 " + Integer.toString(posX)+"，"+Integer.toString(posY));
    }

}
