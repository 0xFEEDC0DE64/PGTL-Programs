package ninja.brunner.pgtl.program3;

import java.util.ArrayList;

public class RennSimulator {
    private Wettbüro wettbüro;

    private ArrayList<Rennstrecke> rennstrecken;
    private ArrayList<Schnecke> schnecken;
    private ArrayList<Rennen> rennen;

    private boolean changesAllowed;

    public Wettbüro getWettbüro() {
        return wettbüro;
    }

    public RennSimulator()
    {
        wettbüro = new Wettbüro();

        rennstrecken = new ArrayList<Rennstrecke>();
        schnecken = new ArrayList<Schnecke>();
        rennen = new ArrayList<Rennen>();

        changesAllowed = true;
    }

    public Rennstrecke registriereRennstrecke(String name, int length) throws Exception {
        if(!changesAllowed)
            throw new Exception("Änderungen nicht mehr erlaubt!");

        for(Rennstrecke rennstrecke : rennstrecken)
            if(rennstrecke.name == name)
                throw new Exception("Name bereits vergeben!");

        Rennstrecke rennstrecke = new Rennstrecke(name, length);
        rennstrecken.add(rennstrecke);
        return rennstrecke;
    }

    public Schnecke registriereSchnecke(String name) throws Exception {
        if(!changesAllowed)
            throw new Exception("Änderungen nicht mehr erlaubt!");

        for(Schnecke schnecke : schnecken)
            if(schnecke.name == name)
                throw new Exception("Name bereits vergeben!");

        Schnecke schnecke = new Schnecke(name);
        schnecken.add(schnecke);
        return schnecke;
    }

    public Rennen registriereRennen(String name, Rennstrecke rennstrecke, Schnecke schnecken[]) throws Exception {
        if(!changesAllowed)
            throw new Exception("Änderungen nicht mehr erlaubt!");

        for(Rennen _rennen : rennen)
            if(_rennen.name == name)
                throw new Exception("Name bereits vergeben!");

        Rennen _rennen = new Rennen(name, rennstrecke, schnecken);
        rennen.add(_rennen);
        return _rennen;
    }

    public RennErgebnis simuliere(Rennen rennen) {
        try {
            rennen.begin();

            while(rennen.schritt());

            rennen.cleanup();
        }
        catch (Exception ex) {
            System.out.println("Unbehandelte Ausnahme in Rennen: " + ex.toString());
            return null;
        }

        //TODO

        return null;
    }

    public void start() throws Exception {
        if(!changesAllowed)
            throw new Exception("Simulation bereits gestartet!");

        changesAllowed = false;

        for(Rennen _rennen : rennen)
        {
            RennErgebnis rennErgebnis = simuliere(_rennen);

            //TODO: notify wettBüro
        }

        rennen.clear();

        changesAllowed = true;
    }
}
