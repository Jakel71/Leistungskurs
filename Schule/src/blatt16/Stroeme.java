package blatt16;

import blatt07.ArbeitMitArrays;
import blatt14.MultiArrays;

import java.io.*;

public class Stroeme {

    /**
     * Liest ein 2D-Char Array aus einer Datei ein
     * @param dateiName Name der Datei, mit datei Endung
     * @param path  use "" if no path is given and the "io"-dir is directly in the CWD; OR Hier den Pfad aus dem Current Working Dictionary zum Ordner, welcher zum "io" Ordner führt
     * @return 2D-Char Array mit dem Inhalt der Datei
     */
    public static char[][] readCharArray (String dateiName, String path){
        File f = new File(path + File.separator + "io", dateiName);
        char [][] arr;
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            int x = Integer.parseInt(br.readLine());
            int y = Integer.parseInt(br.readLine());

            arr = new char[x][y];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    arr[i][j] = br.readLine().charAt(0);
                }

            }
            br.close();
            fr.close();
            return arr;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Schreibt ein 2D-Char Array in eine Datei hinein
     * @param arr Das 2D-Char Array
     * @param dateiName Name der zu erstellenden Datei mit Endung
     * @param path  use "" if no path is given and the "io"-dir is directly in the CWD; OR Hier den Pfad aus dem Current Working Dictionary zum Ordner, welcher zum "io" Ordner führt
     * @return true/false if the writing was successful
     */
    public static boolean writeCharArray (char[][] arr, String dateiName, String path){
        if(path != "") {
            path =  path + File.separator + "io";
        } else{
            path = "io";
        }

        File f = new File(path, dateiName);
        System.out.println(f.getAbsolutePath());
        if(!f.exists()){
            try {
                File dir = f.getParentFile();
                if(!dir.exists()){
                    dir.mkdirs();
                }
                f.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(""+arr.length);
            bw.newLine();
            bw.write(""+arr[0].length);
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    bw.newLine();
                    bw.write(arr[i][j]);
                }
            }
            bw.close();
            fw.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        writeCharArray(readCharArray("1.txt", "Schule" + File.separator + "src" + File.separator + "blatt16"),"2.txt","Schule" + File.separator + "src" + File.separator + "blatt16");
    }
}
