package blatt06;

import java.util.Scanner;

public class GrenzenSetzen {

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.println("Bitte geben sie nur natürliche Zahlen (alle Zahlen >= 0; und ohne Komma) ein.");
            System.out.println("Was ist Ihr Startwert, unterer Wert?");
            int u = input.nextInt();
            System.out.println("Was ist Ihr Endwertwert, oberer Wert?");
            int o = input.nextInt();
            int anzahl = o-u+2;
            int[] zaehler = new int[anzahl];
            for (int i = u; i < o+1; i++) {
                zaehler[i] = i;
                System.out.println("Der Wert von Element [" + i + "] ist: " + zaehler[i]);
            }
        }
}
