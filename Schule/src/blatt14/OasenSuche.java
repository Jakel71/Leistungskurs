package blatt14;

import schisch_visualizer.*;

public class OasenSuche {
    static int[] spielerPosition = new int[2];
    static char[][] spielfeld;
    //Spieler = 'P'
    //Wasser = '2'
    //Stein = 'A'

    /**
     * Erstellt ein Spielfeld ohne es im Schisch Visualizer zu initialisieren
     * @param a breite des Spielfeldes
     * @param b laenge des Spielfelds
     */
    public static void initialisiereSpielfeld(int a, int b){
        spielfeld =  MultiArrays.createEmpty2DCharArray(a,b);
    }

    /**
     * Teleportiert den Spieler auf ein random freies Feld
     */
    public static void zufallsPositionSpieler(){
        if(spielfeld!=null) {
            int positionX = (int) (Math.random() * spielfeld.length);
            int positionY = (int) (Math.random() * spielfeld[0].length);

            if (spielerPosition != null && spielfeld[spielerPosition[0]][spielerPosition[1]] == 'P') {
                spielfeld[spielerPosition[0]][spielerPosition[1]] = '0';
            }
            spielerPosition[0] = positionX;
            spielerPosition[1] = positionY;
            spielfeld[spielerPosition[0]][spielerPosition[1]] = 'P';

        }
    }

    /**
     * erzeugt zufaellig Wasser
     * @param wahrscheinlichkeit wahrscheinlichkeit der Wassergenerierung auf einem Feld
     */
    public static void wasserZufall(double wahrscheinlichkeit){
        if(spielfeld!=null) {
            for (int i = 0; i < spielfeld.length; i++) {
                for (int j = 0; j < spielfeld[i].length; j++) {
                    double zufallZahl = Math.random();
                    if (zufallZahl <= wahrscheinlichkeit && (i != spielerPosition[0] && j != spielerPosition[1])) {
                        spielfeld[i][j] = '2';
                    }
                }
            }
        }
    }

    /**
     * erzeugt zufaellig Stein
     * @param wahrscheinlichkeit wahrscheinlichkeit der Steingenerierung auf einem Feld
     */
    public static void steinZufall(double wahrscheinlichkeit){
        if(spielfeld!=null) {
            for (int i = 0; i < spielfeld.length; i++) {
                for (int j = 0; j < spielfeld[i].length; j++) {
                    double zufallZahl = Math.random();
                    if (zufallZahl <= wahrscheinlichkeit && (i != spielerPosition[0] && j != spielerPosition[1])&&(spielfeld[i][j] != '2') ) {
                        spielfeld[i][j] = 'A';
                    }
                }
            }
        }
    }

    public static void bewegeSpielerZufaellig(){
        int richtung = (int)(Math.random()*4);

        if(richtung==0){ // Schritt nach rechts
            if((spielfeld[spielerPosition[0]+1][spielerPosition[1]] != '2')&&(spielfeld[spielerPosition[0]+1][spielerPosition[1]] != 'A')){
                spielfeld[spielerPosition[0]+1][spielerPosition[1]] = 'P';
                spielfeld[spielerPosition[0]][spielerPosition[1]] = '4';
            }
        } else if(richtung==1){ // Schritt nach oben
            if((spielfeld[spielerPosition[0]+1][spielerPosition[1]] != '2')&&spielfeld[spielerPosition[0]][spielerPosition[1]+1] != 'A'){
                spielfeld[spielerPosition[0]][spielerPosition[1]+1] = 'P';
                spielfeld[spielerPosition[0]][spielerPosition[1]] = '4';
            }
        } else if(richtung==2) { // Schritt nach links
            if ((spielfeld[spielerPosition[0]+1][spielerPosition[1]] != '2')&&spielfeld[spielerPosition[0]-1][spielerPosition[1]] != 'A') {
                spielfeld[spielerPosition[0]-1][spielerPosition[1]] = 'P';
                spielfeld[spielerPosition[0]][spielerPosition[1]] = '4';
            }
        } else if(richtung==3) { // Schritt nach unten
            if ((spielfeld[spielerPosition[0]+1][spielerPosition[1]] != '2')&&spielfeld[spielerPosition[0]][spielerPosition[1] - 1] != 'A') {
                spielfeld[spielerPosition[0]][spielerPosition[1] - 1] = 'P';
                spielfeld[spielerPosition[0]][spielerPosition[1]] = '4';
            }
        }
    }

    public static void findeWasser(){
        if(spielfeld!=null) {
            if(spielerPosition!=null) {
                bewegeSpielerZufaellig();
            }
        }
    }

    public static void main(String[] args) {
        SchischVisualizer sv = new SchischVisualizer();
        initialisiereSpielfeld(11,14);
        sv.step(spielfeld);
        zufallsPositionSpieler();
        sv.step(spielfeld);
        wasserZufall(0.50);
        sv.step(spielfeld);
        steinZufall(0.50);
        sv.step(spielfeld);
        findeWasser();
        sv.step(spielfeld);
        sv.start();
    }
}
