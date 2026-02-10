package blatt15;

import blatt14.MultiArrays;
import blatt14.Simulationen;
import schisch_visualizer.*;

public class Spiegel {
    static char[][] spielfeld;
    static SchischVisualizer sv = new SchischVisualizer();


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

    /**
     * generiert einen Pfeil auf 0 | y/2
     * @param feld Das Feld, auf dem dieser Pfeil generiert werden soll
     */
    public static void generierePfeil(char[][] feld){
        feld[0][feld[0].length/2] = '>';
    }

    /**
     * Dreht einen Spiegel mit einer gewissen Wahrscheinlichkeit
     * @param feld Das Feld auf dem sich der Spiegel befindet
     * @param wahrs Die Wahrscheinlichkeit, mit der sich der Spiegel dreht
     * @param x x-Koordinate des Spiegels
     * @param y y-Koordinate des Spiegels
     */
    public static void dreheSpiegel(char[][] feld, double wahrs, int x, int y){
        if(Math.random()<wahrs){
            if(feld[x][y] == '/'){
                feld[x][y] = '\\';
            } else{
                feld[x][y] = '/';
            }
        }
    }

    /**
     * Hilfsfunktion für spiegelSimulation, welche mithilfe von Rekursion den Pfeil bewegt und sicherstellt, dass kein Spiegel überschrieben wird.
     * @param feld Spielfeld, das Feld, wo sich Spiegel, Pfeil, etc. befindet
     * @param drehwahrscheinlichkeit Wahrscheinlichkeit, mit der sich ein Spiegel nach Kontakt mit Pfeil dreht
     * @param x X-Korrdinate des Pfeis / Feldes
     * @param y Y-Koordinate des Pfeils/ Feldes
     * @param ignore Bereich, welcher nicht überprüft wird
     */
    public static void pfeilBewege(char[][] feld, double drehwahrscheinlichkeit, int x, int y, char[][] ignore){
        if (feld[x][y] == '>' && ignore[x][y] != 'X') {
            feld[x][y] = '0';
            if(x < feld.length-1) {
                if (feld[x + 1][y] == 'O') {
                    feld[x + 1][y] = '0';
                } else if (feld[x + 1][y] == '<' || feld[x + 1][y] == '>' || feld[x + 1][y] == 'v' || feld[x + 1][y] == '^') {
                    feld[x + 1][y] = '0';
                } else if (feld[x + 1][y] == '/') {
                    if(y > 0) {
                        if (feld[x + 1][y - 1] != '/' && feld[x + 1][y - 1] != '\\') {
                            feld[x + 1][y - 1] = '^';
                            ignore[x + 1][y - 1] = 'X';
                        } else {
                            feld[x + 1][y] = '^';
                            pfeilBewege(feld, drehwahrscheinlichkeit, x + 1, y, ignore);
                            feld[x + 1][y] = '/';
                        }
                    }
                    dreheSpiegel(feld, drehwahrscheinlichkeit, x + 1, y);

                } else if (feld[x + 1][y] == '\\') {
                    if(y<feld[0].length-1) {
                        if (feld[x + 1][y + 1] != '/' && feld[x + 1][y + 1] != '\\') {
                            feld[x + 1][y + 1] = 'v';
                            ignore[x + 1][y + 1] = 'X';
                        } else {
                            feld[x + 1][y] = 'v';
                            pfeilBewege(feld, drehwahrscheinlichkeit, x + 1, y, ignore);
                            feld[x + 1][y] = '\\';
                        }
                    }
                    dreheSpiegel(feld, drehwahrscheinlichkeit, x + 1, y);

                } else {
                    feld[x + 1][y] = '>';
                    ignore[x + 1][y] = 'X';
                }
            }
        } else if (feld[x][y] == '<' && ignore[x][y] != 'X') {
            feld[x][y] = '0';
            if(x>0) {
                if (feld[x - 1][y] == 'O') {
                    feld[x - 1][y] = '0';
                } else if (feld[x - 1][y] == '<' || feld[x - 1][y] == '>' || feld[x - 1][y] == 'v' || feld[x - 1][y] == '^') {
                    feld[x - 1][y] = '0';
                } else if (feld[x - 1][y] == '/') {
                    if(y<feld[0].length-1) {
                        if(feld[x-1][y+1]!='/' && feld[x-1][y+1]!='\\') {
                            feld[x - 1][y + 1] = 'v';
                            ignore[x - 1][y + 1] = 'X';
                        } else{
                            feld[x - 1][y] = 'v';
                            pfeilBewege(feld, drehwahrscheinlichkeit, x - 1, y, ignore);
                            feld[x - 1][y] = '/';
                        }
                    }
                    dreheSpiegel(feld,drehwahrscheinlichkeit,x-1,y);
                } else if (feld[x - 1][y] == '\\') {
                    if(y>0) {
                        if(feld[x-1][y-1]!='/' && feld[x-1][y-1]!='\\') {
                            feld[x - 1][y - 1] = '^';
                            ignore[x - 1][y - 1] = 'X';
                        } else{
                            feld[x - 1][y] = '^';
                            pfeilBewege(feld, drehwahrscheinlichkeit, x - 1, y, ignore);
                            feld[x - 1][y] = '\\';
                        }
                    }
                    dreheSpiegel(feld,drehwahrscheinlichkeit,x-1,y);
                } else {
                    feld[x - 1][y] = '<';
                    ignore[x - 1][y] = 'X';
                }
            }
        } else if (feld[x][y] == 'v' && ignore[x][y] != 'X') {
            feld[x][y] = '0';
            if(y < feld[0].length-1) {
                if (feld[x][y+1] == 'O') {
                    feld[x][y+1] = '0';
                } else if (feld[x][y+1] == '<' || feld[x][y+1] == '>' || feld[x][y+1] == 'v' || feld[x][y+1] == '^') {
                    feld[x][y+1] = '0';
                }  else if (feld[x][y + 1] == '/') {
                    if(x>0) {
                        if(feld[x-1][y+1]!='/' && feld[x-1][y+1]!='\\') {
                            feld[x - 1][y + 1] = '<';
                            ignore[x - 1][y + 1] = 'X';
                        } else{
                            feld[x][y+1] = '<';
                            pfeilBewege(feld, drehwahrscheinlichkeit, x, y+1, ignore);
                            feld[x][y+1] = '/';
                        }
                    }
                    dreheSpiegel(feld,drehwahrscheinlichkeit,x,y+1);
                } else if (feld[x][y+1] == '\\') {
                    if(x<feld.length-1) {
                        if(feld[x+1][y+1]!='/' && feld[x+1][y+1]!='\\') {
                            feld[x + 1][y + 1] = '>';
                            ignore[x + 1][y + 1] = 'X';
                        } else{
                            feld[x][y+1] = '>';
                            pfeilBewege(feld, drehwahrscheinlichkeit, x, y + 1, ignore);
                            feld[x][y+1] = '\\';
                        }
                    }
                    dreheSpiegel(feld,drehwahrscheinlichkeit,x,y+1);
                }else {
                    feld[x][y + 1] = 'v';
                    ignore[x][y + 1] = 'X';
                }
            }
        } else if (feld[x][y] == '^' &&  ignore[x][y] != 'X') {
            feld[x][y] = '0';
            if(y>0) {
                if (feld[x][y - 1] == 'O') {
                    feld[x][y - 1] = '0';
                } else if (feld[x][y-1] == '<' || feld[x][y-1] == '>' || feld[x][y-1] == 'v' || feld[x][y-1] == '^') {
                    feld[x][y-1] = '0';
                } else if (feld[x][y - 1] == '/') {
                    if(x<feld.length-1) {
                        if(feld[x+1][y-1]!='/' && feld[x+1][y-1]!='\\') {
                            feld[x + 1][y - 1] = '>';
                            ignore[x + 1][y - 1] = 'X';
                        } else{
                            feld[x][y - 1] = '>';
                            pfeilBewege(feld, drehwahrscheinlichkeit, x, y - 1, ignore);
                            feld[x][y-1] = '/';
                        }
                    }
                    dreheSpiegel(feld,drehwahrscheinlichkeit,x,y-1);
                } else if (feld[x][y-1] == '\\') {
                    if(x>0) {
                        if(feld[x-1][y-1]!='/' && feld[x-1][y-1]!='\\') {
                            feld[x - 1][y - 1] = '<';
                            ignore[x - 1][y - 1] = 'X';
                        } else{
                            feld[x][y-1] = '<';
                            pfeilBewege(feld, drehwahrscheinlichkeit, x, y - 1, ignore);
                            feld[x][y-1] = '\\';
                        }
                    }
                    dreheSpiegel(feld,drehwahrscheinlichkeit,x,y-1);
                } else {
                    feld[x][y - 1] = '^';
                    ignore[x][y - 1] = 'X';
                }
            }
        }
    }

    /**
     * Simuliert das Feld mit Spiegeln und Pfeilen, die von ihnen abprallen
     * @param feld Spielfeld
     * @param schritteAnzahl Anzahl an Schritten, welche Simuliert werden
     * @param drehwahrscheinlichkeit Wahrscheinlichkeit, mit der sich ein Spiegel dreht, nachdem ein Pfeil von ihm abgeprallt sind
     * @param pfeilabstand Abstand zwischen 2 Pfeilen, 2 = 1 Feld frei, 3 = 2 Felder frei, etc.
     * @return True/ False, je nachdem ob alle Ziele eingesammelt wurden.
     */
    public static boolean spiegelSimulation (char[][] feld, int schritteAnzahl, double drehwahrscheinlichkeit, int pfeilabstand){

        zufallSpiegelSchwer(feld,0.25);
        zufallZiele(feld,0.05);

        char[][] ignore = new char[feld.length][feld[0].length];
        for (int i = 0; i < schritteAnzahl; i++) {
            ignore = blatt14.MultiArrays.createEmpty2DCharArray(feld.length, feld[0].length);
            for (int x = 0; x < feld.length; x++) {
                for (int y = 0; y < feld[x].length; y++) {
                    pfeilBewege(feld,drehwahrscheinlichkeit,x,y,ignore);
                }
            }
            if(i%pfeilabstand==0){
                generierePfeil(feld);
            }
            sv.step(feld);
        }

        for (int x = 0; x < feld.length; x++) {
            for (int y = 0; y < feld[0].length; y++) {
                if (feld[x][y] == 'O') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        initialisiereSpielfeld(40);
        System.out.println(spiegelSimulation(spielfeld,10000,0.5,2));
        sv.start();
    }
}
