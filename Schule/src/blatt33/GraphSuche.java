package blatt33;

import blatt28.a02.Stapel;
import blatt28.a02.Warteschlange;
import blatt32.a03.Graph;
import schgraphs.SchGraphs;
import schisch_visualizer.SchischVisualizer;

import java.util.Arrays;

public class GraphSuche {
    public int[] AlphabeticalToIntegers(Graph graph,String path) {
        char[] chars = path.toCharArray();
        int[] pathArray = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            pathArray[i] = chars[i] - 'a';
        }
        return pathArray;
    }

    public boolean isPath(Graph graph, String path) {
        int[] pathArray = AlphabeticalToIntegers(graph, path);
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

    public int pathLength(Graph graph, String path) {
        int[] pathArray = AlphabeticalToIntegers(graph, path);
        return pathLength(graph, pathArray);
    }

    public int pathLength(Graph graph, int[] path) {
        int length = 0;
        for (int i = 0; i < path.length-1; i++) {
            for (int neighbour: graph.getNeighbours(path[i])) {
                if (neighbour == path[i+1]) {
                    length+= graph.getAdjMatrix()[path[i]][path[i+1]];
                }
            }
        }
        return length;
    }

    public boolean zyklensuche(Graph graph, char startKnoten) {
        int startKnotenInt = startKnoten - 'a';
        return zyklensuche(graph, startKnotenInt);
    }

    public boolean zyklensuche(Graph graph, int startKnoten) {
        int[][] adjMatrix = graph.getAdjMatrix();
        boolean[] visited = new boolean[adjMatrix.length];
        Stapel<Integer> stack = new Stapel<Integer>();
        stack.push(startKnoten);
        boolean zyklus = false;
        while (stack.peek()!=null) {
            int currentKnoten = (int) stack.pop();
            int[]neighbours = graph.getNeighbours(currentKnoten);
            for (int neighbour: neighbours) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    stack.push(neighbour);
                } else {
                    zyklus = true;
                }
            }
            System.out.println("visited: " + Arrays.toString(visited));
            System.out.println("stack: " + stack);
        }
        return zyklus;
    }

    public boolean zyklensuche(Graph graph, char startKnoten, SchGraphs sg) {
        int startKnotenInt = startKnoten - 'a';
        return zyklensuche(graph, startKnotenInt, sg);
    }

    public boolean zyklensuche(Graph graph, int startKnoten, SchGraphs sg) {
        int[][] adjMatrix = graph.getAdjMatrix();
        boolean[] visited = new boolean[adjMatrix.length];
        Stapel<Integer> stack = new Stapel<Integer>();
        stack.push(startKnoten);
        boolean zyklus = false;
        sg.step(adjMatrix);

        while (stack.peek()!=null) {
            int currentKnoten = (int) stack.pop();
            int[]neighbours = graph.getNeighbours(currentKnoten);
            for (int neighbour: neighbours) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    stack.push(neighbour);
                } else {
                    zyklus = true;
                    sg.colorEdge(currentKnoten,neighbour,'r',false);
                    sg.step();
                }
            }
            System.out.println("visited: " + Arrays.toString(visited));
            System.out.println("stack: " + stack);
            sg.colorNode(currentKnoten, 'g');
            int nextKnoten = stack.peek();
            sg.colorEdge(currentKnoten, nextKnoten, 'g',false);
            sg.step();
        }
        return zyklus;
    }

    public boolean[] erreichbarkeit(Graph graph, char startKnoten, SchGraphs sg) {
        int startKnotenInt = startKnoten - 'a';
        return erreichbarkeit(graph, startKnotenInt, sg);
    }

    public boolean[] erreichbarkeit(Graph graph, int startKnoten,  SchGraphs sg) {
        int[][] adjMatrix = graph.getAdjMatrix();
        boolean[] visited = new boolean[adjMatrix.length];
        Warteschlange<Integer> queue = new Warteschlange<>();
        queue.add(startKnoten);
        while (queue.peek()!=null) {
            int currentKnoten = (int) queue.poll();
            int[]neighbours = graph.getNeighbours(currentKnoten);
            for (int neighbour: neighbours) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                    sg.colorNode(neighbour, 'g');
                    sg.colorEdge(currentKnoten, neighbour, 'g', false);
                    sg.step();
                }
            }
            System.out.println("visited: " + Arrays.toString(visited));
            System.out.println("queue: " + queue);
        }
        System.out.println("Erreichbare Knoten: " + Arrays.toString(visited));
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
                sg.colorNode(i, 'r');
            }
        }
        sg.step();
        return visited;
    }

    public boolean erreichbarkeitAbsolute(Graph graph, char startKnoten, SchGraphs sg) {
        int startKnotenInt = startKnoten - 'a';
        return erreichbarkeitAbsolute(graph, startKnotenInt, sg);
    }

    public boolean erreichbarkeitAbsolute(Graph graph, int startKnoten, SchGraphs sg) {
        int[][] adjMatrix = graph.getAdjMatrix();
        boolean[] visited = new boolean[adjMatrix.length];
        Warteschlange<Integer> queue = new Warteschlange<>();
        queue.add(startKnoten);
        while (queue.peek()!=null) {
            int currentKnoten = (int) queue.poll();
            int[]neighbours = graph.getNeighbours(currentKnoten);
            for (int neighbour: neighbours) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                    sg.colorNode(neighbour, 'g');
                    sg.colorEdge(currentKnoten, neighbour, 'g', false);
                    sg.step();
                }
            }
            System.out.println("visited: " + Arrays.toString(visited));
            System.out.println("queue: " + queue);
        }
        System.out.println("Erreichbare Knoten: " + Arrays.toString(visited));

        boolean unerreichbarkeit = false;
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
                sg.colorNode(i, 'r');
                unerreichbarkeit = true;
            }
        }
        sg.step();
        return !unerreichbarkeit;
    }

    public boolean[] erreichbarkeit(Graph graph, char startKnoten) {
        int startKnotenInt = startKnoten - 'a';
        return erreichbarkeit(graph, startKnotenInt);
    }

    public boolean[] erreichbarkeit(Graph graph, int startKnoten) {
        int[][] adjMatrix = graph.getAdjMatrix();
        boolean[] visited = new boolean[adjMatrix.length];
        Warteschlange<Integer> queue = new Warteschlange<>();
        queue.add(startKnoten);
        while (queue.peek()!=null) {
            int currentKnoten = (int) queue.poll();
            int[]neighbours = graph.getNeighbours(currentKnoten);
            for (int neighbour: neighbours) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
            System.out.println("visited: " + Arrays.toString(visited));
            System.out.println("queue: " + queue);
        }
        System.out.println("Erreichbare Knoten: " + Arrays.toString(visited));
        return visited;
    }

    public boolean erreichbarkeitAbsolute(Graph graph, char startKnoten) {
        int startKnotenInt = startKnoten - 'a';
        return erreichbarkeitAbsolute(graph, startKnotenInt);
    }

    public boolean erreichbarkeitAbsolute(Graph graph, int startKnoten) {
        int[][] adjMatrix = graph.getAdjMatrix();
        boolean[] visited = new boolean[adjMatrix.length];
        Warteschlange<Integer> queue = new Warteschlange<>();
        queue.add(startKnoten);
        while (queue.peek()!=null) {
            int currentKnoten = (int) queue.poll();
            int[]neighbours = graph.getNeighbours(currentKnoten);
            for (int neighbour: neighbours) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
            System.out.println("visited: " + Arrays.toString(visited));
            System.out.println("queue: " + queue);
        }
        System.out.println("Erreichbare Knoten: " + Arrays.toString(visited));
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
                return false;
            }
        }
        return true;
    }
}
