package blatt20.A0;

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
    
    public void beschleunigen (double targetSpeed){
        currentSpeed = targetSpeed;
    }
    public void klingeln(){
        System.out.println("Klingelingeling!");
    }

    public void bremsen (double targetSpeed){
        currentSpeed = targetSpeed;
    }

    public void fahren (){
        if(currentSpeed == 0){
            amFahren = false;
        }
        amFahren = true;
    }

    public void schalten(int targetGangVorne, int targetGangHinten){
        if(targetGangVorne!=-1) {
            currentGangVorne = targetGangVorne;
        }
        if(targetGangHinten!=-1) {
            currentGangHinten = targetGangHinten;
        }
    }

    public void beschreiben(){
        System.out.println("Beschreibung: " + this.typ + ", " + this.farben[0] + ", " + this.farben[1] + ", " + this.farben[2] + ", " + this.gaengeVorne+", " + this.gaengeHinten);
    }

}
