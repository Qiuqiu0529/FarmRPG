package Mgr;

import java.util.List;

import Monster.IMonster;

public class ForestMgr {
    public static List<IMonster> allmonsters;// 当前森林里所有的怪物
    public static List<IMonster> battlemonsters;// 一次战斗的所有怪物
    private static volatile ForestMgr instance;

    public static int monsterCountRestrict=3;//一次战斗最多一个敌人

    private ForestMgr() {
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        }

    }

    public static ForestMgr GetInstance() {
        var result = instance;
        if (result == null) {
            synchronized (ForestMgr.class) {
                result = instance;
                if (result == null) {
                    instance = result = new ForestMgr();
                }
            }
        }
        return result;
    }

    public void GetTotalMonsterCount() {

    }

    public void UpdatePos()
    {
        for (IMonster monster : allmonsters) {
            monster.MoveUpdate();
        }
    }

    public void KillMoster(IMonster monster)
    {
        allmonsters.remove(monster);
        battlemonsters.remove(monster);
        if(battlemonsters.size()==0)
        {

        }
    }

    public void Victory()
    {
        SoundMgr.GetInstance().PlayVictorySound();
    }

    public void Escape()
    {
        battlemonsters.clear();

    }
}
