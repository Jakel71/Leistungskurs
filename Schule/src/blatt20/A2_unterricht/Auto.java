package blatt20.A2_unterricht;

/**
 * Generiert eine Auto-Klasse
 * @author Jan
 * @version 1.0
 */
public class Auto {

    String marke;
    String modell;
    int tank;
    int geschwindigkeit;
    int kilometerstand;

    /**
     * PARAMETER-KONSTRUKTOR: generiert ein Auto mit den übergebenen Werten
     * @param marke Marke
     * @param modell Modell
     * @param tank Tank
     * @param geschwindigkeit Geschwindigkeit
     * @param kilometerstand Kilometerstand
     */
    public Auto(String marke, String modell, int tank, int geschwindigkeit, int kilometerstand) {
        this.marke = marke;
        this.modell = modell;
        this.tank = tank;
        this.geschwindigkeit = geschwindigkeit;
        this.kilometerstand = kilometerstand;
    }

    /**
     * COPY-KONSTRUKTOR: Generiert ein Auto als Abbild eines anderen Autos;
     * ACHTUNG: nur VERWEIS, keine Kopie
     * @param a1 anderes Auto
     */
    public Auto(Auto a1) {
        this.marke = a1.marke;
        this.modell = a1.modell;
        this.tank = a1.tank;
        this.geschwindigkeit = a1.geschwindigkeit;
        this.kilometerstand = a1.kilometerstand;
    }

    /**
     * DEFAULT-KONSTRUKTOR: normalfall, kann leer oder mit Standartwerten gefüllt werden
     */
    public Auto() {
        this.marke = "N/A";
        this.modell = "N/A";
        /* für Standartwerte:
        this.marke = "BMW";
        this.tank = 60;
        ...
         */
    }


    /**
     * beschleunigt auf v
     * @param v km/h
     */
    public void beschleunigen (int v){
    }

    /**
     * bremst auf v
     * @param v km/h
     */
    public void bremsen (int v){
    }

    /**
     * faehrt Anzahl an km weiter
     * @param km strecke
     */
    public void fahren (int km){
    }
}
