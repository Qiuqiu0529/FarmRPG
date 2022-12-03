package Monster;

public interface IMonster {
    public void MoveUpdate();//怪物可以移动
    public void Attack();//怪物可以攻击
    public void Hit(float amount);//怪物可以被攻击
    public void Death();//怪物可以死亡
}
