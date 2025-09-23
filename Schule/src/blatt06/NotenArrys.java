package blatt06;

import java.util.Scanner;

public class NotenArrys {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Wie viele Schüler gibt es in Ihrer Klasse? ");
        int anzSchueler =  input.nextInt();
        int [] noten = new int[anzSchueler]; // Array initialisieren
        double durchschnitt = 0;
        for (int i = 0; i<anzSchueler; i++) {
            System.out.println("Welche Note hat Ihr Schueler " + (i+1) + "?");
            noten[i] = input.nextInt(); // Wert setzten für Array für Element i
            if (noten[i] <0 || noten[i]>7){
                noten[i]=-1;
                i--;
                continue;
            }

        }

        for (int i = 0 ; i < noten.length ; i++) {
            System.out.println("Note von Schüler " + (i+1) + " hat die Note: " + noten[i]); // Zugriff auf Array, Element i
        }
        System.out.println("\nReverse order:");

        for (int i = noten.length -1 ; i >= 0 ; i --) {
            System.out.println("Note von Schüler " + (i+1) + " hat die Note: " + noten[i]);
            durchschnitt += noten[i];
        }
        durchschnitt/=noten.length;
        System.out.printf("\n Der Durchschnitt der Noten beträgt: %.2f", durchschnitt);
    }
}
