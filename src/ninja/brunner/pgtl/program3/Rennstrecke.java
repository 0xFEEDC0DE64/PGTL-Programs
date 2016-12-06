package ninja.brunner.pgtl.program3;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.ConsoleHandler;

public class Rennstrecke {
    public Rennen rennen;
    public int length;
    public ArrayList<Schnecke> schnecken;
    public int maxNameLength;

    private String[] names = {
            "Namgung",
            "Hwangbo",
            "Jegal",
            "Sagong",
            "Seonu",
            "Seomun",
            "Dokgo",
            "Dongbang"
    };

    public Rennstrecke(Rennen rennen, int length, int schneckenCount)
    {
        this.rennen = rennen;
        this.length = length;

        schnecken = new ArrayList<Schnecke>();
        for(int i = 0; i < schneckenCount; i++)
            schnecken.add(new Schnecke(this, names[rennen.random.nextInt(names.length)]));

        maxNameLength = 0;

        for(Schnecke schnecke : schnecken) {
            if(schnecke.name.length() > maxNameLength)
                maxNameLength = schnecke.name.length();
        }
    }

    public void kriechen() {
        for(Schnecke schnecke : schnecken)
            schnecke.kriechen();
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        for(Schnecke schnecke : schnecken) {
            sb.append(schnecke.toString());
            sb.append('\n');
        }

        return sb.toString();
    }
}
