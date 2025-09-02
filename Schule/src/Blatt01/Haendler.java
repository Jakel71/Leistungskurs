package Blatt01;

public class Haendler {
    public static void main(String[] args) {
        double normal = 5;
        double mini = 8;
        double micro = 12;

        int an = 9;
        int ami = 5;
        int amc = 0;
        System.out.println("Der Preis für ...\n"
                + an + " normale SD-Karten\n"
                + ami + " MiniSD-Karten\n"
                + amc + " MicroSD-Karten\n... lautet "
                + (an*normal+ ami*mini+amc*micro) + " €");
        // Mindestens 6 Variabeln benötigt
        //für Anzahl int und für Preis double
        //Negative Eingaben für die Anzahl und man erhält einen Rabatt
    }
}
