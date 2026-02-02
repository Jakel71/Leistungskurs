package blatt14;

import schisch_visualizer.*;

public class Simulationen {
    static char[][] spielfeld;

    /**
     * Füllt ein 2D-char Array mit einem Zeichen
     * @param arr 2D Char array
     * @param zeichen Einzusetzendes Zeichen
     * @param wahrsch Wahrscheinlichkeit des Einsetzens
     * @return gefülltes Array
     */
    public static char[][] fuellen(char[][] arr,char zeichen, double wahrsch){
        for(int j=0;j<arr.length;j++){
            for(int k=0;k<arr[j].length;k++){
                if(Math.random()<=wahrsch){
                    arr[j][k] = zeichen;
                }
            }
        }
        return arr;
    }

    /**
     * Füllt ein 2D-char Array mit einem Zeichen
     * @param arr 2D Char array
     * @param norm Zeichen, welches überschrieben werden soll
     * @param zeichen Einzusetzendes Zeichen
     * @param wahrsch Wahrscheinlichkeit des Einsetzens
     * @return gefülltes Array
     */
    public static char[][] fuellen(char[][] arr,char norm,char zeichen, double wahrsch){
        for(int j=0;j<arr.length;j++){
            for(int k=0;k<arr[j].length;k++){
                if(Math.random()<=wahrsch){
                    if (arr[j][k] == norm) {
                        arr[j][k] = zeichen;
                    }
                }
            }
        }
        return arr;
    }

    /**
     *platziert ein Element auf einem zufälligen Feld
     * @param arr Felder
     * @param zeichen Zeichen
     * @param dopplung sorgt dafür, das das Element tatsächlich platziert wird
     * @return Felder
     */
    public static char[][] platzieren(char[][] arr, char zeichen, boolean dopplung){
        while(true) {
            int posX = (int) (Math.random() * arr.length);
            int posY = (int) (Math.random() * arr[0].length);
            if(arr[posX][posY] != zeichen) {
                arr[posX][posY] = zeichen;
                break;
            }
        }
        return arr;
    }

    /**
     * Returned das Feld Nördlich
     * @param arr 2D-Char Array
     * @param x X-Koordinate
     * @param y Y-Koordinate
     * @param rand true: ohne berücksichtigung des Spielfeld rands;
     *             false: berücksichtigung des Spielfeldrandes (wird dann nichts returned)
     * @return
     */
    public static char getNorden(char[][] arr, int x, int y, boolean rand){
        if(rand) {
            if (y == 0) {
                y = arr[0].length;
            }

            y--;

        } else{
            if(y>0) {
                y--;
            }
        }
        return arr[x][y];
    }

    /**
     * Returned das Feld Südlich
     * @param arr 2D-Char Array
     * @param x X-Koordinate
     * @param y Y-Koordinate
     * @param rand true: ohne berücksichtigung des Spielfeld rands;
     *             false: berücksichtigung des Spielfeldrandes (wird dann nichts returned)
     * @return
     */
    public static char getSueden(char[][] arr, int x, int y, boolean rand){
        if(rand) {
            if (y == arr[0].length-1) {
                y = -1;
            }

            y++;

        } else{
            if(y<arr[0].length-1) {
                y++;
            }
        }
        return arr[x][y];
    }


    /**
     * Returned das Feld Westlich
     * @param arr 2D-Char Array
     * @param x X-Koordinate
     * @param y Y-Koordinate
     * @param rand true: ohne berücksichtigung des Spielfeld rands;
     *             false: berücksichtigung des Spielfeldrandes (wird dann nichts returned)
     * @return
     */
    public static char getWesten(char[][] arr, int x, int y, boolean rand){
        if(rand) {
            if (x == 0) {
                x = arr.length;
            }

            x--;

        } else{
            if(x>0) {
                x--;
            }
        }
        return arr[x][y];
    }


    /**
     * Returned das Feld Östlich
     * @param arr 2D-Char Array
     * @param x X-Koordinate
     * @param y Y-Koordinate
     * @param rand true: ohne berücksichtigung des Spielfeld rands;
     *             false: berücksichtigung des Spielfeldrandes (wird dann nichts returned)
     * @return
     */
    public static char getOsten(char[][] arr, int x, int y, boolean rand){
        if(rand) {
            if (x == arr.length-1) {
                x = -1;
            }

            x++;

        } else{
            if(x<arr.length-1) {
                x++;
            }
        }
        return arr[x][y];
    }


    /**
     * Returned das Feld Nörd-Westlich
     * @param arr 2D-Char Array
     * @param x X-Koordinate
     * @param y Y-Koordinate
     * @param rand true: ohne berücksichtigung des Spielfeld rands;
     *             false: berücksichtigung des Spielfeldrandes (wird dann nichts returned)
     * @return
     */
    public static char getNordWest(char[][] arr, int x, int y, boolean rand){
        if(rand) {
            if (y == 0) {
                y = arr[0].length;
            }

            y--;

            if (x == 0) {
                x = arr.length;
            }

            x--;

        } else{
            if(y>0) {
                y--;
            }
            if(x>0) {
                x--;
            }
        }
        return arr[x][y];
    }

    /**
     * Returned das Feld Nörd-Östlich
     * @param arr 2D-Char Array
     * @param x X-Koordinate
     * @param y Y-Koordinate
     * @param rand true: ohne berücksichtigung des Spielfeld rands;
     *             false: berücksichtigung des Spielfeldrandes (wird dann nichts returned)
     * @return
     */
    public static char getNordOst(char[][] arr, int x, int y, boolean rand){
        if(rand) {
            if (y == arr[0].length-1) {
                y = -1;
            }

            y++;

            if (x == 0) {
                x = arr.length;
            }

            x--;

        } else{
            if(y<arr[0].length) {
                y++;
            }
            if(x>0) {
                x--;
            }
        }
        return arr[x][y];
    }


    /**
     * Returned das Feld Süd-Westlich
     * @param arr 2D-Char Array
     * @param x X-Koordinate
     * @param y Y-Koordinate
     * @param rand true: ohne berücksichtigung des Spielfeld rands;
     *             false: berücksichtigung des Spielfeldrandes (wird dann nichts returned)
     * @return
     */
    public static char getSuedWest(char[][] arr, int x, int y, boolean rand){
        if(rand) {
            if (y == 0) {
                y = arr[0].length;
            }

            y--;

            if (x == arr.length-1) {
                x = 0;
            }

            x++;

        } else{
            if(y>0) {
                y--;
            }
            if(x<arr.length) {
                x++;
            }
        }
        return arr[x][y];
    }

    /**
     * Returned das Feld Süd-Östlich
     * @param arr 2D-Char Array
     * @param x X-Koordinate
     * @param y Y-Koordinate
     * @param rand true: ohne berücksichtigung des Spielfeld rands;
     *             false: berücksichtigung des Spielfeldrandes (wird dann nichts returned)
     * @return Zeichen
     */
    public static char getSuedOst(char[][] arr, int x, int y, boolean rand){
        if(rand) {
            if (y == arr[0].length - 1) {
                y = -1;
            }

            y++;

            if (x == arr.length - 1) {
                x = -1;
            }

            x++;

        } else{
            if(y<arr[0].length-1) {
                y++;
            }
            if(x<arr.length-1) {
                x++;
            }
        }
        return arr[x][y];
    }

    /**
     * Zählt die Anzahl an Elementen(zeichen) im direkt benachbarten Bereich(nord/süd/ost/west)
     * @param arr Feld(2D-char)
     * @param x X-Koordinate
     * @param y y-Koordinate
     * @param zeichen zu findendes Zeichen
     * @param rand Ob am Ende des Feldes am anderen Ende geschaut werden soll
     * @return Anzahl des Zeichens im Umfeld
     */
    public static int zaehlenVier(char[][] arr, int x, int y, char zeichen, boolean rand){
        int i = 0;

        if(getNorden(arr, x,y,rand)==zeichen){
            i++;
        }

        if(getSueden(arr, x,y,rand)==zeichen){
            i++;
        }

        if(getWesten(arr, x,y,rand)==zeichen){
            i++;
        }

        if(getOsten(arr, x,y,rand)==zeichen){
            i++;
        }

        return i;
    }

    /**
     * Zählt die Anzahl an Elementen(zeichen) im benachbarten Bereich(nord/süd/ost/west/nordwest/nordost/südwest/südost)
     * @param arr Feld(2D-char)
     * @param x X-Koordinate
     * @param y y-Koordinate
     * @param zeichen zu findendes Zeichen
     * @param rand Ob am Ende des Feldes am anderen Ende geschaut werden soll
     * @return Anzahl des Zeichens im Umfeld
     */
    public static int zaehlenAcht(char[][] arr, int x, int y, char zeichen, boolean rand){
        int i = 0;

        if(getNorden(arr, x,y,rand)==zeichen){
            i++;
        }

        if(getSueden(arr, x,y,rand)==zeichen){
            i++;
        }

        if(getWesten(arr, x,y,rand)==zeichen){
            i++;
        }

        if(getOsten(arr, x,y,rand)==zeichen){
            i++;
        }


        if(getNordWest(arr, x,y,rand)==zeichen){
            i++;
        }

        if(getNordOst(arr, x,y,rand)==zeichen){
            i++;
        }

        if(getSuedWest(arr, x,y,rand)==zeichen){
            i++;
        }

        if(getSuedOst(arr, x,y,rand)==zeichen){
            i++;
        }
        return i;
    }

    public static void main(String args[]){
        SchischVisualizer sv = new SchischVisualizer();
        spielfeld = MultiArrays.createEmpty2DCharArray(10,10);
        sv.step(spielfeld);
        double wahrscheinlichkeit = 0.9;
        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length; j++) {
                double zufallZahl = Math.random();
                if (zufallZahl <= wahrscheinlichkeit) {
                    spielfeld[i][j] = '2';
                }
            }
        }
        sv.step(spielfeld);
        System.out.println(zaehlenAcht(spielfeld, 3,9,'2',true));
        sv.start();
    }
}
