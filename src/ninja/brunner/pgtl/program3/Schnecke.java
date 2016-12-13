package ninja.brunner.pgtl.program3;

import java.util.Random;

public class Schnecke {
    public String name;

    public Rennen currentRennen;
    public Integer position;

    public Schnecke(String name)
    {
        this.name = name;

        currentRennen = null;
        position = null;
    }
}
