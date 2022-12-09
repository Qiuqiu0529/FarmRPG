package Item.Potion;

import java.util.EnumMap;
import java.util.Map;

public class PotionFactory {//Flyweight
    private final Map<PotionType, IPotion> potions;

    public PotionFactory() {
        potions = new EnumMap<>(PotionType.class);
    }

    IPotion createPotion(PotionType type) {
        var potion = potions.get(type);
        if (potion == null) {
            switch (type) {
                case HEALING:
                    potion = new HealingPotion();
                    break;
                case ENERGY:
                    potion = new EnergyPotion();
                    break;
                case CRITICALHIT:
                    potion = new CriticalHitPotion();
                    break;
                case STRENGTH:
                    potion = new StrengthPotion();
                    break;
                default:
                    break;
            }
            if (potion != null) {
                potions.put(type, potion);
            }
        }
        return potion;
    }

    public IPotion GetInstance(PotionType type)
    {
        var potion = potions.get(type);
        if (potion == null)
        {
            potion=createPotion(type);
        }
        return potion;
    }
}
