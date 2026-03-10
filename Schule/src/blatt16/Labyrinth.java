package blatt16;

import blatt14.MultiArrays;
import blatt14.Simulationen;
import schisch_visualizer.*;

import java.io.File;

public class Labyrinth {

    static SchischVisualizer sv = new SchischVisualizer();

    /**
     * liest ein Labyrinth aus einer Datei ein
     * @param numLaby Nummer der Datei
     * @return Char[][]
     */
    public static char[][] leseLabyrinth(int numLaby){
        if(numLaby<10){
            return Stroeme.readCharArray("laby0" + numLaby+".txt","Schule" + File.separator + "src" + File.separator + "blatt16");
        }

        return Stroeme.readCharArray("laby" + numLaby + ".txt", "Schule" + File.separator + "src" + File.separator + "blatt16");
    }

    /**
     * Simuliert einen Pathfinder, welcher versucht ein Labyrinth zu lösen
     * @param laby Labyrinth
     * @return Anzahl der gebrauchten Schritte
     */
    public static int labyrinthSimulation(char[][] laby){
        if(istMoeglich(laby)) {
            int richtung = 1;
            int x = -1;
            int y = -1;
            for (int i = 0; i < laby.length; i++) {
                for (int j = 0; j < laby[i].length; j++) {
                    if (laby[i][j] == '9') {
                        x = i;
                        y = j;

                    }
                }
            }
            int count = 0;
            while (true) {
                count++;
                char[][] newLaby = MultiArrays.copy2DCharArray(laby);
                if (Simulationen.zaehlenVier(newLaby, x, y, '7', false) > 0) {
                    System.out.println("gefunden");
                    break;
                }
                int newRichtung = 3;
                do {
                    richtung = newRichtung;

                    if (x > 0 && laby[x - 1][y] == '1' && newRichtung == 1) {
                        newRichtung = 2;
                    }
                    if (y < laby[0].length && laby[x][y + 1] == '1' && newRichtung == 2) {
                        newRichtung = 3;
                    }

                    if (x < laby.length && laby[x + 1][y] == '1' && newRichtung == 3) {
                        newRichtung = 4;
                    }

                    if (y > 0 && laby[x][y - 1] == '1' && newRichtung == 4) {
                        newRichtung = 1;
                    }

                    if (x > 0 && y > 0 && (laby[x - 1][y] == '1' || laby[x - 1][y] == '4') && (laby[x][y - 1] == '5') && laby[x][y - 1] != '1') {
                        newRichtung = 8;
                    }

                    if (y < laby[0].length && x > 0 && (laby[x][y + 1] == '1' || laby[x][y + 1] == '4') && (laby[x - 1][y] == '5') && laby[x - 1][y] != '1') {
                        newRichtung = 5;
                    }

                    if (x < laby.length && y < laby[0].length && (laby[x + 1][y] == '1' || laby[x + 1][y] == '4') && (laby[x][y + 1] == '5') && laby[x][y + 1] != '1') {
                        newRichtung = 6;
                    }

                    if (x < laby.length && y > 0 && (laby[x][y - 1] == '1' || laby[x][y - 1] == '4') && (laby[x + 1][y] == '5') && laby[x + 1][y] != '1') {
                        newRichtung = 7;
                    }

                    if (y < laby[0].length && laby[x][y + 1] == '0') {
                        newRichtung = 2;
                    }
                    if (x < laby.length && laby[x + 1][y] == '0') {
                        newRichtung = 3;
                    }
                    if (y > 0 && laby[x][y - 1] == '0') {
                        newRichtung = 4;
                    }
                    if (x > 0 && laby[x - 1][y] == '0') {
                        newRichtung = 1;
                    }

                } while (richtung != newRichtung);

                switch (richtung) {
                    case 1:
                        newLaby[x][y] = '5';
                        x--;
                        newLaby[x][y] = 'P';
                        break;
                    case 2:
                        newLaby[x][y] = '5';
                        y++;
                        newLaby[x][y] = 'P';
                        break;
                    case 3:
                        newLaby[x][y] = '5';
                        x++;
                        newLaby[x][y] = 'P';
                        break;
                    case 4:
                        newLaby[x][y] = '5';
                        y--;
                        newLaby[x][y] = 'P';
                        break;
                    case 5:
                        newLaby[x][y] = '4';
                        x--;
                        newLaby[x][y] = 'P';
                        break;
                    case 6:
                        newLaby[x][y] = '4';
                        y++;
                        newLaby[x][y] = 'P';
                        break;
                    case 7:
                        newLaby[x][y] = '4';
                        x++;
                        newLaby[x][y] = 'P';
                        break;
                    case 8:
                        newLaby[x][y] = '4';
                        y--;
                        newLaby[x][y] = 'P';
                        break;
                }
                laby = MultiArrays.copy2DCharArray(newLaby);
                sv.step(laby);
            }
            if (x < laby.length && laby[x + 1][y] == '7') {
                laby[x][y] = '6';
                x++;
                laby[x][y] = 'P';
                count++;
            } else if (x > 0 && laby[x - 1][y] == '7') {
                laby[x][y] = '6';
                x--;
                laby[x][y] = 'P';
                count++;
            } else if (y < laby[0].length && laby[x][y + 1] == '7') {
                laby[x][y] = '6';
                y++;
                laby[x][y] = 'P';
                count++;
            } else if (y > 0 && laby[x][y - 1] == '7') {
                laby[x][y] = '6';
                y--;
                laby[x][y] = 'P';
                count++;
            }
            sv.step(laby);
            return count;
        }
        return -1;
    }

    /**
     * Überprüft, ob ein Laby eine Lösung hat, dazu wird ein Flutungsalgorithmus wie bei Kaese verwendet
     * @param laby char[][] das Labyrinth
     * @return true: Lösung; fals: keine Lösung
     */
    public static boolean istMoeglich(char[][] laby){
        char[][] newLaby = MultiArrays.copy2DCharArray(laby);
        do{
            laby = MultiArrays.copy2DCharArray(newLaby);
            for (int i = 0; i < laby.length; i++) {
                for (int j = 0; j < laby[i].length; j++) {
                    if (laby[i][j] == '9') {
                        if (i > 0) {
                            if (laby[i - 1][j] == '0') {
                                newLaby[i - 1][j] = '9';
                            }
                        }
                        if (i < laby.length) {
                            if (laby[i + 1][j] == '0') {
                                newLaby[i + 1][j] = '9';
                            }
                        }
                        if (j > 0) {
                            if (laby[i][j - 1] == '0') {
                                newLaby[i][j - 1] = '9';
                            }
                        }
                        if (j < laby[i].length) {
                            if (laby[i][j + 1] == '0') {
                                newLaby[i][j + 1] = '9';
                            }
                        }
                    }
                }
            }
        }while (!MultiArrays.istIdentisch(newLaby, laby));

        laby = MultiArrays.copy2DCharArray(newLaby);
        for (int i = 0; i < laby.length; i++) {
            for (int j = 0; j < laby[i].length; j++) {
                if (laby[i][j] == '7') {
                    if(0<Simulationen.zaehlenVier(laby,i,j,'9',false)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        char[][] laby = leseLabyrinth(4);
        sv.step(laby);
        System.out.println(labyrinthSimulation(laby));
        sv.start();
    }
}
