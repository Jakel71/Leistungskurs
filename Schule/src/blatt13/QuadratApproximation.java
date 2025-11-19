package blatt13;

public class QuadratApproximation {
    /**
     * Quadriert b
     * @param b double Basis
     * @return Quadrietes b
     */
    public static double flaecheQuadrat(double b){
        return b*b;
    }

    /**
     * Quadratwurzelsuche ohne Wurzelziehn mithilfe der Intervallhalbierung:
     * @param b Das Quadrierte
     * @return Basis
     */
    public static double sucheSeitenlaenge (double b){
        double l = 0;
        double r = b;
        while (r - l > 0.00001){
            double m = (r+l)/2;
            if(m*m > b){
                r = m;
            }else{
                l = m;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(sucheSeitenlaenge(25));
    }
}
