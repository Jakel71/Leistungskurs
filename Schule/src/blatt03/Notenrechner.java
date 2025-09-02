package blatt03;

import java.util.Scanner;

public class Notenrechner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Einlesen der Punkten, max und erreichte
        System.out.print("Dies ist der Notenrechner.\nBitte geben sie die maximal erreichbare Punktzahl ein:");
        double max = input.nextDouble();
        System.out.print("Bitte geben sie ihre Punktzahl ein: ");
        double punkte = input.nextDouble();
        // Falls Buchstaben eingegeben werden, bricht Java ab, deswegen müssen und können wir diesen Fall nicht vorbeugen
        // geht schon, aber nur mit umwandlung eines Strings in einen double, dass können wir uns aber sparen

        if (punkte > max){ // Sicherstellen dass die maximalen Punkte nicht überschritten werden
            System.out.println("Haben sie wirklich mehr Punkte als möglich erreicht?\n" +
                    "Falls dies der Fall ist Gratulation, sie haben eine 1. Ansonsten haben sie sich leider vertippt.");
            System.exit(0);
        } else if (punkte < 0 || max < 0){ // Keine Negativen Zahlen erlauben
            System.out.println("Sie haben sich wohl vertippt, sie dürfen nur positive Zahlen eingeben!");
            System.exit(0);
        } else if (punkte == max){ // Die spezielle Nachricht:
            System.out.println("Gratulation, sie haben volle Punktzahl erreicht, damit haben sie eine 1.");
            System.exit(0);
        }
        //Prozentsatz berechnen
        double anteil = punkte/max;

        //Nun kommt die komplierte Ausgabe, mit Arrays wäre diese leichter, haben wir noch nicht

        if (anteil >=0.85){
            System.out.printf("Du hast eine 1 mit %.2f von %.2f",punkte, max);
        } else if (anteil >=0.70){
            System.out.printf("Du hast eine 2 mit %.2f von %.2f",punkte, max);
        } else if (anteil >=0.55){
            System.out.printf("Du hast eine 3 mit %.2f von %.2f",punkte, max);
        } else if (anteil >=0.39){
            System.out.printf("Du hast eine 4 mit %f.2 von %.2f",punkte, max);
        } else if (anteil >=0.17){
            System.out.printf("Du hast eine 5 mit %f.2 von %.2f",punkte, max);
        } else if (anteil <=0.17){
            System.out.printf("Du hast eine 6 mit %.2f von %.2f",punkte, max);
        }
    }
}
