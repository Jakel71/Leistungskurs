package blatt32.a03;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Graph {
    private int[][] adjMatrix;



    public Graph() {
        this.adjMatrix = new int[0][0];
    }

    public Graph(int length) {
        this.adjMatrix = new int[length][length];
    }


    public void addVertex (){
        int[][] newAdjMatrix =  new int[this.adjMatrix.length+1][this.adjMatrix.length+1];
        for (int i = 0; i < this.adjMatrix.length; i++) {
            for (int j = 0; j < this.adjMatrix.length; j++) {
                newAdjMatrix[i][j] = this.adjMatrix[i][j];
            }
        }
        this.adjMatrix = newAdjMatrix;
    }

    public void addEdge (int from, int to){
        this.adjMatrix[from][to] = 1;
        this.adjMatrix[to][from] = 1;
    }

    public void addEdge (int from, int to, boolean isDirected){
        this.adjMatrix[from][to] = 1;
        if(!isDirected) {
            this.adjMatrix[to][from] = 1;
        }
    }
    public void addEdge (int from, int to, int weight){
        this.adjMatrix[from][to] = weight;
        this.adjMatrix[to][from] = weight;
    }

    public void addEdge (int from, int to, int weight, boolean isDirected){
        this.adjMatrix[from][to] = weight;
        if(!isDirected) {
            this.adjMatrix[to][from] = weight;
        }
    }

    public int size(){
        return this.adjMatrix.length;
    }

    public boolean isDirected(){
        for(int i = 0; i < this.adjMatrix.length; i++){
            for(int j = 0; j < i; j++){
                if(this.adjMatrix[i][j] != this.adjMatrix[j][i]){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isWeighted(){
        for(int i = 0; i < this.adjMatrix.length; i++){
            for(int j = 0; j < this.adjMatrix.length; j++){
                if(this.adjMatrix[i][j] >= 1){
                    return true;
                }
            }
        }
        return false;
    }

    public int[][] getAdjMatrix() {
        int[][] newAdjMatrix =  new int[this.adjMatrix.length][this.adjMatrix.length];
        for (int i = 0; i < this.adjMatrix.length; i++) {
            for (int j = 0; j < this.adjMatrix.length; j++) {
                newAdjMatrix[i][j] = this.adjMatrix[i][j];
            }
        }
        return newAdjMatrix;
    }

    public int[] getNeighbours(int from){
        ArrayList<Integer> neighbours = new ArrayList<>();
        for(int i = 0; i < this.adjMatrix.length; i++){
            if(this.adjMatrix[from][i] > 0){
                neighbours.add(i);
            }
        }
        int[] newNeighbours = new int[neighbours.size()];
        for(int i = 0; i < neighbours.size(); i++){
            newNeighbours[i] = neighbours.get(i);
        }
        return newNeighbours;
    }

    private String getMainPackageName() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (int i = stackTrace.length - 1; i >= 0; i--) {
            String className = stackTrace[i].getClassName();
            if (className.startsWith("java.") || className.startsWith("sun.") || className.startsWith("jdk.")) {
                continue;
            }
            int lastDot = className.lastIndexOf('.');
            return (lastDot != -1) ? className.substring(0, lastDot) : "";
        }
        return "";
    }

    private File getSourcePackageDirectory() {
        String packageName = getMainPackageName();
        String packagePath = packageName.replace('.', File.separatorChar);

        File projectRoot = new File(System.getProperty("user.dir"));
        File dir = new File(projectRoot, "Schule" + File.separator + "src" + File.separator + packagePath);
        dir.mkdirs(); // legt den Ordner an, falls er fehlt

        return dir;
    }

    public void exportHTML() {
        File outputFile = new File(getSourcePackageDirectory(), "Adjazensmartix.html");
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>\n<html>\n<head>\n<meta charset=\"UTF-8\">\n<title>Adjazensmatrix</title>\n</head>\n<body>\n<style>\ntable, th, td{\nborder: 1px solid #000;\nborder-collapse: collapse;\n}\n</style>");
        sb.append("<h1>Adjazensmatrix</h1>\n<table>\n<tr>\n");
        for (int i = 0; i < this.adjMatrix.length; i++) {
            sb.append("<th>").append(i).append("</th>\n");
        }
        sb.append("</tr>\n");
        for(int i = 0; i < this.adjMatrix.length; i++){
            sb.append("<tr>\n");
            for(int j = 0; j < this.adjMatrix.length; j++){
                sb.append("<td>").append(this.adjMatrix[i][j]).append("</td>\n");
            }
            sb.append("</tr>\n");
        }

        sb.append("\n</table>\n</body>\n</html>");

        try (FileWriter fw = new FileWriter(outputFile);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(sb.toString());
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        System.out.println("Datei gespeichert unter: " + outputFile.getAbsolutePath());
    }

    public void exportGraph(){
        File outputFile = new File(getSourcePackageDirectory(), "Adjazensmartix.txt");
        StringBuilder sb = new StringBuilder();
        sb.append(this.size()).append("\n");
        for(int i = 0; i < this.adjMatrix.length; i++){
            for(int j = 0; j < this.adjMatrix.length; j++){
                sb.append(this.adjMatrix[i][j]).append("\n");
            }
        }

        try{
            FileWriter fw = new FileWriter(outputFile);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(sb.toString());
            bw.close();
            fw.close();
        }catch(IOException e){
            throw new RuntimeException(e.getMessage(), e);
        }
    }
    public void importGraph(String filePath){
        File inputFile = new File(filePath);
        Graph graph = new Graph();
        try{
            FileReader fr = new FileReader(inputFile);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            graph = new Graph(Integer.parseInt(line));
            int x = 0;
            int y = 0;
            while (br.ready()){
                line = br.readLine();
                graph.addEdge(x,y,Integer.parseInt(line),true);
                x++;
                if(x >= graph.size()){
                    x = 0;
                    y++;
                }
            }
        } catch (IOException e){
            throw new RuntimeException(e.getMessage(), e);
        }
        this.adjMatrix = graph.getAdjMatrix();
    }
}
