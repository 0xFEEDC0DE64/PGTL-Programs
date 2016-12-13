package ninja.brunner.pgtl.program3;

public class Wette {
    public Person person;
    public Rennen rennen;
    public Schnecke schnecke;
    public float einsatz;

    public Wette(Person person, Rennen rennen, Schnecke schnecke, float einsatz) {
        this.person = person;
        this.rennen = rennen;
        this.schnecke = schnecke;
        this.einsatz = einsatz;
    }
}
