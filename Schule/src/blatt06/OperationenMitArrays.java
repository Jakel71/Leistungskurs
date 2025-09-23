package blatt06;

import java.util.Arrays;

public class OperationenMitArrays {
    public static void main(String[] args) {
        int [] auftraege = new int[] {9000, 23000, 41000, 6000, 13000, 22000, 38000, 16000, 7000, 14000, 12000, 5000, 17000};
        int sum = 0;
        int wert = 0;
        for(int i=0;i<auftraege.length;i++){
            sum+=auftraege[i];
            if(auftraege[i]>15000){
                wert++;
            }
        }
        //Seite 2:
        int zwischenSpeicher = 0;
        zwischenSpeicher = auftraege[1];
        auftraege[1] = auftraege[6];
        auftraege[6] = zwischenSpeicher;

        zwischenSpeicher = auftraege[0];
        for(int i=1;i<auftraege.length;i++){
            auftraege[i-1]=auftraege[i];
        }
        auftraege[auftraege.length-1] = zwischenSpeicher;

        System.out.println("Die Summe aller Aufträge ist: " + sum + " €");
        System.out.println("Die Anzahl der Werte über 15000 € ist: " + wert);
    }
}
