public class PlayerMoveState implements PlayerState{
    Player player;
    public PlayerMoveState(Player player)
    {
        this.player=player;
    }
    public void ExcuteState()
    {
        System.out.println("玩家进入移动状态");
    }
    public void ExitState()
    {
        System.out.println("玩家移动结束");
    }
}
