public class Money {//MVP、callback
    private float moneyAmount=0;
    private Callback callback;

    public void SetOnChange(Callback back) {
        callback = back;
    }

    public float Getmoney()
    {
        return moneyAmount;
    }
    
    public void AddMoney(float addAmount)
    {
        moneyAmount+=addAmount;
        UpdateMoney();
    }

    public void MinusMoney(float minusAmount)
    {
        moneyAmount-=minusAmount;
        UpdateMoney();
    }

    public void MultiplyMoney(float multiAmount)
    {
        moneyAmount*=multiAmount;
        UpdateMoney();
    }
   
    public void UpdateMoney()
    {
       callback.call();
    }
}

