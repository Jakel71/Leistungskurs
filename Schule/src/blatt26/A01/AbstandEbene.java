package blatt26.A01;

public interface AbstandEbene{
    public default double distanz(AbstandEbene geo1){
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
