package chapter4_2;

import chapter1_2.Stack;

public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private boolean[] onStack;
    private Stack<Integer> cycle;
    
    public DirectedCycle (Digraph digraph) {
        marked = new boolean[digraph.V()];
        edgeTo = new int[digraph.V()];
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
    
    public Iterable<Integer> cycle() {
        return cycle;
    }
    
    private void dfs(Digraph digraph, int v) {
        marked[v] = true;
        onStack[v] = true;
        for (int w : digraph.adj(v)) {
            if (hasCycle()) {
                return;
            }
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(digraph, w);
            } else if (onStack[w]) {
                cycle = new Stack<>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }
    
    

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Digraph digraph = new Digraph(13);
        digraph.addEdge(4, 2);
        digraph.addEdge(2, 3);
        digraph.addEdge(3, 2);
        digraph.addEdge(6, 0);
        digraph.addEdge(0, 1);
        digraph.addEdge(2, 0);
        digraph.addEdge(11, 12);
        digraph.addEdge(12, 9);
        digraph.addEdge(9, 10);
        digraph.addEdge(9, 11);
        digraph.addEdge(8, 9);
        digraph.addEdge(10, 12);
        digraph.addEdge(11, 4);
        digraph.addEdge(4, 3);
        digraph.addEdge(3, 5);
        digraph.addEdge(7, 8);
        digraph.addEdge(8, 7);
        digraph.addEdge(5, 4);
        digraph.addEdge(0, 5);
        digraph.addEdge(6, 4);
        digraph.addEdge(6, 9);
        digraph.addEdge(7, 6);
        DirectedCycle cycle = new DirectedCycle(digraph);
        System.out.println(cycle.hasCycle());
        if (cycle.hasCycle()) {
            for (int v : cycle.cycle()) {
                System.out.print(v + " ");
            }
        }

    }

}
