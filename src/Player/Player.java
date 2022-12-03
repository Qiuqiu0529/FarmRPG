package Player;
import java.lang.reflect.Type;
import Mgr.SoundMgr;
public class Player {
    private static volatile Player instance;
    public String description="一个厌倦了996生活想重归田园的程序员";
    public String playername="玩家";

    public Player() {
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        } else {
            playerVisual = new PlayerVisual();
            state = new PlayerIdleState(this);
            state.ExcuteState();
        }
    }

    public static Player getInstance() {
        var result = instance;
        if (result == null) {
            synchronized (MoneyPresenter.class) {
                result = instance;
                if (result == null) {
                    instance = result = new Player();
                }
            }
        }
        return result;
    }

    PlayerVisual playerVisual;
    PlayerState state;

    public void SetPlayerState(PlayerState newState) {
        state.ExitState();
        state = newState;
        state.ExcuteState();
    }

    public Type GetState() {
        System.out.println("玩家当前状态为" + state.getClass());
        return state.getClass();
    }

    public void EnterIdle()
    {
       
    }

    public void EnterMoveUp()
    {
        
    }

}
