package blatt20.A3;

public class Ofen {
    String[] modi = new String[]{"Aus", "Beleuchtung", "Unterhitze", "Oberhitze", "Unterhitze", "Oberhitze", "Umluft"};
    int beziehungsmodus;
    double temperatur;

    public Ofen() {
        int beziehungsmodus = 0;
        double temperatur = 0;
    }

    public void einstellenTemp(double zielTemp){
        this.temperatur = zielTemp;
        if(this.temperatur>250){
            this.temperatur=250;
        }
        if(this.temperatur<0){
            this.temperatur=0;
        }
    }

    public void modiWechselen(boolean up){
        if(up){
            this.beziehungsmodus += 1;
            if(beziehungsmodus >= modi.length){
                beziehungsmodus -= modi.length;
            }
        } else{
            this.beziehungsmodus -= 1;
            if(beziehungsmodus < 0){
                beziehungsmodus += modi.length;
            }
        }
    }

}
