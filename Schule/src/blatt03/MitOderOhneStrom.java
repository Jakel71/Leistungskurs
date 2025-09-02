package blatt03;

import java.util.Scanner;

public class MitOderOhneStrom {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Auswählen des Gatters
        System.out.println("Wählen sie bitte ein Gatter: NOT; OR; AND; XOR");
        String gatter = input.nextLine();
        if (gatter.equals("NOT")) {
            System.out.println("Das NOT-Gatter:\nDas Gatter verfügt über einen Eingang und einen Ausgang.\nBefindet sich auf dem ersten Eingang Strom? (true/false)");
            Boolean strom1 = input.nextBoolean();
            System.out.printf("%b NOT = %b", strom1, !strom1);
        }else if (gatter.equals("AND")) {
            System.out.println("Das AND-Gatter:\nDas Gatter verfügt über 2 Eingänge und einen Ausgang.\nBefindet sich auf dem ersten Eingang Strom? (true/false)");
            Boolean strom1 = input.nextBoolean();
            System.out.println("Befindet sich auf dem zweiten Eingang Strom? (true/false)");
            Boolean strom2 = input.nextBoolean();
            System.out.printf("%b AND %b = %b", strom1, strom2, strom1 == strom2);
        }else if (gatter.equals("XOR")) {
            System.out.println("Das XOR-Gatter");
        }else if (gatter.equals("OR")) {

        }else{
            System.out.println("Sie müssen ein Gatter eingeben, dass Programm beendet sich jetzt.");
            System.exit(0);
        }


    }
}
