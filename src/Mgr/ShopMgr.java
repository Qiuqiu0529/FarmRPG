package Mgr;

import java.util.EnumMap;
import java.util.Map;

import Shop.FarmShop;
import Shop.PotionShop;
import Shop.ShopBase;
import Shop.ShopType;

public class ShopMgr {
    private final Map<ShopType, ShopBase> shops;
    private static volatile ShopMgr instance;

    private ShopMgr() {
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        } else {
            instance = this;
            shops = new EnumMap<>(ShopType.class);
        }
    }

    public static ShopMgr GetInstance() {
        var result = instance;
        if (result == null) {
            synchronized (ShopMgr.class) {
                result = instance;
                if (result == null) {
                    instance = result = new ShopMgr();
                }
            }
        }
        return result;
    }

    public ShopBase GetInstance(ShopType type)// 店的instance
    {
        var shop = shops.get(type);
        if (shop == null) {
            shop = CreateShop(type);
        }
        return shop;
    }

    ShopBase CreateShop(ShopType type) {// 待改
        var shop = shops.get(type);
        if (shop == null) {
            switch (type) {
                case POTION:
                    shop = new PotionShop();
                case SEED:
                    shop = new FarmShop();
                default:
                    break;
            }
            if (shop != null) {
                shops.put(type, shop);
            }
        }
        return shop;
    }

}
