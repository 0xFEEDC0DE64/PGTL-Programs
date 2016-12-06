package ninja.brunner.pgtl.program3;

import java.util.Random;

public class Rennen {
    public Random random;
    public Rennstrecke rennStrecke;

    public Rennen()
    {
        random = new Random();
        rennStrecke = new Rennstrecke(this, random.nextInt(50) + 25, random.nextInt(10) + 15);
    }

    public void run() throws InterruptedException {
        while(true) {
            rennStrecke.kriechen();

            System.out.println(rennStrecke.toString());

            boolean anySchneckeUnterwegs = false;
            for(Schnecke schnecke : rennStrecke.schnecken)
                if(schnecke.position < rennStrecke.length) {
                    anySchneckeUnterwegs = true;
                    break;
                }

            if(!anySchneckeUnterwegs)
                break;

            Thread.sleep(1000);
        }
    }
}
