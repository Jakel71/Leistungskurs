package blatt01;

public class TypKonversion {
    public static void main(String[] args) {
        int a = 14;
        double b = -21.25;

        int c = (int) b; // konvertierung double zu int
        double d = (double) a; // Konvertierung int zu double

        System.out.println(c);
        System.out.println(d);

        // Zusammenhang zwischen Int und double: bei int wird alles hinter dem Komma ignoriert, bei Rückkonvertierung wird ".0" angehängt.

        char e = 'a';
        char f = 65;
        int g = (int) e;
        char h = (char) f;
        System.out.println(g);
        System.out.println(h);

        //Zusammenhang zwischen int und char: Konvertierung mit ASCII

        //Ausgabe ist die Konvertierte Form, int <--> double und char <--> int

        // e)
        //boolean t = true;
        //h= (char) t;
        // erzeugt Fehler, da man Wahr nicht in einen Buchstaben bzw. Zeichen umwandeln kann!!!

        // Frage an Herr Schisch: Warum wird Warnung wegen redundanz bei konvertierung angezeit?

    }
}
