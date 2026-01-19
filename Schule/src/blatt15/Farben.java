package blatt15;

import blatt14.MultiArrays;
import schisch_visualizer.*;

public class Farben {
    static SchischVisualizer sv = new SchischVisualizer();
    static int[] spielerPosX;
    static int[] spielerPosY;
    static int[] reihenfolge;
    static char[][] spielfeld;

    public static void initialisiereSpielfeld(int breite, int laenge){
        spielfeld = MultiArrays.createEmpty2DCharArray(breite, laenge);
        for (int i = 0; i < spielfeld.length-1; i++){
            for (int j = 0; j < spielfeld[0].length-1; j++){
                if(i==spielfeld.length-1 || j==spielfeld[0].length-1 || i==0 || j==0){
                    spielfeld[i][j] = '8';
                }else{
                    spielfeld[i][j] = '0';
                }
            }
        }
    }

    public static void main (String [] args){
    initialisiereSpielfeld(80,80);
    sv.step(spielfeld);
    sv.start();
    }
}
