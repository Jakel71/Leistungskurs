package blatt20.A3;

public class Kochfeld {
    int hitzestufe;
    String groesse;

    public Kochfeld(int hitzestufe, String groesse) {
        this.hitzestufe = hitzestufe;
        this.groesse = groesse;
    }

    public void hitze(boolean mehr){
        if(mehr){
            if(this.hitzestufe<6) {
                this.hitzestufe += 1;
            }
        } else if(this.hitzestufe>0) {
            this.hitzestufe -= 1;
        }
    }
}
