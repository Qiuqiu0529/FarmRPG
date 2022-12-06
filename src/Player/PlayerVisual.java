package Player;
import java.util.HashMap;

import Actor.IVisual;
public class PlayerVisual implements IVisual{
    HairStyleType hairStyle;
    ColorType eyesColor;
    ColorType hairColor;
    ConstellationType constellation;//假装星座影响外表，例如衣服有个星座图案？

    public PlayerVisual()
    {
        hairStyle=HairStyleType.LongHair;
        hairColor=ColorType.Black;
        eyesColor=ColorType.Black;
        constellation=ConstellationType.Libra;
    }

    public static class PlayerVisualBuilder {
        HairStyleType hairStyle;
        ColorType eyesColor;
        ColorType hairColor;
        ConstellationType constellation;
    
        public PlayerVisualBuilder() {
        }
    
        public PlayerVisualBuilder withHairType(HairStyleType hairType) {
            this.hairStyle = hairType;
            return this;
        }
    
        public PlayerVisualBuilder withHairColor(ColorType hairColor) {
            this.hairColor = hairColor;
            return this;
        }
    
        public PlayerVisualBuilder withEyesColor(ColorType eyeColor) {
            this.eyesColor = eyeColor;
            return this;
        }
    
        public PlayerVisualBuilder withConstellation(ConstellationType constellation) {
            this.constellation=constellation;
            return this;
        }

        public PlayerVisual build() {
            return new PlayerVisual(this);
        }
    }
    
    public PlayerVisual(PlayerVisualBuilder builder) {
       this.hairStyle=builder.hairStyle;
       this.eyesColor=builder.eyesColor;
       this.hairColor=builder.hairColor;
       this.constellation=builder.constellation;
      }

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


