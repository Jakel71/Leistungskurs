package blatt15;

import blatt14.MultiArrays;
import blatt14.OasenSuche;
import blatt14.Simulationen;
import schisch_visualizer.*;

public class Spiegel {
    static char[][] spielfeld;


    /**
     * Erstellt ein Spielfeld, ohne es im Schisch Visualizer zu initialisieren
     * @param a breite/lange des Spielfeldes
     */
    public static void initialisiereSpielfeld(int a){
        spielfeld =  MultiArrays.createEmpty2DCharArray(a,a);
        for(int i = 0; i < spielfeld.length; i++){
            for(int j = 0; j < spielfeld[i].length; j++){
                spielfeld[i][j] = '0';
            }
        }
    }

    /**
     * erzeugt Random Spiegel auf einem Feld mit mindestens 1 Feld Abstand
     * @param feld das Feld (char[][])
     * @param wahrs Wahrscheinlichkeit ein Feld mit einem Spiegel auszustatten
     */
    public static void zufallSpiegel(char[][] feld, double wahrs){
        for (int i = 0; i < feld.length; i++) {
            for (int j = 0; j < feld[i].length; j++) {
                if(Math.random()<wahrs){
                    if (Simulationen.zaehlenVier(feld,i,j,'/',false)<1 && Simulationen.zaehlenVier(feld, i, j, '\\', false) < 1) {
                        if ((int) (Math.random() * 2) == 0) {
                            feld[i][j] = '/';
                        } else {
                            feld[i][j] = '\\';
                        }
                    }
                }
            }
        }
    }

    /**
     * erzeugt Random Spiegel auf einem Feld
     * @param feld das Feld (char[][])
     * @param wahrs Wahrscheinlichkeit ein Feld mit einem Spiegel auszustatten
     */
    public static void zufallSpiegelSchwer(char[][] feld, double wahrs){
        for (int i = 0; i < feld.length; i++) {
            for (int j = 0; j < feld[i].length; j++) {
                if(Math.random()<wahrs){
                    if((int)(Math.random()*2)==0){
                        feld[i][j] = '/';
                    } else{
                        feld[i][j] = '\\';
                    }
                }
            }
        }
    }

    /**
     * erzeugt Random Ziele auf einem Feld
     * @param feld das Feld (char[][])
     * @param wahrs Wahrscheinlichkeit ein Feld mit einem Spiegel auszustatten
     */
    public static void zufallZiele(char[][] feld, double wahrs){
        for (int i = 0; i < feld.length; i++) {
            for (int j = 0; j < feld[i].length; j++) {
                if(Math.random()<wahrs && ((i>0)&&(i< feld.length-1) && ((j>0)&&j<feld[0].length-1))){
                    if(feld[i][j]!='/' && feld[i][j]!='\\'){
                        feld[i][j] = 'O';
                    }
                }
            }
        }
    }

    public static void generierePfeil(char[][] feld){
        feld[0][feld[0].length/2] = '>';
    }

    public static void main(String[] args){
        SchischVisualizer sv = new SchischVisualizer();
        initialisiereSpielfeld(40);
        zufallSpiegel(spielfeld,0.1);
        zufallZiele(spielfeld,0.1);
        sv.step(spielfeld);
        generierePfeil(spielfeld);
        sv.step(spielfeld);

        sv.start();
    }
}
