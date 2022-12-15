package Shop;

public interface IShop {
    public void VisitShop() throws InterruptedException;//进入商店
    public void DisplayGoods() throws InterruptedException;//供玩家购买
    public void InitGoods();//初始化商品
}
