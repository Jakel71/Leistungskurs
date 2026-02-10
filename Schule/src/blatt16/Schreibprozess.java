package blatt16;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Schreibprozess {
    public static void main(String[] args) {
        char seperator = File.separatorChar;
        File dir = new File("Schule" + seperator + "src" + seperator + "blatt16" + seperator + "io");
        if(!dir.isDirectory()) {
            dir.mkdir();
        }
        File f01 = new File("Schule" + seperator + "src" + seperator + "blatt16" + seperator + "io" + seperator + "Test01.txt");
        try {
            FileWriter fw = new FileWriter(f01);
            fw.write("Im Internet bildet sich Mirjas nachlässige Freundin billig fort.\nWeil eine Oberkellnerin einfallsreich sticht, kauft sie blutig ein.\nAus der Website: satzgenerator.de herauskopiert.");
            fw.close();
        } catch (Exception e){
            e.getMessage();
        }
        File f02 =  new File("Schule" + seperator + "src" + seperator + "blatt16" + seperator + "io" + seperator + "Test02.html");
        try {
            FileWriter fw = new FileWriter(f02);
            fw.write("<html>\n\t<head>\n\t\t<title>HTML aus Java</title>\n\t</head>\n\t<body>\n\t\t<h1>HTML aus Java?</h1>\n\t\t<p>Es geht wirklich.</p>\n\t</body>\n</html>");
            fw.close();
        } catch (Exception e){
            e.getMessage();
        }
    }
}
