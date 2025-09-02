package blatt02;


import java.util.Scanner;

public class AmiiboKostenRechner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double preis = 15; // Währung in €
        System.out.println("Der Preis für eine Amiibo-Figuren beträgt " + preis + "€");
        System.out.println("Wie viele Amiibo-Figuren möchten sie (für Herr Schisch) kaufen?");
        int anzahl = input.nextInt(); //TODO: Kein negativer Input, sonst negativer Preis
        double preisNeu = preis * anzahl;
        System.out.printf("Der gesmate Preis für die Amiibo-Figuren beträgt %.2f €, möchten sie diese Figuren zu Herr Schisch schicken?", preisNeu);
        boolean drSchischious = input.nextBoolean(); // TODO: alle anderen werte ignoriren!
        if (drSchischious) {
            System.out.println("Vielen Dank, ihre Bestellung wird jetzt bearbeitet.");
        } else {
            System.out.println("Vielen Dank, ihre Bestellung wird in 100 Jahren bearbeitet.");
        }
    }
}
