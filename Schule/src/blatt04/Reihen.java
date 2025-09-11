package blatt04;

import java.util.Scanner;

public class Reihen {
    public static void reihe(int laenge, int art){
        System.out.printf("Reihe %d:\n", art);
        int wert =0;
        for (int i=1;i<laenge+1;i++){ // For loop, da wir i später brauchen und es so übersichtlicher ist
            if (art == 1) {
                wert++; // Folge 1: immer um 1 erhöhen
            } else if (art == 2) {
                wert+=2;// Folge 2: immer um 2 erhöhen
            }else if (art == 3) {
                wert = i * i; //Folge 3: immer Element (i) quadrieren
            }else if (art == 4 && i %2 == 0) {
                wert -=i; //Folge 4 (gerade Zahlen): i subtrahieren, da zuvor ungerade Zahl (i-1), damit wird das ganze ins negative gespiegelt
            } else {
                wert += i; // Folge 4 (ungerade Zahlen): siehe 1 weiter oben, funktioniert genau umgekehrt.
            }
            System.out.print(wert + " "); //Ausgabe
        }
        System.out.println("\n");
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Input:
        System.out.println("Wie viele Zahlen möchten Sie je Reihe ausgegeben bekommen?");
        int laenge = input.nextInt();
        //erzeugen der Reihen mit einer Funktion:
        reihe(laenge,1);
        reihe(laenge,2);
        reihe(laenge,3);
        reihe(laenge,4);
    }
}
