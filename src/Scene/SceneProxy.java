package Scene;

import Mgr.GameMgr;

public class SceneProxy implements iScene {
    public iScene scene;
    private int date=0;
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

    public void SetDay() {
        this.date=GameMgr.GetInstance().GetDay()+1;
    }

    public void SetScene(iScene scene) {
        this.scene = scene;
    }

    public iScene GetScene() throws InterruptedException {
        return scene;
    }

    public String GetDescription() {
        return scene.GetDescription();
    }

    public void StartVisit() throws InterruptedException {
        int today = GameMgr.GetInstance().GetDay();
        Thread.sleep(1000);
        if (today!=date|| GameMgr.GetInstance().GetTimePeriod()!=1) {
            System.out.println("你在咖啡馆里坐了许久，却没有等来熟悉的人。");
        }
        else {
            date = 0;
            scene.StartVisit();
        }
    }
}
