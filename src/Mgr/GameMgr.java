package Mgr;
public class GameMgr {
    private static volatile GameMgr instance;

    private GameMgr() {
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        }
        else
        {
            RunGame();
        }
        
    }

    public static GameMgr GetInstance() {
        var result = instance;
        if (result == null) {
            synchronized (GameMgr.class) {
                result = instance;
                if (result == null) {
                    instance = result = new GameMgr();
                }
            }
        }
        return result;
    }

    protected volatile GameStatus status;
    public boolean IsGameRunning() {
        return status == GameStatus.RUNNING;
      }
    

    public void RunGame() {
        status = GameStatus.RUNNING;
    }

    public void StopGame()
    {
        status = GameStatus.STOPPED;
    }

    public void EndADay()
    {

    }
}
