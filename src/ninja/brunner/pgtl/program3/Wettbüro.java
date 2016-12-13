package ninja.brunner.pgtl.program3;

import java.util.ArrayList;
import ninja.brunner.pgtl.program3.exceptions.ZuWenigGeldException;

public class Wettbüro {
    public ArrayList<Person> personen;
    public ArrayList<Wette> wetten;

    public Wettbüro() {
        personen = new ArrayList<Person>();
        wetten = new ArrayList<Wette>();
    }

    public Wette wetteAbschließen(Person person, Rennen rennen, Schnecke schnecke, float einsatz) throws ZuWenigGeldException {


        if(person.guthaben < einsatz)
            throw new ZuWenigGeldException();

        person.guthaben -= einsatz;

        return new Wette(person, rennen, schnecke, einsatz);
    }

    public Person registrierePerson(String name, float guthaben) {
        Person person = new Person(name, guthaben);
        personen.add(person);
        return person;
    }
}
