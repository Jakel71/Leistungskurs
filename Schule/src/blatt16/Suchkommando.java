package blatt16;

import blatt07.ArbeitMitArrays;

import java.awt.image.ImageProducer;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Suchkommando {
    public static String[] suchen(String dateiName, String dir){
        Scanner input = new Scanner( System.in );
        ArrayList<String> found = new ArrayList<String>();
        File root = new File(dir);
        if(!root.exists() || !root.isDirectory()){
            System.out.println("Startverzeichnis existiert nicht oder ist kein Verzeichnis!");
            return null;
        }
        ArrayList<String> liste = new ArrayList<String>();
        String[] files = root.list();
        for(int i=0;i<files.length;i++){
            liste.add(files[i]);
        }

//        ArbeitMitArrays.printArray(files);

        for(String s : liste){
            File f =  new File(root,s);
            if(s.equals(dateiName)){
                System.out.println(f.getAbsolutePath());
                found.add(f.getAbsolutePath());
                System.out.println("Soll weiter gesucht werden? (Y/N): ");
                if(input.next() == "N"){
                    return found.toArray(new String[0]);
                }
            }
        }
        return liste.toArray(new String[0]);
    }

    public static void main(String[] args) {
        File[] roots = File.listRoots();
        for(File f : roots){
            System.out.println(f.getAbsolutePath());
        }
        String[] found = suchen("1.txt","Schule" + File.separator + "src" + File.separator + "blatt16" +  File.separator + "sprengtest");
        ArbeitMitArrays.printArray(found);
    }
}
