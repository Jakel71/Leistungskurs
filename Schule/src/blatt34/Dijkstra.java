package blatt34;

import blatt32.a03.Graph;
import blatt33.MST;
import schgraphs.SchGraphs;

import java.util.ArrayList;

public class Dijkstra {

    public int[][] dijkstra (Graph graph, char start){
        int startInt = start-'a';
        return dijkstra(graph, startInt);
    }

    public int[][] dijkstra(Graph graph, int start){
        int[][] solution = new int[graph.size()][2];
        for(int i = 0; i < solution.length; i++){
            solution[i][0] = Integer.MAX_VALUE;
            solution[i][1] = -1;
        }
        boolean[] visited = new boolean[graph.size()];
        solution[start][0] = 0;
        solution[start][1] = start;

        while(!MST.allvisited(visited)){
            int[] min = {-1,Integer.MAX_VALUE};
            for(int i = 0; i < graph.size(); i++){
                if(solution[i][0] < min[1]){
                    min[1] = solution[i][0];
                    min[0] = i;
                }
            }
            visited[min[0]] = true;
            for (int neighbour : graph.getNeighbours(min[0])){
                int newDistance = graph.getAdjMatrix()[min[0]][neighbour] + solution[min[0]][0];
                if(solution[neighbour][0] > newDistance){
                    solution[neighbour][0] = newDistance;
                    solution[neighbour][1] = min[0];
                }
            }
        }
        return solution;
    }

    public static String getPath(int[][] wegenetz,int from, int to){
        ArrayList<Character> sb = new ArrayList<>();
        int knoten = wegenetz[to][1];
        sb.add((char)knoten);
        while(knoten != from){
            knoten = wegenetz[knoten][0];
            sb.add('.');
            sb.add((char)knoten);
        }
        StringBuilder sbReverse = new StringBuilder();
        for(int i = sb.size(); i > 0 ; i--){
            sbReverse.append(sb.get(i));
        }
        return sbReverse.toString();
    }

    public static void clearPaths(SchGraphs sg,Graph graph){
        for (int i = 0; i < graph.size(); i++) {
            for (int j = 0; j < graph.getNeighbours(i).length; j++) {
                sg.colorEdge(i, j, 'b', graph.isDirected());
            }
        }
    }
}
