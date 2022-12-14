package Actor;

public interface IHealth {
    public float GetCurrentHealth() ;
    public float AddHealth(float addAmount);
    public float MinusHealth(float minusAmount);
}
