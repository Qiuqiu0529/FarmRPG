package Actor;

public class Attack implements IAttack{
    float baseAttack=0;//带
    float buffAttack=0;
    float currentAttack=0;

    public void ChangeBuffAttack(float change)
    {
        buffAttack+=change;
        currentAttack=baseAttack+buffAttack;
    }
    
    public Attack(float baseatt)
    {
        baseAttack=baseatt;
        currentAttack=baseatt;
    }

    public float GetCurrentAttack()
    {
        return currentAttack;
    }
    
    public void GiveAttack()
    {
        
    }
}
