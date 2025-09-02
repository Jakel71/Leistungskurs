package blatt02;

import java.util.Scanner;

public class Haendler {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double normal = 5;
        double mini = 8;
        double micro = 12;
        System.out.print("Anzahl an (normalen) SD-Karten: ");
        int an = input.nextInt();// TODO: Input von negativen Zahlen verhindern
        System.out.print("Anzahl an mini SD-Karten: ");
        int ami = input.nextInt();// TODO: Input von negativen Zahlen verhindern
        System.out.print("Anzahl an micro SD-Karten: ");
        int amc = input.nextInt();// TODO: Input von negativen Zahlen verhindern
        System.out.println("\nDer Preis für ...\n"
                + an + " normale SD-Karten\n"
                + ami + " MiniSD-Karten\n"
                + amc + " MicroSD-Karten\n... lautet "
                + (an*normal+ ami*mini+amc*micro) + " €");
        // Mindestens 6 Variabeln benötigt
        //für Anzahl int und für Preis double
        //Negative Eingaben für die Anzahl und man erhält einen Rabatt
    }
}
