package Item.Buff;

import Actor.Defence;

public class DefenceBuff extends Buff{//防御力持续一段时间增加
    int adddefence=3;
    boolean first=true;
    Defence defence;
    public DefenceBuff(int contitime) {
        super(contitime);
    }
    public DefenceBuff(int contitime,int addAmount)
    {
        super(contitime);
        adddefence=addAmount;
    }


    public void AddBuff() throws InterruptedException
    {
        super.AddBuff();
        if(first)
        {
            defence.ChangeBuffDefence(adddefence);
            first=false;
        }
        if(continueTime<=0)
        {
            CancleBuff();
        }
    }

    public void CancleBuff() throws InterruptedException{
        defence.ChangeBuffDefence(-adddefence);
    }
    
}