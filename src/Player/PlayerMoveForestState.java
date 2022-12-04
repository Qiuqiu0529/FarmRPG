package Player;

public class PlayerMoveForestState implements PlayerState{//森林模式
    Player player;
    public PlayerMoveForestState(Player player)
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

