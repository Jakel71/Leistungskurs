package blatt26.A03;

/**
 * Klasse um einen Spieler zu beschreiben
 */
public class Spieler implements Comparable<Spieler>{
    private int id;
    private VerschKarten[] deck;
    protected int anzahlSterne;
    private boolean living;

    /**
     * Konstruktor
     * @param id des Spielers
     */
    public Spieler(int id) {
        this.id = id;
        this.deck =new VerschKarten[]{VerschKarten.Papier, VerschKarten.Papier, VerschKarten.Papier, VerschKarten.Papier,
                VerschKarten.Stein, VerschKarten.Stein, VerschKarten.Stein, VerschKarten.Stein,
                VerschKarten.Schere, VerschKarten.Schere, VerschKarten.Schere, VerschKarten.Schere};
        this.anzahlSterne = 3;
        this.living = true;
    }

    /**
     * getter
     */
    public int getId() {
        return id;
    }

    /**
     * getter, welcher eine random Karte auswählt.
     */
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

    /**
     * getter
     */
    public int getAnzahlKarten(){
        return this.deck.length;
    }

    /**
     * setter for living
     */
    public void kill(){
        this.living = false;
    }

    /**
     * getter
     */
    public boolean isLiving(){
        return this.living;
    }

    /**
     * Konverter für eine Ausgabe des Spielers
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Spieler ").append(id).append(" hat ").append(anzahlSterne).append(" Sterne und hat ").append(deck.length).append(" Karten:");
//        for (VerschKarten karte : deck) {
//            sb.append("\n").append(karte);
//        }
        return sb.toString();
    }

    /**
     * compareTo-Funktion, welche die Karten von Spieler 1 und Spieler 2 gegeneinander antreten lässt und daraus einen Wert zurückgibt.
     * @param o the object to be compared.
     * @return 1 = this has one; -1 = o has won; 0 = unentschieden
     */
    @Override
    public int compareTo(Spieler o) {
        VerschKarten k1 = this.getKarte();
        VerschKarten k2 = o.getKarte();
        if(k1==k2){
            return 0;
        }
        switch (k1) {
            case Papier:
                if (k2 == VerschKarten.Stein) {
                    return 1;
                } else {
                    return -1;
                }
            case Schere:
                if (k2 == VerschKarten.Papier) {
                    return 1;
                } else {
                    return -1;
                }
            case Stein:
                if (k2 == VerschKarten.Schere) {
                    return 1;
                } else {
                    return -1;
                }
        }
        return 0;
    }
}
