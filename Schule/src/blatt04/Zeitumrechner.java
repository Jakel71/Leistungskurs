package blatt04;

import java.util.Scanner;

public class Zeitumrechner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Gebe eine positive Zahl an Sekunden an:");
        int sek = input.nextInt(); // Sekunden
        int min = 0; // minuten
        int h = 0; // Stunden
        int d = 0; // Tage
        int i = 0; //Zähler
        while (sek >= 60){
            i++;
            min++;
            sek -= 60;
            if (min >= 60){ // herunter kürzen auf das Nötigste:
                h++;
                min -= 60;

                if (h >= 24){
                    d++;
                    h -= 24;
                }
            }
        }

        System.out.printf("%d Tage, %d Stunden, %d Minuten, %d Sekunden\n",d,h,min,sek);
        System.out.println("Anzahl an Schleifen: " + i); // Beispiel: 8943103 Sekunden --> 14951 Schleifen; weiter optimierbar, wenn man mithilfe von Teilern arbeiten würde, es geht hier ja aber darum Schleifen zu benutzen.
        //c) Machbar durch Teiler: sek/60, dann min/60 und zum schluss h/24, da Java bei Integern immer abrundet, entsteht auch kein rundungsproblem. // gerade erst mal durchgezählt, ich habe so schon nur 10 gebraucht :)
    }
}
