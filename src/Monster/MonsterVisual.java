package Monster;
import Actor.IVisual;

public class MonsterVisual implements IVisual{
    public String monstername;
    public void PlayAnim(String anim)
    {
        System.out.println("播放" +monstername+"动画："+anim );
    }

    public void PlayAttackAnim()
    {
        PlayAnim("进攻");
    }

    public void PlayDefenceAnim()
    {
        PlayAnim("防御");
    }
}
