package NPC;

import java.util.ArrayList;
import java.util.List;
import Choice.ChoiceFavor;

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
        choices.add(new ChoiceFavor(this, 3, "请教有关花的知识",name+"亲切地解答了你的困惑。你们闲聊了一会儿，度过了一段愉快的时光。"));
        choices.add(new ChoiceFavor(this, 3, "购买花束",name+"为你包装了花束，说希望您再来。"));
        choices.add(new ChoiceFavor(this, 5, "帮她修剪玫瑰",name+"：今天好忙，没有你我都不知道该怎么办了！")); //friendly
        choices.add(new ChoiceFavor(this, 10, "邀请她喝一杯咖啡",name+"：明天下午吗？我很期待噢。")); //hospitality
        choices.add(new ChoiceFavor(this, 5, "抱住她说，今天也辛苦了",name+"笑着亲了你一下。")); //love
        instance=this;
    }

}
