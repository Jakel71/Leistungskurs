package blatt20.A1;

public class Main {
    public static void main(String[] args) {
        Kafeemaschine k1 = new Kafeemaschine();

        k1.bohnenAuffuellen(350);
        k1.kaffesatzLeeren();
        k1.wasserLeeren(800);
        k1.wasserReinigen();
        k1.wasserAuffuellen(800);

        for (int i = 0; i < 200; i++) {
            k1.kaffeeZiehenSmart(10,200);
        }
    }
}
