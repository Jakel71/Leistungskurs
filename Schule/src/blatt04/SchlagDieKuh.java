package blatt04;

import java.util.Random;
import java.util.Scanner;

public class SchlagDieKuh {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rnd = new Random();
        int topfX = rnd.nextInt(-5, +5);
        int topfY = rnd.nextInt(-5, +5);
        int playerX = rnd.nextInt(-5, +5);
        int playerY = rnd.nextInt(-5, +5);
        System.out.printf("Das Spiel beginnt: Sie starten bei %d und %d.",playerX,playerY);
        double playerDifX = playerX - topfX;
        double playerDifY = playerY - topfY;
        while (topfX != playerX && topfY != playerY){
            double oldPlayerDifX = playerDifX;
            double oldPlayerDifY = playerDifY;
            System.out.println("Wohin möchten sie gehen?");
            char steuerung = input.next().charAt(0);
            steuerung = Character.toLowerCase(steuerung);
            switch (steuerung) {
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


        }
    }
}
