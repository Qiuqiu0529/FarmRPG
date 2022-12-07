package NPC;

import Choice.IChoice;

public interface NPC {
    public void ChangeFavor(int amount);//state is changed or not

    public int GetFavor();

    public String GetState();

    public IChoice GetChoice(int num);

    public String GetName();
}
