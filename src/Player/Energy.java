package Player;

import Other.Mathf;
import Other.Callback;

public class Energy {
    float minEnergy=0;//等于0直接进入下一天
    float maxEnergy=30;
    float currentEnergy=30;//
    
    private Callback callback;

    public void SetOnChange(Callback back) {
        callback = back;
    }

    public float GetCurrentEnergy()
    {
        return currentEnergy;
    }
    public float GetMaxEnergy()
    {
        return maxEnergy;
    }
    
    public void AddEnergy(float addAmount)
    {
        currentEnergy+=addAmount;
        currentEnergy = Mathf.Clamp(currentEnergy , minEnergy, maxEnergy);
        UpdateEnergy();
    }

    public void MinusEnergy(float minusAmount)
    {
        currentEnergy-=minusAmount;
        currentEnergy = Mathf.Clamp(currentEnergy , minEnergy, maxEnergy);
        UpdateEnergy();
    }

    public void UpdateEnergy()
    {
       callback.Call();
    }

    public void Restore()
    {
        currentEnergy=maxEnergy;
        UpdateEnergy();
    }

    public void BadRestore()
    {
        currentEnergy=maxEnergy/2;
        UpdateEnergy();
    }

}
