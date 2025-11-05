package blatt10;

public class Aufwand {
    static int o = 0;
    static int a = 0;

    public static int zahlDerUmbrueche(char[] charr) {
        int count = 0;
        o++;
        for (int i = 0; i < charr.length-1; i++) {
            a++;
            a++;
            if (charr[i] == '.') {
                a++;
                o++;
                if (charr[i+1] == ' ') {
                    count++;
                    o++;
                }
            }
        }
        o++;
        return count;
    }

    public static char[] umbrueche(String s) {
        char[] charr = s.toCharArray();
        o++;
        int c = zahlDerUmbrueche(charr);
        o++;
        int k = 0;
        o++;
        char[] charr2 = new char[charr.length+c];
        o++;
        o++;
        while (c > 0) {
            a++;
            for (int i = 0; i < charr.length-1; i++) {
                a++;
                a++;
                o++;
                if (charr[i] == '.') {
                    a++;
                    o++;
                    if (charr[i+1] == ' ') {
                        charr2[i] = charr[i];
                        o++;
                        charr2[i+1] = '\n';
                        o++;
                        o++;
                        k++;
                        o++;
                        c--;
                        o++;
                    } else {
                        charr2[i+k] = charr[i];
                        o++;
                        o++;
                    }
                } else {
                    a++;
                    a++;
                    a++;
                    o++;
                    if (charr[i] == ' ' && charr[i-1] == '.') {

                    } else {
                        o++;
                        charr2[i] = charr[i];
                    }
                }
            }
        }
        o++;
        return charr2;

    }
    // Funktion: Ausgabe eines Nusseckenrezeptes; ausgabe: Einfügen von Zeilenumbrüchen in dem Rezept(eingabe)
    public static void main(String[] args) {
        String eingabe = "Nussecken (1 Blech). Teig: 300g Mehl, 1 TL Backpulver, 130g Zucker, 1 Pkg Vanillezucker, 2 EL Leinsamen, 6 EL Wasser, 130g Margarine/Butter. Belag: 200g Margarine/Butter, 6 EL Wasser, 200g Zucker, 1 Pkg Vanillezucker, 400g gemahlene Haselnüsse/Mandeln. Außerdem: Erdbeer-/Himbeermarmelade, 100g Zartbitterschokolade. Schritte: Die Leinsamen in 6 EL Wasser aufquellen lassen. Alle Zutaten für den Teig vermischen und zu einem relativ weichen Teig zerkneten, dann auf einem mit Backpapier ausgelegten Backbleck dünn drücken. Marmelade dünn auf dem Teig verteilen. Margarine, Wasser, Zucker und Vanillezucker in einem Topf schmelzen und kurz aufkochen lassen, dann Nüsse dazugeben und alles vermischen. Belag auf der Marmelade verteilen. Im vorgeheizten Backofen bei 180° C Ober/Unterhitze oder 160° C Umluft ca. 30 Minuten backen. Glasur erwärmen und mit einem Löffel über das Blech sprenkeln (so wird es gleichmäßiger und geht schneller als die Ecken in Schokolade zu tunken), abkühlen lassen. Zu Ecken schneiden.";
        o++;
        char[] ausgabe = umbrueche(eingabe);
        o++;
        System.out.println(eingabe);
        o++;
        System.out.println(ausgabe);
        o++;

        System.out.println("Anzahl an Operationen: " + o);
        System.out.println("Anzahl an Abfragen: " + a);
    }
    /*
    c) Speicheranalyse:
        Integer:5 * 32 Bit = 160Bit
        Array: 3 char[] = Variabler Speicher --> alle drei gleiche Element Anzahl * 16Bit für Zeichen --> 1024*16 Bits + ca. 96Bits (für den Haeder also das Array an sich) --> 16.480 Bits
        String = Variabel --> 1024 Zeichen (Character) --> 1024*16Bit = 16.384

    d) Ist nicht C++, keine Random funktion --> also muss durch gleicher Input immer das Gleiche heraus kommen & es wurde mehrfach ausgeführt.

    e) Worst-Case:
        Aufwand: jedes Element verursacht einen Zeilenumbruch
        Speicher: infinit Elemente

        Best-Case:
        Aufwand: kein einziger Zeilenumbruch
        Speicher: kein Zeichen
     */

}

