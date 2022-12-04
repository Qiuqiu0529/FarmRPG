package Player;
import Other.Callback;
import Mgr.GameMgr;


public class MoneyPresenter {//singleton、MVP、callback
    Money money;
    int debtTimeRestrcit=7;//可以欠债的最多天数

    private static volatile MoneyPresenter instance;

    private MoneyPresenter() {
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        }
        else
        {
            money = new Money();
            money.SetOnChange(moneyChanged);
        }
    }

    public static MoneyPresenter GetInstance() {
        var result = instance;
        if (result == null) {
            synchronized (MoneyPresenter.class) {
                result = instance;
                if (result == null) {
                    instance = result = new MoneyPresenter();
                }
            }
        }
        return result;
    }

    private static Callback moneyChanged = new Callback() {
        @Override
        public void Call() {
            instance.UpdateView();
        }
    };

    public void SpendMoney(float minusAmount) {
        System.out.println("花费金钱：" + Float.toString(minusAmount));
        money.MinusMoney(minusAmount);
       
    }

    public void EarnMoney(float addAmount) {
        System.out.println("获得金钱：" + Float.toString(addAmount));
        money.AddMoney(addAmount);
    }

    public void UpdateView()// 更新金钱值UI，表现为控制台输出
    {
        if (money == null)
            return;
        System.out.println("当前金钱数量为：" + Float.toString(money.Getmoney()));
    }

    public void CheckDebt()//每天更新
    {
        System.out.println( Player.playername+"今天总共获得金钱" + Float.toString(money.GetEarnMoneyThisDay()));
        System.out.println( Player.playername+"今天花费金钱" + Float.toString(money.GetSpendMoneyThisDay()));
        money.StartNewDay();
        UpdateView();
        if(money.Getmoney()<0)
        {
            money.AddDebtTime();
        }
        else
        {
            money.SetDebtTime(0);
        }
        int debttime=money.GetDebtTime();
        if(debttime>=0)//
        {
            System.out.println( Player.playername+"当前欠债天数为：" + Float.toString(debttime));
            if(debttime>7)
            {
                System.out.println("你欠款太多，买不起饭了，只能重回996生活赚钱还款，游戏结束");
                GameMgr.GetInstance().StopGame();
            }
            else
            {
                System.out.println("请注意最多欠债天数为：" + Float.toString(debtTimeRestrcit));
            }
        }

    }
}
