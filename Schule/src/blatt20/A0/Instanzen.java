package blatt20.A0;

public class Instanzen {
    public static void main(String[] args) {
        Fahrrad fahrrad1 = new Fahrrad();
        fahrrad1.typ = "Rennrad";
        fahrrad1.gaengeVorne = 2;
        fahrrad1.gaengeHinten = 7;
        fahrrad1.marke = "KS-Cycling";
        fahrrad1.farben = new String[]{"Schwarz","Blau","Orange"};
        fahrrad1.reifendurchmesser = 60; //cm
        fahrrad1.zugelassen = false;
        fahrrad1.ruecklicht = true;
        fahrrad1.currentSpeed = 0; //km/h
        fahrrad1.amFahren = false;
        fahrrad1.currentGangVorne = 1;
        fahrrad1.currentGangHinten = 2;

        System.out.println("Gaenge vorne: " + fahrrad1.gaengeVorne);
        fahrrad1.klingeln();
    }
}
