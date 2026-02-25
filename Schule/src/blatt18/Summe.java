package blatt18;

public class Summe {

    public static int summe(int n){
        if (n==1){
            return 1;
        } else{
            return n+summe(n-2);
        }
    }
    public static void main(String[] args){
        System.out.println(summe(47));
    }
}
