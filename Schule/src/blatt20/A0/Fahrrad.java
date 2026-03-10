package blatt20.A0;

/**
 * Repräsentiert ein einfaches Fahrrad aus dem Info-Unterricht
 * @author Jan
 * @version 1.0
 */
public class Fahrrad {

    String typ;
    int gaengeVorne;
    int gaengeHinten;
    String marke;
    String[] farben;
    int reifendurchmesser; //cm
    boolean zugelassen;
    boolean ruecklicht;

    double currentSpeed; //km/h
    boolean amFahren;
    int currentGangVorne;
    int currentGangHinten;

    /**
     * beschleunigt auf Zielgeschwindigkeit
     * @param targetSpeed Zielgeschwindigkeit
     */
    public void beschleunigen (double targetSpeed){
        currentSpeed = targetSpeed;
    }

    /**
     * klingelt die klingel
     */
    public void klingeln(){
        System.out.println("Klingelingeling!");
    }

    /**
     * bremst auf Zielgeschwindigkeit
     * @param targetSpeed Zielgeschwindigkeit
     */
    public void bremsen (double targetSpeed){
        this.currentSpeed = targetSpeed;
    }

    /**
     * gibt an, ob ein Fahrrad gerade bewegt wird
     */
    public void fahren (){
        if(this.currentSpeed == 0){
            this.amFahren = false;
        } else {
            this.amFahren = true;
        }
    }

    /**
     * Schaltet die Gaenge
     * @param targetGangVorne Zielgang vorne; -1 für bleiben
     * @param targetGangHinten Zielgang hinten; -1 für bleiben
     */
    public void schalten(int targetGangVorne, int targetGangHinten){
        if(targetGangVorne!=-1) {
            this.currentGangVorne = targetGangVorne;
        }
        if(targetGangHinten!=-1) {
            this.currentGangHinten = targetGangHinten;
        }
    }

    /**
     * kurze beschreibung vom Fahrrad
     */
    public void beschreiben(){
        System.out.println("Beschreibung: " + this.typ + ", " + this.farben[0] + ", " + this.farben[1] + ", " + this.farben[2] + ", " + this.gaengeVorne+", " + this.gaengeHinten);
    }

}
