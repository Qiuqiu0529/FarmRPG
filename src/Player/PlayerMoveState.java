package Player;
public class PlayerMoveState implements PlayerState{//非冒险（森林）模式移动
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
