package NPC;

import java.util.ArrayList;
import java.util.List;
import Choice.ChoiceFavor;
import Choice.DateInCafe;

import Choice.IChoice;

public class Alice extends Resident {
    private static volatile Alice instance;
    
    private Alice() {
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        } else {
            Init();
        }
    }

    public static Alice GetInstance() throws InterruptedException{
        var result = instance;
        if (result == null) {
            synchronized (Alice.class) {
                result = instance;
                if (result == null) {
                    instance = result = new Alice();
                }
            }
        }
        return result;
    }
    
    public void Init()
    {
        name = "Alice";
        choices = new ArrayList<>();
        choices.add(new ChoiceFavor(this, 0, "今天天气真好啊！",name+"：是啊，天气真好"));
        choices.add(new ChoiceFavor(this, 10, "请教有关花的知识",name+"亲切地解答了你的困惑，并与你闲聊了一会儿。"));
        choices.add(new ChoiceFavor(this, 3, "购买花束",name+"为你包装了花束，说希望您再来。"));
        choices.add(new ChoiceFavor(this, 5, "帮她修剪玫瑰",name+"：今天好忙，没有你我都不知道该怎么办了！")); //friendly
        choices.add(new DateInCafe(this, 10, "邀请她喝一杯咖啡",name+"：明天下午吗？我很期待噢。\n(记得第二天下午前往咖啡店)")); //hospitality
        choices.add(new ChoiceFavor(this, 5, "抱住她说，今天也辛苦了", name + "笑着亲了你一下。")); //love
        choices.add(new ChoiceFavor(this, 5, "各自点一杯咖啡", "这天下午你们聊了许多，发现自己更了解彼此了。"));
        choices.add(new ChoiceFavor(this, 5, "为她点了一杯冰拿铁，你知道她最爱喝这个。", name + "和你畅聊了一下午，你们好像有说不完的话。"));
        choices.add(new ChoiceFavor(this, -20, "为她点一杯冰美式", "皱着眉头喝了一半，好像不太喜欢。你们之间的氛围也像这杯美式一样。"));
        choices.add(new ChoiceFavor(this, 10, "为她点一杯冰拿铁", "她看起来很喜欢。\n你们度过了愉快的下午，发现自己更了解彼此了。"));
        choices.add(new ChoiceFavor(this, 20, "为她点一杯招牌特调拿铁", name + "说这杯咖啡尝起来有一股花果香。她看起来很喜欢。\n你们度过了愉快的下午，发现自己更了解彼此了！")); 
        instance=this;
    }

}
