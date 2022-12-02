public class MoneyPresenter {//singleton、MVP、callback
    Money money = new Money();

    private static volatile MoneyPresenter instance;

    private MoneyPresenter() {
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        }
        else
        {
            money.SetOnChange(moneyChanged);
        }
    }

    public static MoneyPresenter getInstance() {
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
        public void call() {
            instance.UpdateView();
        }
    };

    public void SpendMoney(int minusAmount) {
        money.MinusMoney(minusAmount);
    }

    public void EarnMoney(int addAmount) {
        money.AddMoney(addAmount);

    }

    public  void UpdateView()// 更新金钱值UI，表现为控制台输出
    {
        if (money == null)
            return;
        System.out.println("玩家当前的金钱数量为：" + Integer.toString(money.Getmoney()));
    }
}
