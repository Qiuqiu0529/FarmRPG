public class Energy {
    float minEnergy=0;//小于0直接进入下一天
    float maxEnergy=30;
    float baseEnergy=30;
    float currentEnergy=30;//
    
    private Callback callback;

    public void SetOnChange(Callback back) {
        callback = back;
    }

    public float GetCurrentEnergy()
    {
        return currentEnergy;
    }
    
    public void AddEnergy(float addAmount)
    {
        currentEnergy+=addAmount;
        UpdateEnergy();
    }

    public void MinusEnergy(float minusAmount)
    {
        currentEnergy-=minusAmount;
        UpdateEnergy();
    }

    public void MultiplyEnergy(float multiAmount)
    {
        currentEnergy*=multiAmount;
        UpdateEnergy();
    }
   
    public void UpdateEnergy()
    {
       callback.call();
    }


}
