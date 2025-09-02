package blatt03;

import java.util.Scanner;

public class SpringImKreis {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        // Erfassen der Korrdinaten über Abfragen:
        System.out.println("Bitte geben sie einen Punkt (x|y) in einem Korrdinatensystem ein:");
        System.out.print("X-Korrdinat: ");
        double x = input.nextDouble();
        System.out.print("Y-Korrdinat: ");
        double y = input.nextDouble();

        //Verarbeiten der Daten, bzw. Überprüfung ob der Punkt im Kreis liegt:
        double solution = Math.sqrt(x*x+y*y); // Quadrieren würde auch mit Math.pow(x,2) gehen, würde aber das ganze unnötig komplitzierter machen.
        System.out.print("Bitte wählen sie den Radius des Kreises: ");
        double radius = input.nextDouble();

        //Ausgabe:
        if (solution<radius){
            System.out.printf("Der angegebene Punkt (%.2f|%.2f) befindet sich im Kreis.", x, y);
        } else  if (solution == radius){
            System.out.printf("Der angegebene Punkt (%.2f|%.2f) befindet sich genau auf dem Kreis.", x, y);
        } else{
            System.out.printf("Der angegebene Punkt (%.2f|%.2f) befindet sich nicht im Kreis.", x, y);
        }
    }
}
