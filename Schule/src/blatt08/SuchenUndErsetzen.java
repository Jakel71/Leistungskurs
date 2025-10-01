package blatt08;

public class SuchenUndErsetzen {
    /**
     * Sucht und ersetzt einen Char in einem String
     * @param gesucht Gesuchter Char (wird ersetzt)
     * @param sollErsetzen ersetzen mit (Char)
     * @param eingabe der String
     * @return String mit ersetzten Zeichen
     */
    public static String ersetzen (char gesucht,char sollErsetzen, String eingabe) {
        char [] eingabeArray = eingabe.toCharArray();
        for (int i = 0; i < eingabeArray.length; i++) {
            if (eingabeArray[i] == gesucht) {
                eingabeArray[i] = sollErsetzen;
            }
        }
        return new String(eingabeArray);
    }

    public static void main(String[] args) {
        System.out.println(ersetzen('l','I', "Hello World"));
    }
}
