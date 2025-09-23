package blatt06;

import java.util.Scanner;

/*
|-----------------------------------------------------------------------------------|
Aufgabe:
Du kennst sicherlich die Sportart Dart. Falls nicht ist das gar kein Problem,
denn hier sind die nochmal die Regeln (verkürtzt):
1. Ein Dartspiel beginnt bei 501 Punkten.
2. Ein Spieler kann in jeder Runde eine Punktzahl zwischen 0-180.
3. Die geworfenen Punkte werden in jeder Runde von der Gesamtpunktzahl abgezogen.
4. Das Spiel endet, wenn man exakt 0 Punkte erreicht. Sollte man ins negative geraten,
wird man auf den Wert von der vorherigen Runde zurückgesetzt.

Implementiere nun einen automatischen Dartzähler, damit der Spieler seine Punkte nicht
selbst im Kopf rechnen muss.
 |-----------------------------------------------------------------------------------|
 */
public class Dart_Multiplayer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //Erzeuge Scanner

        int punkte = 501; //Variable "punkte" mit 501 initialisiert -->Startwert
        int anzahl;
        do {
            System.out.print("Geben Sie die Anzahl der Spieler ein: ");
            anzahl = input.nextInt();
        } while (anzahl <= 0);

        int[] spieler = new int[anzahl];

        for (int i = 0; i < spieler.length; i++) {
            spieler[i] = punkte;
        }
        int wurf;
        outer:
        while (true) {
            for (int i = 0; i < spieler.length; i++) {
                System.out.println("\nDer Spieler " + (i + 1) + " ist nun am Zug");
                do {
                    System.out.println("Gebe deine Punktzahl ein (0-180)");
                    wurf = input.nextInt(); //Setzt die Variable "wurf" auf den eingegebenen Wert (Es kann angenommen, dass nur gültige Werte eingegeben werden)}
                } while (wurf > 180 || wurf < 0);

                if (spieler[i] - wurf >= 0) {
                    spieler[i] -= wurf;

                    if (spieler[i] > 0) {
                        System.out.printf("Werfen sie noch %d Punkte.\n", spieler[i]);
                    } else {
                        System.out.println("Sie (Spieler " + spieler[i] + ") haben gewonnen.");
                    }
                    if (spieler[i] == 0) {
                        break outer;
                    }
                }
            }
        }
    }
}

