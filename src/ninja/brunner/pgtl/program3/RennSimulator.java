package ninja.brunner.pgtl.program3;

import ninja.brunner.pgtl.program3.exceptions.NameBereitsVergebenException;

import java.util.ArrayList;

public class RennSimulator {
    private ArrayList<Rennstrecke> rennstrecken;
    private ArrayList<Schnecke> schnecken;
    private ArrayList<Rennen> rennen;
    private boolean changesAllowed;

    public RennSimulator()
    {
        rennstrecken = new ArrayList<Rennstrecke>();
        schnecken = new ArrayList<Schnecke>();
        rennen = new ArrayList<Rennen>();

        changesAllowed = true;
    }

    public Rennstrecke registriereRennstrecke(String name, int length) throws NameBereitsVergebenException {
        for(Rennstrecke rennstrecke : rennstrecken)
            if(rennstrecke.name == name)
                throw new NameBereitsVergebenException();

        Rennstrecke rennstrecke = new Rennstrecke(name, length);
        rennstrecken.add(rennstrecke);
        return rennstrecke;
    }

    public Schnecke registriereSchnecke(String name) throws NameBereitsVergebenException {
        for(Schnecke schnecke : schnecken)
            if(schnecke.name == name)
                throw new NameBereitsVergebenException();

        Schnecke schnecke = new Schnecke(name);
        schnecken.add(schnecke);
        return schnecke;
    }

    public Rennen registriereRennen(String name, Rennstrecke rennstrecke, Schnecke schnecken[]) throws NameBereitsVergebenException {
        for(Rennen _rennen : rennen)
            if(_rennen.name == name)
                throw new NameBereitsVergebenException();

        Rennen _rennen = new Rennen(name, rennstrecke, schnecken);
        rennen.add(_rennen);
        return _rennen;
    }

    public RennErgebnis simuliere(Rennen rennen) {
        try {
            rennen.begin();

            //TODO

            rennen.cleanup();
        }
        catch (Exception ex) {
            System.out.println("Unbehandelte Ausnahme in Rennen: " + ex.toString());
            return null;
        }

        //TODO

        return null;
    }

    public void start() {
    }
}
