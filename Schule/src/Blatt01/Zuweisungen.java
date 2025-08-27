package Blatt01;

public class Zuweisungen {
    public static void main(String[] args) {
        int a = 42;
        int b = a;
        a = ((a+3)*4-8)/2-2*b;
        //a = 6-4 = 2; herunterkürzbar darauf!
        //6 Rechenoperatoren

        System.out.println(a);
    }
}
