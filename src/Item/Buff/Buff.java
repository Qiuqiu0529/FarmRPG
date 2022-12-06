package Item.Buff;

public class Buff implements IBuff{
    public int continueTime=3;
    public Buff(int contitime)
    {
        continueTime=contitime;
    }

    public void AddBuff() throws InterruptedException
    {
        continueTime--;
    }
    public void CancleBuff() throws InterruptedException{

    }
}
