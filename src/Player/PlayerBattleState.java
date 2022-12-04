package Player;

public class PlayerBattleState implements PlayerState{//战斗状态
    Player player;
    public PlayerBattleState(Player player)
    {
        this.player=player;
    }
    public void ExcuteState()
    {
        System.out.println( Player.playername+"进入战斗状态");
    }
    public void ExitState()
    {
        System.out.println( Player.playername+"结束战斗");
    }
}