package ninja.brunner.pgtl.program3;

public class Rennen {
    String name;
    Rennstrecke rennStrecke;
    Schnecke schnecken[];

    boolean currentlyRenning;

    public Rennen(String name, Rennstrecke rennStrecke, Schnecke schnecken[])
    {
        this.name = name;
        this.rennStrecke = rennStrecke;
        this.schnecken = schnecken;

        this.currentlyRenning = false;
    }

    public void begin() throws Exception {
        System.out.println("Begine Rennen \"" + name + "\"");
        if(currentlyRenning)
            throw new Exception("Rennen bereits aktiv!");

        rennStrecke.begin(this);
        for(Schnecke schnecke : schnecken)
            schnecke.begin(this);
        currentlyRenning = true;
    }

    public void cleanup() throws Exception {
        System.out.println("Beende Rennen \"" + name + "\"");
        if(!currentlyRenning)
            throw new Exception("Rennen nicht aktiv!");

        rennStrecke.cleanup();
        for(Schnecke schnecke : schnecken)
            schnecke.cleanup();
        currentlyRenning = false;
    }

    public boolean schritt() throws Exception {
        if(!currentlyRenning)
            throw new Exception("Rennen nicht aktiv!");

        boolean anySchnecke = false;

        for(Schnecke schnecke : schnecken)
            anySchnecke |= schnecke.krabbeln();

        return anySchnecke;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(getClass().getName() + " \"" + name + "\" " + (currentlyRenning ? "aktiv" : "inaktiv"));
        if(currentlyRenning) {
            sb.append(" (Rennstrecke: \"" + rennStrecke.name + "\")\n");
            for(Schnecke schnecke : schnecken) {
                sb.append(schnecke.toString() + '\n');
            }
        }

        return sb.toString();
    }
}
