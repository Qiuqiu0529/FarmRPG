package NPC;

import java.util.ArrayList;
import java.util.List;

import Choice.IChoice;

public class Alice extends Resident {
    private static volatile Alice instance;
    static List<IChoice> choices;

    private Alice() {
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        } else {
            Init();
        }
    }
    
    public void Init()
    {
        choices=new ArrayList<>();
        PlayerReturn playerReturn=new PlayerReturn();
        PlayerRestInForest playerRestInForest=new PlayerRestInForest(Player.getInstance());
        PlayerMoveInForest playerMoveUpForest=new PlayerMoveInForest(Player.getInstance(), "上",0, 1);
        PlayerMoveInForest playerMoveDownForest=new PlayerMoveInForest(Player.getInstance(), "下",0, -1);
        PlayerMoveInForest playerMoveLeftForest=new PlayerMoveInForest(Player.getInstance(), "左",-1, 0);
        PlayerMoveInForest playerMoveRightForest=new PlayerMoveInForest(Player.getInstance(), "右",1, 0);
        choices.add(playerReturn);
        choices.add(playerRestInForest);
        choices.add(playerMoveUpForest);
        choices.add(playerMoveDownForest);
        choices.add(playerMoveLeftForest);
        choices.add(playerMoveRightForest);
    }

}
