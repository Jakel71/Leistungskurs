package blatt04;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Rechenuebung {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(true){
            //Einlesen und berechnen der Aufgabe:
            System.out.println("Bitte geben sie eine Zahl ein:");
            int zahl1 = input.nextInt();
            System.out.println("Bitte geben sie eine zweite Zahl ein:");
            int zahl2 = input.nextInt();
            double loesung = zahl1*zahl2;
            // Abfrage und Auswertung
            while(true){
                System.out.println("Bitte geben sie ihre Lösung ein:");
                double loesung1 = input.nextDouble();
                if(loesung1 ==loesung){
                    System.out.println("Sie haben die richtige Lösung gefunden."); // Richtige Lösung --> neue Aufgabe
                    break;
                } else {
                    System.out.println("Ihre Lösung ist falsch, bitte versuchen sie es erneut."); // alle falschen Lösungen --> neuer Versuch
                }
            }
            System.out.println("Möchten sie fortfahren? (true/false)"); // Abbrechen des While true loops
            boolean choice = input.nextBoolean();
            if(!choice){
                break;
            }

        }
    }
}
