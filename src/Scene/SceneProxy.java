package Scene;

import Mgr.GameMgr;

public class SceneProxy implements iScene {
    public iScene scene;
    private int oneday=0;
    private volatile int count=0;
    private static volatile SceneProxy instance;

    private SceneProxy() throws InterruptedException{
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        } else {
            instance = this;
        }
    }

    public static SceneProxy GetInstance() throws InterruptedException {
        var result = instance;
        if (result == null) {
            synchronized (SceneProxy.class) {
                result = instance;
                if (result == null) {
                    instance = result = new SceneProxy();
                }
            }
        }
        return result;
    }

    public void SetScene(iScene scene) {
        this.scene = scene;
        int today=GameMgr.GetInstance().GetDay();
        if (oneday == today)
        {
            count++;
        }
        else {
            count = 0;
            oneday = today;
        }
    }

    public iScene GetScene() throws InterruptedException {
        return scene;
    }

    public String GetDescription() {
        return scene.GetDescription();
    }

    public void StartVisit() throws InterruptedException {
        if (count >= 1) {
            System.out.println("你今天已经来过这里了，明天再来吧！");
        }
        else{
            scene.StartVisit();
        }
    }
}
