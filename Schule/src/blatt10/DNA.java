package blatt10;

import blatt07.ArbeitMitArrays;

public class DNA {
    /*
    a) 1Byte = 8Bit
        2^8 = 256   | -1 Bit für Vorzeichen
        2^7 = 128
        0 beinhaltet in den positiven Werten --> 0 bis 127
        negative Werte (ohne 0) --> -1 bis -128

     e) Byte-Array (Laenge n) --> n*8 Bit + Haedder (also das was gebraucht wird, damit java weiß, dass das eine Liste ist)
        String (Laenge n) --> n*16Bit + evtl. Haedder

     h) boolean-Array (Laenge n) --> n*2 Bit + Haedder

     k) Speicherplatz--> h) da alles in booleans gespeichert wird.
     */

    /**
     * Überprüft, ob ein String ein DNA-Strang sein kann.
     * @param s String, welcher überprüft wird
     * @return true/false
     */
    public static boolean istDNA (String s){
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 'A' && arr[i] != 'T' && arr[i] != 'G' && arr[i] != 'C') {

                return false;
            }
            if (i%2!=0){
                switch (arr[i]) {
                    case 'A', 'T':
                        if (arr[i-1] == 'G' || arr[i-1] == 'C') {
                            return false;
                        }
                        break;
                    case 'G', 'C':
                        if (arr[i-1] == 'A' || arr[i-1] == 'T') {
                            return false;
                        }
                        break;
                }
            }
        }
        return true;
    }

    /**
     * Umwandlung eines DNA-Stranges aus einem String zu einem Byte-Array
     * @param s String
     * @return Byte-Array
     */
    public static byte[] zuDNA (String s){
        char[] arr = s.toCharArray();
        byte[] dna = new byte[arr.length];
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case 'A':
                    dna[i] = 0;
                    break;
                case 'T':
                    dna[i] = 1;
                    break;
                case 'G':
                    dna[i] = 2;
                    break;
                case 'C':
                    dna[i] = 3;
                    break;
            }
        }
        return dna;
    }

    /**
     * Umwandlung eines DNA-Stranges von einem Byte-Array zu einem String
     * @param dna Byte-Array
     * @return String
     */
    public static String zuDNA (byte[] dna){

        char[] arr = new char[dna.length];
        for (int i = 0; i < dna.length; i++) {
            switch (dna[i]) {
                case 0:
                    arr[i] = 'A';
                    break;
                case 1:
                    arr[i] = 'T';
                    break;
                case 2:
                    arr[i] = 'G';
                    break;
                case 3:
                    arr[i] = 'C';
                    break;
            }
        }

        return new String(arr);
    }

    /**
     * Umwandlung eines DNA-Strangs aus einem String zu einer boolischen Liste
     * @param s String
     * @return boolean-Array
     */
    public static boolean[] zuDNA_Bool(String s){
        char[] arr = s.toCharArray();
        boolean[] bool = new boolean[arr.length*2];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case 'A':
                    bool[j] = false;
                    bool[j+1] = false;
                    break;
                case 'T':
                    bool[j] = false;
                    bool[j+1] = true;
                    break;
                case 'G':
                    bool[j] = true;
                    bool[j+1] = false;
                    break;
                case 'C':
                    bool[j] = true;
                    bool[j+1] = true;
                    break;
            }
            j+=2;
        }
        return bool;
    }

    /**
     * Umwandlung einer boolischen Liste eines DNA-Stranges zu einem String
     * @param bool boolean Array
     * @return String
     */
    public static String zuDNA_Bool(boolean[] bool){
        char[] arr = new char[bool.length/2];
        int j = 0;
        for(int i = 0; i < bool.length; i+=2){
            if(bool[i]){
                if(bool[i+1]){
                    arr[j] = 'C';
                } else{
                    arr[j] = 'G';
                }
            }else{
                if(bool[i+1]){
                    arr[j] = 'T';
                }else{
                    arr[j] = 'A';
                }
            }
            j++;
        }
        return new String(arr);
    }

    /**
     * Umwandlung eines DNA-Stranges aus einem String in ein Byte-Array, wobei jedes Element 4 DNA-Moleküle speichert.
     * @param s String (Datenverlust, wenn nicht (s.length %4 == 0))
     * @return byte-Array
     */
    public static byte[] zuDNA_effizient (String s){
        char[] arr = s.toCharArray();
        boolean[] dna_bool = zuDNA_Bool(s);
        byte[] dna = new byte[arr.length/4];

        for (int i = 1; i <= dna.length; i++) {
            int zweierPotenz = 1;
            int dezimalZahl = 0;
            for (int j = 7; j >= 0; j--) {
                if (dna_bool[j+((i-1)*8)]) {
                    dezimalZahl += zweierPotenz;
                }
                zweierPotenz *= 2;
            }
            dna[i-1] = (byte) (dezimalZahl-128);
        }
        // Information: je 4 Elemente des Strings werden zusammengepackt, da A = (00)2, deshalb können wir keine Felder lehr lassen
        // |-> die Anzahl an Elementen muss durch 4 Teilbar sein, da sonst die letzten 2 Elemente verloren gehen!!!

        return dna;
    }

    /**
     * Umwandlung eines DNA-Stranges aus einem Byte-Array, wobei jedes Element 4 DNA-Moleküle speichert, in einen String.
     * @param dna boolean-Array
     * @return String
     */
    public static String zuDNA_effizient (byte[] dna){
        boolean[] dna_bool= new boolean[dna.length*8];
        for (int i = 1; i <= dna.length; i++) {
            int zweierPotenz = 128;
            int dezimalZahl = dna[i-1]+128;
            for (int j = 0; j < 8; j++) {
                System.out.println(dezimalZahl);
                if(dezimalZahl>=zweierPotenz){
                    dezimalZahl-=zweierPotenz;
                    dna_bool[j+((i-1)*8)] = true;
                } else{
                    dna_bool[j+((i-1)*8)] = false;
                }
                zweierPotenz /= 2;
            }

        }
        return new String(zuDNA_Bool(dna_bool));
    }

}
