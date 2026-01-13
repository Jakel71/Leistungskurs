package blatt14;

import schisch_visualizer.*;

public class OasenSuche {
    static int[] spielerPosition = new int[2];
    static char[][] spielfeld;

    /**
     * Erstellt ein Spielfeld ohne es im Schisch Visualizer zu initialisieren
     * @param a breite des Spielfeldes
     * @param b laenge des Spielfelds
     */
    public static void initialisiereSpielfeld(int a, int b){
        char[][] spielfeld =  MultiArrays.createEmpty2DCharArray(a,b);
    }

    public static void zufallsPositionSpieler(){
        if(spielfeld!=null) {
            int positionX = (int) (Math.random() * spielfeld.length);
            int positionY = (int) (Math.random() * spielfeld[0].length);
            spielerPosition[0] = positionX;
            spielerPosition[1] = positionY;
        }
    }

    public static void wasserZufall(double wahrscheinlichkeit){
        for(int i=0;i<spielfeld[0].length;i++){
            for(int j=0;j<spielfeld.length;j++){
                double zufallZahl = Math.random();
                if(zufallZahl<=wahrscheinlichkeit && (i!=spielerPosition[0]&&j!=spielerPosition[1])){
                    spielfeld[i][j]='2';
                }
            }
        }
    }

    public static void main(String[] args) {
        SchischVisualizer sv = new SchischVisualizer();
        initialisiereSpielfeld(11,14);
        sv.step(spielfeld);
        sv.start();
    }
}
