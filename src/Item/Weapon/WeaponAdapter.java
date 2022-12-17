package Item.Weapon;

import Item.InventoryItem;
import Player.PlayerBattle;

public class WeaponAdapter extends InventoryItem {
  WeaponBase weapon;

  public boolean Equip() throws InterruptedException {
    if (weapon != null) {
      PlayerBattle.GetInstance().SetWeapon(weapon);
      return true;
    }
    return false;
  }

  public void SetWeapon(WeaponBase wea) {
    this.weapon = wea;
  }

}
