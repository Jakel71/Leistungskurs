package Blatt01;

public class Zuweisungen {
    public static void main(String[] args) {
        int a = 42;
        int b = a;
        a = ((a+3)*4-8)/2-2*b;

        System.out.println(a);
    }
}
