package blatt26.A04;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        Schachbrett schachbrett = new Schachbrett();
        System.out.println(schachbrett);
        schachbrett.placeFigur(new Figuren(Farbe.WEISS, Rolle.DAME), 4, 4);
        File f = new File("Schule" + File.separator + "src" + File.separator + "blatt26" + File.separator + "A04" + File.separator + "schachbrett.schach");
        schachbrett.save(f);
        Schachbrett s2 = new Schachbrett(f);
        System.out.println(s2);

    }
}
