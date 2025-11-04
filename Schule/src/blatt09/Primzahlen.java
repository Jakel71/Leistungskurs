package blatt09;

public class Primzahlen {
    /**
     * Überprüft, ob es sich um eine Primzahl handelt
     * @param zahl Int Zahl
     * @return boolischer Wert
     */
    public static boolean istPrim(int zahl){
        int [] teilerArray = Teiler.teiler(zahl);
        if (teilerArray.length > 2){
            return false;
        } else  {
            return  true;
        }
    }


    public static void main(String[] args) {
    }
}
