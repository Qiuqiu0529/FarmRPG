package Mgr;
public class SoundMgr {//Singleton
    private static volatile  SoundMgr instance;
    private SoundMgr() {
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        }
    }

    public static SoundMgr GetInstance() {
        var result = instance;
        if (result == null) {
            synchronized (SoundMgr.class) {
                result = instance;
                if (result == null) {
                    instance = result = new SoundMgr();
                }
            }
        }
        return result;
    }

    //#region Forest


    public void PlayForestBGM()
    {
        System.out.println("播放静谧的森林背景乐，小鸟啁啾，叶子摇摇" );
    }

    public void PlayForestWalkingSound()
    {
        System.out.println("播放在森林行走的声音，沙沙" );
    }

    public void PlayRestSound()
    {
        System.out.println("播放在休息时哼歌的声音，哼哼哼~" );
    }

    public void PlayBattleBGM()
    {
        System.out.println("播放激烈的战斗背景乐，哒哒哒锵锵锵" );
    }

    public void PlayMonsterDiedSound()
    {
        System.out.println("播放怪物倒下的声音，沉重的砰" );
    }
    public void PlaMonsterAttackSound()
    {
        System.out.println("播放怪物进攻的声音，嗷嗷" );
    }

    public void PlayPlayerDamageSound()
    {
        System.out.println("播放玩家受伤的声音，好痛" );
    }

    public void PlayGunSound()
    {
        System.out.println("播放子弹发出的声音，咻咻" );
    }

    public void PlaySwordSound()
    {
        System.out.println("播放挥刀发出的声音，唰、锵" );
    }

    public void PlayDrinkSound()
    {
        System.out.println("播放喝药水的声音，咕咚咕咚" );
    }

    public void PlayMonsterDamageSound()
    {
        System.out.println("播放怪物受伤的声音，嗷呜" );
    }

    public void PlayVictorySound()
    {
        System.out.println("播放玩家胜利的声音，啦啦啦" );
    }

    public void PlayFailureSound()
    {
        System.out.println("播放玩家倒下的声音，啊" );
    }

    //#endregion


    public void PlayPlantBGM()
    {
        System.out.println("播放轻松的种田背景乐，啦啦啦哒哒哒" );
    }

    public void PlayNormalBGM()
    {
        System.out.println("播放日常背景乐，噔铛噔，噔铛噔" );
    }


    public void PlayCoinSound()
    {
        System.out.println("播放硬币撞击声，清脆的叮叮叮" );
    }

  
  

   

   

}
