package blatt26.A03;

import java.util.ArrayList;

/**
 * Klasse, welcher die Simulation macht
 */
public class Main {

    /**
     * Führt einen Kampf zwischen 2 Spielern aus, und verändert entsprechend die Sterne.
     * @param sp1 Spieler 1
     * @param sp2 Spieler 2
     */
    public static void battle(Spieler sp1,Spieler sp2){
       switch (sp1.compareTo(sp2)){
           case 1:
               sp1.anzahlSterne++;
               sp2.anzahlSterne--;
               break;
           case -1:
               sp1.anzahlSterne--;
               sp2.anzahlSterne++;
               break;
       }
    }

    /**
     * bestimmt die Anzahl der Spieler, welche noch kämpfen
     * @param spielers Liste aller Spieler
     * @return Anzahl der kämpfenden Spieler
     */
    public static int anzahlSpielerMitKarten(Spieler[] spielers){
        int anzahl = 0;
        for(Spieler spieler : spielers){
            if(spieler.getAnzahlKarten()>0 && spieler.isLiving()){
                anzahl++;
            }
        }
        return anzahl;
    }

    /**
     * Simuliert eine ganze Runde eines Kampfes
     * @param spieler liste aller Spieler
     * @return liste aller Spieler mit den neuen Stats
     */
    public static Spieler[] battleRound(Spieler[] spieler){
        ArrayList<Spieler> temp = new ArrayList<>();
        ArrayList<Integer> temp2 = new ArrayList<>();
        for (int i = 0; i < spieler.length; i++) {
            temp.add(spieler[i]);
            if(spieler[i].isLiving() && spieler[i].getAnzahlKarten()>0) temp2.add(spieler[i].getId());
        }
        spieler = temp.toArray(new Spieler[0]);
        int[] ids = new int[temp2.size()];
        for (int i = 0; i < temp2.size(); i++) {
            ids[i] = temp2.get(i);
        }
        int[] reihenfolge = new int[ids.length];

        for(int i=0; i<reihenfolge.length; i++){
            reihenfolge[i] = -1;
        }

        for(int i=0; i<reihenfolge.length; i++){
            int pos;
            do{
                pos = (int)(Math.random()*(reihenfolge.length));
            } while (reihenfolge[pos] !=-1);
            reihenfolge[pos] = ids[i];
        }

        for (int i = 0; i + 1 < reihenfolge.length; i+=2) {
            battle(spieler[reihenfolge[i]],spieler[reihenfolge[i+1]]);
        }

        for(int i=0; i<spieler.length; i++){
            if(spieler[i].anzahlSterne<=0){
                spieler[i].kill();
            }
        }

        return spieler;
    }

    /**
     * Simuliert das Spiel für n Spieler
     * @param anzahlSpieler n Spieler
     */
    public static void simGame(int anzahlSpieler){
        Spieler[] spieler = new Spieler[anzahlSpieler];
        for(int i=0; i<anzahlSpieler; i++){
            spieler[i] = new Spieler(i);
        }
        int timeOut = 100;
        while(anzahlSpielerMitKarten(spieler)>1) {
            System.out.println("Es sind noch " + anzahlSpielerMitKarten(spieler) + " Spieler im Spiel.");
            if(anzahlSpielerMitKarten(spieler)==3){
                timeOut --;
            }
            if(timeOut==0){
                break;
            }
            spieler = battleRound(spieler);
        }

        for (int i = 0; i < spieler.length; i++) {
            if(spieler[i].anzahlSterne<3 || spieler[i].getAnzahlKarten()>0){
                System.out.println("Spieler " + spieler[i].getId() + " ist nun versklavt.");
            } else {
                System.out.println("Spieler " + spieler[i].getId() + " hat " + (spieler[i].anzahlSterne-3)*10000 + " €.");
            }
        }
    }

    public static void main(String[] args) {
        simGame(8);
    }

    /*
    Reduktion aus der Realität:
    - Spieler wählen ihre Karte eigentlich nicht Random, für unsere Simulation jedoch einfacher.
    - Karten können nicht vernichtet werden, aber bei einem Spieler mit 0 Sternen werden alle Karten vernichtet --> Unlogik, im Real life können die Karten zerstört werden, auch wenn es extremst schwer wäre, alles ist zerstörbar
     */
}
