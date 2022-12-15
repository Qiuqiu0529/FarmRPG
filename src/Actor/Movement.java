package Actor;

public abstract class Movement implements IMovement{
    protected int posX=0;
    protected int posY=0;

    static int maxposX=10;
    static int minposX=0;

    static int maxposY=10;
    static int minposY=0;

    public static int GetMaxPosX()
    {
        return maxposX;
    }
    public static int GetMaxPosY()
    {
        return maxposY;
    }

    public static void SetMinPosX(int min)
    {
        minposX=min;
    }
    public static void SetMinPosY(int min)
    {
        minposY=min;
    }
    public static void SetMaxPosX(int max)
    {
        maxposX=max;
    }
    public static void SetMaxPosY(int max)
    {
        maxposY=max;
    }


    protected static boolean InBoundry(int x,int y)
    {
        if(0<=x&&x<maxposX&&0<=y&&y<maxposY)
        {
            return true;
        }
        return false;
    }
    
    public boolean CanMove(int x,int y)
    {
        return InBoundry(x+posX,y+posY);
    }

    public void MoveUpdate(int changex,int changey)
    {
        posX+=changex;
        posY+=changey;
    }

    protected abstract void InitPos();
}
