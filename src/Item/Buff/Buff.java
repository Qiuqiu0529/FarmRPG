package Item.Buff;

public class Buff implements IBuff{
    public int continueTime=3;
    public int amount=3;
    public Buff(int contitime)
    {
        continueTime=contitime;
    }

    public void AddBuff() throws InterruptedException
    {
        continueTime--;
        System.out.println("buff剩余作用回合：" + Float.toString(continueTime));
    }
    
    public void CancleBuff() throws InterruptedException{

    }
}
