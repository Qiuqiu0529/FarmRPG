package Player;
import Actor.IVisual;
public class PlayerVisual implements IVisual{

    public void PlayAnim(String anim)
    {
        System.out.println("播放" +Player.playername+"动画："+anim );
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
    public void PlayWalkAnim(String dir)
    {
        PlayAnim("向"+dir+"行走");
    }
    
    public void PlayRestAnim()
    {
        PlayAnim("休息");
    }

}
