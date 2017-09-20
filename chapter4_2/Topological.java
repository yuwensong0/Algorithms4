package chapter4_2;

public class Topological {
    private Iterable<Integer> order;
    
    public Topological(Digraph digraph) {
        DirectedCycle cycleFinder = new DirectedCycle(digraph);
        if (!cycleFinder.hasCycle()) {
            DepthFirstOrder depthFirstOrder = new DepthFirstOrder(digraph);
            order = depthFirstOrder.reversePost();
        }
    }
    
    public Iterable<Integer> order() {
        return order;
    }
    
    public boolean isDAG() {
        return order != null;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Digraph digraph = new Digraph(13);
        digraph.addEdge(0, 5);
        digraph.addEdge(0, 1);
        digraph.addEdge(0, 6);
        digraph.addEdge(2, 0);
        digraph.addEdge(2, 3);
        digraph.addEdge(3, 5);
        digraph.addEdge(5, 4);
        digraph.addEdge(6, 4);
        digraph.addEdge(6, 9);
        digraph.addEdge(7, 6);
        digraph.addEdge(8, 7);
        digraph.addEdge(9, 11);
        digraph.addEdge(9, 10);
        digraph.addEdge(9, 12);
        digraph.addEdge(11, 12);
        Topological topological = new Topological(digraph);
        if (topological.isDAG()) {
            for (int v : topological.order()) {
                System.out.print(v + " ");
            }
        }

    }

}
