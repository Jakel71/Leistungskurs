package blatt08;

public class Kalender {
    /**
     * Gibt aus dem Datum (TT.MM.JJ) (String) den Tag zurück
     * @param eingabe String (TT.MM.JJ)
     * @return Tag (int)
     */
    public static int getTag (String eingabe) {
        char[] eingabeArray = eingabe.toCharArray();
        String tag = String.valueOf(eingabeArray[0]) + String.valueOf(eingabeArray[1]);
        return Integer.parseInt(tag);
    }
    /**
     * Gibt aus dem Datum (TT.MM.JJ) (String) den Monat zurück
     * @param eingabe String (TT.MM.JJ)
     * @return Monat (int)
     */
    public static int getMonat (String eingabe) {
        char[] eingabeArray = eingabe.toCharArray();
        String Monat = String.valueOf(eingabeArray[3]) + String.valueOf(eingabeArray[4]);
        return Integer.parseInt(Monat);
    }
    /**
     * Gibt aus dem Datum (TT.MM.JJ) (String) das Jahr (vierstellige Schreibweise!) zurück
     * @param eingabe String (TT.MM.JJ)
     * @return Jahr (int)
     */
    public static int getJahr (String eingabe) {
        char[] eingabeArray = eingabe.toCharArray();
        String jahr = String.valueOf(eingabeArray[6]) + String.valueOf(eingabeArray[7]) + String.valueOf(eingabeArray[8]) + String.valueOf(eingabeArray[9]);
        return Integer.parseInt(jahr);
    }

    /**
     * Überprüft, ob es sich um ein Schaltjahr handelt
     * @param jahr Das Jahr (int)
     * @return true / false
     */
    public static boolean istSchaltjahr (int jahr) {
        if (jahr %400 == 0) {
            return true;
        } else if (jahr % 4 == 0 && jahr % 100 != 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Konvetiert Tag (int), Monat (int) und Jahr (int) zu einem String (TT.MM.JJ)
     * @param tag int Zahl
     * @param monat int Zahl
     * @param jahr int Zahl
     * @return String (TT.MM.JJ)
     */
    public static String zuDatum (int tag, int monat, int jahr) {
        return  String.valueOf(tag) + "." + String.valueOf(monat) + "." + String.valueOf(jahr);
    }

    /**
     * Berechnung des nächsten Tages aus dem String (TT.MM.JJ)
     * @param eingabe String (im Format: TT.MM.JJ)
     * @return String (im Format: TT.MM.JJ)
     */
    public static String naechsterTag (String eingabe) {
        int tag = getTag(eingabe) + 1;
        int monat = getMonat(eingabe);
        int jahr = getJahr(eingabe);
        int [] anzahltage = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        boolean istSchaltjahr = istSchaltjahr(jahr);
        if (istSchaltjahr && monat == 2 && tag > 29 ) {
            tag -= 29;
            monat += 1;
            System.out.println("Schaltjahr + Tages überschreitung im Februar");
        } else if (tag > anzahltage[monat-1]) {
            tag -= anzahltage[monat-1];
            monat += 1;
        }
        if (monat > 12) {
            jahr++;
            monat -= 12;
        }
        return zuDatum(tag, monat, jahr);
    }

}
