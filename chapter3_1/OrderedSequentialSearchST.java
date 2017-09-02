package chapter3_1;

import chapter1_2.Queue;

public class OrderedSequentialSearchST<Key extends Comparable<Key>, Value> {
	private int N;
	private Node first;
	private Node last;

	private class Node {
		Key key;
		Value val;
		Node pre;
		Node post;

		public Node() {

		}

		public Node(Key key, Value val) {
			this.key = key;
			this.val = val;
		}
	}

	public OrderedSequentialSearchST() {

	}

	public boolean contains(Key key) {
		for (Node temp = first; temp != null; temp = temp.post) {
			if (key.compareTo(temp.key) == 0) {
				return true;
			}
		}
		return false;
	}

	public Key min() {
		if (N == 0) {
			return null;
		}
		return first.key;
	}

	public Key max() {
		if (N == 0) {
			return null;
		}
		return last.key;
	}

	public Key select(int k) {
		if (k >= N) {
			return null;
		}
		Node temp = first;
		while (k > 0) {
			temp = temp.post;
			k--;
		}
		return temp.key;
	}

	public int rank(Key key) {
		int i = 0;
		for (Node temp = first; temp != null && key.compareTo(temp.key) > 0; temp = temp.post) {
			i++;
		}
		return i;
	}

	public Key floor(Key key) {
		Node temp = precursor(key);
		if (temp == null) {
			return null;
		} else {
			return temp.key;
		}
	}

	public Key ceiling(Key key) {
		Node temp = postcursor(key);
		if (temp == null) {
			return null;
		} else {
			return temp.key;
		}
	}

	public int size() {
		return N;
	}

	public int size(Key lo, Key hi) {
		if (hi.compareTo(lo) < 0) {
			return 0;
		}
		if (contains(hi)) {
			return rank(hi) - rank(lo) + 1;
		}
		return rank(hi) - rank(lo);
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public void put(Key key, Value val) {
		if (N == 0) {
			first = new Node(key, val);
			last = first;
			N++;
			return;
		}
		if (key.compareTo(first.key) < 0) {
			Node oldFirst = first;
			first = new Node(key, val);
			first.post = oldFirst;
			oldFirst.pre = first;
			N++;
			return;
		}
		if (key.compareTo(last.key) > 0) {
			Node oldLast = last;
			last = new Node(key, val);
			last.pre = oldLast;
			oldLast.post = last;
			N++;
			return;
		}
		Node cursor = precursor(key);
		if (key.compareTo(cursor.key) == 0) {
			cursor.val = val;
			return;
		}
		Node temp = new Node(key, val);
		temp.post = cursor.post;
		cursor.post.pre = temp;
		cursor.post = temp;
		temp.pre = cursor;
		N++;
	}

	public Value get(Key key) {
		for (Node temp = first; temp != null; temp = temp.post) {
			if (key.compareTo(temp.key) == 0)
				return temp.val;
		}
		return null;
	}

	public void delete(Key key) {
		if (key == null) {
			return;
		}
		for (Node temp = first; temp != null; temp = temp.post) {
			if (key.compareTo(temp.key) == 0) {
				if (N == 1) {
					first = null;
					last = null;
					N--;
				} else if (temp == first) {
					Node oldFirst = first;
					first = first.post;
					oldFirst.post = null;
					first.pre = null;
					N--;
				} else if (temp == last) {
					Node oldLast = last;
					last = last.pre;
					oldLast.pre = null;
					last.post = null;
					N--;
				} else {
					Node preTemp = temp.pre;
					preTemp.post = temp.post;
					temp.post.pre = preTemp;
					temp.post = null;
					temp.pre = null;
					N--;
				}
			}
		}
	}

	public void deleteMax() {
		if (N == 0) {
			return;
		}
		delete(last.key);
	}

	public void deleteMin() {
		if (N == 0) {
			return;
		}
		delete(first.key);
	}

	public Iterable<Key> keys() {
		Queue<Key> queue = new Queue<>();
		for (Node temp = first; temp != null; temp = temp.post) {
			queue.enqueue(temp.key);
		}
		return queue;
	}

	public Iterable<Key> keys(Key lo, Key hi) {
		Queue<Key> queue = new Queue<>();
		if (lo == null || hi == null || hi.compareTo(lo) < 0 || N == 0 || lo.compareTo(last.key) > 0
				|| hi.compareTo(first.key) < 0) {
			return queue;
		}
		Node temp = first;
		while (temp.key.compareTo(lo) < 0) {
			temp = temp.post;
		}
		for (Node cursor = temp; cursor != null && cursor.key.compareTo(hi) <= 0; cursor = cursor.post) {
			queue.enqueue(cursor.key);
		}
		return queue;
	}

	private Node postcursor(Key key) {
		if (N > 0 && key.compareTo(first.key) < 0) {
			return first;
		}
		for (Node temp = last; temp != null; temp = temp.pre) {
			if (key.compareTo(temp.key) == 0) {
				return temp;
			}
			if (key.compareTo(temp.key) > 0) {
				return temp.post;
			}
		}
		return null;
	}

	private Node precursor(Key key) {
		if (N > 0 && key.compareTo(last.key) > 0) {
			return last;
		}
		for (Node temp = first; temp != null; temp = temp.post) {
			if (key.compareTo(temp.key) == 0) {
				return temp;
			}
			if (key.compareTo(temp.key) < 0) {
				return temp.pre;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OrderedSequentialSearchST<Integer, String> st = new OrderedSequentialSearchST<>();
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
		st.put(9, "r");
		st.put(2, "t");
		st.put(4, "f");
		st.put(3, "b");
		st.put(5, "j");
		st.put(1, "p");
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
