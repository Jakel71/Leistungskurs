package blatt15;

import blatt11.BubbleSort;
import blatt13.Umgebung;
import blatt14.MultiArrays;
import blatt14.Simulationen;
import schisch_visualizer.*;

public class Farben {
    static SchischVisualizer sv = new SchischVisualizer();
    static int[] spielerPosX = new int[8] ;
    static int[] spielerPosY = new int[8] ;
    static int[] reihenfolge = new int[8] ;
    static char[][] spielfeld;
    static boolean spielerBewegt;


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

    /**
     * Gibt die Umgebung um einen Spieler zurück
     * @param spielernum Nummer des Spielers
     * @return Liste der Elemente
     */
    public static char[] scanneUmgebung(int spielernum){
        int[] pos = new int[]{spielerPosX[spielernum],spielerPosY[spielernum]};
        int[] posN = new int[]{spielerPosX[spielernum],spielerPosY[spielernum]-1};
        int[] posS = new int[]{spielerPosX[spielernum],spielerPosY[spielernum]+1};
        int[] posW = new int[]{spielerPosX[spielernum]-1,spielerPosY[spielernum]};
        int[] posO = new int[]{spielerPosX[spielernum]+1,spielerPosY[spielernum]};

        char[] umgebung = new char[13];
        umgebung[0] = Simulationen.getNorden(spielfeld,spielerPosX[spielernum],spielerPosY[spielernum]-1,false);     //0
        umgebung[1] = Simulationen.getNordWest(spielfeld,spielerPosX[spielernum],spielerPosY[spielernum],false);        //1
        umgebung[2] = Simulationen.getNorden(spielfeld,spielerPosX[spielernum],spielerPosY[spielernum],false);          //2
        umgebung[3] = Simulationen.getNordOst(spielfeld,spielerPosX[spielernum],spielerPosY[spielernum],false);         //3
        umgebung[4] = Simulationen.getWesten(spielfeld,spielerPosX[spielernum]-1,spielerPosY[spielernum],false);     //4
        umgebung[5] = Simulationen.getWesten(spielfeld,spielerPosX[spielernum],spielerPosY[spielernum],false);          //5
        umgebung[6] = 'P';                                                                                                   //6
        umgebung[7] = Simulationen.getOsten(spielfeld,spielerPosX[spielernum],spielerPosY[spielernum],false);           //7
        umgebung[8] = Simulationen.getOsten(spielfeld,spielerPosX[spielernum]+1,spielerPosY[spielernum],false);      //8
        umgebung[9] = Simulationen.getSuedWest(spielfeld,spielerPosX[spielernum],spielerPosY[spielernum],false);        //9
        umgebung[10] = Simulationen.getSueden(spielfeld,spielerPosX[spielernum],spielerPosY[spielernum],false);         //10
        umgebung[11] = Simulationen.getSuedOst(spielfeld,spielerPosX[spielernum],spielerPosY[spielernum],false);        //11
        umgebung[12] = Simulationen.getSueden(spielfeld,spielerPosX[spielernum],spielerPosY[spielernum]+1,false);    //12

        /*Umgebung:
               0
           1   2   3
       4   5  6(P) 7   8
           9   10  11
               12
         */
        return umgebung;
    }

    /**
     * bewegt Spieler zufällig; unterscheidet zwischen hinten und vorne
     * @param spielernum Spielernummer
     * @param teamPos Position im Team
     */
    public static void bewegeSpieler(int spielernum,int teamPos) {

        int richtung = (int) (Math.random() * 6);
        if(spielernum<4) {
            if (teamPos > 1) { // Angriff
                // Random Schritte: (Manipuliert um eher nach links/rechts zu gehen)

                if (richtung == 0 || richtung == 4) { // Schritt nach rechts
                    if (spielerPosX[spielernum] < spielfeld.length - 2) {
                        spielerPosX[spielernum]++;
                    }else { // Falls Spieler in Wand laufen würde, wird er jetzt erneut berechnet
                        bewegeSpieler(spielernum, teamPos);
                    }

                } else if (richtung == 1  || richtung == 5) { // Schritt nach links
                    if (spielerPosX[spielernum] > 1) {
                        spielerPosX[spielernum]--;
                    }else { // Falls Spieler in Wand laufen würde, wird er jetzt erneut berechnet
                        bewegeSpieler(spielernum, teamPos);
                    }

                } else if (richtung == 2) { // Schritt nach oben
                    if (spielerPosY[spielernum] > 1) {
                        spielerPosY[spielernum]--;
                    }else { // Falls Spieler in Wand laufen würde, wird er jetzt erneut berechnet
                        bewegeSpieler(spielernum, teamPos);
                    }

                } else if (richtung == 3) { // Schritt nach unten
                    if (spielerPosY[spielernum] < spielfeld[0].length - 2) {
                        spielerPosY[spielernum]++;
                    }else { // Falls Spieler in Wand laufen würde, wird er jetzt erneut berechnet
                        bewegeSpieler(spielernum, teamPos);
                    }
                }
            } else { //Verteidigung?!
                // Random Schritte: (manipuliert um eher nach oben/unten zu gehen)

                if (richtung == 0) { // Schritt nach rechts
                    if (spielerPosX[spielernum] < spielfeld.length - 2) {
                        spielerPosX[spielernum]++;
                    } else { // Falls Spieler in Wand laufen würde, wird er jetzt erneut berechnet
                        bewegeSpieler(spielernum, teamPos);
                    }

                } else if (richtung == 1) { // Schritt nach links
                    if (spielerPosX[spielernum] > 1) {
                        spielerPosX[spielernum]--;
                    }else { // Falls Spieler in Wand laufen würde, wird er jetzt erneut berechnet
                        bewegeSpieler(spielernum, teamPos);
                    }

                } else if (richtung == 2 || richtung == 4) { // Schritt nach oben
                    if (spielerPosY[spielernum] > 1) {
                        spielerPosY[spielernum]--;
                    }else { // Falls Spieler in Wand laufen würde, wird er jetzt erneut berechnet
                        bewegeSpieler(spielernum, teamPos);
                    }

                } else if (richtung == 3 || richtung == 5) { // Schritt nach unten
                    if (spielerPosY[spielernum] < spielfeld[0].length - 2) {
                        spielerPosY[spielernum]++;
                    }else { // Falls Spieler in Wand laufen würde, wird er jetzt erneut berechnet
                        bewegeSpieler(spielernum, teamPos);
                    }

                }
            }
        } else{
            if (teamPos < 2) { // Angriff
                // Random Schritte: (Manipuliert um eher nach links/rechts zu gehen)

                if (richtung == 0 || richtung == 4) { // Schritt nach rechts
                    if (spielerPosX[spielernum] < spielfeld.length - 2) {
                        spielerPosX[spielernum]++;
                    }else { // Falls Spieler in Wand laufen würde, wird er jetzt erneut berechnet
                        bewegeSpieler(spielernum, teamPos);
                    }

                } else if (richtung == 1 || richtung == 5) { // Schritt nach links
                    if (spielerPosX[spielernum] > 1) {
                        spielerPosX[spielernum]--;
                    }else { // Falls Spieler in Wand laufen würde, wird er jetzt erneut berechnet
                        bewegeSpieler(spielernum, teamPos);
                    }

                } else if (richtung == 2) { // Schritt nach oben
                    if (spielerPosY[spielernum] > 1) {
                        spielerPosY[spielernum]--;
                    }else { // Falls Spieler in Wand laufen würde, wird er jetzt erneut berechnet
                        bewegeSpieler(spielernum, teamPos);
                    }

                } else if (richtung == 3) { // Schritt nach unten
                    if (spielerPosY[spielernum] < spielfeld[0].length - 2) {
                        spielerPosY[spielernum]++;
                    }else { // Falls Spieler in Wand laufen würde, wird er jetzt erneut berechnet
                        bewegeSpieler(spielernum, teamPos);
                    }
                }

            } else { //Verteidigung?!
                // Random Schritte: (manipuliert um eher nach oben/unten zu gehen)

                if (richtung == 0) { // Schritt nach rechts
                    if (spielerPosX[spielernum] < spielfeld.length - 2) {
                        spielerPosX[spielernum]++;
                    } else { // Falls Spieler in Wand laufen würde, wird er jetzt erneut berechnet
                        bewegeSpieler(spielernum, teamPos);
                    }

                } else if (richtung == 1) { // Schritt nach links
                    if (spielerPosX[spielernum] > 1) {
                        spielerPosX[spielernum]--;
                    }else { // Falls Spieler in Wand laufen würde, wird er jetzt erneut berechnet
                        bewegeSpieler(spielernum, teamPos);
                    }

                } else if (richtung == 2 || richtung == 4) { // Schritt nach oben
                    if (spielerPosY[spielernum] > 1) {
                        spielerPosY[spielernum]--;
                    }else { // Falls Spieler in Wand laufen würde, wird er jetzt erneut berechnet
                        bewegeSpieler(spielernum, teamPos);
                    }

                } else if (richtung == 3 || richtung == 5) { // Schritt nach unten
                    if (spielerPosY[spielernum] < spielfeld[0].length - 2) {
                        spielerPosY[spielernum]++;
                    }else { // Falls Spieler in Wand laufen würde, wird er jetzt erneut berechnet
                        bewegeSpieler(spielernum, teamPos);
                    }

                }
            }
        }
    }

    /**
     * Besigt andere Spieler, falls diese 1 fällt entfernt sind
     * @param spielernum Spielernummer
     * @param umgebungCount normal 1; durch rekursion
     */
    public static void attack (int spielernum, int umgebungCount) {

        char[] umgebung = scanneUmgebung(spielernum);

            /*Umgebung:
                   0
               1   2   3
           4   5  6(P) 7   8
               9   10  11
                   12
             */
        if (Simulationen.zaehlenVier(spielfeld, spielerPosX[spielernum], spielerPosY[spielernum], 'P', false) > 0) {
            if (umgebung[2] == 'P') { //N
                int x;
                int y;
                int spielernum2 = spielernum;
                //Finde spieler in der Nähe
                int count = umgebungCount;
                for (int i = 0; i < 8; i++) {
                    if (spielerPosX[spielernum] == spielerPosX[i] && (spielerPosY[spielernum]-1) == spielerPosY[i]) {
                        x = spielerPosX[i];
                        y = spielerPosY[i];
                        spielernum2 = i;
                        count--;
                        if (count == 0) {
                            break;
                        }
                    }
                }
                if (spielernum < 4) {
                    if (spielernum2 > 3) {
                        spielerPosY[spielernum]--;
                        spielerPosX[spielernum2] = -1;
                        spielerPosY[spielernum2] = -1;
                        spielerBewegt = true;
                    } else {
                        if(umgebungCount<4) {
                            attack(spielernum, umgebungCount + 1);
                        }
                    }
                } else {
                    if (spielernum2 < 4) {
                        spielerPosY[spielernum]--;
                        spielerPosX[spielernum2] = -1;
                        spielerPosY[spielernum2] = -1;
                        spielerBewegt = true;
                    } else {
                        if(umgebungCount<4) {
                            attack(spielernum, umgebungCount + 1);
                        }
                    }
                }
            } else if (umgebung[5] == 'P') { //O
                int x;
                int y;
                int spielernum2 = spielernum;

                int count = umgebungCount;
                for (int i = 0; i < 8; i++) {
                    if ((spielerPosX[spielernum]+1) == spielerPosX[i] && spielerPosY[spielernum] == spielerPosY[i]) {
                        x = spielerPosX[i];
                        y = spielerPosY[i];
                        spielernum2 = i;
                        count--;
                        if (count == 0) {
                            break;
                        }
                    }
                }
                if (spielernum < 4) {
                    if (spielernum2 > 3) {
                        spielerPosX[spielernum]--;
                        spielerPosX[spielernum2] = -1;
                        spielerPosY[spielernum2] = -1;
                        spielerBewegt = true;
                    } else {
                        if(umgebungCount<4) {
                            attack(spielernum, umgebungCount + 1);
                        }
                    }
                } else {
                    if (spielernum2 < 4) {
                        spielerPosX[spielernum]--;
                        spielerPosX[spielernum2] = -1;
                        spielerPosY[spielernum2] = -1;
                        spielerBewegt = true;
                    } else {
                        if(umgebungCount<4) {
                            attack(spielernum, umgebungCount + 1);
                        }
                    }
                }
            } else if (umgebung[7] == 'P') { //W
                int x;
                int y;
                int spielernum2 = spielernum;

                int count = umgebungCount;
                for (int i = 0; i < 8; i++) {
                    if ((spielerPosX[spielernum]-1) == spielerPosX[i] && spielerPosY[spielernum] == spielerPosY[i]) {
                        x = spielerPosX[i];
                        y = spielerPosY[i];
                        spielernum2 = i;
                        count--;
                        if (count == 0) {
                            break;
                        }
                    }
                }
                if (spielernum < 4) {
                    if (spielernum2 > 3) {
                        spielerPosX[spielernum]++;
                        spielerPosX[spielernum2] = -1;
                        spielerPosY[spielernum2] = -1;
                        spielerBewegt = true;
                    } else {
                        if(umgebungCount<4) {
                            attack(spielernum, umgebungCount + 1);
                        }
                    }
                } else {
                    if (spielernum2 < 4) {
                        spielerPosX[spielernum]++;
                        spielerPosX[spielernum2] = -1;
                        spielerPosY[spielernum2] = -1;
                        spielerBewegt = true;
                    } else {
                        if(umgebungCount<4) {
                            attack(spielernum, umgebungCount + 1);
                        }
                    }
                }
            } else if (umgebung[10] == 'P') { //S
                int x;
                int y;
                int spielernum2 = spielernum;

                int count = umgebungCount;
                for (int i = 0; i < 8; i++) {
                    if (spielerPosX[spielernum] == spielerPosX[i] && (spielerPosY[spielernum]+1) == spielerPosY[i]) {
                        x = spielerPosX[i];
                        y = spielerPosY[i];
                        spielernum2 = i;
                        count--;
                        if (count == 0) {
                            break;
                        }
                    }
                }
                if (spielernum < 4) {
                    if (spielernum2 > 3) {
                        spielerPosY[spielernum]++;
                        spielerPosX[spielernum2] = -1;
                        spielerPosY[spielernum2] = -1;
                        spielerBewegt = true;
                    } else {
                        if(umgebungCount<4) {
                            attack(spielernum, umgebungCount + 1);
                        }
                    }
                } else {
                    if (spielernum2 < 4) {
                        spielerPosY[spielernum]++;
                        spielerPosX[spielernum2] = -1;
                        spielerPosY[spielernum2] = -1;
                        spielerBewegt = true;
                    } else {
                        if(umgebungCount<4) {
                            attack(spielernum, umgebungCount + 1);
                        }
                    }
                }
            }
        }
    }

    /**
     * Verfolgt die Spur des gegnerischen Teams, falls es auf dieses stößt
     * @param spielernum Spielernummer
     */
    public static void follow(int spielernum){
        char farbeGegner = '7';

        if (spielernum < 4) {
            farbeGegner = '9';
        }

        char[] umgebung = scanneUmgebung(spielernum);
                    /*Umgebung:
                   0
               1   2   3
           4   5  6(P) 7   8
               9   10  11
                   12
             */
        if(umgebung[2] == farbeGegner){
            if(umgebung[0] != 'P' && umgebung[1] !='P' && umgebung[3] != 'P'){
                spielerPosY[spielernum] -= 1;
                spielerBewegt = true;
                return;
            }
        }
        if(umgebung[5] == farbeGegner){
            if(umgebung[4] != 'P' && umgebung[1] !='P' && umgebung[9] != 'P'){
                spielerPosX[spielernum] -= 1;
                spielerBewegt = true;
                return;
            }
        }
        if(umgebung[7] == farbeGegner){
            if(umgebung[8] != 'P' && umgebung[3] !='P' && umgebung[11] != 'P'){
                spielerPosX[spielernum] +=1;
                spielerBewegt = true;
                return;
            }
        }
        if(umgebung[10] == farbeGegner){
            if(umgebung[9] != 'P' && umgebung[12] !='P' && umgebung[11] != 'P'){
                spielerPosY[spielernum] +=1;
                spielerBewegt = true;
            }
        }
    }

    /**
     * Zug1
     * @param spielernum Spielernummer
     */
    public static void zug1 (int spielernum) {
        if ((spielerPosX[spielernum] != -1) && (spielerPosY[spielernum] != -1)) {
            if (spielernum > 3) {
                spielfeld[spielerPosX[spielernum]][spielerPosY[spielernum]] = '9';
            } else {
                spielfeld[spielerPosX[spielernum]][spielerPosY[spielernum]] = '7';
            }



            spielerBewegt = false;
            //Gegner angreifen, falls 1 Block entfernt:
            attack(spielernum,1);

            if(spielerBewegt==false){
                follow(spielernum);
            }

            if(spielerBewegt == false) {
                //Angriff oder Verteidigung
                int[] team = new int[4];
                if (spielernum < 4) {
                    for (int i = 0; i < 4; i++) {
                        team[i] = spielerPosX[i];
                    }
                } else {
                    for (int i = 0; i < 4; i++) {
                        team[i] = spielerPosX[i + 4];
                    }
                }

                team = BubbleSort.bubbleSort(team);
                int teamPos = 0;
                for (int i = 0; i < 4; i++) {
                    if (team[i] == spielerPosX[spielernum]) {
                        teamPos = i;
                    }
                }

                bewegeSpieler(spielernum, teamPos);
            }
            spielfeld[spielerPosX[spielernum]][spielerPosY[spielernum]] = 'P';
        }
    }

    /**
     * Zug2 (ruft zug 1 auf)
     * @param spielernum Spielernummer
     */
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
