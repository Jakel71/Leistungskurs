package blatt08;

public class Klammernsprache {
    /**
     * Überprüfung, ob es ein Klammerwort ist
     * @param eingabe Eingabe String
     * @return true/false
     */
    public static boolean istKlammerwort(String eingabe) {
        char [] eingabeArray = eingabe.toCharArray();
        boolean isfound;
        for (int i = 0; i < eingabeArray.length; i++) {
            if (eingabeArray[i] == ')') {
                isfound = false;
                for  (int j = 0; j < i; j++) {
                    if (eingabeArray[j] == '(') {
                        isfound = true;
                        eingabeArray[j] = ' ';
                        break;
                    }
                }
                if (!isfound) {
                    return false;
                }

            }
        }
        return true;
    }
}
