package chapter4_3;

import com.sun.media.jfxmedia.events.NewFrameEvent;

import chapter1_2.Queue;
import chapter2_4.MinPQ;

public class LazyPrimMST {
    private boolean[] marked;
    private Queue<Edge> mst;
    private MinPQ<Edge> pq;
    
    public LazyPrimMST(EdgeWeightedGraph graph) {
        marked = new boolean[graph.V()];
        mst = new Queue<>();
        pq = new MinPQ<>();
        visit(graph, 0);
        while (!pq.isEmpty()) {
            Edge edge = pq.delMin();
            int v = edge.either();
            int w = edge.other(v);
            if (marked[v] && marked[w]) {
                continue;
            }
            mst.enqueue(edge);
            if (!marked[v]) {
                visit(graph, v);
            }
            if (!marked[w]) {
                visit(graph, w);
            }
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
    
    private void visit(EdgeWeightedGraph graph, int v) {
        marked[v] = true;
        for (Edge edge : graph.adj(v)) {
            int w = edge.other(v);
            if (!marked[w]) {
                
                pq.insert(edge);
            }
        }
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
        LazyPrimMST mst = new LazyPrimMST(graph);
        for (Edge edge : mst.edges()) {
            System.out.println(edge);
        }
        System.out.println(mst.weight());
    }

}
