package Item.Potion;

public enum PotionType {
    HEALING,  ATTACK, ENERGY,DEFENCE,
    CONTINUEHEALING,CONTINUEENERGY,CONTINUEATTACK,CONTINUEDEFENCE
}//加health，加攻击（限一次），加精力，加防御（限定一次）,
//连续三个回合加health,连续三个回合加energy，三个回合内持续加攻击，回合后取消，
