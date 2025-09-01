package Blatt02;

import java.util.Scanner;

public class Zinssatz {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Altes Kapital (in €): ");
        double kapital = input.nextDouble() ; // TODO: Input von negativen Zahlen verhindern
        System.out.print("Zinssatz (in %): ");
        double zinssatz = input.nextDouble() ; // TODO: Input von negativen Zahlen verhindern
        double zinsen = kapital * zinssatz/100;
        System.out.printf(" \nZinsen: %.2f € \n", zinsen);
        System.out.printf("Neues Kapital: %.2f €", (kapital+zinsen));
    }
}
