package Actor;

public class Movement implements IMovement{
    int posX=0;
    int posY=0;

    static int maxposX=10;
    static int minposX=0;

    static int maxposY=10;
    static int minposY=0;
    
    public boolean CanMove(int x,int y)
    {
        int tempx=x+posX;
        int tempy=y+posY;
        if(0<=tempx&&tempx<maxposX&&0<=tempy&&tempy<maxposY)
        {
            return false;
        }
        return true;
    }

    public void MoveUp(int amount)
    {
        posY+=amount;
    }

    public void MoveDown(int amount)
    {
        posY-=amount;

    }

    public void MoveLeft(int amount)
    {
       posX-=amount;
    }

    public void MoveRight(int amount)
    {
       posX+=amount;
    }

    public void MoveUpdate(int x,int y)
    {
        posX+=x;
        posY+=y;
    }

}
