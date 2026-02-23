package blatt16;

import schisch_visualizer.*;

import java.io.File;

public class Labyrinth {
    public static char[][] leseLabyrinth(int numLaby){
        if(numLaby<10){
            return Stroeme.readCharArray("laby0" + numLaby+".txt","Schule" + File.separator + "src" + File.separator + "blatt16");
        }

        return Stroeme.readCharArray("laby" + numLaby + ".txt", "Schule" + File.separator + "src" + File.separator + "blatt16");
    }
    public static void main(String[] args){
        SchischVisualizer sv = new SchischVisualizer();
        for(int i=1;i<=5;i++) {
            char[][] laby = leseLabyrinth(i);
            sv.step(laby);
        }
        sv.start();
    }
}
