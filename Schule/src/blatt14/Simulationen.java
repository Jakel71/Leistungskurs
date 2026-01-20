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
     * @param position Position(x|y) in [x,y]
     * @return
     */
    public static char getNorden(char[][] arr, int[] position){
        int x = position[0];
        int y = position[1];
        if (y == 0) {
            y = arr[0].length-1;
        } else{
            y--;
        }
        return arr[x][y];
    }

    /**
     * Returned das Feld Südlich
     * @param arr 2D-Char Array
     * @param position Position(x|y) in [x,y]
     * @return
     */
    public static char getSueden(char[][] arr, int[] position){
        int x = position[0];
        int y = position[1];

        if (y >= arr[0].length-1) {
            y = 0;
        } else{
            y++;
        }
        return arr[x][y];
    }


    /**
     * Returned das Feld Westlich
     * @param arr 2D-Char Array
     * @param position Position(x|y) in [x,y]
     * @return
     */
    public static char getWesten(char[][] arr, int[] position){
        int x = position[0];
        int y = position[1];
        if (x == 0) {
            x = arr.length-1;
        } else{
            x--;
        }
        return arr[x][y];
    }


    /**
     * Returned das Feld Östlich
     * @param arr 2D-Char Array
     * @param position Position(x|y) in [x,y]
     * @return
     */
    public static char getOsten(char[][] arr, int[] position){
        int x = position[0];
        int y = position[1];
        if (x == arr.length-1) {
            x = 0;
        } else{
            x++;
        }
        return arr[x][y];
    }


    /**
     * Returned das Feld Nörd-Westlich
     * @param arr 2D-Char Array
     * @param position Position(x|y) in [x,y]
     * @return
     */
    public static char getNordWest(char[][] arr, int[] position){
        int x = position[0];
        int y = position[1];
        if (y == 0) {
            y = arr[0].length-1;
        } else{
            y--;
        }

        if (x == 0) {
            x = arr.length-1;
        } else{
            x--;
        }

        return arr[x][y];
    }

    /**
     * Returned das Feld Nörd-Östlich
     * @param arr 2D-Char Array
     * @param position Position(x|y) in [x,y]
     * @return
     */
    public static char getNordOst(char[][] arr, int[] position){
        int x = position[0];
        int y = position[1];

        if (y == 0) {
            y = arr[0].length-1;
        } else{
            y--;
        }

        if (x == arr.length-1) {
            x = 0;
        } else{
            x++;
        }

        return arr[x][y];
    }


    /**
     * Returned das Feld Süd-Westlich
     * @param arr 2D-Char Array
     * @param position Position(x|y) in [x,y]
     * @return
     */
    public static char getSuedWest(char[][] arr, int[] position){
        int x = position[0];
        int y = position[1];
        if (y == arr[0].length-1) {
            y = 0;
        } else{
            y++;
        }
        if (x == 0) {
            x = arr.length-1;
        } else{
            x--;
        }
        return arr[x][y];
    }

    /**
     * Returned das Feld Süd-Östlich
     * @param arr 2D-Char Array
     * @param position Position(x|y) in [x,y]
     * @return Zeichen
     */
    public static char getSuedOst(char[][] arr, int[] position){
        int x = position[0];
        int y = position[1];

        if (y == arr[0].length-1) {
            y = 0;
        } else{
            y++;
        }

        if (x == arr.length-1) {
            x = 0;
        } else{
            x++;
        }
        return arr[x][y];
    }

    /**
     * Zählt die Anzahl an Elementen(zeichen) im direkt benachbarten Bereich(nord/süd/ost/west)
     * @param arr Feld(2D-char)
     * @param position Position, um welche geschaut wird
     * @param zeichen zu findendes Zeichen
     * @param rand Ob am Ende des Feldes am anderen Ende geschaut werden soll
     * @return Anzahl des Zeichens im Umfeld
     */
    public static int zaehlenVier(char[][] arr, int[] position, char zeichen, boolean rand){
        int i = 0;

        if(getNorden(arr, position)==zeichen){
            if(!rand || position[1]!=0) {
                i++;
            }
        }
        if(getSueden(arr, position)==zeichen){
            if(!rand || position[1]!=arr[0].length-1) {
                i++;
            }
        }
        if(getWesten(arr, position)==zeichen){
            if(!rand || position[0]!=0) {
                i++;
            }

        }
        if(getOsten(arr, position)==zeichen){
            if(!rand || position[0]!=arr.length-1) {
                i++;
            }

        }
        return i;
    }

    /**
     * Zählt die Anzahl an Elementen(zeichen) im benachbarten Bereich(nord/süd/ost/west/nordwest/nordost/südwest/südost)
     * @param arr Feld(2D-char)
     * @param position Position, um welche geschaut wird
     * @param zeichen zu findendes Zeichen
     * @param rand Ob am Ende des Feldes am anderen Ende geschaut werden soll
     * @return Anzahl des Zeichens im Umfeld
     */
    public static int zaehlenAcht(char[][] arr, int[] position, char zeichen, boolean rand){
        int i = 0;

        if(getNorden(arr, position)==zeichen){
            if(!rand || position[1]!=0) {
                i++;
            }
        }
        if(getSueden(arr, position)==zeichen){
            if(!rand || position[1]!=arr[0].length-1) {
                i++;
            }
        }
        if(getWesten(arr, position)==zeichen){
            if(!rand || position[0]!=0) {
                i++;
            }

        }
        if(getOsten(arr, position)==zeichen){
            if(!rand || position[0]!=arr.length-1) {
                i++;
            }

        }


        if(getNordWest(arr, position)==zeichen){
            if(!rand || (position[1]!=0 && position[0]!=0)) {
                i++;
            }
        }
        if(getNordOst(arr, position)==zeichen){
            if(!rand || (position[1]!=0 && position[0]!=arr.length-1)) {
                i++;
            }
        }
        if(getSuedWest(arr, position)==zeichen){
            if(!rand || (position[1]!=arr[0].length-1 && position[0]!=0)) {
                i++;
            }
        }
        if(getSuedOst(arr, position)==zeichen){
            if(!rand || (position[1]!=arr[0].length-1 && position[0]!=arr.length-1)) {
                i++;
            }
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
        System.out.println(zaehlenAcht(spielfeld, new int[] {3,9},'2',true));
        sv.start();
    }
}
