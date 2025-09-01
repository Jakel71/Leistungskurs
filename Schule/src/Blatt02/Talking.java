package Blatt02;

import java.util.Scanner; //Import des Scanners

public class Talking {
    public static void main (String [] args){
        Scanner input = new Scanner (System.in); // Bennen und aktivieren des Scanners
        System.out.println("Guten Tag, wie heißen Sie?"); // Frage
        String daniel = input.nextLine(); //Input(siehe Phyton) // Antwort
        System.out.println("Hallo " + daniel + "!"); // Begrüßung

    }
}
