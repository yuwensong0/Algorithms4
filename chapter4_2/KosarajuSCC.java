package chapter4_2;

import chapter1_2.Bag;

public class KosarajuSCC {
    private boolean[] marked;
    private int[] id;
    private int count;
    
    public KosarajuSCC(Digraph digraph) {
        marked = new boolean[digraph.V()];
        id = new int[digraph.V()];
        count = 0;
        DepthFirstOrder order = new DepthFirstOrder(digraph.reverse());
        for (int v : order.reversePost()) {
            if (!marked[v]) {
                dfs(digraph, v);
                count++;
            }
        }
        
    }
    
    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }
    
    public int id(int v) {
         return id[v];
    }
    
    public int count() {
        return count;
    }
    
    private void dfs(Digraph digraph, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : digraph.adj(v)) {
            if (!marked[w]) {
                dfs(digraph, w);
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Digraph digraph = new Digraph(13);
        digraph.addEdge(0, 5);
        digraph.addEdge(0, 1);
        digraph.addEdge(2, 0);
        digraph.addEdge(2, 3);
        digraph.addEdge(3, 2);
        digraph.addEdge(3, 5);
        digraph.addEdge(4, 2);
        digraph.addEdge(4, 3);
        digraph.addEdge(5, 4);
        digraph.addEdge(6, 0);
        digraph.addEdge(6, 4);
        digraph.addEdge(6, 9);
        digraph.addEdge(7, 6);
        digraph.addEdge(7, 8);
        digraph.addEdge(8, 7);
        digraph.addEdge(8, 9);
        digraph.addEdge(9, 11);
        digraph.addEdge(9, 10);
        digraph.addEdge(10, 12);
        digraph.addEdge(11,  12);
        digraph.addEdge(12, 9);
        KosarajuSCC kosarajuSCC = new KosarajuSCC(digraph);
        int M = kosarajuSCC.count();
        System.out.println(M + "components");
        
        Bag<Integer>[] components = (Bag<Integer>[]) new Bag[M];
        for (int i = 0; i < M; i++) {
            components[i] = new Bag<>();
        }
        for (int v = 0; v < digraph.V(); v++) {
            components[kosarajuSCC.id(v)].add(v);
        }
        for (int i = 0; i < M; i++) {
            for (int v : components[i]) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
        Digraph digraph2 = new Digraph(13);
        digraph2.addEdge(0, 5);
        digraph2.addEdge(0, 1);
        digraph2.addEdge(0, 6);
        digraph2.addEdge(2, 0);
        digraph2.addEdge(2, 3);
        digraph2.addEdge(3, 5);
        digraph2.addEdge(5, 4);
        digraph2.addEdge(6, 4);
        digraph2.addEdge(6, 9);
        digraph2.addEdge(7, 6);
        digraph2.addEdge(8, 7);
        digraph2.addEdge(9, 11);
        digraph2.addEdge(9, 10);
        digraph2.addEdge(9, 12);
        digraph2.addEdge(11, 12);
        KosarajuSCC kosarajuSCC2 = new KosarajuSCC(digraph2);
        int M2 = kosarajuSCC2.count();
        System.out.println(M2 + "components");
        
        Bag<Integer>[] components2 = (Bag<Integer>[]) new Bag[M2];
        for (int i = 0; i < M2; i++) {
            components2[i] = new Bag<>();
        }
        for (int v = 0; v < digraph.V(); v++) {
            components2[kosarajuSCC2.id(v)].add(v);
        }
        for (int i = 0; i < M2; i++) {
            for (int v : components2[i]) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

}
