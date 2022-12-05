package Choice;

import Player.Player;

public class PlayerRestInForest extends ChoiceCosumeEnergy{
    Player player;
    public PlayerRestInForest(Player player)
    {
        this.player=player;
        needEnergy=1;
        description="原地休整";
    }
    public void Choose() throws InterruptedException
    {
        super.Choose();
        System.out.println( Player.playername+"选择原地修整");
        player.RestInForest();
    }
}
