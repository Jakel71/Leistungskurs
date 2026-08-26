package blatt33;

import blatt19.QuickSortGeneral;
import blatt32.a03.Graph;
import schgraphs.SchGraphs;

import java.util.ArrayList;

public class MST {

    private static boolean allvisited(boolean[] list){
        for (boolean bool : list) {
            if(!bool) return false;
        }
        return true;
    }

    public static Graph primMST(Graph graph, SchGraphs sg) {
        Graph primMST = new Graph(graph.size());
        boolean[] visited = new boolean[graph.size()];
        ArrayList<Integer> knoten = new ArrayList<Integer>();
        for (int i = 0; i < graph.size(); i++) {
            knoten.add(i);
        }
        visited[0] = true;
        while (!allvisited(visited)) {
            Edge newEdge = new Edge(-1, -1, Integer.MAX_VALUE);
            for (int i : knoten) {
                if (visited[i]) {
                    for (int neighbour : graph.getNeighbours(i)) {
                        if (!visited[neighbour] && newEdge.weight>graph.getAdjMatrix()[i][neighbour]) {
                            newEdge = new Edge(i, neighbour, graph.getAdjMatrix()[i][neighbour]);
                        }
                    }
                }
            }
            if(newEdge.from != -1 && newEdge.to != -1 && newEdge.weight != Integer.MAX_VALUE) {
                primMST.addEdge(newEdge.from, newEdge.to, newEdge.weight);
                sg.step(primMST.getAdjMatrix());
                visited[newEdge.to] = true;
            }
        }
        return primMST;
    }

    public static Graph kruskalMST(Graph graph, SchGraphs sg) {
        Graph kruskalMST = new Graph(graph.size());

        ArrayList<Edge> edges = new ArrayList<Edge>();
        for (int i = 0; i < graph.size(); i++) {
            for (int j : graph.getNeighbours(i)) {
                edges.add(new Edge(i, j, graph.getAdjMatrix()[i][j]));
            }
        }
        Edge[] edgeArray = edges.toArray(new Edge[0]);
        edgeArray = QuickSortGeneral.quickSort(edgeArray);
        boolean[]visited=new boolean[graph.size()];
        for (Edge edge : edgeArray) {
            boolean[] erreichbar =  GraphSuche.erreichbarkeit(kruskalMST, edge.from);
            if(!erreichbar[edge.to]){
                kruskalMST.addEdge(edge.from, edge.to, edge.weight);
                sg.step(kruskalMST.getAdjMatrix());
            }
        }
        return kruskalMST;
    }
}
