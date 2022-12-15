package Player;

import java.lang.reflect.Type;

import Mgr.ChoiceMgr;
import Mgr.ForestMgr;
import Mgr.IPlayerMoveObserver;
import Mgr.SoundMgr;

public class Player {//state/component/
    private static volatile Player instance;
    public String description = "一个厌倦了996生活想重归田园的程序员";
    public static String playername = "玩家";


    PlayerVisual playerVisual;
    PlayerMovement playerMovement;
    PlayerBattle playerBattle;//跟战斗有关的
    PlayerState state;
    PlayerComaState playerComaState;
    PlayerMoveState playerMoveState;
    PlayerSleepState playerSleepState;
    PlayerIdleState playerIdleState;
    PlayerInitState playerInitState;

    public Player() throws InterruptedException{
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        } else {
            Init();
        }
    }

    public Player(String nameString) throws InterruptedException{
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        } else {
            playername = nameString;
            Init();
        }
    }

    public void Init() throws InterruptedException{
        HairStyleType hairStyleType=ChoiceMgr.GetInstance().ChooseHair();
        ColorType hType=ChoiceMgr.GetInstance().ChooseColor("头发");
        ColorType eType=ChoiceMgr.GetInstance().ChooseColor("眼睛");
        ConstellationType constellationType=ChoiceMgr.GetInstance().ChooseConstellation();

        playerVisual = new PlayerVisual.PlayerVisualBuilder()
        .withHairType(hairStyleType).withHairColor(hType)
        .withEyesColor(eType).withConstellation(constellationType)
        .build();

        
        playerMovement=new PlayerMovement();
        playerIdleState=new PlayerIdleState(this);
        playerComaState=new PlayerComaState(this);
        playerMoveState=new PlayerMoveState(this);
        playerSleepState=new PlayerSleepState(this);
        playerIdleState=new PlayerIdleState(this);
        playerInitState=new PlayerInitState();

        
        state = playerInitState;
        instance=this;
    }

    public static Player getInstance() throws InterruptedException {
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

    public void BadSleep()
    {
        EnergyPresenter.GetInstance().BadReset();
    }

    public void Idle()
    {
        playerVisual.PlayIdleAnim();
    }


    public boolean CanMove(int x,int y)
    {
        return playerMovement.CanMove(x, y);
    }

    public void MoveInForest(String dir,int x,int y) throws InterruptedException
    {
        SetMove();
        playerVisual.PlayWalkAnim(dir);
        SoundMgr.GetInstance().PlayForestWalkingSound();
        Thread.sleep(300);
        playerMovement.SetDir(dir);
        playerMovement.MoveUpdate(x, y);
        SetPlayerState(playerIdleState);
    }

    public void SetMoveObservers(IPlayerMoveObserver observer)
    {
        playerMovement.AddObserver(observer);
    }

    public void RestInForest()
    {
        SoundMgr.GetInstance().PlayRestSound();
    }

    public void InitPlayerPosInForest()
    {
        playerMovement.InitPos();
    }

    public void MoveInScene() throws InterruptedException
    {
        SetMove();
        playerVisual.PlayMoveAnim();
        SoundMgr.GetInstance().PlayNormalMoveSound();
        Thread.sleep(1000);
        SetPlayerState(playerIdleState);
    }

    
}
