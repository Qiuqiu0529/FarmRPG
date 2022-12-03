package Player;
public class PlayerMoveUpState implements PlayerState{//森林模式移动
    Player player;
    public PlayerMoveUpState(Player player)
    {
        this.player=player;
    }
    public void ExcuteState()
    {
        System.out.println("玩家向上移动");
    }
    public void ExitState()
    {

    }
}
