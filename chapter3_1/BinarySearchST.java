package chapter3_1;

import chapter1_2.Queue;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
	private int N;
	private Key[] keys;
	private Value[] vals;

	public BinarySearchST() {
		keys = (Key[]) new Comparable[1];
		vals = (Value[]) new Object[1];
		N = 0;
	}

	public BinarySearchST(int capacity) {
		keys = (Key[]) new Comparable[capacity];
		vals = (Value[]) new Object[capacity];
		N = 0;
	}

	public int size() {
		return N;
	}
	
	public boolean contains(Key key) {
		int i = rank(key);
		return keys[i].compareTo(key) == 0;
	}

	public boolean isEmpty() {
		return N == 0;
	}
	
	public Key min() {
		return keys[0];
	}
	
	public Key max() {
		if (N == 0) {
			return null;
		}
		return keys[N - 1];
	}
	
	public Key floor(Key key) {
		int i = rank(key);
		if (i == N) {
			return keys[N - 1];
		}
		if (keys[i].compareTo(key) == 0) {
			return keys[i];
		}
		if (i == 0) {
			return null;
		}
		return keys[i - 1];
	}
	
	public Key ceiling(Key key) {
		int i = rank(key);
		if (i == N) {
			return null;
		}
		return keys[i];
	}
	
	public Key select(int k) {
		if (k < 0 || k >= N) {
			return null;
		}
		return keys[k];
	}
	
	public void deleteMin() {
		delete(min());
	}
	
	public void deleteMax() {
		delete(max());
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

	public void delete(Key key) {
		int i = rank(key);
		if (i < N && key.compareTo(keys[i]) == 0) {
			for (int j = i; j < N - 1; j++) {
				keys[j] = keys[j + 1];
				vals[j] = vals[j + 1];
			}
			N--;
			keys[N] = null;
			vals[N] = null;
			if (N > 0 && N <= keys.length)
				resize(2 * N);
		}
	}

	public Value get(Key key) {
		if (isEmpty()) {
			return null;
		}
		int i = rank(key);
		if (i < N && key.compareTo(keys[i]) == 0) {
			return vals[i];
		}
		return null;
	}

	public void put(Key key, Value val) {
		if (max() != null && key.compareTo(max()) > 0) {
			if (N == keys.length) {
				resize(2 * N);
			}
			keys[N] = key;
			vals[N] = val;
			N++;
			return;
		}
		int i = rank(key);
		if (i < N && key.compareTo(keys[i]) == 0) {
			vals[i] = val;
			return;
		}
		if (N == keys.length) {
			resize(2 * N);
		}
		for (int j = N; j > i; j--) {
			keys[j] = keys[j - 1];
			vals[j] = vals[j - 1];
		}
		keys[i] = key;
		vals[i] = val;
		N++;
	}

	public int rank(Key key) {
		int lo = 0;
		int hi = N - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (key.compareTo(keys[mid]) > 0) {
				lo = mid + 1;
			} else if (key.compareTo(keys[mid]) < 0) {
				hi = mid - 1;
			} else {
				return mid;
			}
		}
		return lo;
	}

	private void resize(int max) {
		Key[] keysTemp = (Key[]) new Comparable[max];
		for (int i = 0; i < N; i++) {
			keysTemp[i] = keys[i];
		}
		Value[] valsTemp = (Value[]) new Object[max];
		for (int i = 0; i < N; i++) {
			valsTemp[i] = vals[i];
		}
		keys = keysTemp;
		vals = valsTemp;
	}
	
	public Iterable<Key> keys(Key lo, Key hi) {
		Queue<Key> queue = new Queue<>();
		if (lo == null || hi == null) {
			return queue;
		}
		for (int i = rank(lo); i < rank(hi); i++) {
			queue.enqueue(keys[i]);
		}
		if (rank(hi) != N && hi.compareTo(keys[rank(hi)]) == 0) {
			queue.enqueue(keys[rank(hi)]);
		}
		return queue;
	}
	
	public Iterable<Key> keys() {
		return keys(min(), max());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchST<Integer, String> st = new BinarySearchST<>();
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
