package Player;

public class PlayerSleepState implements PlayerState{//森林模式移动
    Player player;
    public PlayerSleepState(Player player)
    {
        this.player=player;
    }
    public void ExcuteState()
    {
        System.out.println( Player.playername+"进入睡眠状态");
    }
    public void ExitState()
    {
        System.out.println( Player.playername+"睡了个好觉");
        player.GoodSleep();
    }

}