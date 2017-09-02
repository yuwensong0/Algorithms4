package chapter3_2;

import chapter1_2.Queue;

public class BST<Key extends Comparable<Key>, Value> {
	private Node root;

	private class Node {
		private int N;
		private Key key;
		private Value val;
		private Node left;
		private Node right;

		public Node() {

		}

		public Node(Key key, Value val, int N) {
			this.key = key;
			this.val = val;
			this.N = N;
		}
	}

	public boolean isEmpty() {
		return root == null;
	}
	
	public int height() {
		return height(root);
	}
	
	private int height(Node x) {
		if (x == null) {
			return -1;
		}
		int heightLeft = height(x.left);
		int heightRight = height(x.right);
		if (heightLeft > heightRight) {
			return heightLeft + 1;
		} else {
			return heightRight + 1;
		}
	}

	public int size() {
		return size(root);
	}

	public int size(Key lo, Key hi) {
		return size(root, lo, hi, 0);
	}

	private int size(Node x, Key lo, Key hi, int sum) {
		if (x == null) {
			return sum;
		}
		int cmplo = lo.compareTo(x.key);
		int cmphi = hi.compareTo(x.key);
		if (cmplo < 0) {
			sum = size(x.left, lo, hi, sum);
		}
		if (cmplo <= 0 && cmphi >= 0) {
			sum++;
		}
		if (cmphi > 0) {
			sum = size(x.right, lo, hi, sum);
		}
		return sum;
	}

	private int size(Node x) {
		if (x == null) {
			return 0;
		}
		return x.N;
	}

	public Value get(Key key) {
		return get(root, key);
	}

	private Value get(Node x, Key key) {
		if (x == null) {
			return null;
		}
		int cmp = key.compareTo(x.key);
		if (cmp > 0) {
			return get(x.right, key);
		} else if (cmp < 0) {
			return get(x.left, key);
		} else {
			return x.val;
		}
	}

	public void put(Key key, Value val) {
		root = put(root, key, val);
	}

	private Node put(Node x, Key key, Value val) {
		if (x == null) {
			return new Node(key, val, 1);
		}
		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			x.left = put(x.left, key, val);
		} else if (cmp > 0) {
			x.right = put(x.right, key, val);
		} else {
			x.val = val;
		}
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	public Key min() {
		Node x = min(root);
		if (x == null) {
			return null;
		}
		return x.key;
	}

	private Node min(Node x) {
		if (x == null) {
			return null;
		}
		if (x.left == null) {
			return x;
		}
		return min(x.left);
	}

	public Key max() {
		Node x = max(root);
		if (x == null) {
			return null;
		}
		return x.key;
	}

	private Node max(Node x) {
		if (x == null) {
			return null;
		}
		if (x.right == null) {
			return x;
		}
		return max(x.right);
	}

	public Key floor(Key key) {
		Node x = floor(root, key);
		if (x == null) {
			return null;
		}
		return x.key;

	}

	private Node floor(Node x, Key key) {
		if (x == null) {
			return null;
		}
		int cmp = key.compareTo(x.key);
		if (cmp == 0) {
			return x;
		} else if (cmp < 0) {
			return floor(x.left, key);
		} else {
			Node t = floor(x.right, key);
			if (t == null) {
				return x;
			}
			return t;
		}
	}

	public Key ceiling(Key key) {
		Node x = ceiling(root, key);
		if (x == null) {
			return null;
		}
		return x.key;
	}

	private Node ceiling(Node x, Key key) {
		if (x == null) {
			return null;
		}
		int cmp = key.compareTo(x.key);
		if (cmp == 0) {
			return x;
		} else if (cmp > 0) {
			return ceiling(x.right, key);
		} else {
			Node t = ceiling(x.left, key);
			if (t == null) {
				return x;
			}
			return t;
		}
	}

	public Key select(int k) {
		Node x = select(root, k);
		if (x == null) {
			return null;
		}
		return x.key;
	}

	private Node select(Node x, int k) {
		if (x == null) {
			return null;
		}
		int t = size(x.left);
		if (t > k) {
			return select(x.left, k);
		} else if (t < k) {
			return select(x.right, k - t - 1);
		} else {
			return x;
		}
	}

	public int rank(Key key) {
		return rank(root, key);
	}

	private int rank(Node x, Key key) {
		if (x == null) {
			return 0;
		}
		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			return rank(x.left, key);
		} else if (cmp > 0) {
			return rank(x.right, key) + size(x.left) + 1;
		} else {
			return size(x.left);
		}
	}

	public void deleteMin() {
		root = deleteMin(root);
	}

	private Node deleteMin(Node x) {
		if (x == null) {
			return null;
		}
		if (x.left == null) {
			return x.right;
		}
		x.left = deleteMin(x.left);
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	public void deleteMax() {
		root = deleteMax(root);
	}

	private Node deleteMax(Node x) {
		if (x == null) {
			return null;
		}
		if (x.right == null) {
			return x.left;
		}
		x.right = deleteMax(x.right);
		x.N = size(x.right) + size(x.left) + 1;
		return x;
	}

	public void delete(Key key) {
		root = delete(root, key);
	}

	private Node delete(Node x, Key key) {
		if (x == null) {
			return null;
		}
		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			x.left = delete(x.left, key);
		} else if (cmp > 0) {
			x.right = delete(x.right, key);
		} else {
			if (x.left == null) {
				return x.right;
			}
			if (x.right == null) {
				return x.left;
			}
			Node t = x;
			x = min(x.right);
			x.right = deleteMin(x.right);
			x.left = t.left;
		}
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	public Iterable<Key> keys() {
		return keys(min(), max());
	}

	public Iterable<Key> keys(Key lo, Key hi) {
		Queue<Key> queue = new Queue<>();
		if (lo == null || hi == null) {
			return queue;
		}
		keys(root, queue, lo, hi);
		return queue;
	}

	private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
		if (x == null) {
			return;
		}
		int cmplo = lo.compareTo(x.key);
		int cmphi = hi.compareTo(x.key);
		if (cmplo < 0) {
			keys(x.left, queue, lo, hi);
		}
		if (cmplo <= 0 && cmphi >= 0) {
			queue.enqueue(x.key);
		}
		if (cmphi > 0) {
			keys(x.right, queue, lo, hi);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST<Integer, String> st = new BST<>();
		st.deleteMax();
		System.out.println(st.isEmpty());
		System.out.println(st.size());
		for (Integer key : st.keys()) {
			System.out.println("key : " + key + "  val : " + st.get(key));
		}
		st.deleteMin();
		System.out.println(st.isEmpty());
		System.out.println(st.size());
		for (Integer key : st.keys()) {
			System.out.println("key : " + key + "  val : " + st.get(key));
		}
		System.out.println(st.isEmpty());
		System.out.println(st.size());
		st.put(1, "a");
		System.out.println("first : " + st.height());
		st.put(9, "r");
		System.out.println("first2 : " + st.height());
		st.put(2, "t");
		System.out.println("first3 : " + st.height());
		st.put(4, "f");
		System.out.println("first4 : " + st.height());
		st.put(3, "b");
		System.out.println("first5 : " + st.height());
		st.put(5, "j");
		System.out.println("first6 : " + st.height());
		st.put(1, "p");
		System.out.println("first7 : " + st.height());
		System.out.println("size(5, 2) : " + st.size(5, 2));
		System.out.println("size(1, 7) : " + st.size(1, 7));
		System.out.println("size(1, 5) : " + st.size(1, 5));
		System.out.println("size(0, 5) : " + st.size(0, 5));
		System.out.println("size(0, 7) : " + st.size(0, 7));
		System.out.println("select(10) : " + st.select(10));
		System.out.println("select(3) : " + st.select(3));
		System.out.println("floor(0) : " + st.floor(0));
		System.out.println("floor(1) : " + st.floor(1));
		System.out.println("floor(10) : " + st.floor(10));
		System.out.println("floor(7) : " + st.floor(7));
		System.out.println("ceiling(0) : " + st.ceiling(0));
		System.out.println("ceiling(1) : " + st.ceiling(1));
		System.out.println("ceiling(10) : " + st.ceiling(10));
		System.out.println("ceiling(7) : " + st.ceiling(7));
		System.out.println("rank(0) : " + st.rank(0));
		System.out.println("rank(100) : " + st.rank(100));
		System.out.println("rank(3) : " + st.rank(3));
		System.out.println("rank(7) : " + st.rank(7));
		System.out.println(st.isEmpty());
		System.out.println(st.size());
		for (Integer key : st.keys()) {
			System.out.println("key : " + key + "  val : " + st.get(key));
		}
		System.out.println();
		for (Integer key : st.keys(0, 19)) {
			System.out.println("key : " + key + "  val : " + st.get(key));
		}
		System.out.println();
		for (Integer key : st.keys(0, 7)) {
			System.out.println("key : " + key + "  val : " + st.get(key));
		}
		System.out.println();
		for (Integer key : st.keys(0, 5)) {
			System.out.println("key : " + key + "  val : " + st.get(key));
		}
		System.out.println();
		for (Integer key : st.keys(1, 7)) {
			System.out.println("key : " + key + "  val : " + st.get(key));
		}
		System.out.println();
		for (Integer key : st.keys(1, 5)) {
			System.out.println("key : " + key + "  val : " + st.get(key));
		}
		st.delete(0);
		System.out.println(st.isEmpty());
		System.out.println(st.size());
		for (Integer key : st.keys()) {
			System.out.println("key : " + key + "  val : " + st.get(key));
		}
		st.delete(1);
		System.out.println(st.isEmpty());
		System.out.println(st.size());
		for (Integer key : st.keys()) {
			System.out.println("key : " + key + "  val : " + st.get(key));
		}
		st.delete(3);
		System.out.println(st.isEmpty());
		System.out.println(st.size());
		for (Integer key : st.keys()) {
			System.out.println("key : " + key + "  val : " + st.get(key));
		}
		st.deleteMax();
		System.out.println(st.isEmpty());
		System.out.println(st.size());
		for (Integer key : st.keys()) {
			System.out.println("key : " + key + "  val : " + st.get(key));
		}
		st.deleteMin();
		System.out.println(st.isEmpty());
		System.out.println(st.size());
		for (Integer key : st.keys()) {
			System.out.println("key : " + key + "  val : " + st.get(key));
		}

	}

}
