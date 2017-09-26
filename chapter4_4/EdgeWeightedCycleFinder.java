package chapter4_4;

import chapter1_2.Stack;
import chapter4_2.Digraph;

public class EdgeWeightedCycleFinder {
    private boolean[] marked;
    private DirectedEdge[] edgeTo;
    private boolean[] onStack;
    private Stack<DirectedEdge> cycle;
    
    public EdgeWeightedCycleFinder (EdgeWeightedDigraph digraph) {
        marked = new boolean[digraph.V()];
        edgeTo = new DirectedEdge[digraph.V()];
        onStack = new boolean[digraph.V()];
        for (int v = 0; v < digraph.V(); v++) {
            if (!marked[v]) {
                dfs(digraph, v);
            }
        }
    }
    
    public boolean hasCycle() {
        return cycle != null;
    }
    
    public Iterable<DirectedEdge> cycle() {
        return cycle;
    }
    
    private void dfs(EdgeWeightedDigraph digraph, int v) {
        marked[v] = true;
        onStack[v] = true;
        for (DirectedEdge edge : digraph.adj(v)) {
            int w = edge.to();
            if (hasCycle()) {
                return;
            }
            if (!marked[w]) {
                edgeTo[w] = edge;
                dfs(digraph, w);
            } else if (onStack[w]) {
                cycle = new Stack<>();
                cycle.push(edge);
                for (DirectedEdge edge2 = edgeTo[v]; edge2 != edgeTo[w]; edge2 = edgeTo[edge2.from()]) {
                    cycle.push(edge2);
                }
            }
        }
        onStack[v] = false;
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
        EdgeWeightedCycleFinder cf = new EdgeWeightedCycleFinder(digraph);
        if (cf.hasCycle()) {
            for (DirectedEdge edge : cf.cycle()) {
                System.out.print(edge + "  ");
            }
        }
        

    }

}
