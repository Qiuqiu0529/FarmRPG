package Item.Weapon;

public class WeaponAttackData {
    public int minAttackAmount=1;
    public int maxAttackAmount=10;
    public int minthread=1;
    public int maxthread=12;
    public int attackCountEachTurn=1;


    WeaponAttackData(int minAttackAmount,int maxAttackAmount,
    int minthread,int maxthread,
    int attackCountEachTurn)
    {
        this.maxAttackAmount=maxAttackAmount;
        this.maxthread=maxthread;
        this.minAttackAmount=minAttackAmount;
        this.minthread=minthread;
        this.attackCountEachTurn=attackCountEachTurn;
    }
}
