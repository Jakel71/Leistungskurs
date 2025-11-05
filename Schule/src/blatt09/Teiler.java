package blatt09;

public class Teiler {
    /**
     * Überprüft, ob eine natürliche Zahl durch eine andere natürliche Zahl geteilt werden kann.
     * @param zahl Die Zahl, welche geteilt wird
     * @param teiler Der Teiler, die Zahl, welche teilt
     * @return boolischer Wert, möglich oder nicht möglich, also true wenn kein Rest entsteht
     */
    public static boolean istTeiler (int zahl, int teiler){
        if (teiler != 0){
            if (zahl%teiler == 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * Findet und gibt alle Teiler einer natürlichen Zahl aus.
     * @param zahl Die natürliche Zahl
     * @return Ausgabe in der Comando Zeile mit der Liste.
     */
    public static void teilerPrint(int zahl){
        int[] teilerArray = new int[zahl];
        int zaehler = 0;
        for (int i = 1; i<=zahl; i++){
            if (zahl%i==0){
                teilerArray[zaehler] = i;
                zaehler++;
            }
        }
        int[] teilerArrayNull = new int[zaehler];
        zaehler = 0;
        for (int i = 0; i<zahl; i++){
            if (teilerArray[i] != 0){
                teilerArrayNull[zaehler] = teilerArray[i];
                zaehler++;
            }
        }
        blatt07.ArbeitMitArrays.printArray(teilerArrayNull);
    }


    /**
     * Findet und gibt alle Teiler einer natürlichen Zahl zurück.
     * @param zahl Die natürliche Zahl
     * @return Die Liste (Array) mit allen Zahlen.
     */
    public static int anzahlTeiler(int zahl){
        int[] teilerArray = new int[zahl];
        int zaehler = 0;
        for (int i = 1; i<=zahl; i++){
            if (zahl%i==0){
                zaehler++;
            }
        }
        return zaehler;
    }

    /**
     * Findet und gibt alle Teiler einer natürlichen Zahl zurück.
     * @param zahl Die natürliche Zahl
     * @return Die Liste (Array) mit allen Zahlen.
     */
    public static int[] teiler(int zahl){
        int[] teilerArray = new int[zahl];
        int zaehler = 0;
        for (int i = 1; i<=zahl; i++){
            if (zahl%i==0){
                teilerArray[zaehler] = i;
                zaehler++;
            }
        }
        int[] teilerArrayNull = new int[zaehler];
        zaehler = 0;
        for (int i = 0; i<zahl; i++){
            if (teilerArray[i] != 0){
                teilerArrayNull[zaehler] = teilerArray[i];
                zaehler++;
            }
        }
        return teilerArrayNull;
    }

    public static void main(String[] args) {
        System.out.println(istTeiler(1,0));
    }
}
