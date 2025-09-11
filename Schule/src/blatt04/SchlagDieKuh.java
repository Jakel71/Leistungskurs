package blatt04;

import java.util.Random;
import java.util.Scanner;

public class SchlagDieKuh {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rnd = new Random();
        System.out.println("Möchten sie Schlag die Kuh spielen (true) oder möchten sie das Programm spielen lassen(false)?");
        boolean schlagDieKuh = input.nextBoolean();
        if (schlagDieKuh) {
            int topfX = rnd.nextInt(0, +10);
            int topfY = rnd.nextInt(0, +10);
            int playerX = rnd.nextInt(0, +10);
            int playerY = rnd.nextInt(0, +10);
            System.out.printf("Das Spiel beginnt: Sie starten bei %d und %d.\n", playerX, playerY);
            double playerDifX = topfX - playerX;
            double playerDifY = topfY - playerY;
            int i = 0;
            while (topfX != playerX && topfY != playerY) {
                i++;
                double oldPlayerDifX = playerDifX;
                double oldPlayerDifY = playerDifY;
                System.out.println("Wohin möchten sie gehen?");
                char steuerung = input.next().charAt(0);
                steuerung = Character.toLowerCase(steuerung);
                switch (steuerung) {
                    default:
                        System.out.println("Dies ist kein zugelassener Befehl. Zugelassene befehle sind w / a / s / d");
                    case 'w':
                        playerY += 1;
                    case 's':
                        playerY -= 1;
                    case 'a':
                        playerX -= 1;
                    case 'd':
                        playerX += 1;
                }
                playerDifX = playerX - topfX;
                playerDifY = playerY - topfY;

                if (playerDifX < oldPlayerDifX || playerDifY < oldPlayerDifY) {
                    System.out.println("Wärmer");
                } else if (playerDifX > oldPlayerDifX || playerDifY > oldPlayerDifY) {
                    System.out.println("Kälter");
                } else {
                    System.out.println("Gleichwarm?!");
                }


            }
            System.out.println("Sie haben gewonnen. Sie haben " + i + " Züge gebraucht.");
        } else {
            int i = 0;
            System.out.println("Geben sie bitte die Y-Korrdinate des Startpunktes an:");
            int playerY = input.nextInt();
            System.out.println("Geben sie bitte die X-Korrdinate des Startpunktes an:");
            int playerX = input.nextInt();
            System.out.println("Geben sie bitte die Y-Korrdinate des Endpunktes an:");
            int topfY = input.nextInt();
            System.out.println("Geben sie bitte die X-Korrdinate des Endpunktes an:");
            int topfX = input.nextInt();
            double playerDifX = topfX-playerX;
            if (playerDifX > 0) {

                while (playerX != topfX) {
                    playerX += 1;
                    i++;
                    System.out.printf("Das Programm geht einen Schritt nach rechts. Neuer Punkt: (%d|%d)\n", playerX, playerY);
                }
            } else {
                while (playerX != topfX) {
                    playerX -= 1;
                    i++;
                    System.out.printf("Das Programm geht einen Schritt nach links. Neuer Punkt: (%d|%d)\n", playerX, playerY);
                }
            }
            double playerDifY = topfY - playerY;
            if (playerDifY > 0) {
                while (playerY != topfY) {
                    playerY += 1;
                    i++;
                    System.out.printf("Das Programm geht einen Schritt nach oben. Neuer Punkt: (%d|%d)\n", playerX, playerY);
                }
            } else {
                while (playerY != topfY) {
                    playerY -= 1;
                    i++;
                    System.out.printf("Das Programm geht einen Schritt nach unten. Neuer Punkt: (%d|%d)\n", playerX, playerY);
                }
            }
            System.out.println("Das Programm erreicht den Endpunkt mit " + i + " Schritten.");
        }
    }
}
