package Mgr;
import Item.InventoryMgr;
import Other.Global;
import Player.Player;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("在厌倦了日复一日的工作后，你选择回归田园生活。" );
        Global global=new Global();
        System.out.println("请输入玩家姓名：" );
        String playername=InputMgr.GetInstance().GetInputString();
        Player player=new Player(playername);
        InventoryMgr.GetInstance().AddInventory();
        GameMgr.GetInstance().ADay();
        
    }
}
