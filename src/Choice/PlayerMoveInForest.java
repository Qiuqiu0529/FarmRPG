package Choice;

import Player.Player;

public class PlayerMoveInForest extends ChoiceCosumeEnergy{
    Player player;
    int x=0,y=0;
    String dir;

    public boolean CanChoose()
    {
        if(!super.CanChoose())
        {
            return false;
        }
        return player.CanMove(x,y);
    }

    public PlayerMoveInForest(Player player,String dir,int x,int y)
    {
        this.player=player;
        this.x=x;
        this.y=y;
        needEnergy=2;
        this.dir=dir;
        description="向"+dir+"移动";
    }

    public void Choose()
    {
        super.Choose();
        player.MoveInForest(dir, x, y);
    }
    
}

