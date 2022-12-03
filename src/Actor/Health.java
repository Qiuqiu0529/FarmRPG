package Actor;
import Other.Mathf;

public class Health {//战斗用数值，每天刷新一次
    
    protected float minHealth = 0;
    protected float maxHealth=100 ;
    protected float currentHealth=100;

    public Health(float max)
    {
        maxHealth=max;
        currentHealth=maxHealth;
    }
   
    public float GetCurrentHealth() {
        return currentHealth;
    }

    public void AddHealth(float addAmount) {
        currentHealth += addAmount;
        currentHealth = Mathf.Clamp(currentHealth, minHealth, currentHealth);
        UpdateHealth();
    }

    public void MinusHealth(float minusAmount) {
        currentHealth -= minusAmount;
        currentHealth = Mathf.Clamp(currentHealth, minHealth, currentHealth);
        if(currentHealth<minHealth)
        {
            Death();
        }
        else
        {
            UpdateHealth();
        }
    }

    public void MultiplyHealth(float multiAmount) {
        currentHealth *= multiAmount;
        currentHealth = Mathf.Clamp(currentHealth, minHealth, currentHealth);
        UpdateHealth();
    }

    public void Restore() {
        currentHealth=maxHealth;
        UpdateHealth();
    }

    public void UpdateHealth() {
    }
    public void Death()
    {
    }
}
