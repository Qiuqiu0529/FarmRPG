package Player;
public class PlayerIdleState implements PlayerState{
    Player player;
    public PlayerIdleState(Player player)
    {
        this.player=player;
    }
    public void ExcuteState()
    {
        System.out.println("玩家进入默认待机状态");
        player.EnterIdle();
    }
    public void ExitState()
    {
        System.out.println("玩家退出默认待机状态");
    }
}
