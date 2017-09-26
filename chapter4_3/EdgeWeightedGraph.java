package chapter4_3;

import chapter1_2.Bag;

public class EdgeWeightedGraph {
    private final int V;
    private int E;
    private Bag<Edge>[] adj;
    
    public EdgeWeightedGraph(int V) {
        this.V = V;
        E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }
    }
    
    public void addEdge(Edge edge) {
        int v = edge.either();
        int w = edge.other(v);
        adj[v].add(edge);
        adj[w].add(edge);
        E++;
    }
    
    public int V() {
        return V;
    }
    
    public int E() {
        return E;
    }
    
    public Iterable<Edge> adj(int v) {
        return adj[v];
    }
    
    public Iterable<Edge> edges() {
        Bag<Edge> bag = new Bag<>();
        for (int v = 0; v < V; v++) {
            for (Edge edge : adj[v]) {
                if (edge.other(v) > v) {
                    bag.add(edge);
                }
            }
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

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Edge edge1 = new Edge(0, 1, 0.9);
        Edge edge2 = new Edge(2, 1, 0.7);
        EdgeWeightedGraph edgeWeightedGraph = new EdgeWeightedGraph(4);
        edgeWeightedGraph.addEdge(edge1);
        edgeWeightedGraph.addEdge(edge2);
        System.out.println(edgeWeightedGraph);
    }

}
