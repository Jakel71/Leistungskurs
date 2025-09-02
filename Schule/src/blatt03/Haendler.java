package blatt03;

import java.util.Scanner;

public class Haendler {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double normal = 5;
        double mini = 8;
        double micro = 12;
        System.out.print("Anzahl an (normalen) SD-Karten: ");
        int an = input.nextInt();
        if (an<0){
            System.exit(0);
        } else if(an>50){
            an = 50;
            System.out.println("Bestelllimit von 50 SD-Karten erreicht, wir setzten ihre Bestellmenge nun auf 50 herrab.");
        }
        System.out.print("Anzahl an mini SD-Karten: ");
        int ami = input.nextInt();
        if (ami<0){
            System.exit(0);
        } else if(ami>50){
            ami = 50;
            System.out.println("Bestelllimit von 50 SD-Karten erreicht, wir setzten ihre Bestellmenge nun auf 50 herrab.");
        }
        System.out.print("Anzahl an micro SD-Karten: ");
        int amc = input.nextInt();
        if (amc<0){
            System.exit(0);
        } else if(amc>50){
            amc = 50;
            System.out.println("Bestelllimit von 50 SD-Karten erreicht, wir setzten ihre Bestellmenge nun auf 50 herrab.");
        }
        double startPreis = an*normal+ ami*mini+amc*micro;

        System.out.println("\nDer normale Preis für ...\n"
                + an + " normale SD-Karten\n"
                + ami + " MiniSD-Karten\n"
                + amc + " MicroSD-Karten\n... lautet "
                + startPreis + " €");
        // Mindestens 6 Variabeln benötigt
        //für Anzahl int und für Preis double
        if (an+ami+amc >=15) { // Rabatt ab dem 15. Artikel, falls 15 nicht inklusive ist, einfach "="-Zeichen löschen oder 15 um eins erhöhen
            double rabattSatz = 0.85;
            double rabatt = startPreis * rabattSatz;
            System.out.printf(" \nRabatt : %.2f € \n", rabatt);
            System.out.printf("Gesamt Preis nach Rabattierung: %.2f €", (startPreis - rabatt));
        }
    }
}
