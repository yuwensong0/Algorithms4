package chapter4_4;

public class DirectedEdge {
    private final int v;
    private final int w;
    private double weight;
    
    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    
    public int from() {
        return v;
    }
    
    public int to() {
        return w;
    }
    
    public double weight() {
        return weight;
    }
    
    public String toString() {
        return String.format("%d->%d %.2f", v, w, weight);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DirectedEdge edge = new DirectedEdge(1, 2, 0.3);
        System.out.println("from " + edge.from() + " to " + edge.to() + " weight : " + edge.weight());
        System.out.println(edge);
                

    }

}
