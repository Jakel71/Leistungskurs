package blatt19;

public class ggT {
    public static int ggT(int a, int b){
        if(a==b){
            return a;
        } else if (a>b) {
            return ggT(a-b, b);
        } else {
            return ggT(a, b-a);
        }
    }
}
