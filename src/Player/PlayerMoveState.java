package Player;
public class PlayerMoveState implements PlayerState{//移动
    Player player;
    public PlayerMoveState(Player player)
    {
        this.player=player;
    }
    public void ExcuteState()
    {
        System.out.println( Player.playername+"进入移动状态");
    }
    public void ExitState()
    {
        System.out.println( Player.playername+"移动结束");
    }
}
