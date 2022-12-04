package Player;

public class PlayerMoveRightState implements PlayerState{//森林模式移动
    Player player;
    public PlayerMoveRightState(Player player)
    {
        this.player=player;
    }
    public void ExcuteState()
    {
        System.out.println( Player.playername+"向右移动");
    }
    public void ExitState()
    {

    }
}
