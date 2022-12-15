package Shop;

import java.util.ArrayList;
import java.util.List;

import Choice.DefaultChoice;
import Choice.IChoice;
import Mgr.ChoiceMgr;
import Player.Player;

public class ShopBase implements IShop{
    public List<IChoice> goods=new ArrayList<>();
    public String shopname="";
    public void VisitShop() throws InterruptedException
    {
        DisplayGoods();
    }

    public void DisplayGoods() throws InterruptedException
    {
        System.out.println(shopname+ "商品列表：");
        int i = ChoiceMgr.GetInstance().Choose(goods);
        if (i != 0) {//0为结束购买
            //触发事件
            DisplayGoods();
        }
    }
    public void InitGoods()
    {
        goods.add(new DefaultChoice("什么都不买",
        Player.playername+"离开了"+shopname));
    }
}
