package blatt33;

public class Edge implements Comparable<Edge>{
    public int from;
    public int to;
    public int weight;
    public Edge(int from, int to) {
        this.from = from;
        this.to = to;
    }
    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        if(this.weight < o.weight) return -1;
        else if(this.weight > o.weight) return 1;
        return 0;
    }
}
