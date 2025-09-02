package blatt03;

import java.util.Scanner;

public class MinMax {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        //Erfassen der 3 Zahlen:
        System.out.print("Bitte gebe deine erste Zahl ein: ");
        double ersteZahl = input.nextDouble();
        System.out.print("Bitte gebe deine zweite Zahl ein: ");
        double zweiteZahl = input.nextDouble();
        System.out.print("Bitte gebe deine dritte Zahl ein: ");
        double dritteZahl = input.nextDouble();

        //Verarbeitung der Zahlen:
        if(ersteZahl < zweiteZahl && zweiteZahl < dritteZahl){
            System.out.printf("Die erste Zahl (%.2f) ist die kleinste Zahl\n und die dritte Zahl (%.2f) ist die größte Zahl",ersteZahl,dritteZahl);
        } else if(ersteZahl < zweiteZahl && zweiteZahl > dritteZahl){
            if(ersteZahl > dritteZahl){
                System.out.printf("Die dritte Zahl (%.2f) ist die kleinste Zahl\n und die zweite Zahl (%.2f) ist die größte Zahl",dritteZahl,zweiteZahl);
            } else if (ersteZahl < dritteZahl){
                System.out.printf("Die erste Zahl (%.2f) ist die kleinste Zahl\n und die zweite Zahl (%.2f) ist die größte Zahl",ersteZahl,zweiteZahl);
            } else {
                System.out.printf("Die erste Zahl (%.2f) ist die kleinste Zahl zusammen mit der dritten Zahl (%.2f)\n und die zweite Zahl (%.2f) ist die größte Zahl",ersteZahl,dritteZahl,zweiteZahl);
            }
        } else if(ersteZahl > zweiteZahl && zweiteZahl < dritteZahl){
            if(ersteZahl > dritteZahl){
                System.out.printf("Die zweite Zahl (%.2f) ist die kleinste Zahl\n und die erste Zahl (%.2f) ist die größte Zahl",zweiteZahl,ersteZahl);
            } else if (ersteZahl < dritteZahl){
                System.out.printf("Die zweite Zahl (%.2f) ist die kleinste Zahl\n und die dritte Zahl (%.2f) ist die größte Zahl",zweiteZahl,dritteZahl);
            } else {
                System.out.printf("Die zweite Zahl (%.2f) ist die kleinste Zahl\n und die erste Zahl (%.2f) ist die größte Zahl zusammen mit der dritten Zahl (%.2f)",zweiteZahl,ersteZahl,dritteZahl);
            }
        } else if(ersteZahl > zweiteZahl && zweiteZahl > dritteZahl){
            System.out.printf("Die dritte Zahl (%.2f) ist die kleinste Zahl\n und die erste Zahl (%.2f) ist die größte Zahl",dritteZahl,ersteZahl);
        }
        // Für den Fall, das 2 Zahlen gleich groß sind:
        else if(ersteZahl == zweiteZahl && zweiteZahl < dritteZahl){
            System.out.printf("Die erste Zahl (%.2f) ist die kleinste Zahl zusammen mit der zweiten Zahl (%.2f)\n und die dritte Zahl (%.2f) ist die größte Zahl",ersteZahl,zweiteZahl,dritteZahl);

        } else if(ersteZahl == zweiteZahl && zweiteZahl > dritteZahl){

                System.out.printf("Die dritte Zahl (%.2f) ist die kleinste Zahl\n und die zweite Zahl (%.2f) ist die größte Zahl zusammen mit der ersten Zahl (%.2f)",dritteZahl,zweiteZahl,ersteZahl);

        } else if(ersteZahl > zweiteZahl && zweiteZahl == dritteZahl){
                System.out.printf("Die zweite Zahl (%.2f) ist die kleinste Zahl zusammen mit der dritten Zahl (%.2f)\n und die erste Zahl (%.2f) ist die größte Zahl",zweiteZahl,dritteZahl,ersteZahl);

        } else if(ersteZahl < zweiteZahl && zweiteZahl == dritteZahl){
            System.out.printf("Die erste Zahl (%.2f) ist die kleinste Zahl\n und die dritte Zahl (%.2f) ist die größte Zahl zusammen mit der zweiten Zahl (%.2f)",ersteZahl,dritteZahl,zweiteZahl);
        } else {
            System.out.println("Alle Zahlen sind gleich groß!"); // Oder  es besteht noch ein Fall, welcher nicht berücksichtigt wurde
        }

    }
}
