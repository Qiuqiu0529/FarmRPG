package Choice;

import Player.PlayerMovement;

public class PlayerMoveLeftChoice extends ChoiceCosumeEnergy{
    PlayerMovement playerMovement;

    public boolean CanChoose()
    {
        return playerMovement.CanMove(-1,0);
    }

    public PlayerMoveLeftChoice(PlayerMovement pMovement)
    {
        needEnergy=2;
        description="向左移动";
    }

    public void Choose()
    {
        super.Choose();
        playerMovement.MoveLeft();
    }
    
}
