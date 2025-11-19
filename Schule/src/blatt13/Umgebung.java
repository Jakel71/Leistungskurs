package blatt13;

public class Umgebung {
    /**
     * Logeritmus funktion zur ermittlung einer nähe zur 0:
     * @param b Basis (0<b<1)
     * @param e Ergebnis (nähe zur null, z.B. 0,001 , 0,1)
     * @return Exponent
     */
    public static double findeExponent (double b ,double e){
        int x = 1;
        double base = b;
        if (0<b && b<1){
            while(base>e){
                base*=b;
                x++;
            }
            return x;
        }else {
            return -10000;
        }
    }

    public static void main(String[] args) {
        System.out.println(findeExponent(0.5,0.001));
    }
}
