package blatt32.a04;

import blatt32.a03.Graph;
import schgraphs.SchGraphs;

public class Main {

    public static Graph graph1(){
        Graph graph1 = new Graph(5);

        graph1.addEdge(0, 1);
        graph1.addEdge(0, 2);
        graph1.addEdge(0, 3);
        graph1.addEdge(0, 4);

        graph1.addEdge(1, 0);
        graph1.addEdge(1, 2);
        graph1.addEdge(1, 3);
        graph1.addEdge(1, 4);

        graph1.addEdge(2, 0);
        graph1.addEdge(2, 1);
        graph1.addEdge(2, 3);
        graph1.addEdge(2, 4);


        graph1.addEdge(3, 0);
        graph1.addEdge(3, 1);
        graph1.addEdge(3, 2);
        graph1.addEdge(3, 4);


        graph1.addEdge(4, 0);
        graph1.addEdge(4, 1);
        graph1.addEdge(4, 2);
        graph1.addEdge(4, 3);

        return graph1;
    }

    public static Graph graph2(){
        Graph graph2 = new Graph(5);
        graph2.addEdge(0, 1,true);
        graph2.addEdge(2, 3,true);
        return graph2;
    }

    public static Graph graph3(){
        Graph graph3 = new Graph(5);
        graph3.addEdge(0, 1,10);
        graph3.addEdge(0, 2);
        graph3.addEdge(0, 3,100);
        graph3.addEdge(1,3);
        graph3.addEdge(2,3,20);
        return graph3;
    }

    public static Graph graph4(){
        Graph graph4 = new Graph(5);
        graph4.addEdge(0, 1,20,true);
        graph4.addEdge(1, 2,20,true);
        graph4.addEdge(2, 0,20,true);

        graph4.addEdge(1, 0,10,true);
        graph4.addEdge(2, 1,10,true);
        graph4.addEdge(0, 2,10,true);

        return graph4;
    }

    public static void main(String[] args) {
        SchGraphs sg = new SchGraphs();
        sg.step(graph1().getAdjMatrix());
        sg.step(graph2().getAdjMatrix());
        sg.step(graph3().getAdjMatrix());
        sg.step(graph4().getAdjMatrix());
        sg.start();
    }
}
