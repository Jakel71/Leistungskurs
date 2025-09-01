package Blatt02;

import java.util.Scanner;

public class Multiplikation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nenne die erste (ganze) Zahl");
        int multiplikationsZahl1 = input.nextInt();
        System.out.println("Nenne die zweite (ganze) Zahl");
        int multiplikationsZahl2 = input.nextInt();
        System.out.printf("%d * %d = %d", multiplikationsZahl1, multiplikationsZahl2, multiplikationsZahl1 * multiplikationsZahl2);
    }
}