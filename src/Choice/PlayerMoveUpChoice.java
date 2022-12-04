package Choice;

import Player.PlayerMovement;

public class PlayerMoveUpChoice extends ChoiceCosumeEnergy{
    PlayerMovement playerMovement;

    public boolean CanChoose()
    {
        return playerMovement.CanMove(0,1);
    }

    public PlayerMoveUpChoice(PlayerMovement pMovement)
    {
        needEnergy=2;
        description="向上移动";
    }

    public void Choose()
    {
        super.Choose();
        playerMovement.MoveUp();
    }
    
}
