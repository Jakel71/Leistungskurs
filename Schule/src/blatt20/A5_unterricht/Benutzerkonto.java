package blatt20.A5_unterricht;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Generiert eine benutzerkonto-Klasse
 * @author Jan
 * @version 1.0
 */
public class Benutzerkonto {
    private String benutzername;
    private String eMail;
    private String Geburtsdatum;
    private String passwort;
    private double guthaben;
    private String[][] codes = new String[][]{{"BLABLA","10"},{"1233456789","15"},{"dfgeaufjseofoewa","20"}};
    private String erstellDatum;

    /**
     * Prameter-Konstuktor
     */
    public Benutzerkonto(String benutzername, String eMail, String geburtsdatum, String passwort, double guthaben) {
        this.benutzername = benutzername;
        this.eMail = eMail;
        Geburtsdatum = geburtsdatum;
        this.passwort = passwort;
        this.guthaben = guthaben;

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        this.erstellDatum = now.format(formatter);
    }

    /**
     * returned if login data is correct
     * @param name username || eMail
     * @param passwort password
     * @return ture/false
     */
    public boolean login(String name, String passwort) {
        if ((this.benutzername.equals(name) || this.eMail.equals(name)) && this.passwort.equals(passwort)) {
            return true;
        }
        return false;
    }

    /**
     * aendert Passwort, wenn aktuelles Password richtig ist
     * @param passwortALT altes Passwort
     * @param passwort neues Passwort
     */
    public void setPasswort(String passwortALT, String passwort, String passwortWieder) {
        if(this.passwort.equals(passwortALT) && passwortWieder.equals(passwort)) {
            this.passwort = passwort;
        }
    }

    /**
     * fügt Guthaben aus einem Code hinzu
     * @param code Code
     */
    public void setGuthaben(String code) {
        for (int i = 0; i < this.codes.length; i++) {
            if(this.codes[i][0].equals(code)) {
                this.guthaben += Integer.parseInt( codes[i][1]);
            }
        }
    }

    /**
     * Setter, welcher nur verringern darf
     * @param guthaben neuer Wert
     */
    public void verringerGuthaben(double guthaben) {
        if(this.guthaben > guthaben) {
            this.guthaben = guthaben;
        }
    }

    /**
     * getter
     * @return guthaben
     */
    public double getGuthaben() {
        return this.guthaben;
    }

    /**
     * getter
     * @return datum der Kontoeröffnung
     */
    public String getErstellDatum() {
        return erstellDatum;
    }


    /**
     * getter
     * @return Benutzernamen
     */
    public String getBenutzername() {
        return benutzername;
    }

    /**
     * getter
     * @return eMail Adresse
     */
    public String geteMail() {
        return eMail;
    }

    /**
     * getter
     * @return Geburstag
     */
    public String getGeburtsdatum() {
        return Geburtsdatum;
    }
}
