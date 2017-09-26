package chapter4_4;

import chapter1_2.Queue;

public class BellmanFordSP {
    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private boolean[] onQ;
    private Queue<Integer> queue;
    private int cost;
    private Iterable<DirectedEdge> cycle;
    
    public BellmanFordSP(EdgeWeightedDigraph digraph, int s) {
        edgeTo = new DirectedEdge[digraph.V()];
        distTo = new double[digraph.V()];
        for (int i = 0; i < digraph.V(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;
        onQ = new boolean[digraph.V()];
        queue = new Queue<>();
        cost = 0;
        queue.enqueue(s);
        onQ[s] = true;
        while (!queue.isEmpty() && !hasNegativeCycle()) {
            int v = queue.dequeue();
            onQ[v] = false;
            relax(digraph, v);
        }
        
    }
    
    public boolean hasNegativeCycle() {
        return cycle != null;
    }
    
    public Iterable<DirectedEdge> negativeCycle() {
        return cycle;
    }
    
    private void relax(EdgeWeightedDigraph digraph, int v) {
        for (DirectedEdge edge : digraph.adj(v)) {
            int w = edge.to();
            if (distTo[w] > distTo[v] + edge.weight()) {
                distTo[w] = distTo[v] + edge.weight();
                edgeTo[w] = edge;
                if (!onQ[w]) {
                    queue.enqueue(w);
                    onQ[w] = true;
                }
            }
            cost++; 
            if (cost % digraph.V() == 0) {
                findNegativeCycle();
            }
        }
        
    }
    
    private void findNegativeCycle() {
        int V = edgeTo.length;
        EdgeWeightedDigraph spt = new EdgeWeightedDigraph(V);
        for (int v = 0; v < V; v++) {
            if (edgeTo[v] != null) {
                spt.addEdge(edgeTo[v]);
            }
        }
        EdgeWeightedCycleFinder findCycle = new EdgeWeightedCycleFinder(spt);
        cycle = findCycle.cycle();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        EdgeWeightedDigraph digraph = new EdgeWeightedDigraph(8);
        digraph.addEdge(new DirectedEdge(4, 5, 0.35));
        digraph.addEdge(new DirectedEdge(5, 4, -0.66));
        digraph.addEdge(new DirectedEdge(4, 7, 0.37));
        digraph.addEdge(new DirectedEdge(5, 7, 0.28));
        digraph.addEdge(new DirectedEdge(7, 5, 0.28));
        digraph.addEdge(new DirectedEdge(5, 1, 0.32));
        digraph.addEdge(new DirectedEdge(0, 4, 0.38));
        digraph.addEdge(new DirectedEdge(0, 2, 0.26));
        digraph.addEdge(new DirectedEdge(7, 3, 0.39));
        digraph.addEdge(new DirectedEdge(1, 3, 0.29));
        digraph.addEdge(new DirectedEdge(2, 7, 0.34));
        digraph.addEdge(new DirectedEdge(6, 2, 0.40));
        digraph.addEdge(new DirectedEdge(3, 6, 0.52));
        digraph.addEdge(new DirectedEdge(6, 0, 0.58));
        digraph.addEdge(new DirectedEdge(6, 4, 0.93));
        int s = 0;
        BellmanFordSP sp = new BellmanFordSP(digraph, s);
        if (sp.hasNegativeCycle()) {
            for (DirectedEdge edge : sp.negativeCycle()) {
                System.out.print(edge + "  ");
            }
        }

    }

}


