package chapter4_1;

import sun.net.www.content.text.plain;

public class DepthFirstSearch implements Search {
    private int count;
    private boolean[] marked;
    
    public DepthFirstSearch(Graph G, int s) {
        count = 0;
        marked = new boolean[G.V()];
        dfs(G, s);
    }
    
    private void dfs(Graph G, int v) {
        marked[v] = true;
        count++;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }
    
    public boolean marked(int v) {
        return marked[v];
    }
    
    public int count() {
        return count;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int s = 9;
        Graph graph = new Graph(13);
        graph.addEdge(0, 5);
        graph.addEdge(4, 3);
        graph.addEdge(0, 1);
        graph.addEdge(9, 12);
        graph.addEdge(6, 4);
        graph.addEdge(5, 4);
        graph.addEdge(0, 2);
        graph.addEdge(11, 12);
        graph.addEdge(9, 10);
        graph.addEdge(0, 6);
        graph.addEdge(7, 8);
        graph.addEdge(9, 11);
        graph.addEdge(5, 3);
        Search search = new DepthFirstSearch(graph, s);
        for (int v = 0; v < graph.V(); v++) {
            if (search.marked(v)) {
                System.out.print(v + " ");
            }
        }
        System.out.println();
        if (search.count() != graph.V()) {
            System.out.print("NOT ");
        }
        System.out.println("connected");
    }

}
