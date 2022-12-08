package Choice;

import NPC.NPC;
import Scene.SceneProxy;

public class DateInCafe extends ChoiceFavor {
    public DateInCafe(NPC npc, int changeAmount, String description, String chooseDescription) {
        super(npc, changeAmount, description, chooseDescription);
    }
    public void Choose() throws InterruptedException{
        npc.ChangeFavor(changeAmount);
        SceneProxy.GetInstance().SetDay();
        System.out.println(chooseDescription);
        System.out.println(npc.GetName()+"对你的好感增加了。当前好感度："+npc.GetState());
    }

}