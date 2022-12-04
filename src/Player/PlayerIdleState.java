package Player;
public class PlayerIdleState implements PlayerState{
    Player player;
    public PlayerIdleState(Player player)
    {
        this.player=player;
    }
    public void ExcuteState()
    {
        System.out.println( Player.playername+"进入默认待机状态");
    }
    public void ExitState()
    {
        System.out.println( Player.playername+"退出默认待机状态");
    }
}
