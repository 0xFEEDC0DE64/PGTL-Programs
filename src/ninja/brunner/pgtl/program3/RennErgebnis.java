package ninja.brunner.pgtl.program3;

public class RennErgebnis {
    Rennen rennen;
    Schnecke gewinner[];

    public RennErgebnis(Rennen rennen, Schnecke[] gewinner) {
        this.rennen = rennen;
        this.gewinner = gewinner;
    }
}
