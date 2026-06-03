package blatt29.A04;

public abstract class Wesen {
    private double hp;
    private double maxHp;
    private double staerke;
    private double konstitution;
    private double glueck;
    private double geschwindigkeit;
    private double magicStaerke;
    private double magicKonstitution;
    private double mp;
    private double sp;

    public Wesen kampf(Wesen o){
        return null;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(double maxHp) {
        this.maxHp = maxHp;
    }

    public double getStaerke() {
        return staerke;
    }

    public void setStaerke(double staerke) {
        this.staerke = staerke;
    }

    public double getKonstitution() {
        return konstitution;
    }

    public void setKonstitution(double konstitution) {
        this.konstitution = konstitution;
    }

    public double getGlueck() {
        return glueck;
    }

    public void setGlueck(double glueck) {
        this.glueck = glueck;
    }

    public double getGeschwindigkeit() {
        return geschwindigkeit;
    }

    public void setGeschwindigkeit(double geschwindigkeit) {
        this.geschwindigkeit = geschwindigkeit;
    }

    public double getMagicStaerke() {
        return magicStaerke;
    }

    public void setMagicStaerke(double magicStaerke) {
        this.magicStaerke = magicStaerke;
    }

    public double getMagicKonstitution() {
        return magicKonstitution;
    }

    public void setMagicKonstitution(double magicKonstitution) {
        this.magicKonstitution = magicKonstitution;
    }

    public double getMp() {
        return mp;
    }

    public void setMp(double mp) {
        this.mp = mp;
    }

    public double getSp() {
        return sp;
    }

    public void setSp(double sp) {
        this.sp = sp;
    }
}
