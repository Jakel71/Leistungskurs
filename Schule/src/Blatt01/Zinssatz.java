package Blatt01;

public class Zinssatz {
    public static void main(String[] args) {
        double Kapital = 1220.0 ;
        double Zinssatz = 0.0225 ;
        double Zinsen = Kapital * Zinssatz;
        System.out.println("Zinsen: " + Zinsen + "€");
        System.out.println("Neues Kapital: " + (Kapital+Zinsen) + " €");
    }
}
