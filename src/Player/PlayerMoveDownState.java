package Player;

public class PlayerMoveDownState implements PlayerState{//森林模式移动
    Player player;
    public PlayerMoveDownState(Player player)
    {
        this.player=player;
    }
    public void ExcuteState()
    {
        System.out.println("玩家向下移动");
    }
    public void ExitState()
    {

    }
}
