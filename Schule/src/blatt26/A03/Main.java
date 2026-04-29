package blatt26.A03;

import java.util.ArrayList;

public class Main {
    public static void battle(Spieler sp1,Spieler sp2){
        VerschKarten k1 = sp1.getKarte();
        VerschKarten k2 = sp2.getKarte();
        if(k1==k2){
            return;
        }
        switch (k1) {
            case Papier:
                if (k2 == VerschKarten.Stein) {
                    sp1.anzahlSterne++;
                    sp2.anzahlSterne--;
                } else {
                    sp1.anzahlSterne--;
                    sp2.anzahlSterne++;
                }
                break;
            case Schere:
                if (k2 == VerschKarten.Papier) {
                    sp1.anzahlSterne++;
                    sp2.anzahlSterne--;
                } else {
                    sp1.anzahlSterne--;
                    sp2.anzahlSterne++;
                }
                break;
            case Stein:
                if (k2 == VerschKarten.Schere) {
                    sp1.anzahlSterne++;
                    sp2.anzahlSterne--;
                } else {
                    sp1.anzahlSterne--;
                    sp2.anzahlSterne++;
                }
                break;
        }
    }
    
    public static Spieler[] battleRound(Spieler[] spieler){
        ArrayList<Spieler> temp = new ArrayList<>();
        for (int i = 0; i < spieler.length; i++) {
            if(spieler[i]!=null) temp.add(spieler[i]);
        }
        spieler = temp.toArray(new Spieler[0]);
        int[] reihenfolge =new int[spieler.length];

        for(int i=0; i<reihenfolge.length; i++){
            reihenfolge[i] = -1;
        }

        for(int i=0; i<reihenfolge.length; i++){
            int pos;
            do{
                pos = (int)(Math.random()*(reihenfolge.length));
            } while (reihenfolge[pos] !=-1);
            reihenfolge[pos] = i;
        }

        for (int i = 0; i < reihenfolge.length; i+=2) {
            battle(spieler[reihenfolge[i]],spieler[reihenfolge[i+1]]);
        }
        for(int i=0; i<spieler.length; i++){
            if(spieler[i].anzahlSterne<=0){
                spieler[i] = null;
            }
        }

        return spieler;
    }

    public static void simGame(int anzahlSpieler){
        Spieler[] spieler = new Spieler[anzahlSpieler];
        for(int i=0; i<anzahlSpieler; i++){
            spieler[i] = new Spieler(i);
        }
        for (int i = 0; i < 12; i++) {
            battleRound(spieler);
        }

        for (int i = 0; i < spieler.length; i++) {
            if(spieler[i]==null){
                System.out.println("Spieler " + spieler[i].getId() + " ist nun versklavt.");
            } else {
                System.out.println("Spieler " + spieler[i].getId() + " hat " + spieler[i].anzahlSterne + " Sterne.");
            }
        }
    }

    public static void main(String[] args) {
        simGame(8);
    }
}
