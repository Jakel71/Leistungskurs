package blatt33;

import blatt19.QuickSortGeneral;
import blatt32.a03.Graph;
import schgraphs.SchGraphs;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        SchGraphs sg = new SchGraphs();
        Graph graph = new Graph();
        String source = "Schule" + File.separator + "src" + File.separator + "blatt33" + File.separator + "graph04.txt";
        graph.importGraph(source);
        sg.step(graph.getAdjMatrix());

        MST.kruskalMST(graph, sg);

        sg.start();
    }
}
