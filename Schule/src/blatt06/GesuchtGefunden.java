package blatt06;

public class GesuchtGefunden {

    public static void main(String[] args) {
        double[] arr = new double[] {3.45, 7, 14, -66, 5.4, 33.33, 99.1, 42.3, 3.14, -3.14, 13.56, 7.8031, -54.35, 6.120, 6.435, -2.30001, 0.00005, -65.78, -29.57, 92, -83, 3174.56, -1469.349, -5.086, 27.135, 348.5, 52.3568, -47.320051, 8372.579, -593.2, 0.25874, -7.1952, 3587.6, -201.3, -65.92, 12, 5, 13.7, -30, 16.5, 10071, 1700.34, -50.05, 81.3576, -42};
        double max =arr[0]; // Definieren des größten Wertes mit dem Ausgangswert von arr[0]
        double min =arr[0]; // Definieren des kleinsten Wertes mit dem Ausgangswert von arr[0]
        double sum = 0;
        double kleinstePaardifferenz = arr[1]-arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) { // Teilaufgabe A
                max = arr[i];
            } else if (arr[i] < min) { // Teilaufgabe B // Else if, da wenn es der neue größte Wert ist es nicht auch noch Zeitgleich der kleinste sein kann
                min = arr[i];
            }
            sum+=arr[i]; // Teilaufgabe C
        }
        for (int i = 0; i < arr.length-1; i++) {
            if (kleinstePaardifferenz > (arr[i+1]-arr[i])) {
                kleinstePaardifferenz = arr[i+1]-arr[i];
            }
        }
        System.out.printf("Der größter Wert ist: %.2f", max);
        System.out.printf("\nDer kleinste Wert ist: %.2f", min);
        System.out.printf("\nDie Summe aller Werte des Arrays ist: %.2f", sum);
        System.out.printf("\nDie kleinste Paardifferenz ist: %.2f", kleinstePaardifferenz);
    }

}
