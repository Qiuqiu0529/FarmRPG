package Farm;

public class Vegetable extends Plant {
    @Override
    public void grow(){
        System.out.println("蔬菜正在生长...\n");
        age++;
    }

    public Vegetable(VegetableSeed vegetableSeed){
        type="Vegetable";
        mature= vegetableSeed.mature;
    }
}
