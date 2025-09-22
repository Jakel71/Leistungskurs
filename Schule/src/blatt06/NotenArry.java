package blatt06;

import java.util.Scanner;

public class NotenArry {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Wie viele Schüler gibt es in Ihrer Klasse? ");
        int anzSchueler =  input.nextInt();
        int [] noten = new int[anzSchueler];
        for (int i = 0; i<anzSchueler; i++) {
            do {
                System.out.println("Welche Note hat ihr Schueler " + i + "?");
                noten[i] = input.nextInt();
            }   while (0 > noten[i] && noten[i] > 7);
        }

        for (int i = 0 ; i < noten.length ; i++) {
            System.out.println("Note von Schüler " + (i+1) + " hat die Note: " + noten[i]);
        }
        System.out.println("\nReverse order:");

        for (int i = noten.length -1 ; i >= 0 ; i --) {
            System.out.println("Note von Schüler " + (i+1) + " hat die Note: " + noten[i]);
        }
    }
}
