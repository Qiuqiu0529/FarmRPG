package Choice;

import NPC.NPC;

public class ChoiceFavor implements IChoice {

    protected NPC npc;
    protected int changeAmount;// 好感度增减
    protected String description = "";// 选项描述
    protected String chooseDescription = "";// 选择后的描述

    public boolean CanChoose() {
        return true;
    }

    public ChoiceFavor(NPC npc, int changeAmount, String description, String chooseDescription) {
        this.npc = npc;
        this.changeAmount = changeAmount;
        this.description = description;
        this.chooseDescription = chooseDescription;
    }

    public void ChoiceInfo() {
        System.out.println(description);
    }

    public void Choose() throws InterruptedException{
        npc.ChangeFavor(changeAmount);
        System.out.println(chooseDescription);
        System.out.println(npc.GetName()+"对你的好感改变了。当前好感度："+npc.GetState());
    }

}