package blatt07;

public class ArbeitMitArrays {
    /**
     * Schöne Ausgabe eines int Arrays
     * @param arr Das Array
     */
    public static void printArray(int[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length-1; i++) {
            System.out.print(arr[i] + " | ");
        }
        System.out.println(arr[arr.length-1] + " ]");
    }
    /**
     * Schöne Ausgabe eines double Arrays
     * @param arr Das Array
     */
    public static void printArray(double[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length-1; i++) {
            System.out.printf("%.2f | ", arr[i]);
        }
        System.out.printf("%.2f ]\n", arr[arr.length-1]);
    }
    /**
     * Schöne Ausgabe eines boolean Arrays
     * @param arr Das Array
     */
    public static void printArray(boolean[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length-1; i++) {
            System.out.print(arr[i] + " | ");
        }
        System.out.println(arr[arr.length-1] + " ]");
    }
    /**
     * Schöne Ausgabe eines String Arrays
     * @param arr Das Array
     */
    public static void printArray(String[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length-1; i++) {
            System.out.print(arr[i] + " | ");
        }
        System.out.println(arr[arr.length-1] + " ]");
    }
    /**
     * Schöne Ausgabe eines char Arrays
     * @param arr Das Array
     */
    public static void printArray(char[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length-1; i++) {
            System.out.print(arr[i] + " | ");
        }
        System.out.println(arr[arr.length-1] + " ]");
    }

    /**
     * Gibt zurück, ob ein int Array von klein nach groß sortiert ist
     * @param arr int Array
     * @return true oder false als ausgabe
     */
    public static boolean isSortiert (int [] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] > arr[i+1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Addieret 2 int Arrays miteinander
     * @param arr1 1.Array
     * @param arr2 2. Array
     * @return Summe der Arrays
     */
    public static int [] addArr (int [] arr1, int [] arr2) {
        if (arr1.length <= arr2.length) {
            int [] arrSum = arr2;
            for (int i = 0; i < arr1.length; i++) {
                arrSum[i] += arr1[i];
            }
            return arrSum;
        } else{
            int [] arrSum = arr1;
            for (int i = 0; i < arr2.length; i++) {
                arrSum[i] += arr2[i];
            }
            return arrSum;
        }
    }

    /**
     * Verschiebung eines double Arrays um 1 nach links
     * @param arr Das double Array
     * @return das Verschobene double Array
     */
    public static double[] shiftLeft (double [] arr) {
        double zwischenwert = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = zwischenwert;
        return arr;
    }
    /**
     * Verschiebung eines double Arrays um 1 nach rechts
     * @param arr Das double Array
     * @return das Verschobene double Array
     */
    public static double[] shiftRight (double [] arr) {
        double zwischenwert = arr[arr.length-1];
        for (int i = arr.length-1; i > 0; i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = zwischenwert;
        return arr;
    }

    /**
     * Verschiebung eines double Arrays um 1 nach links
     * @param arr Das double Array
     * @return das Verschobene double Array (Element am Rand wird auf 0 gesetzt (letztes Element))
     */
    public static double[] shiftLeftAbsolute (double [] arr) {
        for (int i = 1; i < arr.length; i++) {
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = 0;
        return arr;
    }
    /**
     * Verschiebung eines double Arrays um 1 nach rechts
     * @param arr Das double Array
     * @return das Verschobene double Array (Element am Rand wird auf 0 gesetzt (erstes Element))
     */
    public static double[] shiftRightAbsolute (double [] arr) {
        for (int i = arr.length-1; i > 0; i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = 0;
        return arr;
    }


}
