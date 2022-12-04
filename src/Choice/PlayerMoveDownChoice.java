package Choice;

import Player.PlayerMovement;

public class PlayerMoveDownChoice extends ChoiceCosumeEnergy{
    PlayerMovement playerMovement;

    public boolean CanChoose()
    {
        return playerMovement.CanMove(0,-1);
    }

    public PlayerMoveDownChoice(PlayerMovement pMovement)
    {
        needEnergy=2;
        description="向下移动";
    }

    public void Choose()
    {
        super.Choose();
        playerMovement.MoveDown();
    }
    
}
