package blatt17;

import blatt14.MultiArrays;
import blatt14.Simulationen;
import schisch_visualizer.SchischVisualizer;

public class GameOfLife {

    public static void initRandom(char[][] feld,double wahr){
        for(int i=0;i<feld.length;i++){
            for(int j=0;j<feld[0].length;j++){
                if(Math.random()<=wahr){
                    feld[i][j] = '9';
                } else{
                    feld[i][j] = '4';
                }
            }
        }
    }

    public static void weiter(char[][] feld){
        char[][] altFeld = MultiArrays.copy2DCharArray(feld);
        for(int i=0;i<altFeld.length;i++){
            for(int j=0;j<altFeld[0].length;j++){
                int numberOfLivingNeigbours = Simulationen.zaehlenAcht(altFeld,i,j,'9',true);
                if(numberOfLivingNeigbours==3){
                    feld[i][j] = '9';
                }else if(numberOfLivingNeigbours<2){
                    feld[i][j] = '4';
                } else if (numberOfLivingNeigbours==2 && feld[i][j]=='9') {
                    feld[i][j] = '9';
                }else if(numberOfLivingNeigbours>3) {
                    feld[i][j] = '4';
                }
            }
        }
    }

    public static void initOszilierend(int objectNum, char[][] feld){
        switch(objectNum){
            case 1:
                feld[feld.length/2-1][feld[0].length/2] = '9';
                feld[feld.length/2][feld[0].length/2] = '9';
                feld[feld.length/2+1][feld[0].length/2] = '9';
                break;
            case 2:
                feld[feld.length/2][feld[0].length/2] = '9';
                feld[feld.length/2-2][feld[0].length/2+1] = '9';
                feld[feld.length/2-1][feld[0].length/2+1] = '9';
                feld[feld.length/2][feld[0].length/2+2] = '9';
                feld[feld.length/2+1][feld[0].length/2+2] = '9';
                feld[feld.length/2-1][feld[0].length/2+3] = '9';
                break;
            case 3:
                feld[feld.length/2-1][feld[0].length/2] = '9';
                feld[feld.length/2-1][feld[0].length/2+1] = '9';
                feld[feld.length/2][feld[0].length/2+1] = '9';
                feld[feld.length/2-1][feld[0].length/2+2] = '9';
                feld[feld.length/2][feld[0].length/2+2] = '9';
                feld[feld.length/2][feld[0].length/2+3] = '9';
                break;
            case 4:
                feld[feld.length/2-2][feld[0].length/2] = '9';
                feld[feld.length/2-1][feld[0].length/2] = '9';
                feld[feld.length/2-2][feld[0].length/2+1] = '9';

                feld[feld.length/2+1][feld[0].length/2+2] = '9';
                feld[feld.length/2][feld[0].length/2+3] = '9';
                feld[feld.length/2+1][feld[0].length/2+3] = '9';
                break;
            case 5:
                feld[feld.length/2-2][feld[0].length/2] = '9';
                feld[feld.length/2-1][feld[0].length/2] = '9';
                feld[feld.length/2-2][feld[0].length/2+1] = '9';

                feld[feld.length/2-1][feld[0].length/2+2] = '9';
                feld[feld.length/2+1][feld[0].length/2+2] = '9';

                feld[feld.length/2+2][feld[0].length/2+3] = '9';
                feld[feld.length/2+1][feld[0].length/2+4] = '9';
                feld[feld.length/2+2][feld[0].length/2+4] = '9';
                break;
            case 6:
                feld[feld.length/2-4][feld[0].length/2] = '9';
                feld[feld.length/2-4][feld[0].length/2+1] = '9';
                feld[feld.length/2-5][feld[0].length/2+1] = '9';
                feld[feld.length/2-4][feld[0].length/2+2] = '9';
                feld[feld.length/2-5][feld[0].length/2+2] = '9';
                feld[feld.length/2-6][feld[0].length/2+2] = '9';
                feld[feld.length/2-4][feld[0].length/2+3] = '9';
                feld[feld.length/2-5][feld[0].length/2+3] = '9';
                feld[feld.length/2-4][feld[0].length/2+4] = '9';

                feld[feld.length/2+3][feld[0].length/2] = '9';
                feld[feld.length/2+3][feld[0].length/2+1] = '9';
                feld[feld.length/2+4][feld[0].length/2+1] = '9';
                feld[feld.length/2+3][feld[0].length/2+2] = '9';
                feld[feld.length/2+4][feld[0].length/2+2] = '9';
                feld[feld.length/2+5][feld[0].length/2+2] = '9';
                feld[feld.length/2+3][feld[0].length/2+3] = '9';
                feld[feld.length/2+4][feld[0].length/2+3] = '9';
                feld[feld.length/2+3][feld[0].length/2+4] = '9';
                break;
        }
    }

    public static void main(String[] args) {
        SchischVisualizer sv = new SchischVisualizer();
        char[][] feld = new char[100][100];
        initRandom(feld,0);
        initOszilierend(6,feld);
        for (int i = 0; i < 200; i++) {
            sv.step(feld);
            weiter(feld);
        }
        sv.start();
    }
}
