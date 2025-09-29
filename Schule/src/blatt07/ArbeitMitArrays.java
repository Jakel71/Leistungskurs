package blatt07;

public class ArbeitMitArrays {
    public static void printArray(int[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length-1; i++) {
            System.out.print(arr[i] + " | ");
        }
        System.out.println(arr[arr.length-1] + " ]");
    }
    public static void printArray(double[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length-1; i++) {
            System.out.print(arr[i] + " | ");
        }
        System.out.println(arr[arr.length-1] + " ]");
    }

    public static void printArray(boolean[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length-1; i++) {
            System.out.print(arr[i] + " | ");
        }
        System.out.println(arr[arr.length-1] + " ]");
    }
    public static void printArray(String[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length-1; i++) {
            System.out.print(arr[i] + " | ");
        }
        System.out.println(arr[arr.length-1] + " ]");
    }
    public static void printArray(char[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length-1; i++) {
            System.out.print(arr[i] + " | ");
        }
        System.out.println(arr[arr.length-1] + " ]");
    }
    public static void main(String[] args) {
        printArray(new boolean[]{true,false,true,false,true,false,true,true});
    }

}
