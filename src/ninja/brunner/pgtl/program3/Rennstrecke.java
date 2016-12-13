package ninja.brunner.pgtl.program3;

public class Rennstrecke {
    public String name;
    public int length;

    public Rennen currentRennen;

    public Rennstrecke(String name, int length)
    {
        this.name = name;
        this.length = length;

        currentRennen = null;
    }
}
