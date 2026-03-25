package blatt20.A4_unterricht;

import java.util.Objects;

/**
 * Generiert eine Smartphone-Klasse
 * @author Jan
 * @version 1.0
 */
public class Smartphone {
    private String marke;
    private String modell;
    private int akkustand;
    private double speicherplatz; // max Speicher (ROM)
    private double preis;
    private double displayGroesse;
    private int helligkeit; // in Prozent
    private int lautstaerke; // in Prozent
    private String betriebssystem;
    private boolean eingeschaltet;
    private double maxSpeicher;

    /**
     * parameter-Konstruktor:
     * @param marke Marke des Gerätes
     * @param modell  Modell des Gerätes
     * @param akkustand Akkustand des Gerätes
     * @param speicherplatz ROM des Gerätes
     * @param preis Preis des Gerätes
     * @param displayGroesse Displaygroesse in Zoll
     * @param helligkeit von 0-100%
     * @param lautstaerke von 0-100%
     * @param betriebssystem Betriebssystem, meistens Android / IOS
     * @param eingeschaltet true/false, ob Geraet an
     * @param maxSpeicher maximaler Speicher eines Geraetes
     */
    public Smartphone(String marke, String modell, int akkustand, double speicherplatz, double preis, double displayGroesse, int helligkeit, int lautstaerke, String betriebssystem, boolean eingeschaltet, double maxSpeicher) {
        this.marke = marke;
        this.modell = modell;
        this.akkustand = akkustand;
        this.speicherplatz = speicherplatz;
        this.preis = preis;
        this.displayGroesse = displayGroesse;
        this.helligkeit = helligkeit;
        this.lautstaerke = lautstaerke;
        this.betriebssystem = betriebssystem;
        this.eingeschaltet = eingeschaltet;
        this.maxSpeicher = maxSpeicher;
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
        return modell;
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
     * getter
     * @return Display Groesse in Zoll
     */
    public double getDisplayGroesse() {
        return displayGroesse;
    }

    /**
     * getter
     * @return Helligkeit in %
     */
    public int getHelligkeit() {
        return helligkeit;
    }

    /**
     * getter
     * @return Laustsärke in %
     */
    public int getLautstaerke() {
        return lautstaerke;
    }

    /**
     * getter
     * @return Betriebssystem
     */
    public String getBetriebssystem() {
        return betriebssystem;
    }

    /**
     * getter
     * @return Eingeschaltet
     */
    public boolean getEingeschaltet() {
        return eingeschaltet;
    }

    /**
     * getter
     * @return Maximaler Speicher eines Gerätes
     */
    public double getMaxSpeicher() {
        return maxSpeicher;
    }

    /**
     * setter
     * @param akkustand
     */
    public void setAkkustand(int akkustand) {
        this.akkustand = akkustand;
        if(this.akkustand <0){
            this.akkustand = 0;
        }
        if(this.akkustand > 100){
            this.akkustand = 100;
        }
    }

    /**
     * setter
     * @param preis
     */
    public void setPreis(double preis) {
        this.preis = preis;
    }

    /**
     * setter
     * @param helligkeit
     */
    public void setHelligkeit(int helligkeit) {
        this.helligkeit = helligkeit;
        if(helligkeit < 0){
            this.helligkeit = 0;
        }
        if(helligkeit > 100){
            this.helligkeit = 100;
        }
    }

    /**
     * setter
     * @param lautstaerke
     */
    public void setLautstaerke(int lautstaerke) {
        this.lautstaerke = lautstaerke;
        if(lautstaerke < 0){
            this.lautstaerke = 0;
        }
        if(lautstaerke > 100){
            this.lautstaerke = 100;
        }
    }

    /**
     * setter
     * @param betriebssystem
     */
    public void setBetriebssystem(String betriebssystem) {
        this.betriebssystem = betriebssystem;
    }

    /**
     * setter
     * @param eingeschaltet
     */
    public void setEingeschaltet(boolean eingeschaltet) {
        this.eingeschaltet = eingeschaltet;
    }

    /**
     * setter
     * @param speicherplatz
     */
    public void setSpeicherplatz(double speicherplatz) {
        this.speicherplatz = speicherplatz;
        if(speicherplatz < 0){
            this.speicherplatz = 0;
        }
        if(this.maxSpeicher<this.speicherplatz){
            this.speicherplatz = this.maxSpeicher;
        }
    }



    /**
     * löscht den gesamten Speicher!
     */
    public void speicherLeeren(){
        this.speicherplatz = 0;
        this.betriebssystem = null;
    }

    /**
     * setter (lädt den Akku)
     * @param zielStand zielwert
     */
    public void akkuLaden(int zielStand){
        this.akkustand = zielStand;
        if(zielStand <0){
            this.akkustand = 0;
        }
        if(zielStand > 100){
            this.akkustand = 100;
        }
    }

    /**
     * schaltet das geraet ein
     */
    public void einschalten(){
        if(!this.eingeschaltet){
            this.eingeschaltet = true;
        }
    }

    /**
     * akku Leer?
     * @return true/false
     */
    public boolean istAkkuLeer(){
        if(this.akkustand == 0){
            this.eingeschaltet = false;
            return true;
        }
        return false;
    }

    /**
     * installiert App
     * @param benoetigterSpeicher Speicher der App, wenn kleiner als max speicher, dann passiert nichts
     */
    public void appInstallieren(double benoetigterSpeicher){
        if(hatGenugSpeicher(benoetigterSpeicher)){
            this.speicherplatz += benoetigterSpeicher;
        }
    }

    /**
     * test, ob genug speicher vorhanden ist
     * @param speicher benoetigter Speicher
     * @return true/false
     */
    public boolean hatGenugSpeicher(double speicher){
        if(this.maxSpeicher-this.speicherplatz>speicher){
            return true;
        }
        return false;
    }

    /**
     * eigene equals funktion, überschreibt den "normalen" equals, mit eigenen Attributen, welche verglichen werden
     * @param o   the reference object with which to compare.
     * @return true/false
     */
    @Override
    public boolean equals(Object o) {
        //1. Referenzvergleich
        if(this == o){
            return true;
        }

        //2. Typprüfung
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        //3. Cast
        Smartphone that = (Smartphone) o;

        //4.Attributprüfung
        return Double.compare(speicherplatz, that.speicherplatz) == 0 && Double.compare(preis, that.preis) == 0 && Double.compare(displayGroesse, that.displayGroesse) == 0 && Double.compare(maxSpeicher, that.maxSpeicher) == 0 && Objects.equals(marke, that.marke) && Objects.equals(modell, that.modell) && Objects.equals(betriebssystem, that.betriebssystem);
    }

}
