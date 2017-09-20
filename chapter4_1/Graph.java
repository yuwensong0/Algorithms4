package chapter4_1;

import chapter1_2.Bag;
import edu.princeton.cs.algs4.*;

public class Graph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj; 
    
    public Graph(int V) {
        this.V = V;
        E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }
    }
    
    public Graph(In in) {
        this(in.readInt());
        E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }
    
    public int E() {
        return E;
    }
    
    public int V() {
        return V;
    }
    
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }
    
    public String toString() {
        String string = V + " vertices, " + E + " edges\n";
        for (int v = 0; v < V; v++) {
            string += v + ": ";
            for (int w : adj(v)) {
                string += w + " ";
            }
            string += "\n";
        }
        return string;
    }
    
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Graph graph = new Graph(6);
        graph.addEdge(0, 5);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(1, 2);
        graph.addEdge(0, 1);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(0, 2);
        System.out.println(graph);

    }

}
