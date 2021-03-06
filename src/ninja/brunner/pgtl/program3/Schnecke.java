package ninja.brunner.pgtl.program3;

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

    public void begin(Rennen rennen) throws Exception {
        if(currentRennen != null)
            throw new Exception("Bereits in einem Rennen!");

        System.out.println("Bereite Schnecke \"" + name + "\" vor auf Rennen \"" + rennen.name + "\"");

        this.currentRennen = rennen;
        this.position = 0;
    }

    public void cleanup() throws Exception {
        if(currentRennen == null)
            throw new Exception("Gerade in keinem Rennen!");

        System.out.println("Räume Schnecke \"" + name + "\" auf");

        this.currentRennen = null;
        this.position = null;
    }

    public boolean krabbeln() throws Exception {
        if(currentRennen == null)
            throw new Exception("Schnecke gerade nicht in einem Rennen!");

        if(position < currentRennen.rennStrecke.length) {
            position += RennSimulator.random.nextInt(3);
            if (position > currentRennen.rennStrecke.length) {
                position = currentRennen.rennStrecke.length;
                return false;
            }
            return true;
        } else
            return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(getClass().getName() + " \"" + name + "\"");
        if(currentRennen != null) {
            sb.append(' ');

            for(int i = 0; i < position; i++)
                sb.append('.');

            sb.append('@');

            for(int i = position; i < currentRennen.rennStrecke.length; i++)
                sb.append(' ');
            sb.append('#');
        }

        return sb.toString();
    }
}
