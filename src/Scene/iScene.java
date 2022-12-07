package Scene;

public interface iScene {
    public iScene GetScene() throws InterruptedException;

    public String GetDescription();

    public void StartVisit() throws InterruptedException;
}
