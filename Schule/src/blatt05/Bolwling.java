package blatt05;

import java.util.Scanner;

public class Bolwling {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int counter = 0;
        int multiplier = 1;
        int runde_Multiplier = 0;
        int treffer = 0;
        int treffer_sum = 0;
        boolean strike = false;
        for (int i = 1; i <= 10; i++) {
            System.out.println("Sie befinden sich in Runde: " + i);
            for (int j = 1; j <= 2; j++) {
                System.out.println("Sie befinden sich in Wurf: " + j);
                do {
                    System.out.println("Geben Sie bitte Ihre Getroffene Würfe ein");
                    treffer = input.nextInt();
                    if ((j ==1 &&(treffer >= 11 || treffer <= -1)) || (treffer + treffer_sum >= 11 || treffer + treffer_sum<= -1)) {
                        System.out.println("Sie haben sich vertippt.");
                    }
                }while ((j ==1 &&(treffer >= 11 || treffer <= -1)) || (treffer + treffer_sum >= 11 || treffer + treffer_sum<= -1));

                if (treffer == 10 && j==1) {
                    System.out.println("Strike");
                    counter+=10*multiplier;
                    multiplier ++;
                    runde_Multiplier +=3;
                    strike = true;
                    System.out.println("Sie haben " + counter + " Punkte");
                } else if (treffer_sum == 10 && j==2) {
                    System.out.println("Spare");
                    counter+=10*multiplier;
                    multiplier ++;
                    runde_Multiplier +=2;
                    System.out.println("Sie haben " + counter + " Punkte");
                } else {
                    treffer_sum += treffer;
                    if (j==2) {
                        counter+=treffer_sum*multiplier;
                        System.out.println("Sie haben "+ treffer_sum + " Punkte getroffen.");
                    }
                }
                if (runde_Multiplier > 1) {
                    runde_Multiplier --;
                } else {
                    multiplier = 1;
                }

                if (strike) {
                    strike = false;
                    break;
                }
            }
            treffer_sum = 0;

        }
    }
}
