package blatt04;

import java.util.Scanner;

public class ETF {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double wert = 3578.89;
        double wertsteigerung = 6.00;
        System.out.println("Welchen betrag möchten sie im Monat anlegen?");
        double sparBetrag = input.nextDouble();
        System.out.println("Wie lange möchten sie Anlegen? (in Monaten)");
        int laufzeit = input.nextInt();
        double anteil = 0;
        double gewinn = 0;
        int i = 0;
        double totalSparBetrag = 0;
        while(i<laufzeit) {
            i++;
            totalSparBetrag += sparBetrag;
            anteil = totalSparBetrag/wert;
            System.out.println("Monat:\t\t\t\t\t\t\t" + i);
            System.out.println("Gesamter Sparbetrag:\t\t\t" + totalSparBetrag);
            System.out.println("Gesamter Anteil an der Aktie:\t" + anteil);
        }
        gewinn += (anteil*wert)*wertsteigerung/100*i/12;
        System.out.printf("Gewinn:\t\t\t\t\t\t\t%.2f€",gewinn);

    }
}
