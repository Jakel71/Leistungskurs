package blatt12;

import blatt07.ArbeitMitArrays;

public class InsertionSort {
    /**
     * InsertionSort eines int-Array, gleiche Elemente überschreiben sich nicht, sondern werden nebeneinander gestapelt
     * @param arr int-Array
     * @return Array
     */
    public static int[] insertionSort(int[] arr) {
        int n = arr.length;
        int[] arr2 = new int[n];
        for (int i = 1; i < n; i++) {
            int einzusortierender_wert = arr[i];
            int j = i;
            while (j > 0 && arr2[j - 1] > einzusortierender_wert) {
                arr2[j] = arr2[j - 1];
                j = j - 1;
            }
            arr2[j] = einzusortierender_wert;
        }
        return arr2;
    }


    /**
     * InsertionSort eines int-Array, es wird kein neues Array angelegt, gleiche Elemente überschreiben sich nicht, sondern werden nebeneinander gestapelt
     * @param arr int-Array
     * @return Array
     */
    public static int[] insertionSortInPlace(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int einzusortierender_wert = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > einzusortierender_wert) {
                arr[j] = arr[j - 1];
                j = j - 1;
            }
            arr[j] = einzusortierender_wert;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = insertionSortInPlace(new int[] {10, 2, 3, -4, 5});
        ArbeitMitArrays.printArray(arr);
    }
}
