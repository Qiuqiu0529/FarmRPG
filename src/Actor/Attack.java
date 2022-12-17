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

    public void ChangeBase(float change)
    {
        baseAttack+=change;
    }

    public int GetEachAttackCount()
    {
        return 1;
    }
    
    public Attack(float baseatt)
    {
        baseAttack=baseatt;
        currentAttack=baseatt;
    }
    
    public float GiveAttack()
    {
        return currentAttack;
    }
}
