package Player;

import Other.Callback;

public class EnergyPresenter {
    Energy energy;
    private static volatile EnergyPresenter instance;

    private EnergyPresenter() {
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        } else {
            energy = new Energy();
            energy.SetOnChange(energyChanged);
        }
    }

    public static EnergyPresenter GetInstance() {
        var result = instance;
        if (result == null) {
            synchronized (EnergyPresenter.class) {
                result = instance;
                if (result == null) {
                    instance = result = new EnergyPresenter();
                }
            }
        }
        return result;
    }

    private static Callback energyChanged = new Callback() {
        @Override
        public void Call() {
            instance.UpdateView();
        }
    };

    public void SpendEnergy(float minusAmount) {
        System.out.println("消耗体力：" + Float.toString(minusAmount));
        energy.MinusEnergy(minusAmount);

    }

    public void EarnEnergy(float addAmount) {
        System.out.println("增加体力：" + Float.toString(addAmount));
        energy.AddEnergy(addAmount);
    }

    public void UpdateView()// 更新体力值UI，表现为控制台输出
    {
        if (energy == null)
            return;
        System.out.println(
            Player.playername+"当前体力值为： " + Float.toString(energy.GetCurrentEnergy()) + " / " + Float.toString(energy.GetMaxEnergy()));
    }

    public boolean HasEnoughEnergy(float demand) {
        if (energy.GetCurrentEnergy() >= demand) {
            return true;
        }
        return false;
    }

    public void Reset()
    {
        energy.Restore();
    }

    public void BadReset()
    {
        energy.BadRestore();
    }
}
