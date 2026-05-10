package blatt26.A04;

import java.io.*;
import java.util.Arrays;

public class Schachbrett implements Serializable {
    private Figuren[][] brett = new Figuren[8][8];
    private static final long serialVersionUID = 1L;

    public Schachbrett(){
        this.brett =new Figuren[][]{
                {new Figuren(Farbe.SCHWARZ, Rolle.TURM), new Figuren(Farbe.SCHWARZ, Rolle.SPRINGER), new Figuren(Farbe.SCHWARZ, Rolle.LAEUFER), new Figuren(Farbe.SCHWARZ, Rolle.DAME), new Figuren(Farbe.SCHWARZ, Rolle.KOENIG), new Figuren(Farbe.SCHWARZ, Rolle.LAEUFER), new Figuren(Farbe.SCHWARZ, Rolle.SPRINGER), new Figuren(Farbe.SCHWARZ, Rolle.TURM)},
                {new Figuren(Farbe.SCHWARZ, Rolle.BAUER),new Figuren(Farbe.SCHWARZ, Rolle.BAUER),new Figuren(Farbe.SCHWARZ, Rolle.BAUER),new Figuren(Farbe.SCHWARZ, Rolle.BAUER),new Figuren(Farbe.SCHWARZ, Rolle.BAUER),new Figuren(Farbe.SCHWARZ, Rolle.BAUER),new Figuren(Farbe.SCHWARZ, Rolle.BAUER),new Figuren(Farbe.SCHWARZ, Rolle.BAUER)},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {new Figuren(Farbe.WEISS, Rolle.BAUER),new Figuren(Farbe.WEISS, Rolle.BAUER),new Figuren(Farbe.WEISS, Rolle.BAUER),new Figuren(Farbe.WEISS, Rolle.BAUER),new Figuren(Farbe.WEISS, Rolle.BAUER),new Figuren(Farbe.WEISS, Rolle.BAUER),new Figuren(Farbe.WEISS, Rolle.BAUER),new Figuren(Farbe.WEISS, Rolle.BAUER)},
                {new Figuren(Farbe.WEISS, Rolle.TURM), new Figuren(Farbe.WEISS, Rolle.SPRINGER), new Figuren(Farbe.WEISS, Rolle.LAEUFER), new Figuren(Farbe.WEISS, Rolle.DAME), new Figuren(Farbe.WEISS, Rolle.KOENIG), new Figuren(Farbe.WEISS, Rolle.LAEUFER), new Figuren(Farbe.WEISS, Rolle.SPRINGER), new Figuren(Farbe.WEISS, Rolle.TURM)}
        };
    }

    public Schachbrett(File f){
        this.brett = load(f).brett;
    }

    public boolean placeFigur(Figuren figur, int x, int y){
        if(brett[x][y]==null){
            brett[x][y]=figur;
            return true;
        }
        return false;
    }

    public boolean clearFeld(int x, int y){
        if(brett[x][y]!=null){
            brett[x][y]=null;
            return true;
        }
        return false;
    }

    public void save(File f){
        try {
            FileOutputStream out = new FileOutputStream(f);
            ObjectOutputStream oout = new ObjectOutputStream(out);
            oout.writeObject(this);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Fehler beim Speichern des Schachbretts: " + e.getMessage());
        }
    }

    public Schachbrett load(File f){
        try {
            ObjectInputStream oin = new ObjectInputStream(new FileInputStream(f));
            return (Schachbrett) oin.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Fehler beim Laden des Schachbretts: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Figuren[] reihe : brett) {
            for (Figuren figur : reihe) {
                if (figur == null) {
                    sb.append("   | ");
                } else {
                    sb.append(figur.toString()).append(" | ");
                }
            }
            sb.append("\n----------------------------------------------------------------------------------------\n");
        }
        return sb.toString();
    }
}
