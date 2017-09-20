package chapter4_1;

import chapter3_4.SeparateChainingHashST;
import edu.princeton.cs.algs4.In;

public class SymbolGraph {
    private SeparateChainingHashST<String, Integer> st;
    private String[] keys;
    private Graph graph;

    public SymbolGraph(String stream, String sp) {
        st = new SeparateChainingHashST<>();
        In in = new In(stream);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(sp);
            for (int i = 0; i < a.length; i++) {
                if (!st.contains(a[i])) {
                    st.put(a[i], st.size());
                }
            }
        }
        keys = new String[st.size()];
        for (String name : st.keys()) {
            keys[st.get(name)] = name;
        }
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(sp);
            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++) {
                graph.addEdge(v, st.get(a[i]));
            }
        }
    }

    public boolean contains(String s) {
        return st.contains(s);
    }
    
    public int index(String s) {
        return st.get(s);
    }
    
    public String name(int v) {
        return keys[v];
    }
    
    public Graph G() {
        return graph;
    }

}
