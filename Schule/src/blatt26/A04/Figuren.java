package blatt26.A04;

public class Figuren implements java.io.Serializable{
    private Farbe farbe;
    private Rolle rolle;
    private static final long serialVersionUID = 1L;

    public Figuren(Farbe farbe, Rolle rolle) {
        this.farbe = farbe;
        this.rolle = rolle;
    }

    @Override
    public String toString() {
        return "Figuren{" +
                "farbe=" + farbe +
                ", rolle=" + rolle +
                '}';
    }

}
