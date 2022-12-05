package Choice;
import Player.Player;
public class PlayerReturn extends ChoiceCosumeEnergy{
 
    public PlayerReturn()
    {
        needEnergy=0;
        description="返回";
    }
    public void Choose()
    {
        super.Choose();
        System.out.println( Player.playername+"选择回家");
        Player.getInstance().MoveInScene();
    }
}
