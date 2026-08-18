package blatt32.a03;

import schgraphs.*;

public class Main {
    public static void main(String[] args) {
        SchGraphs sg = new SchGraphs();
        Graph graph = new Graph( 8 );
        int[][] fakeGraph = graph.getAdjMatrix();
        graph.addEdge(0, 1);
        sg.step(graph.getAdjMatrix());
        sg.step(fakeGraph);
        graph.exportGraph();
        sg.step(graph.getAdjMatrix());
        sg.start();
    }
}
