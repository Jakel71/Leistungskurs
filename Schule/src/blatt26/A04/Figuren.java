package blatt26.A04;

/**
 * Klasse um Schachfiguren darzustellen
 */
public class Figuren implements java.io.Serializable{
    private Farbe farbe;
    private Rolle rolle;
    private static final long serialVersionUID = 1L;

    /**
     * Konstruktor
     */
    public Figuren(Farbe farbe, Rolle rolle) {
        this.farbe = farbe;
        this.rolle = rolle;
    }

    /**
     * Print Ausgabe
     */
    @Override
    public String toString() {
        return "Figuren{" +
                "farbe=" + farbe +
                ", rolle=" + rolle +
                '}';
    }

}
