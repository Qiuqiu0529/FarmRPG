package Item.Buff;

import Actor.Health;

public class HealthBuff extends Buff{
    int addhealth=10;
    Health health;
    public HealthBuff(int contitime) {
        super(contitime);
    }
    public HealthBuff(int contitime,int addAmount)
    {
        super(contitime);
        addhealth=addAmount;
    }

    public void SetHealth(Health health)
    {
        this.health=health;
    }

    public void AddBuff() throws InterruptedException
    {
        super.AddBuff();
        health.AddHealth(addhealth);
    }
    
}
