package blatt08;

public class Palindrom {
    /**
     * Dreht einen String um
     * @param eingabe Eingabe String
     * @return Ausgabe String (umgedreht)
     */
    public static String umdrehen (String eingabe){
        char[] eingabeArray = eingabe.toCharArray();
        char[] ausgabeArray = new char[eingabeArray.length];
        for (int i = 0; i < ausgabeArray.length; i++) {
            ausgabeArray[i] = eingabeArray[eingabeArray.length - i - 1];
        }
        return new String(ausgabeArray);
    }

    /**
     * Überprüfung, ob es sich um ein Palindrom handelt
     * @param eingabe Eingabe String
     * @return true/false
     */
    public static boolean istPalindrom (String eingabe){;
        String vergleichsArray = umdrehen(eingabe);
        if (vergleichsArray.equals(eingabe)) {
            return true;
        } else{
            return false;
        }
    }

}
