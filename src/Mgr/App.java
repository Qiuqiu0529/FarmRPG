package Mgr;
import Item.InventoryMgr;
import Player.Player;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("请输入玩家姓名：" );
        String playername=InputMgr.GetInstance().GetInputString();
        Player player=new Player(playername);
        InventoryMgr.GetInstance().AddInventory();
        GameMgr.GetInstance().ADay();
        
    }
}
