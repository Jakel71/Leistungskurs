package blatt20.A2_unterricht;

/**
 * Generiert eine Auto-Klasse
 * @author Jan
 * @version 1.0
 */
public class Auto {

    private String marke;
    private String modell;
    private int tank;
    private int geschwindigkeit;
    private int kilometerstand;

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
     * getter für Marke
     * @return marke
     */
    public String getMarke() {
        return marke;
    }

    /**
     * setter für Marke
     * @param marke Marke; gültig: jeder String
     */
    public void setMarke(String marke) {
        this.marke = marke;
    }

    /**
     * getter für Modell
     * @return Modell
     */
    public String getModell() {
        return modell;
    }

    /**
     * setter für modell
     * @param modell modell; gültig: jeder String
     */
    public void setModell(String modell) {
        this.modell = modell;
    }

    /**
     * getter für Tank
     * @return Tank in Liter
     */
    public int getTank() {
        return tank;
    }

    /**
     * setter für Tank
     * @param tank Tank; gültig: jeder int >= 0
     */
    public void setTank(int tank) {
        this.tank = tank;
        if(this.tank<0){
            this.tank = 0;
        }
//        if(this.tank>100){
//            this.tank = 100;
//        }
    }

    /**
     * getter für Geschwindigkeit
     * @return Geschwindigkeit in km/h
     */
    public int getGeschwindigkeit() {
        return geschwindigkeit;
    }

    /**
     * setter für Geschwindigkeit
     * @param geschwindigkeit Geschwindigkeit; gültig: jeder int >=0
     */
    public void setGeschwindigkeit(int geschwindigkeit) {
        this.geschwindigkeit = geschwindigkeit;
        if(this.geschwindigkeit<0){
            this.geschwindigkeit = 0;
        }
    }

    /**
     * getter für Kilometerstand
     * @return Kilometerstand in km
     */
    public int getKilometerstand() {
        return kilometerstand;
    }

    /**
     * setter für Kilometerstand
     * @param kilometerstand Kilometerstand; gültig: jeder int >=0;
     */
    public void setKilometerstand(int kilometerstand) {
        this.kilometerstand = kilometerstand;
        if(this.kilometerstand<0){
            this.kilometerstand = 0;
        }
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
