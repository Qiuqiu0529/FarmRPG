package Player;

public class EnergyView {
    public void DisPlayEnergy(Energy energy)
    {
        System.out.println(
            Player.playername+"当前精力值为： " + Float.toString(energy.GetCurrentEnergy()) + " / " + Float.toString(energy.GetMaxEnergy()));
    }

}
