package Choice.battle;

import java.util.ArrayList;
import java.util.List;

import Battle.BattleAction;
import Choice.ChoiceConsumeEnergy;
import Choice.DefaultChoice;
import Choice.IChoice;
import Item.InventoryMgr;
import Item.ItemTypes;
import Mgr.ChoiceMgr;
import Player.PlayerBattle;

public class BattleBackpack extends ChoiceConsumeEnergy {
    List<IChoice> choices;
    PlayerBattle playerBattle;

    public BattleBackpack(PlayerBattle playerBattle) {
        this.playerBattle = playerBattle;
        choices = new ArrayList<>();
        needEnergy = 0;
        description = "背包（装备/使用物品后直接攻击）";
        choices.add(new DefaultChoice("返回",
                ""));
        choices.add(new DefaultChoice("装备",
                ""));
        choices.add(new DefaultChoice("药水",
                ""));

    }

    public void Choose() throws InterruptedException {
        int ibp = ChoiceMgr.GetInstance().Choose(choices);
        if (ibp == 0) {
            playerBattle.ChooseAction();
        } else if (ibp == 1) {
            List<IChoice> list = InventoryMgr.GetInstance().FindInventory("MainInventory").ChooseInventoryEquip();
            List<IChoice> weaponchoices = new ArrayList<>();
            weaponchoices.add(new DefaultChoice("返回",
                    ""));
            for (int i = 0; i < list.size(); i++) {
                weaponchoices.add(list.get(i));
            }
            int i = ChoiceMgr.GetInstance().Choose(weaponchoices);
            if (i == 0) {
                Choose();
            } else {
                playerBattle.Act(BattleAction.ATTACK);
            }
        } else {

            List<IChoice> list = InventoryMgr.GetInstance().FindInventory("MainInventory")
                    .ChooseInventorySingle(ItemTypes.Potion);
            List<IChoice> potionchoices = new ArrayList<>();
            potionchoices.add(new DefaultChoice("返回",
                    ""));
            for (int i = 0; i < list.size(); i++) {
                potionchoices.add(list.get(i));
            }
            int i = ChoiceMgr.GetInstance().Choose(potionchoices);
            if (i == 0) {
                Choose();
            } else {
                playerBattle.Act(BattleAction.ATTACK);
            }

        }

    }

}