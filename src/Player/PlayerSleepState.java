package Player;

public class PlayerSleepState implements PlayerState{//森林模式移动
    Player player;
    public PlayerSleepState(Player player)
    {
        this.player=player;
    }
    public void ExcuteState()
    {
        System.out.println("玩家进入睡眠状态");
    }
    public void ExitState()
    {
        EnergyPresenter.GetInstance().Reset();
    }
}