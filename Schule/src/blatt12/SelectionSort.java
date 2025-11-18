package blatt12;

import blatt07.ArbeitMitArrays;
import blatt11.BubbleSort;

public class SelectionSort {
    /**
     * Selection Sort, eines int-Array nach Min oder Max
     * @param arr int-Array
     * @param max true = Maxsort; false = minsort
     * @return int-Array
     */
    public static int[] selectionSort(int[] arr,boolean max) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(max){
                    if(arr[j] > arr[min]){
                        min = j;
                    }
                }else {
                    if (arr[j] < arr[min]) {
                        min = j;
                    }
                }
            }
            BubbleSort.swap(arr, i, min);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,20,13,4,50,6,-7,8,-9,10};
        ArbeitMitArrays.printArray(selectionSort(arr, false));
    }
}
