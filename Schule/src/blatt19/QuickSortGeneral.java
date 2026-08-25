package blatt19;

public class QuickSortGeneral<T extends Comparable<T>> {

    public static <T extends Comparable<T>> T[] trennenLinks(int pos, T[] arr){
        int count=0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i].compareTo(arr[pos])<0){
                count++;
            }
        }
        T[] fin = (T[]) new Comparable[count];
        count=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].compareTo(arr[pos])<0){
                fin[count]=arr[i];
                count++;
            }
        }
        return fin;
    }

    public static <T extends Comparable<T>> T[] trennenRechts(int pos, T[] arr){
        int count=0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i].compareTo(arr[pos]) >=0 && i!=pos){
                count++;
            }
        }
        T[] fin = (T[]) new Comparable[count];
        count=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].compareTo(arr[pos]) >=0 && i!=pos){
                fin[count]=arr[i];
                count++;
            }
        }
        return fin;
    }

    public static <T extends Comparable<T>> T[] zusammenfuegen(T pivotElement, T[] arrL, T[] arrR){
        T[] fin = (T[]) new Comparable[arrL.length+arrR.length+1];
        for(int i = 0; i < arrL.length; i++){
            fin[i]=arrL[i];
        }
        fin[arrL.length]=pivotElement;

        for(int i = 0; i < arrR.length; i++){
            fin[i+arrL.length+1]=arrR[i];
        }
        return fin;
    }

    public static <T extends Comparable<T>> T[] quickSort(T[] arr){
        if(arr.length>1){
            T pivot=arr[0];

            T[] kUnsortiert = trennenLinks(0, arr);
            T[] gUnsortiert = trennenRechts(0, arr);

            T[] kSortiert = quickSort(kUnsortiert);
            T[] gSortiert = quickSort(gUnsortiert);

            T[] sortiert = zusammenfuegen(pivot, kSortiert, gSortiert);

            return sortiert;

        } else{
            return arr;
        }
    }
}
