package blatt13;

public class MonteCarlo {
    /**
     * Pi Aproximieren
     * @param a Genauigkeit, 0< wert < 1
     * @param r Radius des Brunnens (<1)
     * @return Pi
     */
    public static double piAproximation(double a, double r){
        double pi = 0;
        double drinnen = 0;
        double drausen = 0; //s steht für ß
        while(Math.abs(Math.PI-pi) > a){
            double x = Math.random()-r;
            double y = Math.random()-r;
            double abstand = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
            if(abstand <r){
                drinnen++;
            } else{
                drausen++;
            }

            pi = (4*drinnen)/(drinnen+drausen);
        }
        return pi;
    }
    /*
    c) Reduktion: die Wand des Brunnens ist 0 * die Planck-Länge (1,6*10^-35 m) breit. Zusätzlich wird der Oberflächenumfang der Tropfen ignoriert.

    d) wir lassen uns 2 randomgenerierte werte geben, diese werden als Koordinaten verwendet, um den Abstand via dem Satz des Phytagoras zu berechnen. Damit wird dann bestimmt, ob die Tropfen innen oder außen liegen,danach wird daraus pi berechnet, falls die Annäherung noch nicht nah genug ist, fangen wir wieder von vorne an, also 2 neue Koordinaten.
     */
    public static void main(String[] args) {
        System.out.println("Pi is " + piAproximation(0.00000000001,0.5));
    }
}
