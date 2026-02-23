package blatt16;

import blatt07.ArbeitMitArrays;

import java.awt.image.ImageProducer;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Suchkommando {

    /**
     * sucht eine Datei in einem Ordner und dessen Unterordner
     * @param dateiName Name der Datei + Endung (z.B. ".txt")
     * @param dir Ordner, kann auch "C:" sein
     * @return String Liste mit allen gefundenen Elementen
     */
    public static String[] suchen(String dateiName, String dir){
        Scanner input = new Scanner( System.in );
        ArrayList<String> found = new ArrayList<String>();
        File root = new File(dir);
        if(!root.exists() || !root.isDirectory()){
            System.out.println("Startverzeichnis existiert nicht oder ist kein Verzeichnis!");
            return null;
        }
        ArrayList<File> liste = new ArrayList<>();
        File[] files = root.listFiles();
        for(int i=0;i<files.length;i++){
            liste.add(files[i]);
        }

        while(!liste.isEmpty()) {

                File f = liste.get(0);

                if (f.getName().equals(dateiName)) {
                    System.out.println(f.getAbsolutePath());
                    found.add(f.getAbsolutePath());

                    System.out.println("Soll weiter gesucht werden? (Y/N): ");
                    if (input.next().toUpperCase() == "N") {
                        return found.toArray(new String[0]);
                    }
                } else if (f.isDirectory()) {
                    File[] newFiles = f.listFiles();
                    if(newFiles != null) {
                        for (int j = 0; j < newFiles.length; j++) {
                            liste.add(newFiles[j]);
//                            System.out.println(newFiles[j].getAbsolutePath());
                        }
                    }
                }
                liste.remove(0);
        }
        return found.toArray(new String[0]);
    }

    public static void main(String[] args) {
        File[] roots = File.listRoots();
        for(File f : roots){
            System.out.println(f.getAbsolutePath());
        }
        String[] found = suchen("1.txt",roots[0].getAbsolutePath());//"Schule" + File.separator + "src" + File.separator + "blatt16" +  File.separator + "sprengtest");
        ArbeitMitArrays.printArray(found);
    }
}
