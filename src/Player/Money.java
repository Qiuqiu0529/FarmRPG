package Player;
import Other.Callback;
public class Money {//MVP、callback
    private float moneyAmount=0;
    private Callback callback;
    int debtTime=0;//欠债时长、几天
    int debtTimeRestrcit=7;//可以欠债的最多天数
    float spendMoneyThisDay=0;
    float earnMoneyThisDay=0;

    public void SetOnChange(Callback back) {
        callback = back;
    }

    public float GetSpendMoneyThisDay()
    {
        return spendMoneyThisDay;
    }

    public float GetEarnMoneyThisDay()
    {
        return earnMoneyThisDay;
    }

    public void StartNewDay()
    {
        spendMoneyThisDay=0;
        earnMoneyThisDay=0;
    }

    public float Getmoney()
    {
        return moneyAmount;
    }

    public void AddMoney(float addAmount)
    {
        moneyAmount+=addAmount;
        earnMoneyThisDay+=addAmount;
        UpdateMoney();
    }

    public void MinusMoney(float minusAmount)
    {
        moneyAmount-=minusAmount;
        spendMoneyThisDay+=minusAmount;
        UpdateMoney();
    }

    public void SetDebtTime(int amount)
    {
        debtTime=amount;
    }
    public int GetMaxDebtTime()
    {
        return debtTimeRestrcit;
    }

    public void AddDebtTime()
    {
        ++debtTime;
    }

    public int GetDebtTime()
    {
        return debtTime;
    }

    public void UpdateMoney()
    {
       callback.Call();
    }
}

