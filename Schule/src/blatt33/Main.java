package blatt33;

import blatt19.QuickSortGeneral;

public class Main {
    public static void main(String[] args) {
        Integer[] test = new Integer[]{1, 2,10,-10, 5, 4, 5};
        System.out.println(java.util.Arrays.toString(QuickSortGeneral.quickSort(test)));

//        SchGraphs sg = new SchGraphs();
//        Graph graph = new Graph();
//        String source = "Schule" + File.separator + "src" + File.separator + "blatt33" + File.separator + "graph04.txt";
//        graph.importGraph(source);
//        sg.step(graph.getAdjMatrix());
//
//        sg.start();
    }
}
