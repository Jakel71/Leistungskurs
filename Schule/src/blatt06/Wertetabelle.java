package blatt06;

import java.util.Scanner;

public class Wertetabelle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Wie hoch ist Ihr Exponent?");
        int grad = input.nextInt();
        double[] coeff = new double[grad+1];
        double ergebnis = 0;
        double x;
        for (int i = 0; i <= grad; i++) {
            System.out.println("Was ist Ihr Koeffizient für x^" + i + " ?");
            coeff[i] = input.nextDouble();
        }
        System.out.println("Was ist Ihr Wertebereich?\nWas ist der kleinere Wert?");
        double klein = input.nextDouble();
        System.out.println("Was ist ihr größerer Wert?");
        double gross = input.nextDouble(); // groß geht nicht, da ß als falsch bzw. nicht ASCII angezeigt wird
        System.out.println("Mit welchen Schritten möchten sie Vorgehen?");
        double schritte = input.nextDouble();
        for (double j = klein; j <= gross; j+=schritte) {
            x = j;
            ergebnis = 0;
            for (int i = 0; i <= grad; i++) {
                ergebnis += coeff[i] * Math.pow(x, i);
            }
            System.out.printf("\nDas Ergebnis für x = %.2f ist: %.2f", x, ergebnis);
        }
    }
}
