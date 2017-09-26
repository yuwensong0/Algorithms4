package chapter4_3;

public class Edge implements Comparable<Edge> {
    private final int v;
    private final int w;
    private final double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either() {
        return v;
    }

    public int other(int ver) {
        if (ver == v) {
            return w;
        } else if (ver == w) {
            return v;
        } else {
            throw new RuntimeException("error edge");
        }
    }
    
    public double weight() {
        return weight;
    }
    
    public String toString() {
        return String.format("%d-%d %.2f", v, w, weight);
    }

    public int compareTo(Edge that) {
        if (this.weight > that.weight) {
            return 1;
        } else if (this.weight < that.weight) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Edge edge = new Edge(1, 2, 0.9);
        System.out.println(edge);

    }

}
