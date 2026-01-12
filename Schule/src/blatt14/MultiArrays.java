package blatt14;

import blatt07.ArbeitMitArrays;

import java.util.Arrays;

public class MultiArrays {

    /**
     * Ausgabe in der Commandozeile von 2D array
     * @param arr 2D-int-Array
     */
    public static void print2DArray(int[][] arr) {
        System.out.print("{ ");
        for (int i=0; i<arr.length-1; i++) {
            ArbeitMitArrays.printArray(arr[i]);
            System.out.print( "| ");
        }
        ArbeitMitArrays.printArray(arr[arr.length-1]);
        System.out.println("}");
    }


    /**
     * Ausgabe in der Commandzeile von 2D array
     * @param arr 2D-double-Array
     */
    public static void print2DArray(double[][] arr) {
        System.out.print("{ ");
        for (int i=0; i<arr.length-1; i++) {
            ArbeitMitArrays.printArray(arr[i]);
            System.out.print( "| ");
        }
        ArbeitMitArrays.printArray(arr[arr.length-1]);
        System.out.println("}");
    }


    /**
     * Ausgabe in der Commandozeile von 2D array
     * @param arr 2D-char-Array
     */
    public static void print2DArray(char[][] arr) {
        System.out.print("{ ");
        for (int i=0; i<arr.length-1; i++) {
            ArbeitMitArrays.printArray(arr[i]);
            System.out.print( "| ");
        }
        ArbeitMitArrays.printArray(arr[arr.length-1]);
        System.out.println("}");
    }

    /**
     * Erstellt ein 2D-Int-Array mit Random Werten und returned dieses
     *
     * @param a länge des 1. Arrays
     * @param b lange der 2. Arrays (alle Arrays in Array 1)
     * @param p untere Grenzwert für die Zahlen
     * @param q oberer Grenzwert für die Zahlen
     * @return int[a][b]
     */
    public static int[][] createRandom2DIntArray(int a, int b, int p, int q) {
        int[][] arr = new int[a][b];
        for (int i=0; i<a; i++) {
            for (int j=0; j<b; j++) {
                arr[i][j] = (int)(Math.random()*(q-p)+p);
            }
        }
        return arr;
    }

    /**
     * Erstellt ein 2D-Double-Array mit Random Werten und returned dieses
     * @param a länge des 1. Arrays
     * @param b lange der 2. Arrays (alle Arrays in Array 1)
     * @return double[a][b]
     */
    public static double[][] createRandom2DDoubleArray(int a, int b) {
        double[][] arr = new double[a][b];
        for (int i=0; i<a; i++) {
            for (int j=0; j<b; j++) {
                arr[i][j] = Math.random();
            }
        }
        return arr;
    }

    /**
     * erzeugt 2D-int-Array, welches von 0 bis (a*b)-1 hochzählt
     * @param a
     * @param b
     * @return int[a][b]
     */
    public static int[][] createCountingArray(int a, int b){
        int[][] arr = new int[a][b];
        int counter = 0;
        for (int i=0; i<a; i++) {
            for (int j=0; j<b; j++) {
                arr[i][j] = counter;
                counter++;
            }
        }
        return arr;
    }

    /**
     * Erstellung und zurückgeben von einem char[][]-Array mit ' ' befüllt
     * @param a
     * @param b
     * @return char[a][b]
     */
    public static char[][] createEmpty2DCharArray(int a, int b){
        char[][] arr = new char[a][b];
        for (int i=0; i<a; i++) {
            for (int j=0; j<b; j++) {
                arr[i][j] = ' ';
            }
        }
        return arr;
    }

    /**
     * Überprüfung, ob 2 2D-Char-Arrays identisch sind
     * @param arr1 char[][]
     * @param arr2 char[][]
     * @return true/false
     */
    public static boolean istIdentisch (char[][] arr1, char[][] arr2){
        if (arr1.length != arr2.length) return false;
        if (arr1[0].length != arr2[0].length) return false;
        for (int i=0; i<arr1.length; i++){
            for (int j=0; j<arr1[i].length; j++){
                if (arr1[i][j] != arr2[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Erstellt eine Hardcopy eines char[][]
     * @param arr input
     * @return output
     */

    public static char[][] copy2DCharArray(char[][] arr){
        char[][] copy = new char[arr.length][arr[0].length];
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr[0].length; j++){
                copy[i][j] = arr[i][j];
            }
        }
        return copy;
    }

    /**
     * Verschiebt ein int[][] um b nach links
     * @param arr int[][]
     * @param a Angabe, welches Arrays verschoben wird
     * @param b Anzahl der Verschiebungen
     * @return arr, geshifted
     */
    public static int[][] shiftRows(int[][] arr,int a,int b){
        for(int j=0; j<b; j++) {
            int zwischenwert = arr[a][0];
            for (int i = 1; i < arr[a].length; i++) {
                arr[a][i - 1] = arr[a][i];
            }
            arr[a][arr[a].length - 1] = zwischenwert;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] arr = createRandom2DIntArray(5,10,1,10);
        print2DArray(arr);
        int[][] arr2 = shiftRows(arr,2,5);
        print2DArray(arr2);
    }

}
