package chapter4_1;

import chapter1_2.*;

public class BreadthFirstPaths implements Paths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;
    
    public BreadthFirstPaths(Graph graph, int s) {
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        this.s = s;
        bfs(graph, s);
    }
    
    private void bfs(Graph graph, int v) {
        Queue<Integer> queue = new Queue<>();
        marked[v] = true;
        queue.enqueue(v);
        while (!queue.isEmpty()) {
            int x = queue.dequeue();
            for (int w : graph.adj(x)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = x;
                    queue.enqueue(w);
                }
            }
        }
    }
    
    public boolean hasPathTo(int v) {
        return marked[v];
    }
    
    public Iterable<Integer> pathTo(int v) {
        Stack<Integer> stack = new Stack<>();
        if (!hasPathTo(v)) {
            return stack;
        }
        for (int i = v; i != s; i = edgeTo[i]) {
            stack.push(i);
        }
        stack.push(s);
        return stack;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int s = 0;
        Graph graph = new Graph(6);
        graph.addEdge(0, 5);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(1, 2);
        graph.addEdge(0, 1);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(0, 2);
        Paths search = new BreadthFirstPaths(graph, s);
        for (int v = 0; v < graph.V(); v++) {
            System.out.print(s + " to " + v + ": ");
            if (search.hasPathTo(v)) {
                for (int x : search.pathTo(v)) {
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
