package blatt08;

public class Zahlensysteme {
    /**
     * Überprüft, ob es sich um eine dezimale Zahl handelt
     * @param eingabe Die Zahl in Form von einem String
     * @return true / false
     */

    public static boolean istDezimal (String eingabe) {
        char [] eingabeArray = eingabe.toCharArray();
        if (eingabeArray[0] == '(' || eingabeArray[eingabeArray.length-3] == ')' || eingabeArray[eingabeArray.length-2] == ')' || eingabeArray[eingabeArray.length-2] == '2' || eingabeArray[eingabeArray.length-2] == '1'|| eingabeArray[eingabeArray.length-1] == '6') {
            return false;
        }else  {
            return true;
        }
    }

    /**
     * Überprüft, ob es sich um eine binäre Zahl handelt
     * @param eingabe die Zahl in String Form
     * @return true / false
     */
    public static boolean istBinaer (String eingabe) {
        char [] eingabeArray = eingabe.toCharArray();
        if (eingabeArray[0] == '(' && eingabeArray[eingabeArray.length-2] == ')' && eingabeArray[eingabeArray.length-1] == '2') {
            return true;
        }else  {
            return false;
        }
    }

    /**
     * Überprüft, ob es sich um eine Hexadezimale Zahl handelt
     * @param eingabe Die Zahl in String Form
     * @return true / false
     */
    public static boolean istHexadezimal (String eingabe) {
        char [] eingabeArray = eingabe.toCharArray();
        if (eingabeArray[0] == '(' && eingabeArray[eingabeArray.length-3] == ')'&& eingabeArray[eingabeArray.length-2] == '1'&& eingabeArray[eingabeArray.length-1] == '6') {
            return true;
        }else  {
            return false;
        }
    }

    /**
     * Konvertiert Binär- und Hexadezimalzahlen zu Dezimalzahlen
     * @param eingabe Im String format gegeben Zahl (Hex oder binär)
     * @return Dezimalzahl
     */
    public static int zuDezimal (String eingabe) {
        if (istBinaer(eingabe)) { // Binär
            char [] eingabeArray = eingabe.toCharArray();
            int zweierPotenz = 1;
            int dezimalZahl = 0;
            for (int i = eingabeArray.length-1; i >= 0; i--) {
                if (eingabeArray[i] == '1') {
                    dezimalZahl += zweierPotenz;
                }
                zweierPotenz *= 2;
            }
            return dezimalZahl;
        } else if (istHexadezimal(eingabe)) { // Hexadezimal
            char [] eingabeArray = Palindrom.umdrehen(eingabe).toCharArray();
            int sechszehnerPotenz = 1;
            int dezimalZahl = 0;
            for (int i = 0; i < eingabeArray.length; i++) {
                if (eingabeArray[i] == 'A') {
                    dezimalZahl += 10*sechszehnerPotenz;
                } else if (eingabeArray[i] == 'B') {
                    dezimalZahl += 11*sechszehnerPotenz;
                } else if (eingabeArray[i] == 'C') {
                    dezimalZahl += 12*sechszehnerPotenz;
                } else if (eingabeArray[i] == 'D') {
                    dezimalZahl += 13*sechszehnerPotenz;
                }else if (eingabeArray[i] == 'E') {
                    dezimalZahl += 14*sechszehnerPotenz;
                } else if (eingabeArray[i] == 'F') {
                    dezimalZahl += 15*sechszehnerPotenz;
                } else{
                    dezimalZahl += eingabeArray[i]*sechszehnerPotenz;
                }
                sechszehnerPotenz *= 16;
            }
            return dezimalZahl;
        } else { // Dezimalzahl oder Schwachsinn (z.B. "fhacnheivnhvwmdlir")
            return Integer.parseInt(eingabe);
        }
    }
    public static void main(String[] args) {
        System.out.println(zuDezimal("(B12951)16"));
    }
}
