package blatt20.A6_unterricht;

public class Charakter {
    private String name;
    private String gesichtsklasse;
    private String spezialItem;

    private Kart kart;
    private Item aktuellesItem;

    public Charakter(String name, String gesichtsklasse, String spezialItem) {
        this.name = name;
        this.gesichtsklasse = gesichtsklasse;
        this.spezialItem = spezialItem;
    }

    public String getName() {
        return name;
    }

    public String getGesichtsklasse() {
        return gesichtsklasse;
    }

    public String getSpezialItem() {
        return spezialItem;
    }

    public Kart getKart() {
        return kart;
    }

    public Item getAktuellesItem() {
        return aktuellesItem;
    }

    public void setKart(Kart kart) {
        this.kart = kart;
    }

    public void setAktuellesItem(Item aktuellesItem) {
        this.aktuellesItem = aktuellesItem;
    }

    public void lenkeKart(Kart k){
        System.out.println("Wurde gelenkt");
    }

    public void halteItem(Item i){
        System.out.println("Defence on");
    }

    public void wirfItem (Item i){
        System.out.println("Attack");
    }
}
