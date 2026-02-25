package blatt17;

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
    public static void main(String[] args) {
        SchischVisualizer sv = new SchischVisualizer();
        char[][] feld = new char[100][100];
        initRandom(feld,0.25);
        sv.step(feld);
        sv.start();
    }
}
