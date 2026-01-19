package blatt14;

import schisch_visualizer.*;

public class Steine {
    static char[][] spielfeld;
    static SchischVisualizer sv = new SchischVisualizer();
    static char[] elementData = new char[2];
    static int[] elementPos =  new int[2];
    static int clearRowCount = 0;
    static char[][] endFeld = MultiArrays.createEmpty2DCharArray(10,40);
    /**
     * Erstellt ein Spielfeld, ohne es im Schisch Visualizer zu initialisieren
     * @param a breite des Spielfeldes
     * @param b laenge des Spielfelds
     */
    public static void initialisiereSpielfeld(int a, int b){
        spielfeld =  MultiArrays.createEmpty2DCharArray(a,b);
        for(int i = 0; i < spielfeld.length; i++){
            for(int j = 0; j < spielfeld[i].length; j++){
                spielfeld[i][j] = '0';
            }
        }
    }

    /**
     * Zeichnet das Tetris-Element I
     * @param startpunktX ab dort wird gezeichnet (Erster block, danach wird nur rechts Blöcke hinzugefügt)
     * @param startpunktY ab dort wird gezeichnet (Erster Block, danach nur nach unten Blöcke hinzugefügt)
     * @param farbe Das zeichen, mit dem das Objekt gezeichnet wird
     * @param orientierung 'N'/'S' := 4er-Reihe senkrecht ; 'O'/'W' := 4er-Reihe waagerecht
     */
    public static void zeichneI (int startpunktX, int startpunktY, char orientierung, char farbe){
        if (orientierung == 'O' || orientierung == 'W') {
            spielfeld[startpunktX][startpunktY] = farbe;
            spielfeld[startpunktX+1][startpunktY] = farbe;
            spielfeld[startpunktX+2][startpunktY] = farbe;
            spielfeld[startpunktX+3][startpunktY] = farbe;
        } else if (orientierung == 'N' || orientierung == 'S') {
            spielfeld[startpunktX][startpunktY] = farbe;
            spielfeld[startpunktX][startpunktY+1] = farbe;
            spielfeld[startpunktX][startpunktY+2] = farbe;
            spielfeld[startpunktX][startpunktY+3] = farbe;
        }
    }

    /**
     * Zeichnet das Tetris-Element O
     * @param startpunktX ab dort wird gezeichnet (Erster block, danach wird nur rechts Blöcke hinzugefügt)
     * @param startpunktY ab dort wird gezeichnet (Erster Block, danach nur nach unten Blöcke hinzugefügt)
     * @param farbe Das zeichen, mit dem das Objekt gezeichnet wird
     */
    public static void zeichneO (int startpunktX, int startpunktY, char farbe){
        spielfeld[startpunktX][startpunktY] = farbe;
        spielfeld[startpunktX+1][startpunktY] = farbe;
        spielfeld[startpunktX][startpunktY+1] = farbe;
        spielfeld[startpunktX+1][startpunktY+1] = farbe;

    }

    /**
     * Zeichnet das Tetris-Element T
     * @param startpunktX ab dort wird gezeichnet (Erster block, danach wird nur rechts Blöcke hinzugefügt)
     * @param startpunktY ab dort wird gezeichnet (Erster Block, danach nur nach unten Blöcke hinzugefügt)
     * @param farbe Das zeichen, mit dem das Objekt gezeichnet wird
     * @param orientierung 'N' := 3er-Reihe unten + 1 Block oben mittig ; 'O' := 3er-Reihe senkrecht + rechts 1 Block mittig ;
     *                     'S' := 3er-Reihe oben + 1 Block unten mittig ; 'W' := 3er-Reihe senkrecht + links 1 Block mittig
     */
    public static void zeichneT (int startpunktX,int startpunktY, char orientierung, char farbe){
        if (orientierung == 'N') {
            spielfeld[startpunktX][startpunktY+1] = farbe;
            spielfeld[startpunktX+1][startpunktY] = farbe;
            spielfeld[startpunktX+1][startpunktY+1] = farbe;
            spielfeld[startpunktX+2][startpunktY+1] = farbe;
        } else if (orientierung == 'S') {
            spielfeld[startpunktX][startpunktY] = farbe;
            spielfeld[startpunktX+1][startpunktY] = farbe;
            spielfeld[startpunktX+1][startpunktY+1] = farbe;
            spielfeld[startpunktX+2][startpunktY] = farbe;
        } else if (orientierung == 'O') {
            spielfeld[startpunktX][startpunktY] = farbe;
            spielfeld[startpunktX][startpunktY+1] = farbe;
            spielfeld[startpunktX+1][startpunktY+1] = farbe;
            spielfeld[startpunktX][startpunktY+2] = farbe;
        } else if (orientierung == 'W') {
            spielfeld[startpunktX+1][startpunktY] = farbe;
            spielfeld[startpunktX][startpunktY+1] = farbe;
            spielfeld[startpunktX+1][startpunktY+1] = farbe;
            spielfeld[startpunktX+1][startpunktY+2] = farbe;
        }
    }

    /**
     * Zeichnet das Tetris-Element S
     * @param startpunktX ab dort wird gezeichnet (Erster block, danach wird nur rechts Blöcke hinzugefügt)
     * @param startpunktY ab dort wird gezeichnet (Erster Block, danach nur nach unten Blöcke hinzugefügt)
     * @param farbe Das zeichen, mit dem das Objekt gezeichnet wird
     * @param orientierung 'N'/'S' := 2er-Reihe oben um 1 nach links versetzt + unten 2er-Reihe, beginnt bei startpunktX ; 'O'/'W' := 2er-Reihe vertikal + 2-er Reihe rechts davon um 1 nach unten gesetzt ebenfalls vertikal ;
     */
    public static void zeichneS (int startpunktX, int startpunktY, char orientierung, char farbe){
        if (orientierung == 'N'||  orientierung == 'S') {
            spielfeld[startpunktX+1][startpunktY] = farbe;
            spielfeld[startpunktX+2][startpunktY] = farbe;
            spielfeld[startpunktX][startpunktY+1] = farbe;
            spielfeld[startpunktX+1][startpunktY+1] = farbe;
        } else if (orientierung == 'O' || orientierung == 'W') {
            spielfeld[startpunktX][startpunktY] = farbe;
            spielfeld[startpunktX][startpunktY + 1] = farbe;
            spielfeld[startpunktX + 1][startpunktY + 1] = farbe;
            spielfeld[startpunktX + 1][startpunktY + 2] = farbe;
        }
    }

    /**
     * Zeichnet das Tetris-Element Z
     * @param startpunktX ab dort wird gezeichnet (Erster block, danach wird nur rechts Blöcke hinzugefügt)
     * @param startpunktY ab dort wird gezeichnet (Erster Block, danach nur nach unten Blöcke hinzugefügt)
     * @param farbe Das zeichen, mit dem das Objekt gezeichnet wird
     * @param orientierung 'N'/'S' := 2er-Reihe oben um 1 nach links versetzt + unten 2er-Reihe, beginnt bei startpunktX ; 'O'/'W' := 2er-Reihe vertikal + 2-er Reihe rechts davon um 1 nach unten gesetzt ebenfalls vertikal ;
     */
    public static void zeichneZ (int startpunktX, int startpunktY, char orientierung, char farbe){
        if (orientierung == 'N' || orientierung == 'S') {
            spielfeld[startpunktX+1][startpunktY+1] = farbe;
            spielfeld[startpunktX+2][startpunktY+1] = farbe;
            spielfeld[startpunktX][startpunktY] = farbe;
            spielfeld[startpunktX+1][startpunktY] = farbe;
        } else if (orientierung == 'O'||orientierung == 'W') {
            spielfeld[startpunktX][startpunktY+1] = farbe;
            spielfeld[startpunktX][startpunktY+2] = farbe;
            spielfeld[startpunktX+1][startpunktY] = farbe;
            spielfeld[startpunktX+1][startpunktY+1] = farbe;
        }
    }

    /**
     * Zeichnet das Tetris-Element J
     * @param startpunktX ab dort wird gezeichnet (Erster block, danach wird nur rechts Blöcke hinzugefügt)
     * @param startpunktY ab dort wird gezeichnet (Erster Block, danach nur nach unten Blöcke hinzugefügt)
     * @param farbe Das zeichen, mit dem das Objekt gezeichnet wird
     * @param orientierung 'N' := 3er-Reihe unten + 1 Block oben links ; 'O' := 3er-Reihe senkrecht + rechts 1 Block oben ;
     *                     'S' := 3er-Reihe oben + 1 Block unten rechts ; 'W' := 3er-Reihe senkrecht + links 1 Block unten
     */
    public static void zeichneJ (int startpunktX, int startpunktY, char orientierung, char farbe){
        if (orientierung == 'N') {
            spielfeld[startpunktX][startpunktY+1] = farbe;
            spielfeld[startpunktX][startpunktY] = farbe;
            spielfeld[startpunktX+1][startpunktY+1] = farbe;
            spielfeld[startpunktX+2][startpunktY+1] = farbe;
        } else if (orientierung == 'S') {
            spielfeld[startpunktX][startpunktY] = farbe;
            spielfeld[startpunktX+1][startpunktY] = farbe;
            spielfeld[startpunktX+2][startpunktY+1] = farbe;
            spielfeld[startpunktX+2][startpunktY] = farbe;
        } else if (orientierung == 'O') {
            spielfeld[startpunktX][startpunktY] = farbe;
            spielfeld[startpunktX][startpunktY+1] = farbe;
            spielfeld[startpunktX+1][startpunktY] = farbe;
            spielfeld[startpunktX][startpunktY+2] = farbe;
        } else if (orientierung == 'W') {
            spielfeld[startpunktX+1][startpunktY] = farbe;
            spielfeld[startpunktX][startpunktY+2] = farbe;
            spielfeld[startpunktX+1][startpunktY+1] = farbe;
            spielfeld[startpunktX+1][startpunktY+2] = farbe;
        }
    }

    /**
     * Zeichnet das Tetris-Element L
     * @param startpunktX ab dort wird gezeichnet (Erster block, danach wird nur rechts Blöcke hinzugefügt)
     * @param startpunktY ab dort wird gezeichnet (Erster Block, danach nur nach unten Blöcke hinzugefügt)
     * @param farbe Das zeichen, mit dem das Objekt gezeichnet wird
     * @param orientierung 'N' := 3er-Reihe unten + 1 Block oben rechts ; 'O' := 3er-Reihe senkrecht + rechts 1 Block unten ;
     *                     'S' := 3er-Reihe oben + 1 Block unten links ; 'W' := 3er-Reihe senkrecht + links 1 Block oben
     */
    public static void zeichneL (int startpunktX, int startpunktY, char orientierung, char farbe){
        if (orientierung == 'N') {
            spielfeld[startpunktX][startpunktY+1] = farbe;
            spielfeld[startpunktX+2][startpunktY] = farbe;
            spielfeld[startpunktX+1][startpunktY+1] = farbe;
            spielfeld[startpunktX+2][startpunktY+1] = farbe;
        } else if (orientierung == 'S') {
            spielfeld[startpunktX][startpunktY] = farbe;
            spielfeld[startpunktX+1][startpunktY] = farbe;
            spielfeld[startpunktX][startpunktY+1] = farbe;
            spielfeld[startpunktX+2][startpunktY] = farbe;
        } else if (orientierung == 'O') {
            spielfeld[startpunktX][startpunktY] = farbe;
            spielfeld[startpunktX][startpunktY+1] = farbe;
            spielfeld[startpunktX+1][startpunktY+2] = farbe;
            spielfeld[startpunktX][startpunktY+2] = farbe;
        } else if (orientierung == 'W') {
            spielfeld[startpunktX+1][startpunktY] = farbe;
            spielfeld[startpunktX][startpunktY] = farbe;
            spielfeld[startpunktX+1][startpunktY+1] = farbe;
            spielfeld[startpunktX+1][startpunktY+2] = farbe;
        }
    }

    /**
     * erstellt ein Tetris-Element und speichert die daten in statischen Listen
     * @param element Gibt die Art des Elementes an
     */
    public static void genElement (char element){
        elementData[0] = element;
        int temp = (int)(Math.random()*4);
        switch (temp){
            case 0:
                elementData[1] = 'N';
                break;
            case 1:
                elementData[1] = 'O';
                break;
            case 2:
                elementData[1] = 'S';
                break;
            case 3:
                elementData[1] = 'W';
                break;
        }

        elementPos[1] = 0;
        switch(elementData[0]){
            case 'I':
                if(elementData[1] == 'O' || elementData[1] == 'W'){
                    elementPos[0] = (int)(Math.random()*(spielfeld.length-3));

                    if((spielfeld[elementPos[0]][elementPos[1]] != '0') || (spielfeld[elementPos[0]+1][elementPos[1]] != '0') || (spielfeld[elementPos[0]+2][elementPos[1]] != '0') || (spielfeld[elementPos[0]+3][elementPos[1]] != '0') ) {
                        spielfeld = endFeld;
                        sv.step(spielfeld);
                        return;
                    }
                } else{
                    elementPos[0] = (int)(Math.random()*(spielfeld.length));
                    if((spielfeld[elementPos[0]][elementPos[1]] != '0') || (spielfeld[elementPos[0]][elementPos[1]+1] != '0') || (spielfeld[elementPos[0]][elementPos[1]+2] != '0') || (spielfeld[elementPos[0]][elementPos[1]+3] != '0') ) {
                        spielfeld = endFeld;
                        sv.step(spielfeld);
                        return;
                    }
                }
                    zeichneI(elementPos[0], elementPos[1], elementData[1], '6');
                break;

            case 'O':
                elementPos[0] = (int)(Math.random()*(spielfeld.length-1));
                if((spielfeld[elementPos[0]][elementPos[1]] != '0') || (spielfeld[elementPos[0]][elementPos[1]+1] != '0') || (spielfeld[elementPos[0]+1][elementPos[1]] != '0') || (spielfeld[elementPos[0]+1][elementPos[1]+1] != '0') ) {
                    spielfeld = endFeld;
                    sv.step(spielfeld);
                    return;
                }
                zeichneO(elementPos[0], elementPos[1],'5');
                break;

            case 'T':
                if(elementData[1] == 'N'){
                    elementPos[0] = (int)(Math.random()*(spielfeld.length-2));
                    if((spielfeld[elementPos[0]+1][elementPos[1]] != '0') || (spielfeld[elementPos[0]][elementPos[1]+1] != '0') || (spielfeld[elementPos[0]+1][elementPos[1]+1] != '0') || (spielfeld[elementPos[0]+1][elementPos[1]+2] != '0') ) {
                        spielfeld = endFeld;
                        sv.step(spielfeld);
                        return;
                    }
                } else if(elementData[1] == 'S'){
                    elementPos[0] = (int)(Math.random()*(spielfeld.length-2));
                    if((spielfeld[elementPos[0]][elementPos[1]] != '0') || (spielfeld[elementPos[0]][elementPos[1]+1] != '0') || (spielfeld[elementPos[0]+1][elementPos[1]+1] != '0') || (spielfeld[elementPos[0]][elementPos[1]+2] != '0') ) {
                        spielfeld = endFeld;
                        sv.step(spielfeld);
                        return;
                    }
                } else if(elementData[1] == 'O'){
                    elementPos[0] = (int)(Math.random()*(spielfeld.length-2));
                    if((spielfeld[elementPos[0]][elementPos[1]] != '0') || (spielfeld[elementPos[0]][elementPos[1]+1] != '0') || (spielfeld[elementPos[0]][elementPos[1]+2] != '0') || (spielfeld[elementPos[0]+1][elementPos[1]+1] != '0') ) {
                        spielfeld = endFeld;
                        sv.step(spielfeld);
                        return;
                    }
                } else{
                    elementPos[0] = (int)(Math.random()*(spielfeld.length-2));
                    if((spielfeld[elementPos[0]+1][elementPos[1]] != '0') || (spielfeld[elementPos[0]][elementPos[1]+1] != '0') || (spielfeld[elementPos[0]+1][elementPos[1]+1] != '0') || (spielfeld[elementPos[0]+1][elementPos[1]+2] != '0') ) {
                        spielfeld = endFeld;
                        sv.step(spielfeld);
                        return;
                    }
                }

                zeichneT(elementPos[0], elementPos[1], elementData[1],'7');
                break;

            case 'S':
                if (elementData[1] == 'N' || elementData[1] == 'S'){
                    elementPos[0] = (int)(Math.random()*(spielfeld.length-2));
                    if((spielfeld[elementPos[0]][elementPos[1]+1] != '0') || (spielfeld[elementPos[0]+1][elementPos[1]] != '0') || (spielfeld[elementPos[0]+1][elementPos[1]+1] != '0') || (spielfeld[elementPos[0]+2][elementPos[1]] != '0') ) {
                        spielfeld = endFeld;
                        sv.step(spielfeld);
                        return;
                    }
                } else{
                    elementPos[0] = (int)(Math.random()*(spielfeld.length-1));
                    if((spielfeld[elementPos[0]][elementPos[1]] != '0') || (spielfeld[elementPos[0]][elementPos[1]+1] != '0') || (spielfeld[elementPos[0]+1][elementPos[1]+1] != '0') || (spielfeld[elementPos[0]+1][elementPos[1]+2] != '0') ) {
                        spielfeld = endFeld;
                        sv.step(spielfeld);
                        return;
                    }
                }
                zeichneS(elementPos[0], elementPos[1], elementData[1],'9');
                break;

            case 'Z':
                if (elementData[1] == 'N' || elementData[1] == 'S'){
                    elementPos[0] = (int)(Math.random()*(spielfeld.length-2));
                    if((spielfeld[elementPos[0]][elementPos[1]] != '0') || (spielfeld[elementPos[0]+1][elementPos[1]] != '0') || (spielfeld[elementPos[0]+1][elementPos[1]+1] != '0') || (spielfeld[elementPos[0]+2][elementPos[1]+1] != '0') ) {
                        spielfeld = endFeld;
                        sv.step(spielfeld);
                        return;
                    }
                } else{
                    elementPos[0] = (int)(Math.random()*(spielfeld.length-1));
                    if((spielfeld[elementPos[0]][elementPos[1]+1] != '0') || (spielfeld[elementPos[0]][elementPos[1]+2] != '0') || (spielfeld[elementPos[0]+1][elementPos[1]] != '0') || (spielfeld[elementPos[0]+1][elementPos[1]+1] != '0') ) {
                        spielfeld = endFeld;
                        sv.step(spielfeld);
                        return;
                    }
                }
                zeichneZ(elementPos[0], elementPos[1], elementData[1],'F');
                break;

            case 'J':
                if (elementData[1] == 'N'){
                    elementPos[0] = (int)(Math.random()*(spielfeld.length-2));
                    if((spielfeld[elementPos[0]][elementPos[1]] != '0') || (spielfeld[elementPos[0]][elementPos[1]+1] != '0') || (spielfeld[elementPos[0]+1][elementPos[1]+1] != '0') || (spielfeld[elementPos[0]+2][elementPos[1]+1] != '0') ) {
                        spielfeld = endFeld;
                        sv.step(spielfeld);
                        return;
                    }

                } else if (elementData[1] == 'S'){
                    elementPos[0] = (int)(Math.random()*(spielfeld.length-2));
                    if((spielfeld[elementPos[0]][elementPos[1]] != '0') || (spielfeld[elementPos[0]+1][elementPos[1]] != '0') || (spielfeld[elementPos[0]+2][elementPos[1]] != '0') || (spielfeld[elementPos[0]+2][elementPos[1]+1] != '0') ) {
                        spielfeld = endFeld;
                        sv.step(spielfeld);
                        return;
                    }

                } else if (elementData[1] == 'O'){
                    elementPos[0] = (int)(Math.random()*(spielfeld.length-2));
                    if((spielfeld[elementPos[0]][elementPos[1]] != '0') || (spielfeld[elementPos[0]+1][elementPos[1]] != '0') || (spielfeld[elementPos[0]][elementPos[1]+1] != '0') || (spielfeld[elementPos[0]][elementPos[1]+2] != '0') ) {
                        spielfeld = endFeld;
                        sv.step(spielfeld);
                        return;
                    }

                } else{
                    elementPos[0] = (int)(Math.random()*(spielfeld.length-1));

                    if((spielfeld[elementPos[0]][elementPos[1]+2] != '0') || (spielfeld[elementPos[0]+1][elementPos[1]] != '0') || (spielfeld[elementPos[0]+1][elementPos[1]+1] != '0') || (spielfeld[elementPos[0]+1][elementPos[1]+2] != '0') ) {
                        spielfeld = endFeld;
                        sv.step(spielfeld);
                        return;
                    }
                }
                zeichneJ(elementPos[0], elementPos[1], elementData[1],'2');
                break;

            case 'L':
                if (elementData[1] == 'N'){
                    elementPos[0] = (int)(Math.random()*(spielfeld.length-2));

                    if((spielfeld[elementPos[0]][elementPos[1]+1] != '0') || (spielfeld[elementPos[0]+1][elementPos[1]+1] != '0') || (spielfeld[elementPos[0]+2][elementPos[1]+1] != '0') || (spielfeld[elementPos[0]+2][elementPos[1]] != '0') ) {
                        spielfeld = endFeld;
                        sv.step(spielfeld);
                        return;
                    }
                } else if (elementData[1] == 'S'){
                    elementPos[0] = (int)(Math.random()*(spielfeld.length-2));

                    if((spielfeld[elementPos[0]][elementPos[1]] != '0') || (spielfeld[elementPos[0]][elementPos[1]+1] != '0') || (spielfeld[elementPos[0]+1][elementPos[1]] != '0') || (spielfeld[elementPos[0]+2][elementPos[1]] != '0') ) {
                        spielfeld = endFeld;
                        sv.step(spielfeld);
                        return;
                    }
                } else if (elementData[1] == 'O'){
                    elementPos[0] = (int)(Math.random()*(spielfeld.length-2));

                    if((spielfeld[elementPos[0]][elementPos[1]] != '0') || (spielfeld[elementPos[0]][elementPos[1]+1] != '0') || (spielfeld[elementPos[0]][elementPos[1]+2] != '0') || (spielfeld[elementPos[0]+1][elementPos[1]+2] != '0') ) {
                        spielfeld = endFeld;
                        sv.step(spielfeld);
                        return;
                    }
                } else {
                    elementPos[0] = (int)(Math.random()*(spielfeld.length-1));

                    if((spielfeld[elementPos[0]][elementPos[1]] != '0') || (spielfeld[elementPos[0]+1][elementPos[1]] != '0') || (spielfeld[elementPos[0]+1][elementPos[1]+1] != '0') || (spielfeld[elementPos[0]+1][elementPos[1]+2] != '0') ) {
                        spielfeld = endFeld;
                        sv.step(spielfeld);
                        return;
                    }
                }
                zeichneL(elementPos[0], elementPos[1], elementData[1],'A');
                break;
        }
        sv.step(spielfeld);
    }

    /**
     * bewegt das aktuelle Element (Tetris-Block) bis zum maximum nach unten!
     */
    public static void move (){
        switch(elementData[0]){
            case 'I':
                if(elementData[1] == 'N' || elementData[1] == 'S') {
                    if(elementPos[1] <=spielfeld[0].length-5) {
                        if (spielfeld[elementPos[0]][elementPos[1] + 4] == '0') {
                            zeichneI(elementPos[0], elementPos[1], elementData[1], '0');
                            elementPos[1]++;
                            zeichneI(elementPos[0], elementPos[1], elementData[1],'6');
                            sv.step(spielfeld);
                        };
                    }
                } else{
                    if(elementPos[1] <=spielfeld[0].length-2) {
                        if ((spielfeld[elementPos[0]][elementPos[1] + 1] == '0') && (spielfeld[elementPos[0] + 1][elementPos[1] + 1] == '0') && (spielfeld[elementPos[0] + 2][elementPos[1] + 1] == '0') && (spielfeld[elementPos[0] + 3][elementPos[1] + 1] == '0')) {
                            zeichneI(elementPos[0],elementPos[1], elementData[1], '0' );
                            elementPos[1]++;
                            zeichneI(elementPos[0], elementPos[1], elementData[1], '6');
                            sv.step(spielfeld);
                        }
                    }
                }
                break;

            case 'O':
                if(elementPos[1] <=spielfeld[0].length-3) {
                    if ((spielfeld[elementPos[0]][elementPos[1] + 2] == '0') && (spielfeld[elementPos[0] + 1][elementPos[1] + 2] == '0')) {
                        zeichneO(elementPos[0],elementPos[1],'0' );
                        elementPos[1]++;
                        zeichneO(elementPos[0],elementPos[1],'5' );
                        sv.step(spielfeld);
                    }
                }
                break;

            case 'T':
                if(elementData[1] == 'N') {
                    if(elementPos[1] <=spielfeld[0].length-3) {
                        if ((spielfeld[elementPos[0]][elementPos[1] + 2] == '0') && (spielfeld[elementPos[0] + 1][elementPos[1] + 2] == '0') && (spielfeld[elementPos[0] + 2][elementPos[1] + 2] == '0')) {
                            zeichneT(elementPos[0], elementPos[1], elementData[1], '0');
                            elementPos[1]++;
                            zeichneT(elementPos[0], elementPos[1], elementData[1],'7');
                            sv.step(spielfeld);
                        }
                    }
                } else if(elementData[1] == 'S') {
                    if(elementPos[1] <=spielfeld[0].length-3) {
                        if (spielfeld[elementPos[0] + 1][elementPos[1] + 2] == '0') {
                            zeichneT(elementPos[0], elementPos[1], elementData[1], '0');
                            elementPos[1]++;
                            zeichneT(elementPos[0], elementPos[1], elementData[1],'7');
                            sv.step(spielfeld);
                        };
                    }
                } else if(elementData[1] == 'O') {
                    if(elementPos[1] <=spielfeld[0].length-4) {
                        if ((spielfeld[elementPos[0]][elementPos[1] + 3] == '0') && (spielfeld[elementPos[0] + 1][elementPos[1] + 2] == '0')) {
                            zeichneT(elementPos[0], elementPos[1], elementData[1], '0');
                            elementPos[1]++;
                            zeichneT(elementPos[0], elementPos[1], elementData[1],'7');
                            sv.step(spielfeld);
                        }
                    }
                } else{
                    if(elementPos[1] <=spielfeld[0].length-4) {
                        if ((spielfeld[elementPos[0]][elementPos[1] + 2] == '0') && (spielfeld[elementPos[0] + 1][elementPos[1] + 3] == '0')) {
                            zeichneT(elementPos[0],elementPos[1], elementData[1], '0' );
                            elementPos[1]++;
                            zeichneT(elementPos[0], elementPos[1], elementData[1], '7');
                            sv.step(spielfeld);
                        }
                    }
                }
                break;

            case 'S':
                if(elementData[1] == 'N' || elementData[1] == 'S') {
                    if(elementPos[1] <=spielfeld[0].length-3) {
                        if ((spielfeld[elementPos[0]][elementPos[1] + 2] == '0') && (spielfeld[elementPos[0] + 1][elementPos[1] + 2] == '0') && (spielfeld[elementPos[0] + 2][elementPos[1] + 1] == '0')) {
                            zeichneS(elementPos[0], elementPos[1], elementData[1], '0');
                            elementPos[1]++;
                            zeichneS(elementPos[0], elementPos[1], elementData[1],'9');
                            sv.step(spielfeld);
                        }
                    }
                }else {
                    if(elementPos[1] <=spielfeld[0].length-4) {
                        if ((spielfeld[elementPos[0]][elementPos[1] + 2] == '0') && (spielfeld[elementPos[0] + 1][elementPos[1] + 3] == '0')) {
                            zeichneS(elementPos[0],elementPos[1], elementData[1], '0' );
                            elementPos[1]++;
                            zeichneS(elementPos[0], elementPos[1], elementData[1], '9');
                            sv.step(spielfeld);
                        }
                    }
                }
                break;

            case 'Z':
                if(elementData[1] == 'N' || elementData[1] == 'S') {
                    if(elementPos[1] <=spielfeld[0].length-3) {
                        if ((spielfeld[elementPos[0]][elementPos[1] + 1] == '0') && (spielfeld[elementPos[0] + 1][elementPos[1] + 2] == '0') && (spielfeld[elementPos[0] + 2][elementPos[1] + 2] == '0')) {
                            zeichneZ(elementPos[0], elementPos[1], elementData[1], '0');
                            elementPos[1]++;
                            zeichneZ(elementPos[0], elementPos[1], elementData[1],'F');
                            sv.step(spielfeld);
                        }
                    }
                }else {
                    if(elementPos[1] <=spielfeld[0].length-4) {
                        if ((spielfeld[elementPos[0]][elementPos[1] + 3] == '0') && (spielfeld[elementPos[0] + 1][elementPos[1] + 2] == '0')) {
                            zeichneZ(elementPos[0],elementPos[1], elementData[1], '0' );
                            elementPos[1]++;
                            zeichneZ(elementPos[0], elementPos[1], elementData[1], 'F');
                            sv.step(spielfeld);
                        }
                    }
                }
                break;
            case 'J':
                if(elementData[1] == 'N') {
                    if(elementPos[1] <=spielfeld[0].length-3) {
                        if ((spielfeld[elementPos[0]][elementPos[1] + 2] == '0') && (spielfeld[elementPos[0] + 1][elementPos[1] + 2] == '0') && (spielfeld[elementPos[0] + 2][elementPos[1] + 2] == '0')) {
                            zeichneJ(elementPos[0], elementPos[1], elementData[1], '0');
                            elementPos[1]++;
                            zeichneJ(elementPos[0], elementPos[1], elementData[1],'2');
                            sv.step(spielfeld);
                        }
                    }
                } else if(elementData[1] == 'S') {
                    if(elementPos[1] <=spielfeld[0].length-3) {
                        if ((spielfeld[elementPos[0]][elementPos[1] + 1] == '0') && (spielfeld[elementPos[0] + 1][elementPos[1] + 1] == '0') && (spielfeld[elementPos[0] + 2][elementPos[1] + 2] == '0')) {
                            zeichneJ(elementPos[0], elementPos[1], elementData[1], '0');
                            elementPos[1]++;
                            zeichneJ(elementPos[0], elementPos[1], elementData[1],'2');
                            sv.step(spielfeld);
                        };
                    }
                } else if(elementData[1] == 'O') {
                    if(elementPos[1] <=spielfeld[0].length-4) {
                        if ((spielfeld[elementPos[0]][elementPos[1] + 3] == '0') && (spielfeld[elementPos[0] + 1][elementPos[1] + 1] == '0')) {
                            zeichneJ(elementPos[0], elementPos[1], elementData[1], '0');
                            elementPos[1]++;
                            zeichneJ(elementPos[0], elementPos[1], elementData[1],'2');
                            sv.step(spielfeld);
                        }
                    }
                } else{
                    if(elementPos[1] <=spielfeld[0].length-4) {
                        if ((spielfeld[elementPos[0]][elementPos[1] + 3] == '0') && (spielfeld[elementPos[0] + 1][elementPos[1] + 3] == '0')) {
                            zeichneJ(elementPos[0],elementPos[1], elementData[1], '0' );
                            elementPos[1]++;
                            zeichneJ(elementPos[0], elementPos[1], elementData[1], '2');
                            sv.step(spielfeld);
                        }
                    }
                }
                break;
            case 'L':
                if(elementData[1] == 'N') {
                    if(elementPos[1] <=spielfeld[0].length-3) {
                        if ((spielfeld[elementPos[0]][elementPos[1] + 2] == '0') && (spielfeld[elementPos[0] + 1][elementPos[1] + 2] == '0') && (spielfeld[elementPos[0] + 2][elementPos[1] + 2] == '0')) {
                            zeichneL(elementPos[0], elementPos[1], elementData[1], '0');
                            elementPos[1]++;
                            zeichneL(elementPos[0], elementPos[1], elementData[1],'A');
                            sv.step(spielfeld);
                        }
                    }
                } else if(elementData[1] == 'S') {
                    if(elementPos[1] <=spielfeld[0].length-3) {
                        if ((spielfeld[elementPos[0]][elementPos[1] + 2] == '0') && (spielfeld[elementPos[0] + 1][elementPos[1] + 1] == '0') && (spielfeld[elementPos[0] + 2][elementPos[1] + 1] == '0')) {
                            zeichneL(elementPos[0], elementPos[1], elementData[1], '0');
                            elementPos[1]++;
                            zeichneL(elementPos[0], elementPos[1], elementData[1],'A');
                            sv.step(spielfeld);
                        };
                    }
                } else if(elementData[1] == 'O') {
                    if(elementPos[1] <=spielfeld[0].length-4) {
                        if ((spielfeld[elementPos[0]][elementPos[1] + 3] == '0') && (spielfeld[elementPos[0] + 1][elementPos[1] + 3] == '0')) {
                            zeichneL(elementPos[0], elementPos[1], elementData[1], '0');
                            elementPos[1]++;
                            zeichneL(elementPos[0], elementPos[1], elementData[1],'A');
                            sv.step(spielfeld);
                        }
                    }
                } else{
                    if(elementPos[1] <=spielfeld[0].length-4) {
                        if ((spielfeld[elementPos[0]][elementPos[1] + 1] == '0') && (spielfeld[elementPos[0] + 1][elementPos[1] + 3] == '0')) {
                            zeichneL(elementPos[0],elementPos[1], elementData[1], '0' );
                            elementPos[1]++;
                            zeichneL(elementPos[0], elementPos[1], elementData[1], 'A');
                            sv.step(spielfeld);
                        }
                    }
                }
                break;

        }
    }

    public static void clearRow(){
        for(int j=0;j<spielfeld[0].length;j++){
            int counter =0;
            for(int i=0;i<spielfeld.length;i++){
                if(spielfeld[i][j]!='0'){
                    counter++;
                }
            }
            if(counter==spielfeld.length){
                for(int i=spielfeld.length-1;i>=0;i--){
                    for(int k = j;k>0;k--){
                        spielfeld[i][k]=spielfeld[i][k-1];
                    }
                }
                for(int i=spielfeld.length-1;i>=0;i--){
                    spielfeld[i][0]='0';
                }
                clearRowCount++;
                sv.step(spielfeld);
            }
        }
    }

    public static void simulator(int anzahl){
        for (int i = 0; i < anzahl; i++) {
            int temp = (int)(Math.random()*7);
            switch(temp){
                case 0:
                    genElement('I');
                    break;
                case 1:
                    genElement('O');
                    break;
                case 2:
                    genElement('T');
                    break;
                case 3:
                    genElement('S');
                    break;
                case 4:
                    genElement('Z');
                    break;
                case 5:
                    genElement('J');
                    break;
                case 6:
                    genElement('L');
            }

            for (int j = 0; j < 39; j++) {
                move();
            }
            clearRow();

            for (int j = 0; j < spielfeld.length; j++) {
                if(spielfeld[j][0]!='0'){
                    System.out.println("Ende!!! Es wurden " + (clearRowCount) + " Reihen gelöscht.");
                    return;
                }
            }
        }
    }

    public static void main(String args[]) {
        initialisiereSpielfeld(10,40);
        sv.step(spielfeld);
        for(int i=0;i<endFeld.length;i++){
            for(int j=0;j<endFeld[i].length;j++){
                endFeld[i][j] = '1';
            }
        }

        simulator(100);
        sv.start();
    }
}
