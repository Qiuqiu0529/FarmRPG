package Monster;

import Battle.IBattleMember;

public interface IMonster extends IBattleMember{
    public void MonsterMove() throws InterruptedException;//怪物可以移动
}
