package Player;

import java.lang.reflect.Type;
import Mgr.SoundMgr;

public class Player {//state/component/
    private static volatile Player instance;
    public String description = "一个厌倦了996生活想重归田园的程序员";
    public static String playername = "玩家";

    public Player() {
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        } else {
            Init();
        }
    }

    public Player(String nameString) {
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        } else {
            playername = nameString;
            Init();
        }
    }

    public void Init() {
        playerVisual = new PlayerVisual();
        playerMovement=new PlayerMovement();
        playerIdleState=new PlayerIdleState(this);
        playerComaState=new PlayerComaState(this);
        playerMoveState=new PlayerMoveState(this);
        playerSleepState=new PlayerSleepState(this);
        playerIdleState=new PlayerIdleState(this);
        playerInitState=new PlayerInitState();

        
        state = playerInitState;
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
    PlayerMovement playerMovement;
    PlayerState state;
    PlayerComaState playerComaState;
    PlayerMoveState playerMoveState;
    PlayerSleepState playerSleepState;
    PlayerIdleState playerIdleState;
    PlayerInitState playerInitState;
    


    public void SetPlayerState(PlayerState newState) {
        state.ExitState();
        state = newState;
        state.ExcuteState();
    }

    public void SetIdle()
    {
        SetPlayerState(playerIdleState);
    }

    public void SetSleep()
    {
        SetPlayerState(playerSleepState);
    }

    public void SetMove()
    {
        SetPlayerState(playerMoveState);
    }
    public void SetComa()
    {
        SetPlayerState(playerComaState);
    }

    public Type GetState() {
        System.out.println(playername + "当前状态为" + state.getClass());
        return state.getClass();
    }

    public void GoodSleep()
    {
        EnergyPresenter.GetInstance().Reset();
    }

    public void Idle()
    {
        playerVisual.PlayIdleAnim();
    }


    public boolean CanMove(int x,int y)
    {
        return playerMovement.CanMove(x, y);
    }

    public void MoveInForest(String dir,int x,int y)
    {
        SetMove();
        playerVisual.PlayWalkAnim(dir);
        SoundMgr.GetInstance().PlayForestWalkingSound();
        playerMovement.SetDir(dir);
        playerMovement.MoveUpdate(x, y);
        SetPlayerState(playerIdleState);
    }

    public void InitPlayerPosInForest()
    {
        playerMovement.InitPos();
    }

    public void MoveInScene()
    {
        SetMove();
        playerVisual.PlayMoveAnim();
        SoundMgr.GetInstance().PlayNormalMoveSound();
        SetPlayerState(playerIdleState);
    }

    public void BadSleep()
    {
        EnergyPresenter.GetInstance().BadReset();
    }
}
