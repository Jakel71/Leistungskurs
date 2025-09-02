package blatt03;

import java.util.Scanner;


public class PQAllgemein {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Datenerfassen // Fehlerfall von Strings, könnte umgangen werden, würde aber zum gleichen Ergebnis führen
        System.out.println("Bitte geben sie aus folgender Gleichung a,b,c,d ein: a*x^2 + b * x + c = d");
        System.out.print("A: ");
        double a = input.nextDouble();
        System.out.print("B: ");
        double b = input.nextDouble();
        System.out.print("C: ");
        double c = input.nextDouble();
        System.out.print("D: ");
        double d = input.nextDouble();

        // Term Umformungen
        double q = (c-d)/a;
        double p = b/a;

        PQ.pq(p,q); // Zugriff auf Funktion pq aus Datei PQ.java // Herr Schisch, sie kreigen, dass sicher hin, ansonsten kopieren sie bitte die Funktion herr über und löschen dann das PQ.
    }
}
