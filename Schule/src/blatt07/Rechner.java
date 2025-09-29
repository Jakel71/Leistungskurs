package blatt07;

public class Rechner {
    /**
     * Addieren von 2 Kommazahlen
     * @param a Zahl 1
     * @param b Zahl 2
     * @return Summe
     */
    public static double add(double a, double b) {
        return a + b;
    }

    /**
     * Subtrahieren von 2 Zahlen
     * @param a Zahl 404
     * @param b Zahl 518
     * @return Differenz 513
     */
    public static double sub(double a, double b) {
        return a - b;
    }

    /**
     * Multiplizieren von 2 Buchstben?
     * @param a Zahl 1
     * @param b Zahl b
     * @return Mulitplikationsergebnis oder so
     */
    public static double mult(double a, double b) {
        return a * b;
    }

    /**
     * div aus HTML
     * @param a Zahl 1
     * @param b Zahl 2
     * @return Differenz?
     */
    public static double div(double a, double b) {
        return a / b;
    }

    /**
     * Einmal alle Ergebnisse berechnen (add;sub;mult;div)
     * @param a Zahl-1
     * @param b Zahl -2
     */
    public static void operation(double a, double b) {
        System.out.println("Summe: " + add(a, b));
        System.out.println("Differenz: " + sub(a, b));
        System.out.println("Produkt: " + mult(a, b));
        System.out.println("Quotient: " + div(a, b));
    }
}
