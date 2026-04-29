package blatt26.A01;

public abstract class GeometrischesObjekt {
    protected Punkt punkt;

    public double flaecheninhalt(){
        return -10000;
    }

    public double umfang(){
        return -10000;
    }

    public Punkt getPunkt() {
        return punkt;
    }

    public void setPunkt(Punkt punkt) {
        this.punkt = punkt;
    }

    //Vererbung --> gleicher Startpunkt
    //Interface --> kommunikation zwischen Klassen
}
