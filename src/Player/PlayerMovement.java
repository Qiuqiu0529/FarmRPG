package Player;
import Actor.Movement;

public class PlayerMovement extends Movement{
    public void MoveUp(int amount)
    {
       MoveUpdate(0, 1);
    }
    public void MoveDown(int amount)
    {
        MoveUpdate(0, -1);

    }
    public void MoveLeft(int amount)
    {
        MoveUpdate(-1, 0);
    }

    public void MoveRight(int amount)
    {
        MoveUpdate(1, 0);
    }
}
