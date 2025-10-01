package blatt07;

public class Stein {
    /**
     * Berechnet den größten gemeinsamen Teiler (ggT) und gibt ihn zurück
     * @param a Zahl 1 (natürliche Zahl)
     * @param b Zahl 2 (natürliche Zahl)
     * @return ggT (größter gemeinsamer Teiler) (double Wert)
     */
    public static double ggTBerechnen(int a, int b) {
        int k = 0;
        double ggT;

        while (a != 0 && b != 0) {
            if (a % 2 == 0 && b % 2 == 0) {
                a/=2;
                b/=2;
                k++;
            } else if (a % 2 == 0) {
                a/=2;
            } else if (b % 2 == 0) {
                b/=2;
            } else {
                if (a>b){
                    a = (a-b)/2;
                } else{
                    b = (b-a)/2;
                }
            }
        }

        if (a==0){
            ggT= b*Math.pow(2,k);
        } else{
            ggT= a*Math.pow(2,k);
        }
        return ggT;
    }
}
