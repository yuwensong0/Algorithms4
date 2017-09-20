package chapter4_1;

public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;
    
    public Cycle(Graph graph) {
        marked = new boolean[graph.V()];
        for (int i = 0; i < graph.V(); i++) {
            if (!marked[i]) {
                dfs(graph, i, i);
            }
        }
    }
    
    private void dfs(Graph graph, int v, int u) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w, v);
            } else if (w != u) {
                hasCycle = true;
            }
        }
    }
    
    public boolean hasCycle() {
        return hasCycle;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
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
        Cycle cycle = new Cycle(graph);
        System.out.println(cycle.hasCycle());
        Graph graph2 = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 4);
        graph.addEdge(4, 5);
        graph.addEdge(2, 3);
        Cycle cycle2 = new Cycle(graph2);
        System.out.println(cycle2.hasCycle());
                

    }

}
