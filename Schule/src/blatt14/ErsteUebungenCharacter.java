package blatt14;

import schisch_visualizer.SchischVisualizer;

public class ErsteUebungenCharacter {

    public static void main(String[] args) {
        SchischVisualizer sv = new SchischVisualizer();
        char[][] charr = MultiArrays.createEmpty2DCharArray(11,14);
        sv.step(charr);
        for (int i=0; i<charr.length; i++){
            for (int j=0; j<charr[0].length; j++){
                if (j==0){
                    charr[i][j] = '1';
                }

                if (i==0){
                    charr[i][j] = '1';
                }
                if (i==10){
                    charr[i][j] = '1';
                }
                if (j==13){
                    charr[i][j] = '1';
                }
                if ((i==2||i==8)&&(j<12)){
                    charr[i][j] = '1';
                }
                if (((i>2)&&(i<5))&&(j==11)){
                    charr[i][j] = '1';
                }
                if (((i>5)&&(i<9))&&(j==11)){
                    charr[i][j] = '1';
                }
                if (((i>3)&&(i<7))&&(j==3)){
                    charr[i][j] = '1';
                }
                if (((i>3)&&(i<7))&&(j==5)){
                    charr[i][j] = '1';
                }
            }
        }
        charr[5][12] = 'P';
        sv.step(charr);
        sv.start();
    }
}
