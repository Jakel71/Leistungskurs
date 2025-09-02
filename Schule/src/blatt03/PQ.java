package blatt03;

import java.sql.SQLOutput;
import java.util.Scanner;

public class PQ {
    public static void pq(Double p,Double q) {
        //p-q-Formel Teil 1, falls die Wurzel negativ ist oder 0 ist:
        double sqrt = Math.pow(p,2)/4 - q;
        double root = Math.sqrt(sqrt);
        boolean i = false;
        if (sqrt < 0) {
            System.out.println("Es gibt keine Lösung, da die Wurzel negativ ist,\nsofern man die Mathematik der Mittelstufe benutzt.\nZur Handhabung verwenden wir i (Die Wurzel aus -1).");
            sqrt *= -1;
            root = Math.sqrt(sqrt);
            i = true;
        } else if (sqrt == 0) { // Sonderfall 1 Lösung
            System.out.printf("Es gibt genau eine Lösung: %.2f", -p/2);
            System.exit(0);
        }
        if (i){ // Falls i vorkommt, dann hinzufügen
            System.out.printf("Es gibt genau zwei Lösungen: %.2f + i und %.2f + i", -p/2 + root, -p/2 - root);

        } else {
            System.out.printf("Es gibt genau zwei Lösungen: %.2f und %.2f", -p / 2 + root, -p / 2 - root);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Datenerfassen // Fehlerfall von Strings, könnte umgangen werden, würde aber zum gleichen Ergebnis führen
        System.out.println("Bitte geben sie aus folgender Gleichung P und Q ein: x^2 + p * x + q");
        System.out.print("P: ");
        double p = input.nextDouble();
        System.out.print("Q: ");
        double q = input.nextDouble();

        pq(p,q);
    }
}
