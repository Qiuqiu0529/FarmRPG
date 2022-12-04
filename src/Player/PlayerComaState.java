package Player;

public class PlayerComaState implements PlayerState{//战斗失败、陷入昏迷、badsleep
    Player player;
    public PlayerComaState(Player player)
    {
        this.player=player;
    }
    public void ExcuteState()
    {
        System.out.println( Player.playername+"进入昏迷状态");
    }
    public void ExitState()
    {
        System.out.println( Player.playername+"苏醒");
        player.BadSleep();
    }
}