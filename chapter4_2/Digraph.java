package chapter4_2;

import chapter1_2.Bag;
import chapter4_1.Graph;
import edu.princeton.cs.algs4.In;

public class Digraph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;
    
    public Digraph(int V) {
        this.V = V;
        E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }
    }
    
    public Digraph(In in) {
        this(in.readInt());
        E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }
    
    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }
    
    public int V() {
        return V;
    }
    
    public int E() {
        return E;
    }
    
    public Digraph reverse() {
        Digraph digraph = new Digraph(V);
        for (int i = 0; i < V; i++) {
            for (int w : adj[i]) {
                digraph.addEdge(w, i);
            }
        }
        return digraph;
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
        Digraph graph = new Digraph(6);
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
