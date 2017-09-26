package chapter4_3;

import chapter1_2.Bag;
import chapter2_4.IndexMinPQ;

public class PrimMST {
    private Edge[] edgeTo;
    private double[] distTo;
    private boolean[] marked;
    private IndexMinPQ<Double> pq;

    public PrimMST(EdgeWeightedGraph graph) {
        edgeTo = new Edge[graph.V()];
        distTo = new double[graph.V()];
        marked = new boolean[graph.V()];
        pq = new IndexMinPQ<>(graph.V());
        for (int i = 0; i < graph.V(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[0] = 0.0;
        pq.insert(0, 0.0);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            visit(graph, v);
        }

    }

    private void visit(EdgeWeightedGraph graph, int v) {
        marked[v] = true;
        for (Edge edge : graph.adj(v)) {
            int w = edge.other(v);
            if (marked[w]) {
                continue;
            }
            if (edge.weight() < distTo[w]) {
                edgeTo[w] = edge;
                distTo[w] = edge.weight();
                if (pq.contains(w)) {
                    pq.change(w, distTo[w]);
                } else {
                    pq.insert(w, distTo[w]);
                }
            }
        }
    }
    
    public Iterable<Edge> edges() {
        Bag<Edge> bag = new Bag<>();
        for (int i = 1; i < edgeTo.length; i++) {
            bag.add(edgeTo[i]);
        }
        return bag;
    }
    
    public String toString() {
        String s = "";
        for (Edge edge : edges()) {
            s += edge + "\n";
        }
        return s;
    }
    
    public double weight() {
        double sum = 0.0;
        for (int i = 1; i < distTo.length; i++) {
            sum += distTo[i];
        }
        return sum;
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        EdgeWeightedGraph graph = new EdgeWeightedGraph(8);
        graph.addEdge(new Edge(4, 5, .35));
        graph.addEdge(new Edge(4, 7, .37));
        graph.addEdge(new Edge(5, 7, .28));
        graph.addEdge(new Edge(0, 7, .16));
        graph.addEdge(new Edge(1, 5, .32));
        graph.addEdge(new Edge(0, 4, .38));
        graph.addEdge(new Edge(2, 3, .17));
        graph.addEdge(new Edge(1, 7, .19));
        graph.addEdge(new Edge(0, 2, .26));
        graph.addEdge(new Edge(1, 2, .36));
        graph.addEdge(new Edge(1, 3, .29));
        graph.addEdge(new Edge(2, 7, .34));
        graph.addEdge(new Edge(6, 2, .40));
        graph.addEdge(new Edge(3, 6, .52));
        graph.addEdge(new Edge(6, 0, .58));
        graph.addEdge(new Edge(6, 4, .93));
        PrimMST mst = new PrimMST(graph);
        for (Edge edge : mst.edges()) {
            System.out.println(edge);
        }
        System.out.println(mst.weight());

    }

}
