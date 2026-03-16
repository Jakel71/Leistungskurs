package blatt20.A3;

public class Ofenherd {
    Ofen ofen = new Ofen();
    Kochfeld[] kochfelder;

    public Ofenherd(int felder,String groesseKochfeldEins, String groesseKochfeldZwei, String groesseKochfeldDrei, String groesseKochfeldVier) {

        kochfelder = new Kochfeld[felder];
        kochfelder[0] = new Kochfeld(groesseKochfeldEins);
        if(kochfelder.length>1){
            kochfelder[1] = new Kochfeld(groesseKochfeldZwei);
        }
        if(kochfelder.length>2){
            kochfelder[2] = new Kochfeld(groesseKochfeldDrei);
        }
        if(kochfelder.length>3){
            kochfelder[3] = new Kochfeld(groesseKochfeldVier);
        }
    }

    public void hitzeEinstellen(int kochfeld, int ziel){
        while(kochfelder[kochfeld].hitzestufe != ziel){
            if(kochfelder[kochfeld].hitzestufe>ziel){
                kochfelder[kochfeld].hitze(false);
            }
            if(kochfelder[kochfeld].hitzestufe<ziel){
                kochfelder[kochfeld].hitze(true);
            }
        }
    }
}
