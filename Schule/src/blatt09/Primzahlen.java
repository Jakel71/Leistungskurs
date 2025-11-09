package blatt09;


public class Primzahlen {
    /**
     * Überprüft, ob es sich um eine Primzahl handelt
     * @param zahl Int Zahl
     * @return boolischer Wert
     */
    public static boolean istPrim(int zahl){
        int [] teilerArray = Teiler.teiler(zahl);
        if (teilerArray.length == 2){
            return true;
        } else  {
            return  false;
        }
    }

    /**
     * Gibt alle Primzahlen bis zu einer Obergrenze aus
     * @param zahl die Grenze (int)
     */
    public static void printPrim(int zahl){
        int[] moeglichePrimzaehlen = new int[zahl];
        for (int i=0; i<zahl; i++){
            moeglichePrimzaehlen[i] = i+1;
            if (istPrim(moeglichePrimzaehlen[i])) {
                System.out.println("Primzahl: " + moeglichePrimzaehlen[i]);
            }
        }
    }

    /**
     * Berechnet und gibt n Primzahlen zurück
     * @param zahl int Zahl (n)
     * @return Arr mit allen Primzahlen
     */
    public static int[] generierePrimzahlen(int zahl){
        int primzahlenGefunden = 0;
        int i = 0;
        while(primzahlenGefunden<zahl){
            i++;
            if (istPrim(i)){
                primzahlenGefunden ++;
            }
        }
        int [] primzahlen = new int[primzahlenGefunden];
        primzahlenGefunden = 0;
        i = 0;
        while(primzahlenGefunden<zahl){
            i++;
            if (istPrim(i)){
                primzahlen[primzahlenGefunden]=i;
                primzahlenGefunden ++;
            }
        }
        return primzahlen;
    }

    /**
     * Ausgeben aller Primzahlen, welche zusammen multipliziert den Input ergeben
     * @param zahl int Zahl (input)
     */
    public static void primfaktorzerlegung(int zahl){
        while(!istPrim(zahl)){
            int[] teilerArray = Teiler.teiler(zahl);
            for (int i=0; i<teilerArray.length; i++){
                if (istPrim(teilerArray[i])) {
                    System.out.print(teilerArray[i] + " * ");
                    zahl/=teilerArray[i];
                    break;
                }
            }
        }
        System.out.println(zahl);
    }

}
