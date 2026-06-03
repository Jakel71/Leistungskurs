package blatt29.A04;

public abstract class Held extends Wesen{
    private Items[] items;

    public double angreifenN(){
        return this.getStaerke()*0.8+this.getStaerke()*0.2*(Math.random()*this.getGlueck());
    }
    public double angreifenM(){
        return this.getMagicStaerke()*0.8+this.getMagicStaerke()*0.2*(Math.random()*this.getGlueck());
    }

    public double verteidigungN(){
        return this.getKonstitution()*0.8+this.getKonstitution()*0.2*(Math.random()*this.getGlueck());
    }
    public double verteidigungM(){
        return this.getMagicKonstitution()*0.8+this.getMagicKonstitution()*0.2*(Math.random()*this.getGlueck());
    }


}
