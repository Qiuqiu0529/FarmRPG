package Actor;
import Other.Mathf;

public class Health implements IHealth{//战斗用数值，每天刷新一次
    
    protected float minHealth = 0;
    protected float maxHealth=100 ;
    protected float currentHealth=100;
    public Health()
    {

    }

    public Health(float max)
    {
        maxHealth=max;
        currentHealth=maxHealth;
    }
   
    public float GetCurrentHealth() {
        return currentHealth;
    }

    public float AddHealth(float addAmount) {
        float temp = currentHealth;
        currentHealth += addAmount;
        currentHealth = Mathf.Clamp(currentHealth, minHealth, currentHealth);
        UpdateHealth();

        return currentHealth-temp;
    }

    public float MinusHealth(float minusAmount) {
        float temp = currentHealth;
        currentHealth -= minusAmount;
        currentHealth = Mathf.Clamp(currentHealth, minHealth, currentHealth);
        UpdateHealth();
        if(currentHealth<=0)
        {
            Die();
        }
        return temp-currentHealth;
    }


    public void Restore() {
        currentHealth=maxHealth;
        UpdateHealth();
    }

    public void UpdateHealth() {
    }

    public void Die()
    {
    }
}
