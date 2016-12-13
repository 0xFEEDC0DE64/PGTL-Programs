package ninja.brunner.pgtl.program3;

import ninja.brunner.pgtl.program3.exceptions.StreckeNichtFreiException;
import ninja.brunner.pgtl.program3.exceptions.SchneckeNichtFreiException;
import ninja.brunner.pgtl.program3.exceptions.RennenNichtAktivException;

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

    public void begin() throws StreckeNichtFreiException, SchneckeNichtFreiException {
        if(rennStrecke.currentRennen != null)
            throw new StreckeNichtFreiException();

        for(Schnecke schnecke : schnecken)
            if(schnecke.currentRennen != null)
                throw new SchneckeNichtFreiException();

        currentlyRenning = true;
        rennStrecke.currentRennen = this;
        for(Schnecke schnecke : schnecken)
            schnecke.currentRennen = this;
    }

    public void cleanup() throws RennenNichtAktivException
    {
        if(!currentlyRenning)
            throw new RennenNichtAktivException();

        currentlyRenning = false;
        rennStrecke.currentRennen = null;
        for(Schnecke schnecke : schnecken)
            schnecke.currentRennen = null;
    }
}
