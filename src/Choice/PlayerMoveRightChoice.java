package Choice;

import Player.PlayerMovement;

public class PlayerMoveRightChoice extends ChoiceCosumeEnergy{
    PlayerMovement playerMovement;

    public boolean CanChoose()
    {
        return playerMovement.CanMove(1,0);
    }

    public PlayerMoveRightChoice(PlayerMovement pMovement)
    {
        needEnergy=1;
        description="向右移动";
    }

    public void Choose()
    {
        super.Choose();
        playerMovement.MoveRight();
    }
    
}
