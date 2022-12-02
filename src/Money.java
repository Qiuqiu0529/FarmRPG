public class Money {//MVP、callback
    int moneyAmount=0;
    Callback callback;

    public void SetOnChange(Callback back) {
        callback = back;
    }

    public int Getmoney()
    {
        return moneyAmount;
    }
    
    public void AddMoney(int addAmount)
    {
        moneyAmount+=addAmount;
        UpdateMoney();
    }

    public void MinusMoney(int minusAmount)
    {
        moneyAmount-=minusAmount;
        UpdateMoney();
    }

    public void MultiplyMoney(int multiAmount)
    {
        moneyAmount*=multiAmount;
        UpdateMoney();
    }
   
    public void UpdateMoney()
    {
       callback.call();
    }
}

