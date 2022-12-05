package Choice;

import NPC.NPC;

public class ChoiceFaver implements IChoice {

    protected NPC npc;
    protected int changeAmount;// 好感度增减
    protected String description = "";// 选项描述
    protected String chooseDescription = "";// 选择后的描述

    public boolean CanChoose() {
        return true;
    }

    public ChoiceFaver(NPC npc, int changeAmount, String description) {
        this.npc = npc;
        this.changeAmount = changeAmount;
        this.description = description;
    }

    public void ChoiceInfo() {
        System.out.println(description);
    }

    public void Choose() {
        npc.ChangeFavor(changeAmount);
        System.out.println(chooseDescription);
    }

}