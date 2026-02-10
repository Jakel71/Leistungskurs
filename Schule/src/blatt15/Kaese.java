package blatt15;

import blatt14.MultiArrays;
import schisch_visualizer.*;

public class Kaese {
    static char[][] kaeseQuerschnitt;
    static SchischVisualizer sv = new SchischVisualizer();

    /**
     * Erstellt einen Kaese-Querschnitt, ohne es im Schisch Visualizer zu initialisieren
     * @param a breite des Kaeses
     * @param b laenge des Kaeses
     */
    public static void initialisiereKaeseQuer(int a, int b){
        kaeseQuerschnitt =  MultiArrays.createEmpty2DCharArray(a,b);
        for(int i = 0; i < kaeseQuerschnitt.length; i++){
            for(int j = 0; j < kaeseQuerschnitt[i].length; j++){
                kaeseQuerschnitt[i][j] = '0';
            }
        }
    }
    /**
     * erzeugt zufaellig Kaese
     * @param wahrscheinlichkeit wahrscheinlichkeit der Kaesegenerierung auf einem Feld
     */
    public static void kaeseZufall(double wahrscheinlichkeit){
        if(kaeseQuerschnitt!=null) {
            for (int i = 0; i < kaeseQuerschnitt.length; i++) {
                for (int j = 0; j < kaeseQuerschnitt[i].length; j++) {
                    double zufallZahl = Math.random();
                    if (zufallZahl <= wahrscheinlichkeit) {
                        kaeseQuerschnitt[i][j] = '5';
                    }
                }
            }
        }
    }

    /**
     * Generiert Wasser und prüft, ob ein Kaese/Objekt wasserdicht ist. 2-Dimensional
     */
    public static void wasserGen (){
        for (int i = 0; i < kaeseQuerschnitt.length; i++) {
            if (kaeseQuerschnitt[i][0] == '0') {
                kaeseQuerschnitt[i][0] = '6';
            }
        }
        sv.step(kaeseQuerschnitt);
        char[][] altKaeseQuerschnitt = MultiArrays.copy2DCharArray(kaeseQuerschnitt);
        do{
            altKaeseQuerschnitt = MultiArrays.copy2DCharArray(kaeseQuerschnitt);
            for (int i = 0; i <= kaeseQuerschnitt.length - 1; i++) {
                for (int j = 0; j <= kaeseQuerschnitt[i].length - 1; j++) {
                    if (kaeseQuerschnitt[i][j] == '6') {
                        if (i > 0) {
                            if (kaeseQuerschnitt[i - 1][j] == '0') {
                                kaeseQuerschnitt[i - 1][j] = '6';
                                sv.step(kaeseQuerschnitt);
                            }
                        }
                        if (i < kaeseQuerschnitt[i].length - 1) {
                            if (kaeseQuerschnitt[i + 1][j] == '0') {
                                kaeseQuerschnitt[i + 1][j] = '6';
                                sv.step(kaeseQuerschnitt);
                            }
                        }
                        if (j > 0) {
                            if (kaeseQuerschnitt[i][j - 1] == '0') {
                                kaeseQuerschnitt[i][j - 1] = '6';
                                sv.step(kaeseQuerschnitt);
                            }
                        }
                        if (j < kaeseQuerschnitt[i].length - 1) {
                            if (kaeseQuerschnitt[i][j + 1] == '0') {
                                kaeseQuerschnitt[i][j + 1] = '6';
                                sv.step(kaeseQuerschnitt);
                            }
                        }
                    }
                }
                if (kaeseQuerschnitt[i][kaeseQuerschnitt[i].length-1] == '6') {
                    System.out.println("Kaese ist nicht Wasserdicht!");
                    return;
                }
            }
        }while (!MultiArrays.istIdentisch(altKaeseQuerschnitt, kaeseQuerschnitt));

        System.out.println("Kaese ist Wasserdicht!");
    }

    public static void main(String[] args) {
        initialisiereKaeseQuer(40,40);
        sv.step(kaeseQuerschnitt);
        kaeseZufall(0.4);
        sv.step(kaeseQuerschnitt);
        wasserGen();
        sv.start();
    }
}
