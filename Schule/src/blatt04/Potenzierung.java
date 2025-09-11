package blatt04;

import java.util.Scanner;

public class Potenzierung {
    public static void main(String[] args) {
        // Input:
        Scanner input = new Scanner(System.in);
        System.out.print("Wählen sie bitte ihre Basis: ");
        double basis = input.nextDouble();
        System.out.print("Wählen sie bitte ihren Exponenten: ");
        int exponent = input.nextInt();
        int i = 0;
        double loesung = 1; //Startwert für multiplikation; if (exponent == 0) {loesung = 1;} kann man sich dadurch sparen, keine Veränderung, kein Problem
        //Verarbeitung
        if (exponent > 0) { // positiver exponent:
            while (i < exponent) { // multiplikation bis zum Erreichen der Potenz
                i++;
                loesung *= basis;
            }
        } else if (exponent < 0) { // negativer Exponent:
            while (i > exponent) {
                i--;
                loesung *= basis;
            }
            loesung = 1/loesung; // Umsetzung des Negativen Vorzeichens
        }
        System.out.printf("Die Lösung ist (gerundet): %.2f", loesung);
    }
}
