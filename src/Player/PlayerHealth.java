package Player;
import Actor.Health;
public class PlayerHealth extends Health{
    public PlayerHealth()
    {//默认健康100
    }

    public PlayerHealth(int max) {
        super(max);
    }

    public void UpdateHealth() {
        System.out.println(Player.playername+"当前生命值：" + Float.toString(currentHealth));
    }
    
    public void Die()
    {
        System.out.println(Player.playername+"被击倒");
    }
}
