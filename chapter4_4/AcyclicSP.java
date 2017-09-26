package chapter4_4;

import chapter1_2.Stack;
import chapter4_2.Digraph;
import chapter4_2.Topological;

public class AcyclicSP {
    private DirectedEdge[] edgeTo;
    private double[] distTo;

    public AcyclicSP(EdgeWeightedDigraph digraph, int s) {
        edgeTo = new DirectedEdge[digraph.V()];
        distTo = new double[digraph.V()];
        for (int i = 0; i < digraph.V(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        Topological top = new Topological(new Fix(digraph));
        distTo[s] = 0.0;
        for (int v : top.order()) {
            relax(digraph, v);
        }
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<DirectedEdge> stack = new Stack<>();
        for (DirectedEdge edge = edgeTo[v]; edge != null; edge = edgeTo[edge.from()]) {
            stack.push(edge);
        }
        return stack;
    }

    private void relax(EdgeWeightedDigraph digraph, int v) {
        for (DirectedEdge edge : digraph.adj(v)) {
            int w = edge.to();
            if (distTo[w] > distTo[v] + edge.weight()) {
                distTo[w] = distTo[v] + edge.weight();
                edgeTo[w] = edge;
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        EdgeWeightedDigraph digraph = new EdgeWeightedDigraph(8);
        digraph.addEdge(new DirectedEdge(5, 4, 0.35));
        digraph.addEdge(new DirectedEdge(4, 7, 0.37));
        digraph.addEdge(new DirectedEdge(5, 7, 0.28));
        digraph.addEdge(new DirectedEdge(5, 1, 0.32));
        digraph.addEdge(new DirectedEdge(4, 0, 0.38));
        digraph.addEdge(new DirectedEdge(0, 2, 0.26));
        digraph.addEdge(new DirectedEdge(3, 7, 0.39));
        digraph.addEdge(new DirectedEdge(1, 3, 0.29));
        digraph.addEdge(new DirectedEdge(7, 2, 0.34));
        digraph.addEdge(new DirectedEdge(6, 2, 0.40));
        digraph.addEdge(new DirectedEdge(3, 6, 0.52));
        digraph.addEdge(new DirectedEdge(6, 0, 0.58));
        digraph.addEdge(new DirectedEdge(6, 4, 0.93));
        int s = 5;
        AcyclicSP sp = new AcyclicSP(digraph, s);
        for (int t = 0; t < digraph.V(); t++) {
            System.out.print(s + " to " + t);
            System.out.printf(" (%4.2f): ", sp.distTo(t));
            if (sp.hasPathTo(t)) {
                for (DirectedEdge edge : sp.pathTo(t)) {
                    System.out.print(edge + "   ");
                }
            }
            System.out.println();
        }

    }

}

class Fix extends Digraph {
    // private EdgeWeightedDigraph digraph;

    public Fix(EdgeWeightedDigraph digraph) {
        super(digraph.V());
        for (DirectedEdge edge : digraph.edges()) {
            addEdge(edge.from(), edge.to());
        }
    }

}
