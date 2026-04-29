package blatt26.A03;

import java.util.Arrays;

public class Spieler {
    private int id;
    private VerschKarten[] deck;
    protected int anzahlSterne;

    public Spieler(int id) {
        this.id = id;
        this.deck =new VerschKarten[]{VerschKarten.Papier, VerschKarten.Papier, VerschKarten.Papier, VerschKarten.Papier,
                VerschKarten.Stein, VerschKarten.Stein, VerschKarten.Stein, VerschKarten.Stein,
                VerschKarten.Schere, VerschKarten.Schere, VerschKarten.Schere, VerschKarten.Schere};
        this.anzahlSterne = 3;
    }

    public int getId() {
        return id;
    }


    public VerschKarten getKarte(){
        int num = (int) (Math.random() * this.deck.length);
        VerschKarten karte = this.deck[num];
        VerschKarten[] neueDeck = new VerschKarten[this.deck.length - 1];
        int temp =0;
        for (int i = 0; i < this.deck.length; i++) {
            if(i != num){
                neueDeck[temp] = this.deck[i];
                temp++;
            }
        }
        this.deck = neueDeck;
        return karte;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Spieler ").append(id).append(" hat ").append(anzahlSterne).append(" Sterne und hat ").append(deck.length).append(" Karten:");
        for (VerschKarten karte : deck) {
            sb.append("\n").append(karte);
        }
        return sb.toString();
    }


}
