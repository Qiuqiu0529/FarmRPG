public class Defence {
    float baseDefence=0;
    float buffDefence=0;
    float currentDefence=0;

    public void ChangeBuffDefence(float change)
    {
        buffDefence+=change;
        currentDefence=baseDefence+buffDefence;
    }

    public float GetCurrentDefence()
    {
        return currentDefence;
    }

    public float DefenceAttack(float attackAmount)
    {
        attackAmount-=currentDefence;
        if(attackAmount<0)
        {
            attackAmount=0;
        }
        return attackAmount;
    }

}
