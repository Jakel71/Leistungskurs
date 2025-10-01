package blatt08;

public class Zahlensysteme {
    public static boolean istDezimal (String eingabe) {
        char [] eingabeArray = eingabe.toCharArray();
        if (eingabeArray[0] == '(' || eingabeArray[eingabeArray.length-3] == ')' || eingabeArray[eingabeArray.length-2] == '2' || eingabeArray[eingabeArray.length-2] == '1'|| eingabeArray[eingabeArray.length-1] == '6') {
            return false;
        }else  {
            return true;
        }
    }
    public static void main(String[] args) {
        System.out.println(istDezimal("(10101)2"));
    }
}
