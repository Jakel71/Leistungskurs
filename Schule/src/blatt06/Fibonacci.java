package blatt06;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("Wie lang soll die Fibonacci Frequenz werden? Bitte nehmen Sie eine Zahl größer als 2.");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        double[] arr = new double[n + 1];
        if (n <= 2) {
            System.out.println("Die Fibonacci Zahlen für 0 und 1 (x Werte) sind 0 und 1 (y Werte). Deswegen nehmen sie bitte eine Zahl größer als 2.");
        } else if (n > 1477) {
            System.out.println("Für alle Fibonacci Zahlen größer gleich 1477 gilt: Dass deren Wert infinity ist. Deswegen scheitert dann auch die Berechnung des Quotienten, wenn beide Zahlen infinity ist.");

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
                System.out.println("Der Quotient der letzten beiden Fibonacci Zahlen ist: " + quotient);
            }
        }
    }
}
