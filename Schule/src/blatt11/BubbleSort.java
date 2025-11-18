package blatt11;

import blatt07.ArbeitMitArrays;

public class BubbleSort {
    /**
     * swap 2 Numbers in an int-Array with the position a and b
     * @param arr int Array
     * @param a Pos1
     * @param b Pos2
     * @return Array
     */
    public static int[] swap (int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        return arr;
    }

     // O(n^2), da wir eine Schleife in einer Schleife haben, diese stehen in Abhängigkeit von n (der Länge des Arrays)

    /*
    Frage 1:
        Woher weiß man, dass man fast fertig ist, diese Überprüfung erzeugt einen sehr großen Mehraufwand, als das Programm einfach bis zum Ende durchzuführen.
     Frage 2:
        ebenfalls enormer mehraufwand
     */

    /**
     * Sortiert einen int-Array, nach dem BubbleSort-Prinzip
     * @param arr int-Array
     * @return sortiertes Array
     */
    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = bubbleSort(new int[] {10, 2, 3, -4, 5});
        ArbeitMitArrays.printArray(arr);
        System.out.println(ArbeitMitArrays.isSortiert(arr));
    }
}
