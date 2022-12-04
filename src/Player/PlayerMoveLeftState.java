package Player;

public class PlayerMoveLeftState implements PlayerState{//森林模式移动
    Player player;
    public PlayerMoveLeftState(Player player)
    {
        this.player=player;
    }
    public void ExcuteState()
    {
        System.out.println( Player.playername+"向左移动");
    }
    public void ExitState()
    {

    }
}

