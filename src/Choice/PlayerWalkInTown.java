package Choice;

import Player.Player;

public class PlayerWalkInTown extends ChoiceCosumeEnergy{
    Player player;
    public PlayerWalkInTown(Player player)
    {
        this.player=player;
        needEnergy=1;
        description="在小镇上闲逛";
    }
    public void Choose() throws InterruptedException
    {
        super.Choose();
        System.out.println( Player.playername+"在小镇上闲逛。慢节奏的生活真美好啊！");
    }
}
