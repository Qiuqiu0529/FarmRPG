package Actor;

public interface IDefence {
    public float GetCurrentDefence();
    public float DefenceAttack(float attackAmount);
    public void ChangeBuffDefence(float change);
}
