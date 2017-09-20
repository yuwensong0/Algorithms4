package chapter4_2;

import chapter1_2.Queue;
import chapter1_2.Stack;

public class DepthFirstOrder {
    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reversePost;
    private boolean[] marked;

    public DepthFirstOrder(Digraph digraph) {
        pre = new Queue<>();
        post = new Queue<>();
        reversePost = new Stack<>();
        marked = new boolean[digraph.V()];
        for (int v = 0; v < digraph.V(); v++) {
            if (!marked[v]) {
                dfs(digraph, v);
            }
        }
    }

    public Iterable<Integer> pre() {
        return pre();
    }

    public Iterable<Integer> post() {
        return post;
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }

    private void dfs(Digraph digraph, int v) {
        marked[v] = true;
        pre.enqueue(v);
        for (int w : digraph.adj(v)) {
            if (!marked[w]) {
                dfs(digraph, w);
            }
        }
        post.enqueue(v);
        reversePost.push(v);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
