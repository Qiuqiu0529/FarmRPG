package Item.Buff;

import Actor.Defence;

public class DefenceBuff extends Buff{//防御力持续一段时间增加
    boolean first=true;
    Defence defence;
    public DefenceBuff(int contitime) {
        super(contitime);
    }
    public DefenceBuff(int contitime,int addAmount)
    {
        super(contitime);
        amount=addAmount;
    }
    public void SetDefence (Defence defence)
    {
        this.defence=defence;
    }

    public void AddBuff() throws InterruptedException
    {
        if(continueTime<=0)
        {
            CancleBuff();
        }
        if(first)
        {
            super.AddBuff();
            defence.ChangeBuffDefence(amount);
            first=false;
        }
       
    }

    public void CancleBuff() throws InterruptedException{
        defence.ChangeBuffDefence(-amount);
    }
    
}