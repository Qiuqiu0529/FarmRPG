package Item.Potion;

import java.util.EnumMap;
import java.util.Map;

public class PotionFactory {//Flyweight
    
    private final Map<PotionType, IPotion> potions;

    IPotion createPotion(PotionType type) {//待改
        var potion = potions.get(type);
        if (potion == null) {
            switch (type) {
                case HEALING:
                    potion = new HealingPotion(1,10);
                    break;
                case ENERGY:
                    potion = new EnergyPotion(1,5);
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

    public IPotion GetInstance(PotionType type)//药水的instance
    {
        var potion = potions.get(type);
        if (potion == null)
        {
            potion=createPotion(type);
        }
        return potion;
    }


    private static volatile PotionFactory instance;

    public PotionFactory() {
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        } else {
            instance=this;
            potions = new EnumMap<>(PotionType.class);
        }
    }

    public static PotionFactory GetInstance() {
        var result = instance;
        if (result == null) {
            synchronized (PotionFactory.class) {
                result = instance;
                if (result == null) {
                    instance = result = new PotionFactory();
                }
            }
        }
        return result;
    }

}
