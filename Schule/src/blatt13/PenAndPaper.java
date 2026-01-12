package blatt13;

public class PenAndPaper {
    /**
     * Würfelt mit n Würfeln mit den Zahlen x
     * @param n Anzahl der Würfel
     * @param x Zahlenbereich zwischen 0 und x, welcher gewürfelt wird
     * @return Ergebnis
     */
    public static int wuerfel(int n, int x){
        int ergebnis = 0;
        for(int i=0;i<n;i++){
            ergebnis += Math.round(Math.random()*(x-1)+1);
        }
        return (int) ergebnis;
    }

    /**
     * Checkt, ob ein Wurf hoch genug ist, um eine Aktion durchzuführen
     * @param checkWert Wert, der zu erreichen ist
     * @param vorteil Vorteil (true/false)
     * @param nachteil nachteil (true/false)
     * @return true/false, ob eine Aktion gelingt
     */
    public static boolean check(int checkWert, boolean vorteil, boolean nachteil){
        int ergebnis = wuerfel(1,20);
        if (vorteil && !nachteil){
            int ergebnis2 = wuerfel(1,20);
            if (ergebnis2 > ergebnis){
                ergebnis = ergebnis2;
            }
        } else if (!vorteil && nachteil){
            int ergebnis2 = wuerfel(1,20);
            if (ergebnis2 < ergebnis){
                ergebnis = ergebnis2;
            }
        }

        if(ergebnis==1){
            System.out.println("Kritischer Fehlschlag");
            return false;
        } else if(ergebnis==20){
            System.out.println("Kritischer Treffer");
            return true;
        } else if(ergebnis >= checkWert){
            return true;
        } else{
            return false;
        }
    }

    /**
     * Berechnung eines Angriffs
     * @param n Anzahl der Angriffswürfel
     * @param x Zahlenbereich der Würfel
     * @param angriffsbonus Angriffsbonus (int)
     * @param ruestungsklasse Rüstungsklasse (int)
     * @param vorteil true/false
     * @param nachteil true/false
     * @param n2 Anzahl der Würfel des Zusatzschadens
     * @param x2 Zahlenbereich der Würfel für den Zusatzschaden
     * @return Angriffschaden / 0
     */
    public static int angriff (int n, int x,int angriffsbonus, int ruestungsklasse, boolean vorteil, boolean nachteil, int n2, int x2){
        int angriffsSchaden = wuerfel(n,x) + angriffsbonus + wuerfel(n2,x2);

        if (check(ruestungsklasse, vorteil, nachteil)){
            if (angriffsSchaden > 0){
                return angriffsSchaden;
            }
        }
        return 0;
    }

    /**
     * Kampfsimulation zwischen 2 Spielern
     * Spieler A:
     * @param hpA Hp
     * @param nA Anzahl der Würfel von Spieler A beim Angriff
     * @param xA Zahlenbereich der Würfel von Spieler A beim Angriff
     * @param angriffsbonusA Angriffbonus von Spieler A
     * @param ruestungsklasseA Rüstungsklasse von Spieler A
     * @param vorteilA Anzahl der Vorteilsrunden im Kampf
     * @param nachteilA Anzahl der Nachteilsrunden im Kampf
     * @param n2A Anzahl der Würfel für den Schadensbonus von Spieler A
     * @param x2A Zahlenbereich der Würfel für den Schadensbonus von Spieler A
     * Spieler B, siehe Sieler A
     * @param hpB
     * @param nB
     * @param xB
     * @param angriffsbonusB
     * @param ruestungsklasseB
     * @param vorteilB
     * @param nachteilB
     * @param n2B
     * @param x2B
     * @return
     */
    public static char kampf (int hpA, int nA, int xA, int angriffsbonusA, int ruestungsklasseA, int vorteilA, int nachteilA, int n2A, int x2A, int hpB, int nB, int xB, int angriffsbonusB, int ruestungsklasseB, int vorteilB, int nachteilB, int n2B, int x2B){
        int i=0;
        while(hpA>0 && hpB>0){
            i++;
            boolean nachteil2A = false;
            boolean vorteil2A = false;
            boolean nachteil2B = false;
            boolean vorteil2B = false;
            if(i<vorteilA){
                vorteil2A = true;
            }
            if(i<nachteilA){
                nachteil2A = true;
            }
            if(i<vorteilB){
                vorteil2B = true;
            }
            if(i<nachteilB){
                nachteil2B = true;
            }
            hpA-=angriff(nB,xB,angriffsbonusB,ruestungsklasseA,vorteil2B,nachteil2B,n2B,x2B);
            if(hpA<=0){
                break;
            }
            hpB-=angriff(nA,xA,angriffsbonusA,ruestungsklasseB,vorteil2A,nachteil2A,n2A,x2A);
            System.out.println(hpB);

        }

        if(hpA>0){
            return 'A';
        } else if (hpB>0){
            return 'B';
        }
        return 'u';
    }

    /**
     * Methode, welche die Gewinnauswertung der 100 Kämpfe vornimmt
     */
    public static void gewinnauswertungAlt(){
        int a = 0;
        int b = 0;
        int u = 0;
        for (int i=0; i<100; i++){
            char temp = kampf(70,1,8,1,14,0,3,1,10,42,1,6,2,10,3,0,0,0);
            if (temp == 'A'){
                a++;
            } else if (temp == 'B'){
                b++;
            } else {
                u++;
            }
        }
        System.out.println("Spieler A hat " + a + " kämpfe gewonnen!");
        System.out.println("Spieler B hat " + b + " kämpfe gewonnen!");
        System.out.println("Unentschieden: " + u);
    }

    /**
     * Gewinnauswertung wie oben, aber mit veränderten stats im Kampf zu gunsten des Barden
     * 1. Ruestungsklasse von 10 zu 16 --> großer Impcat
     * 2. Angriffsbonus von 2 zu 8 --> noch besser
     */

    public static void gewinnauswertungNeu (){
        int a = 0;
        int b = 0;
        int u = 0;
        for (int i=0; i<100; i++){
            char temp = kampf(70,1,8,1,14,0,3,1,10,42,1,6,8,16,3,0,0,0);
            if (temp == 'A'){
                a++;
            } else if (temp == 'B'){
                b++;
            } else {
                u++;
            }
        }
        System.out.println("Spieler A hat " + a + " kämpfe gewonnen!");
        System.out.println("Spieler B hat " + b + " kämpfe gewonnen!");
        System.out.println("Unentschieden: " + u);
    }

    public static void main(String[] args) {
        gewinnauswertungAlt();

        gewinnauswertungNeu();
    }
}
