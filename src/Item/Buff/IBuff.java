package Item.Buff;
public interface IBuff {
    public void AddBuff() throws InterruptedException;//buff执行
    public void CancleBuff() throws InterruptedException;//一些buff有时限，取消buff效果
}
