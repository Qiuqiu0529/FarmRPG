package Battle;

public enum BattleAction {
    ATTACK,//攻击  怪物2/3可能攻击，1/3可能主动防御（有空可以改成可变概率
    DEFENCE,//主动防御100%，
    BEHIT,//50%可能被动防御
}