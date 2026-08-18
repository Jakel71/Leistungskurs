package blatt33;

import blatt32.a03.Graph;

public class GraphSuche {
    public boolean isPatj(Graph graph,String path) {
        char[] chars = path.toCharArray();
        int[] pathArray = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            pathArray[i] = (int) chars[i];
        }
        return isPath(graph, pathArray);
    }

    public boolean isPath(Graph graph, int[] path) {
        for (int i = 0; i < path.length-1; i++) {
            boolean found = false;
            for (int neighbour: graph.getNeighbours(path[i])) {
                if (neighbour == path[i+1]) {
                    found = true;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }


}
