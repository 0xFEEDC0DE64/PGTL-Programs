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

    public void begin(Rennen rennen) throws Exception {
        if(currentRennen != null)
            throw new Exception("Bereits in einem Rennen!");

        System.out.println("Bereite Rennstrecke \"" + name + "\" vor auf Rennen \"" + rennen.name + "\"");

        currentRennen = rennen;
    }

    public void cleanup() throws Exception {
        if(currentRennen == null)
            throw new Exception("In keinem Rennen in Verwendung!");

        System.out.println("Räume Rennstrecke \"" + name + "\" auf");

        currentRennen = null;
    }
}
