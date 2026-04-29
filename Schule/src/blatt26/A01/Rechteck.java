package blatt26.A01;

public class Rechteck extends GeometrischesObjekt implements AbstandEbene{
    protected double laenge1;
    protected double laenge2;

    public Rechteck(Punkt punkt, double laenge1, double laenge2){
        this.punkt = punkt;
        this.laenge1 = laenge1;
        this.laenge2 = laenge2;
    }

    public double getLaenge1() {
        return laenge1;
    }

    public double getLaenge2() {
        return laenge2;
    }

    public void setLaenge1(double laenge1) {
        this.laenge1 = laenge1;
    }

    public void setLaenge2(double laenge2) {
        this.laenge2 = laenge2;
    }

    //Weil kein Punkt
    @Override
    public double flaecheninhalt(){
        return laenge1*laenge2;
    }

    @Override
    public double umfang(){
        return 2*(laenge1+laenge2);
    }

}
