package blatt14;

import schisch_visualizer.*;

public class Steine {
    static char[][] spielfeld;
    static SchischVisualizer sv = new SchischVisualizer();

    /**
     * Erstellt ein Spielfeld ohne es im Schisch Visualizer zu initialisieren
     * @param a breite des Spielfeldes
     * @param b laenge des Spielfelds
     */
    public static void initialisiereSpielfeld(int a, int b){
        spielfeld =  MultiArrays.createEmpty2DCharArray(a,b);
    }

    public static void zeichneI (int startpunkt, boolean horizontal){
        if (horizontal) {
            spielfeld[startpunkt][0] = '6';
            spielfeld[startpunkt+1][0] = '6';
            spielfeld[startpunkt+2][0] = '6';
            spielfeld[startpunkt+3][0] = '6';
        } else{
            spielfeld[startpunkt][0] = '6';
            spielfeld[startpunkt][1] = '6';
            spielfeld[startpunkt][2] = '6';
            spielfeld[startpunkt][3] = '6';
        }
        sv.step(spielfeld);
    }

    public static void zeichneO (int startpunkt){
        spielfeld[startpunkt][0] = '5';
        spielfeld[startpunkt+1][0] = '5';
        spielfeld[startpunkt][1] = '5';
        spielfeld[startpunkt+1][1] = '5';

        sv.step(spielfeld);
    }

    public static void zeichneT (int startpunkt, char orientierung){
        if (orientierung == 'N') {
            spielfeld[startpunkt][0] = 'D';
        }
    }

    public static void main(String args[]) {
        initialisiereSpielfeld(10,40);
        sv.step(spielfeld);
        zeichneI(1,true);
        zeichneO(2);
        sv.start();
    }
}
