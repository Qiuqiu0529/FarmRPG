package Shop;

import java.util.ArrayList;
import java.util.List;

import Choice.IChoice;
import Mgr.ChoiceMgr;

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

    }
}
