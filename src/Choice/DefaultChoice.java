package Choice;

public class DefaultChoice implements IChoice{
    String description;
    String chooseDescription;

    public boolean CanChoose()
    {
       return true;
    }
    public DefaultChoice(String description,String chooseDescription)
    {
        this.description=description;
        this.chooseDescription=chooseDescription;

    }
    public void ChoiceInfo()
    {
        System.out.println(description);
    }
    public void Choose() throws InterruptedException
    {
        System.out.println(chooseDescription);
    }
}
