package Monster;

public interface IMonster {
    public void MoveUpdate();//怪物可以移动
    public void Action();//怪物可以选择行为，攻击 or 防御
    public void Hit(float amount);//怪物可以被攻击
    public void Death();//怪物可以死亡
}
