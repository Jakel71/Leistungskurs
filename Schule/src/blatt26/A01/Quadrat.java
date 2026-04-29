package blatt26.A01;

public class Quadrat extends GeometrischesObjekt implements AbstandEbene{
    protected double laenge;

    public Quadrat(Punkt punkt, double laenge){
        this.punkt = punkt;
        this.laenge = laenge;
    }

    public double getLaenge() {
        return laenge;
    }

    public void setLaenge(double laenge) {
        this.laenge = laenge;
    }

    //Weil kein Punkt
    @Override
    public double flaecheninhalt(){
        return laenge*laenge;
    }

    @Override
    public double umfang(){
        return 4*laenge;
    }

    @Override
    public double distanz(AbstandEbene geo1) {
        if(geo1 instanceof Punkt){
            return 10;
        }else if(geo1 instanceof Quadrat){
            return 100;
        }else if(geo1 instanceof Rechteck){
            return -100;
        }else if(geo1 instanceof Kreis){
            return -10;
        }

        return 0;
    }
}
