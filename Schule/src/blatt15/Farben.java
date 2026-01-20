package blatt15;

import blatt07.ArbeitMitArrays;
import blatt14.MultiArrays;
import schisch_visualizer.*;

public class Farben {
    static SchischVisualizer sv = new SchischVisualizer();
    static int[] spielerPosX = new int[8] ;
    static int[] spielerPosY = new int[8] ;
    static int[] reihenfolge = new int[8] ;
    static char[][] spielfeld;


    /**
     * erstellt das Spielfeld und erzeugt eine Wand('8') am Rand:
     * @param breite des Spielfelds
     * @param laenge des Spielfelds
     */
    public static void initialisiereSpielfeld(int breite, int laenge){
        //ergebnis immer durch 2 teilbar:
        if(breite%2!=0){
            breite++;
        }
        if(laenge%2!=0){
            laenge++;
        }
        //spielfeld init
        spielfeld = MultiArrays.createEmpty2DCharArray(breite, laenge);
        //Wände einzeichnen
        for (int i = 0; i < spielfeld.length; i++){
            for (int j = 0; j < spielfeld[0].length; j++){
                if(i==spielfeld.length-1 || j==spielfeld[0].length-1 || i==0 || j==0){
                    spielfeld[i][j] = '8';
                }else{
                    spielfeld[i][j] = '0';
                }
            }
        }
    }

    /**
     * erzeugt Startpositionen für 8 Spieler in ihrer Seite des Spielfeldes
     */
    public static void startPositionen(){
        for (int i = 0; i < 4; i++) {
            do {
                spielerPosX[i] = (int)(Math.random()*(spielfeld.length/2));
                spielerPosY[i] = (int)(Math.random()*(spielfeld[0].length));
            }while(spielfeld[spielerPosX[i]][spielerPosY[i]]!='0');
            spielfeld[spielerPosX[i]][spielerPosY[i]] = 'P';
        }

        for (int i = 4; i < 8; i++) {
            do {
                spielerPosX[i] = (int)(Math.random()*(spielfeld.length/2))+spielfeld.length/2;
                spielerPosY[i] = (int)(Math.random()*(spielfeld[0].length));
            }while(spielfeld[spielerPosX[i]][spielerPosY[i]]!='0');
            spielfeld[spielerPosX[i]][spielerPosY[i]] = 'P';
        }
    }

    /**
     * zählt die Spielfelder für das jeweilige team
     * @param teamnummer 0 = leere Felder;
     *                   1 = team 1 + Spieler team 1 auf Spielfeld;
     *                   2 = team 2 + Spieler team 2 auf Spielfeld
     * @param countPlayer false = ohne Spieler, nur eingefärbte Felder der Farbe;
     *                    true = totale Felder-summe des Teams
     * @return Anzahl an eingefärbten Feldern
     */
    public static int zaehlen(int teamnummer, boolean countPlayer){
        int count =0;
        for(int i=0; i<spielfeld.length; i++){
            for(int j=0; j<spielfeld[0].length; j++){
                if(teamnummer==0){
                    if(spielfeld[i][j]=='0'){
                        count++;
                    }
                }else if(teamnummer==1){
                    if(spielfeld[i][j]=='7'){
                        count++;
                    }
                }else if(teamnummer==2){
                    if(spielfeld[i][j]=='9'){
                        count++;
                    }
                }
            }
        }
        if(countPlayer) {
            if (teamnummer == 1) {
                for (int i = 0; i < 4; i++) {
                    if (spielerPosX[i] != -1 && spielerPosY[i] != -1) {
                        count++;
                    }
                }
            } else if (teamnummer == 2) {
                for (int i = 4; i < 8; i++) {
                    if (spielerPosX[i] != -1 && spielerPosY[i] != -1) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /**
     * respawnt einen Spieler, wenn möglich auf eine mFeld seines Teams, ansonsten random irgendwo
     * @param spielernum bestimmt welcher Spieler respawnt (0-3 = team 1; 4-7 = team 2)
     */
    public static void respawn(int spielernum){
        int teamnummer = 1;
        char checkFarbe = '7';
        if(spielernum>3){
            teamnummer = 2;
            checkFarbe = '9';
        }
        int count = zaehlen(teamnummer, false);
        if(count<1){//nicht genug felder eigener Farbe --> random spawn überall
            do {
                spielerPosX[spielernum] = (int) (Math.random() * spielfeld.length);
                spielerPosY[spielernum] = (int) (Math.random() * spielfeld[0].length);
            } while(spielfeld[spielerPosX[spielernum]][spielerPosY[spielernum]]=='P' || spielfeld[spielerPosX[spielernum]][spielerPosY[spielernum]]=='8');
            spielfeld[spielerPosX[spielernum]][spielerPosY[spielernum]] = 'P';
        } else{
            int random = (int)(Math.random()*spielfeld.length*spielfeld[0].length);
            do{
                for(int i=0; i<spielfeld.length; i++){
                    for(int j=0; j<spielfeld[0].length; j++){
                        if(spielfeld[i][j]==checkFarbe){
                            random--;
                            spielerPosX[spielernum] = i;
                            spielerPosY[spielernum] = j;
                        }
                    }
                }
            }while(random>0);
            spielfeld[spielerPosX[spielernum]][spielerPosY[spielernum]] = checkFarbe;
        }
    }


    /**
     * erzeugt eine Reihenfolge für alle Spieler
     */
    public static void reihenfolge(){
        for(int i=0; i<reihenfolge.length; i++){
            reihenfolge[i] = -1;
        }
        for(int i=0; i<reihenfolge.length; i++){
            int pos;
            do{
                pos = (int)(Math.random()*8);
            } while (reihenfolge[pos] !=-1);
            reihenfolge[pos] = i;
        }
    }

    //TODO: Richtige Strategie machen
    public static void zug1 (int spielernum){
        if(spielernum>3){
            spielfeld[spielerPosX[spielernum]][spielerPosY[spielernum]]='9';
        } else {
            spielfeld[spielerPosX[spielernum]][spielerPosY[spielernum]] = '7';
        }

        int richtung = (int)(Math.random()*4);

        if(richtung==0){ // Schritt nach rechts
            if(spielerPosX[spielernum]!=spielfeld.length-2){
                    spielerPosX[spielernum]++;
            }

        } else if(richtung==1){ // Schritt nach links
            if(spielerPosX[spielernum]>1){
                spielerPosX[spielernum]--;
            }

        } else if(richtung==2){ // Schritt nach oben
            if(spielerPosY[spielernum]>1){
                spielerPosY[spielernum]--;
            }

        } else if(richtung==3){ // Schritt nach unten
            if(spielerPosY[spielernum]!=spielfeld[0].length-2){
                spielerPosY[spielernum]++;
            }

        }
        spielfeld[spielerPosX[spielernum]][spielerPosY[spielernum]] = 'P';
    }

    public static void zug2 (int spielernum){
        zug1(spielernum);
    }

    /**
     * ausführen einer Spielrunde
     */
    public static void schritt(){
        reihenfolge();
        for(int i=0; i<reihenfolge.length; i++){
            if(reihenfolge[i]>3){
                zug2(reihenfolge[i]);
            } else{
                zug1(reihenfolge[i]);
            }
        }
        for(int i=0; i<spielerPosX.length; i++){
            if(spielerPosX[i]==-1 && spielerPosY[i]==-1){
                respawn(i);
            }
        }
    }

    /**
     * nimmt die Auswertung nach dem Spiel vor.
     * Ausgabe der %-Zahlen der Teams
     * @return 1 = Team 1 hat gewonnen;
     *         2 = Team 2 hat gewonnen;
     *         0 = beide Teams haben gleich viele Felder Eingefärbt
     */
    public static int auswertung(){
        double team1Prozent = (double) zaehlen(1, true) /(spielfeld.length*spielfeld[0].length);
        double team2Prozent = (double) zaehlen(2, true) /(spielfeld.length*spielfeld[0].length);
        System.out.printf("Das Team 1 hat %.2f aller Felder gefärbt.\n",  team1Prozent);
        System.out.printf("Das Team 2 hat %.2f aller Felder gefärbt.\n",  team2Prozent);
        if(team1Prozent>team2Prozent){
            return 1;
        } else if(team1Prozent<team2Prozent){
            return 2;
        } else{
            return 0;
        }
    }

    public static void simulation(int anzahlDerSchritte){
        //Vorbereitung:
        initialisiereSpielfeld(80,80);
        startPositionen();
        sv.step(spielfeld);
        //Spiel:
        for (int i = 0; i < anzahlDerSchritte; i++) {
            schritt();
            sv.step(spielfeld);
        }
        //Nachbereitung:
        System.out.println(auswertung());
        sv.start();
    }

    public static void main (String [] args){
    simulation(1000);
    }
}
