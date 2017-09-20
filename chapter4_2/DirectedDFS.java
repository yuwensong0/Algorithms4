package chapter4_2;

import chapter1_2.Bag;

public class DirectedDFS {
    private boolean[] marked;
    
    public DirectedDFS(Digraph digraph, int s) {
        marked = new boolean[digraph.V()];
        dfs(digraph, s);
    }
    
    public DirectedDFS(Digraph digraph, Iterable<Integer> s) {
        marked = new boolean[digraph.V()];
        for (int x : s) {
            if (!marked[x]) {
                dfs(digraph, x);
            }
        }
    }
    
    public boolean marked(int v) {
        return marked[v];
    }
    
    private void dfs(Digraph digraph, int v) {
        marked[v] = true;
        for (int w : digraph.adj(v)) {
            if (!marked[w]) {
                dfs(digraph, w);
            }
        }
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
        Bag<Integer> bag = new Bag<>();
        bag.add(1);
        bag.add(2);
        bag.add(6);
        DirectedDFS reachable = new DirectedDFS(digraph, bag);
        for (int v = 0; v < digraph.V(); v++) {
            if (reachable.marked(v)) {
                System.out.print(v + " ");
            }
        }
                
    }

}
