package Player;
import Actor.IVisual;
public class PlayerVisual implements IVisual{

    public void PlayAnim(String anim)
    {
        System.out.println("播放玩家动画："+anim );
    }

    public void PlayIdleAnim()
    {
        PlayAnim("站立");
    }

    public void PlayMoveAnim()
    {
        PlayAnim("移动");
    }

    public void PlaySleepAnim()
    {
        PlayAnim("睡眠");
    }

    public void PlayMoveUpAnim()
    {
        PlayAnim("向上行走");
    }
    public void PlayMoveDownAnim()
    {
        PlayAnim("向下行走");
    }
    public void PlayMoveLeftAnim()
    {
        PlayAnim("向左行走");
    }
    public void PlayMoveRightAnim()
    {
        PlayAnim("向右行走");
    }
    public void PlayRestAnim()
    {
        PlayAnim("休息");
    }

}
