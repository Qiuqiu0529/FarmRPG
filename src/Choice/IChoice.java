package Choice;

public interface IChoice {
    public boolean CanChoose();//选项是否能被选择（显示）
    public void ChoiceInfo();//打印选择信息
    public void Choose() throws InterruptedException;//选择产生的结果
}
