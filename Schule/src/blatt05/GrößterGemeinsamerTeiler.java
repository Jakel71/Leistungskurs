package blatt05;

import java.util.Scanner;

public class GrößterGemeinsamerTeiler {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int h;
        int counter = 0;
        System.out.println("Geben sie A ein: ");
        int a = input.nextInt();
        System.out.println("Geben sie B ein: ");
        int b = input.nextInt();
        while(a!=b){
            if(a<b){
                h = a;
                a = b;
                b = h;
            }
            a -= b;
            counter++;
        }
        System.out.println("A: " + a);
        System.out.println("Counter: " + counter);
    }
}
