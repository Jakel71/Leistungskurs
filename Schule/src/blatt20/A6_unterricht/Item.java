package blatt20.A6_unterricht;

public class Item {
    private String name;
    private String wirkung;
    private boolean aktiv;

    public Item(String name, String wirkung){
        this.name = name;
        this.wirkung = wirkung;
        this.aktiv = false;
    }

    public String getName() {
        return name;
    }

    public String getWirkung() {
        return wirkung;
    }

    public boolean isAktiv() {
        return aktiv;
    }

    public void wirkeAn(Charakter c){
        System.out.println("Wirkung");
    }
}
