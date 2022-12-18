package Player;

import Other.Callback;

public class EnergyController {
    Energy energy;
    private static volatile EnergyController instance;
    EnergyView energyView;

    private EnergyController() {
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        } else {
            energy = new Energy();
            energyView=new EnergyView();
            energy.SetOnChange(energyChanged);
            instance=this;
        }
    }

    public static EnergyController GetInstance() {
        var result = instance;
        if (result == null) {
            synchronized (EnergyController.class) {
                result = instance;
                if (result == null) {
                    instance = result = new EnergyController();
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
        System.out.println("消耗精力：" + Float.toString(minusAmount));
        energy.MinusEnergy(minusAmount);

    }

    public void EarnEnergy(float addAmount) {
        System.out.println("增加精力：" + Float.toString(addAmount));
        energy.AddEnergy(addAmount);
    }

    public void UpdateView()// 更新精力值UI，表现为控制台输出
    {
        if (energy == null)
            return;
        energyView.DisPlayEnergy(energy);
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
