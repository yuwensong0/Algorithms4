package chapter4_3;

import chapter1_2.Queue;
import chapter2_4.MinPQ;
import edu.princeton.cs.algs4.UF;

public class KruskalMST {
    private Queue<Edge> mst;
    
    public KruskalMST(EdgeWeightedGraph graph) {
        mst = new Queue<>();
        MinPQ<Edge> pq = new MinPQ<>(graph.V());
        for (Edge edge : graph.edges()) {
            pq.insert(edge);
        }
        UF uf = new UF(graph.V());
        while (!pq.isEmpty() && mst.size() < graph.V() - 1) {
            Edge edge = pq.delMin();
            int v = edge.either();
            int w = edge.other(v);
            if (uf.connected(v, w)) {
                continue;
            }
            uf.union(v, w);
            mst.enqueue(edge);
        }
    }
    
    public Iterable<Edge> edges() {
        return mst;
    }
    
    public double weight() {
        double sum = 0.0;
        for (Edge edge : edges()) {
            sum += edge.weight();
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
        KruskalMST mst = new KruskalMST(graph);
        for (Edge edge : mst.edges()) {
            System.out.println(edge);
        }
        System.out.println(mst.weight());

    }

}
