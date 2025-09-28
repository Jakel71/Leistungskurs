package blatt06;

import java.util.Scanner;

public class DoubleFibonacci {
    public static void main(String[] args) {
        System.out.println("Wie lang soll die Fibonacci Frequenz werden? Bitte nehmen Sie eine Zahl größer als 2.");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        double[] arr = new double[n + 1];
        if (n <= 2) {
            System.out.println("Die Fibonacci Zahlen für 0 und 1 (x Werte) sind 0 und 1 (y Werte). Deswegen nehmen sie bitte eine Zahl größer als 2.");
        } else if (n > 1477) {
            System.out.println("Für alle Fibonacci Zahlen größer gleich 1477 gilt: Dass deren Wert infinity ist (durch den Datentyp double). Deswegen scheitert dann auch die Berechnung des Quotienten, wenn beide Zahlen infinity ist.");

        }else { // Ab 1477 kommt infinity raus, deswegen limitiere ich das ganze mal darauf. Es wird nur noch das erste infinity ausgegeben.
            arr[0] = 0;
            arr[1] = 1;
            System.out.println("Der Wert für Fibonacci an Stelle 0 ist: " + arr[0]);
            System.out.println("Der Wert für Fibonacci an Stelle 1 ist: " + arr[1]);
            for (int i = 2; i <= n; i++) {
                arr[i] = arr[i - 2] + arr[i - 1];
                System.out.println("Der Wert für Fibonacci an Stelle " + i + " ist: " + arr[i]);
            }
            if (n == 1477) {
                double quotient = arr[n - 1] / arr[n - 2];
                System.out.println("Der Quotient der vorletzten beiden Fibonacci Zahlen ist: " + quotient);
                double quotient2 = arr[n] / arr[n - 1];
                System.out.println("Der Quotient der letzten beiden Fibonacci Zahlen ist: " + quotient2);
            } else {
                double quotient = arr[n] / arr[n - 1];
                System.out.printf("Der Quotient der letzten beiden Fibonacci Zahlen ist: %.2f", quotient);
            }
            /*
            für n --> 46 (ab 47 gehts wieder negativ (wegen dem Datentyp), deswegen schauen wir uns das ganze hier jetzt nur mal bis 46 an):
            Quotient --> 1,62 (terminal ausgabe)
            Ergänzung: im DoubleFibonacci.java Programm bleibt der wert bis zu 1476 bei 1,62, danach ändert das Programm den Zahlen wert auf infinity.
             */
        }
    }
}
