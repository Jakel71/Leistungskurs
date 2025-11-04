package blatt09;

public class Kuerzen {
    /**
     * Gibt zurück, ob ein Wert weiter kürzbar ist
     * @param zaehler Int Zahl
     * @param nenner Int Zahl
     * @return boolischer Wert: true für kürzbar und false für nicht kürzbar
     */
    public static boolean istKuerzbar (int zaehler, int nenner){
        int[] teilerZaehler = Teiler.teiler(zaehler);
        int[]teilerNenner = Teiler.teiler(nenner);
        for (int i = 0; i<teilerNenner.length; i++){
            if (teilerNenner[i] == teilerZaehler[i]){
                return true;
            }
        }
        return false;
    }

    /**
     * Comandozeilen-Ausgabe des gekürzten Bosses
     * @param zaehler Int Zahl
     * @param nenner Int Zahl
     */
    public static void kuerzen (int zaehler, int nenner){
        int teiler = 1;
        int[] teilerZaehler = Teiler.teiler(zaehler);
        int[] teilerNenner = Teiler.teiler(nenner);
        for (int i = 0; i<teilerNenner.length; i++) {
            for (int j = 0; j < teilerZaehler.length; j++) {
                if (teilerNenner[i] == teilerZaehler[j] && (teiler < teilerNenner[i])){
                    teiler = teilerNenner[i];
                }
            }
        }
        zaehler /= teiler;
        nenner /= teiler;
        System.out.println("Zaehler: " + zaehler);
        System.out.println("Nenner: " + nenner);
    }

}
