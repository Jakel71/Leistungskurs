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
            ergebnis += Math.round(Math.random()*x);
        }
        return ergebnis;
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

    public static int angriff (int n, int x,int angriffsbonus, int ruestungsklasse){
        int angriffsSchaden = wuerfel(n,x);

        if (check(ruestungsklasse, false, false)){
            return angriffsSchaden;
        } else{
            return -1;
        }
        
    }

    public static void main(String[] args){

    }
}
