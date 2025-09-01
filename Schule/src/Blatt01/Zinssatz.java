package Blatt01;

public class Zinssatz {
    public static void main(String[] args) {
        double Kapital = 1220.0 ;
        double Zinssatz = 2.25 ;
        double Zinsen = Kapital * Zinssatz /100;
        System.out.println("Altes Kapital: " + Kapital + " €");
        System.out.println("Zinssatz: " + Zinssatz + " %\n");
        System.out.println("Zinsen: " + Zinsen + " €");
        System.out.println("Neues Kapital: " + (Kapital+Zinsen) + " €");
    }
}
