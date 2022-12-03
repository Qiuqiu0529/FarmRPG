public class PlayerVisual implements IVisual{

    public void PlayAnim(String anim)
    {
        System.out.println("播放玩家动画"+anim );
    }

    public void PlayWalkAnim()
    {
        PlayAnim("行走");
    }

    public void PlaySleepAnim()
    {
        PlayAnim("睡眠");
        
    }

}
