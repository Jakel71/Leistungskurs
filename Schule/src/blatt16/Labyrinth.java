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

    public static void labyrinthSimulation(char[][] laby){
        int richtung = 1;
        int x = -1;
        int y= -1;
        for (int i = 0; i < laby.length; i++){
            for (int j = 0; j < laby[i].length; j++){
                if(laby[i][j]=='9'){
                    x = i;
                    y = j;

                }
            }
        }
        int count=0;
        while(count<200) {
            count++;
            char[][] newLaby = MultiArrays.copy2DCharArray(laby);
            if(Simulationen.zaehlenVier(newLaby,x,y,'7',false)>0) {
                System.out.println("gefunden");
                return;
            }
            int newRichtung = richtung;
            do {
                richtung = newRichtung;

                if (x>0 && laby[x - 1][y] == '1' && newRichtung == 1) {
                    newRichtung = 2;
                }
                if (y<laby[0].length && laby[x][y + 1] == '1' && newRichtung == 2) {
                    newRichtung = 3;
                }

                if (x<laby.length && laby[x + 1][y] == '1' && newRichtung == 3) {
                    newRichtung = 4;
                }

                if (y>0 && laby[x][y - 1] == '1' && newRichtung == 4) {
                    newRichtung = 1;
                }

                if (x>0 && y>0 && laby[x - 1][y] == '1' && (laby[x][y - 1]=='5') && laby[x][y - 1]!='1') {
                    newRichtung = 8;
                }

                if (y<laby[0].length && x>0 && laby[x][y + 1] == '1' && (laby[x - 1][y]=='5') && laby[x - 1][y]!='1') {
                    newRichtung = 5;
                }

                if (x<laby.length && y<laby[0].length && laby[x + 1][y] == '1' && (laby[x][y + 1]=='5') && laby[x][y + 1]!='1') {
                    newRichtung = 6;
                }

                if (y>0 && x<laby.length && laby[x][y-1] == '1' && (laby[x + 1][y]=='5') && laby[x + 1][y]!='1') {
                    newRichtung = 7;
                }

                if (y<laby[0].length && laby[x][y + 1] == '0') {
                    newRichtung = 2;
                }
                if (x<laby.length && laby[x+1][y] == '0') {
                    newRichtung = 3;
                }
                if (y>0 && laby[x][y - 1] == '0') {
                    newRichtung = 4;
                }
                if (x>0 && laby[x - 1][y] == '0') {
                    newRichtung = 1;
                }

            } while(richtung!=newRichtung);

            System.out.println("\n" + richtung);
            switch(richtung){
                case 1:
                    newLaby[x][y]='5';
                    x--;
                    newLaby[x][y]='P';
                    break;
                case 2:
                    newLaby[x][y]='5';
                    y++;
                    newLaby[x][y]='P';
                    break;
                case 3:
                    newLaby[x][y]='5';
                    x++;
                    newLaby[x][y]='P';
                    break;
                case 4:
                    newLaby[x][y]='5';
                    y--;
                    newLaby[x][y]='P';
                    break;
                case 5:
                    newLaby[x][y]='4';
                    x--;
                    newLaby[x][y]='P';
                    break;
                case 6:
                    newLaby[x][y]='4';
                    y++;
                    newLaby[x][y]='P';
                    break;
                case 7:
                    newLaby[x][y]='4';
                    x++;
                    newLaby[x][y]='P';
                    break;
                case 8:
                    newLaby[x][y]='4';
                    y--;
                    newLaby[x][y]='P';
                    break;
            }
            laby=MultiArrays.copy2DCharArray(newLaby);
            sv.step(laby);
        }
    }

    public static void main(String[] args){
        char[][] laby = leseLabyrinth(2);
        sv.step(laby);
        labyrinthSimulation(laby);
        sv.start();
    }
}
