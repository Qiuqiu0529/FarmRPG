public class Player {
    private static volatile Player instance;
    private Player() {
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        }
        else
        {
            playerVisual=new PlayerVisual();
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

}
