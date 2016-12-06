package ninja.brunner.pgtl.program3;

import java.util.Random;

public class Schnecke {
    public static final int minSpeed = 0;
    public static final int maxSpeed = 5;

    public Rennstrecke rennstrecke;
    public String name;
    public int position;

    public Schnecke(Rennstrecke rennstrecke, String name)
    {
        this.rennstrecke = rennstrecke;
        this.name = name;

        position = 0;
    }

    public void kriechen()
    {
        if(position < rennstrecke.length) {
            position += rennstrecke.rennen.random.nextInt(maxSpeed - minSpeed) + minSpeed;

            if(position > rennstrecke.length)
                position = rennstrecke.length;
        }
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append(name);
        for(int i = name.length(); i < rennstrecke.maxNameLength; i++)
            sb.append(' ');
        sb.append(": ");
        for(int i = 1; i < position; i++)
            sb.append('.');
        sb.append('M');
        for(int i = position + 1; i < rennstrecke.length; i++)
            sb.append(' ');
        sb.append('#');

        return sb.toString();
    }
}
