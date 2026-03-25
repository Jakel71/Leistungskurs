package blatt20.A6_unterricht;

public class Kart {
    private String modellName;
    private double maxGeschwindigkeit;
    private double beschleunigung;

    private Charakter charakterOne;
    private Charakter charakterTwo;



    public Kart(String modellName, double maxGeschwindigkeit, double beschleunigung, Charakter charakterOne, Charakter charakterTwo) {
        this.modellName = modellName;
        this.maxGeschwindigkeit = maxGeschwindigkeit;
        this.beschleunigung = beschleunigung;
        this.charakterOne = charakterOne;
        this.charakterTwo = charakterTwo;
    }

    public String getModellName() {
        return modellName;
    }

    public Double getMaxGeschwindigkeit() {
        return maxGeschwindigkeit;
    }

    public Double getBeschleunigung() {
        return beschleunigung;
    }

    public Charakter getCharakterOne() {
        return charakterOne;
    }

    public Charakter getCharakterTwo() {
        return charakterTwo;
    }

    public void beschleunigen(){
        System.out.println("Geschwindigkeit++");
    }

    public void bremse(){
        System.out.println("Geschwindigkeit--");
    }

    public void drifte(){
        System.out.println("Kurve scharf.");
    }
}
