package blatt19;

import java.util.ArrayList;

public class QuickSort {

    public static int[] trennenLinks(int pos, int[] arr){
        int count=0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < arr[pos]){
                count++;
            }
        }
        int[] fin = new int[count];
        count=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<arr[pos]){
                fin[count]=arr[i];
                count++;
            }
        }
        return fin;
    }

    public static int[] trennenRechts(int pos, int[] arr){
        int count=0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] >= arr[pos] && i!=pos){
                count++;
            }
        }
        int[] fin = new int[count];
        count=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>=arr[pos] && i!=pos){
                fin[count]=arr[i];
                count++;
            }
        }
        return fin;
    }

    public static int[] zusammenfuegen(int pivotElement, int[] arrL, int[] arrR){
        int[] fin = new int[arrL.length+arrR.length+1];
        for(int i = 0; i < arrL.length; i++){
            fin[i]=arrL[i];
            fin[i+arrL.length]=arrR[i];
        }
        fin[arrL.length]=pivotElement;
        return fin;
    }

    public static int[] quickSort(int[] arr){
        if(arr.length>1){
            int pivot=arr[0];

            int[] kUnsortiert = trennenLinks(0, arr);
            int[] gUnsortiert = trennenRechts(0, arr);

            int[] kSortiert = quickSort(kUnsortiert);
            int[] gSortiert = quickSort(gUnsortiert);

            int[] sortiert = zusammenfuegen(pivot, kSortiert, gSortiert);

            return sortiert;

        } else{
            return arr;
        }
    }
    public static void main(String[] args) {

    }
}
