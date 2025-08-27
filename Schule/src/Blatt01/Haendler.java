package Blatt01;

public class Haendler {
    public static void main(String[] args) {
        double normal = 5;
        double mini = 8;
        double Micro = 12;

        int An = 9;
        int Ami = 5;
        int Amc = 0;
        System.out.println("Der Preis für ...\n"
                + An + " normale SD-Karten\n"
                + Ami + " MiniSD-Karten\n"
                + Amc + " MicroSD-Karten\n... lautet "
                + (An*normal+ Ami*mini+Amc*Micro) + " €");
        // Mindestens 6 Variabeln benötigt
        //für Anzahl int und für Preis double
        //Negative Eingaben für die Anzahl und man erhält einen Rabatt
    }
}
