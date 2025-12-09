package blatt13;

public class Risiko {
    /**
     * Simulation über einen Angriff im Spiel Risiko
     * @return 2=Verteidiger gewinnt; 1= Angreifer gewinnt; 0 = unentschieden (beide verlieren 1)
     */
    public static int risikoSimulation(){
        int[] wurfAngreifer = new int[3];
        for (int i=0; i<3; i++){
            wurfAngreifer[i] = Zufall.zufallGanz(6,1);
        }
        wurfAngreifer = blatt12.InsertionSort.insertionSortInPlace(wurfAngreifer);

        int[] wurfVerteidiger = new int[2];
        for (int i=0; i<2; i++){
            wurfVerteidiger[i] = Zufall.zufallGanz(6,1);
        }
        wurfVerteidiger = blatt12.InsertionSort.insertionSortInPlace(wurfVerteidiger);


        int lostAngreifer = 0;
        int lostVerteidiger = 0;

        if (wurfAngreifer[2]>wurfVerteidiger[1]){
            lostVerteidiger++;
        }else {
            lostAngreifer++;
        }

        if (wurfAngreifer[1]>wurfVerteidiger[0]){
            lostVerteidiger++;
        }else {
            lostAngreifer++;
        }

        if (lostAngreifer>1){
            return 2;
        } else if (lostVerteidiger>1) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Berechnung der Gewinnchancen mit einer bestimmten Anzahl an Durchgängen + ausgabe in Commandline
     * @param anzahlVersuche die Anzahl an Versuchen
     */
    public static void risikoChancen (int anzahlVersuche){
        double lostAngreifer = 0; // wie oft der Angreifer beide Figuren verliert
        double lostVerteidiger = 0;
        double unendschieden = 0;

        for (int i=0; i<anzahlVersuche; i++){
            int temp = risikoSimulation();

            if (temp ==2){
                lostAngreifer++;
            } else if (temp ==1){
                lostVerteidiger++;
            } else if (temp ==0){
                unendschieden++;
            }
        }
        System.out.printf("Der Angreifer gewinnt in %.2f %% der Fälle!\n", (lostVerteidiger/ (double) anzahlVersuche)*100);
        System.out.printf("Der Verteidiger gewinnt in %.2f %% der Fälle!\n", (lostAngreifer/ (double)  anzahlVersuche)*100);
        System.out.printf("Beide Spieler verlieren eine Spielfigur in %.2f %% der Fälle!\n", (unendschieden/ (double) anzahlVersuche)*100);
    }

    public static void main(String[] args) {
        for (int i=0; i<3; i++){
            risikoChancen(10);
        }
    }
}
