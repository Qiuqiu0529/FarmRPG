package NPC;
import java.util.List;

import Choice.IChoice;

public abstract class Resident implements NPC {
    int favors = 0;
    String name = "";
    FavorStatus favorStatus=FavorStatus.general;
    List<IChoice> choices;

    public enum FavorStatus {
        general, frendly, hospitality, love  //0-30, 30-60, 60-90, 90--
    };

    public void ChangeFavor(int amount) {
        if (favors + amount < 0) {
            favors = 0;
        } else if (favors + amount > 100) {
            favors = 100;
        }
        else{
            favors += amount;
        }
        ChangeStatus();
    }

    public void ChangeStatus() {
        if (favors < 30) {
            favorStatus = FavorStatus.general;
        } else if (favors < 60) {
            favorStatus = FavorStatus.frendly;
        } else if (favors < 90) {
            favorStatus = FavorStatus.hospitality;
        } else {
            favorStatus = FavorStatus.love;
        }
    }
    
    public int GetFavor() {
        return favors;
    }

    public String GetState() {
        return favorStatus.name();
    }

    public IChoice GetChoice(int num) {
        return choices.get(num);
    }
    
    public String GetName() {
        return name;
    }
}
