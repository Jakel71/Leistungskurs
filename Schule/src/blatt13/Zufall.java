package blatt13;

import blatt07.ArbeitMitArrays;

public class Zufall {

    /**
     * Zufallszahl zwischen 0 und B
     * @param b obere Grenze der zufallszahlen
     * @return Zufallszahl
     */
    public static double zufall(double b){
        return Math.random()*b;
    }

    /**
     * Zufallszahl zwischen 0 und B
     * @param b obere Grenze der zufallszahl
     * @return Zufallszahl (int)
     */
    public static int zufallGanz(int b){
        return (int) (Math.random()*b);
    }

    /**
     * Zufallszahl zwischen a und B
     * @param b obere Grenze der Zufallszahl
     * @param a untere Grenze der Zufallszahl
     * @return Zufallszahl
     */
    public static double zufall(double b,double a){
        return Math.random()*(b-a)+a;
    }

    /**
     * Zufallszahl zwischen 0 und B
     * @param b obere Grenze der Zufallszahl
     * @param a untere Grenze der Zufallszahl
     * @return Zufallszahl (int)
     */
    public static int zufallGanz(int b, int a){
        return (int) (Math.random()*(b-a)+a);
    }

    public static int[] zufallArray(int l, int a, int b){
        int[] arr = new int[l];
        for(int i=0;i<l;i++){
            arr[i] = zufallGanz(a, b);
        }
        return arr;
    }

    public static void main(String[] args) {
        ArbeitMitArrays.printArray(zufallArray(10,2,30));
    }
}
