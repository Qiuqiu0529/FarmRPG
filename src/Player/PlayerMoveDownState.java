package Player;

public class PlayerMoveDownState implements PlayerState{//森林模式移动
    Player player;
    public PlayerMoveDownState(Player player)
    {
        this.player=player;
    }
    public void ExcuteState()
    {
        System.out.println( Player.playername+"向下移动");
    }
    public void ExitState()
    {

    }
}
