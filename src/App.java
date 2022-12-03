public class App {
    public static void main(String[] args) throws Exception {
        int temp=0;
        while(GameMgr.GetInstance().IsGameRunning())
        {

        }
        MoneyPresenter.GetInstance().EarnMoney(20);
        MoneyPresenter.GetInstance().SpendMoney(50);
        
    }
}
