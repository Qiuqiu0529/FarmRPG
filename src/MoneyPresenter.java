public class MoneyPresenter {//singleton、MVP、callback
    Money money;
    int debtTimeRestrcit=7;

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
        money.MinusMoney(minusAmount);
        System.out.println("花费金钱：" + Float.toString(minusAmount));
    }

    public void EarnMoney(float addAmount) {
        money.AddMoney(addAmount);
        System.out.println("获得金钱：" + Float.toString(addAmount));
    }

    public void UpdateView()// 更新金钱值UI，表现为控制台输出
    {
        if (money == null)
            return;
        System.out.println("玩家当前的金钱数量为：" + Float.toString(money.Getmoney()));
    }

    public void CheckDebt()//每天更新
    {
        if(money.Getmoney()<0)
        {
            money.AddDebtTime();
        }
        else
        {
            money.SetDebtTime(0);
        }
        int debttime=money.GetDebtTime();
        System.out.println("当前欠债天数为：" + Float.toString(debttime));

        if(debttime>=0)//
        {
            System.out.println("请注意最多欠债天数为：" + Float.toString(debtTimeRestrcit));
            if(debttime>7)
            {
                System.out.println("你欠款太多，买不起饭了，只能重回996生活赚钱还款，游戏结束");
                GameMgr.GetInstance().StopGame();
            }
        }

    }
}
