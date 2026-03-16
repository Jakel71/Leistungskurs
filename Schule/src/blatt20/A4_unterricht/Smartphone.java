package blatt20.A4_unterricht;

public class Smartphone {
    private String marke;
    private String Modell;
    private int akkustand;
    private double speicherplatz; // max Speicher (ROM)
    private double preis;

    /**
     * parameter-Konstruktor:
     * @param marke Marke des Gerätes
     * @param Modell  Modell des Gerätes
     * @param akkustand Akkustand des Gerätes
     * @param speicherplatz ROM des Gerätes
     * @param preis Preis des Gerätes
     */
    public Smartphone(String marke, String Modell, int akkustand, double speicherplatz, double preis) {
        this.marke = marke;
        this.Modell = Modell;
        this.akkustand = akkustand;
        this.speicherplatz = speicherplatz;
        this.preis = preis;
    }

    /**
     * getter
     * @return marke
     */
    public String getMarke() {
        return marke;
    }

    /**
     * getter
     * @return modell
     */
    public String getModell() {
        return Modell;
    }

    /**
     * getter
     * @return akkustand
     */
    public int getAkkustand() {
        return akkustand;
    }

    /**
     * getter
     * @return Speicherplatz
     */
    public double getSpeicherplatz() {
        return speicherplatz;
    }

    /**
     * getter
     * @return Preis
     */
    public double getPreis() {
        return preis;
    }

    /**
     * setter
     * @param akkustand neuer Akkustand; gültig: alles zwischen 1 und 100
     */
    public void setAkkustand(int akkustand) {
        this.akkustand = akkustand;
        if(akkustand <0){
            this.akkustand = 0;
        }
        if(akkustand > 100){
            this.akkustand = 100;
        }
    }
}
