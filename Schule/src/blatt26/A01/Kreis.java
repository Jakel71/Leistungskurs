package blatt26.A01;

public class Kreis extends GeometrischesObjekt implements AbstandEbene{
    protected double radius;

    public Kreis(Punkt punkt, double radius){
        this.punkt = punkt;
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    //Weil kein Punkt
    @Override
    public double flaecheninhalt(){
        return Math.PI*radius*radius;
    }

    @Override
    public double umfang(){
        return 2*Math.PI*radius;
    }

}
