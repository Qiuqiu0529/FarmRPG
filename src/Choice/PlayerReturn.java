package Choice;
import Player.Player;
public class PlayerReturn extends ChoiceConsumeEnergy{
 
    public PlayerReturn()
    {
        needEnergy=0;
        description="返回";
    }
    public void Choose() throws InterruptedException
    {
        super.Choose();
        Player.getInstance().MoveInScene();
    }
}
