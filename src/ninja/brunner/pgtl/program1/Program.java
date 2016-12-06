package ninja.brunner.pgtl.program1;

public class Program {
    public static void main(String[] args) {
        String[] zahlen = { "0", "1", "2", "3.3", "4", "falsch"};

        double summe = 0.0;
        for(String zahl : zahlen)  {
            System.out.println(zahl);
            double parsedAsInteger;
            try
            {
                parsedAsInteger = Double.parseDouble(zahl);
            }
            catch (Exception ex)
            {
                System.out.println("Zahl kann nicht geparst werden.");
            }
        }

        System.out.println("Summe: " + summe);
    }
}
