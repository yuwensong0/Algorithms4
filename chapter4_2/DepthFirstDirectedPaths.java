package chapter4_2;

import chapter1_2.Stack;

public class DepthFirstDirectedPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;
    
    public DepthFirstDirectedPaths(Digraph digraph, int s) {
        marked = new boolean[digraph.V()];
        edgeTo = new int[digraph.V()];
        this.s = s;
        dfs(digraph, s);
    }
    
    public boolean hasDirectedPathTo(int v) {
        return marked[v];
    }
    
    public Iterable<Integer> directedPathTo(int v) {
        Stack<Integer> stack = new Stack<>();
        if (!hasDirectedPathTo(v)) {
            return stack;
        }
        for (int x = v; x != s; x = edgeTo[x]) {
            stack.push(x);
        }
        stack.push(s);
        return stack;
        
    }
    
    private void dfs(Digraph digraph, int v) {
        marked[v] = true;
        for (int w : digraph.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(digraph, w);
            }
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int s = 0;
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
        DepthFirstDirectedPaths paths = new DepthFirstDirectedPaths(digraph, s);
        for (int v = 0; v < digraph.V(); v++) {
            System.out.print(s + " to " + v + ": ");
            if (paths.hasDirectedPathTo(v)) {
                for (int x : paths.directedPathTo(v)) {
                    if (x == s) {
                        System.out.print(x);
                    } else {
                        System.out.print("-" + x);
                    }
                }
                
            }
            System.out.println();
        }
    }

}
