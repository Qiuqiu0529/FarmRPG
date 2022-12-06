package Mgr;
import Item.InventoryMgr;
import Other.Global;
import Player.Player;

public class App {
    public static void main(String[] args) throws Exception {
        Global global=new Global();
        System.out.println("请输入玩家姓名：" );
        String playername=InputMgr.GetInstance().GetInputString();
        Player player=new Player(playername);
        InventoryMgr.GetInstance().AddInventory();
        GameMgr.GetInstance().ADay();
        
    }
}
