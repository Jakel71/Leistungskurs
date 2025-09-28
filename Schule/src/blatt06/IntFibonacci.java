package blatt06;

import java.util.Scanner;

public class IntFibonacci {
    public static void main(String[] args) {
        System.out.println("Wie lang soll die Fibonacci Frequenz werden? Bitte nehmen Sie eine Zahl größer als 2.");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n + 1];
        if (n <= 2) {
            System.out.println("Die Fibonacci Zahlen für 0 und 1 (x Werte) sind 0 und 1 (y Werte). Deswegen nehmen sie bitte eine Zahl größer als 2.");
        }else { // Ab 1477 kommt infinity raus, deswegen limitiere ich das ganze mal darauf. Es wird nur noch das erste infinity ausgegeben.
            arr[0] = 0;
            arr[1] = 1;
            System.out.println("Der Wert für Fibonacci an Stelle 0 ist: " + arr[0]);
            System.out.println("Der Wert für Fibonacci an Stelle 1 ist: " + arr[1]);
            for (int i = 2; i <= n; i++) {
                arr[i] = arr[i - 2] + arr[i - 1];
                System.out.println("Der Wert für Fibonacci an Stelle " + i + " ist: " + arr[i]);
            }
            double quotient =  (double) arr[n] / arr[n - 1];
            System.out.printf("Der Quotient der letzten beiden Fibonacci Zahlen ist: %.2f", quotient);

            /*
            für n --> 46 (ab 47 gehts wieder negativ (wegen dem Datentyp), deswegen schauen wir uns das ganze hier jetzt nur mal bis 46 an):
            Quotient --> 1,62 (terminal ausgabe)
            Ergänzung: im DoubleFibonacci.java Programm bleibt der wert bis zu 1476 bei 1,62, danach ändert das Programm den Zahlen wert auf infinity.
             */
        }
    }
}
