package chapter3_4;

import chapter1_2.Queue;

public class LinearProbingHashST<Key, Value> {
	private int N;
	private int M = 16;
	private Key[] keys;
	private Value[] vals;
	
	public LinearProbingHashST() {
		keys = (Key[]) new Object[M];
		vals = (Value[]) new Object[M];
		N = 0;
	}
	
	public LinearProbingHashST(int cap) {
		M = cap;
		N = 0;
		keys = (Key[]) new Object[M];
		vals = (Value[]) new Object[M];
	}
	
	public int size() {
		return N;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public boolean contains(Key key) {
		for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
			if (key.equals(keys[i])) {
				return true;
			}
		}
		return false;
	}

	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	private void resize(int cap) {
		LinearProbingHashST<Key, Value> t = new LinearProbingHashST<>(cap);
		for (int i = 0; i < M; i++) {
			if (keys[i] != null) {
				put(keys[i], vals[i]);
			}
		}
		keys = t.keys;
		vals = t.vals;
		M = t.M;
	}
	public void put(Key key, Value val) {
		if (N >= M/2) {
			resize(2 * M);
		}
		int i;
		for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
			if (key.equals(keys[i])) {
				vals[i] = val;
				return;
			}
		}
		keys[i] = key;
		vals[i] = val;
		N++;
	}
	
	public void delete(Key key) {
		if (!contains(key)) {
			return;
		}
		int i = hash(key);
		while (!key.equals(keys[i])) {
			i = (i + 1) % M;
		}
		keys[i] = null;
		vals[i] = null;
		i = (i + 1) % M;
		while (keys[i] != null) {
			Key keyToRedo = keys[i];
			Value valToRedo = vals[i];
			keys[i] = null;
			vals[i] = null;
			N--;
			put(keyToRedo, valToRedo);
			i = (i + 1) % M;
		}
		N--;
		if (N > 0 && N <= M/8) {
			resize(M / 2);
		}
	}
	
	public Value get(Key key) {
		for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
			if (key.equals(keys[i])) {
				return vals[i];
			}
		}
		return null;
	}
	
	public Iterable<Key> keys() {
		Queue<Key> queue = new Queue<>();
		for (int i = 0; i < M; i++) {
			if (keys[i] != null) {
				queue.enqueue(keys[i]);;
			}
		}
		return queue;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinearProbingHashST<Integer, Integer> st = new LinearProbingHashST<>();
		System.out.println(st.size());
		System.out.println(st.isEmpty());
		st.put(1, 1);
		st.put(3, 4);
		st.put(2, 6);
		st.put(7, 88);
		st.put(22, 9);
		st.put(88, 5);
		for (int i : st.keys()) {
			System.out.println("key : " + i + " val : " + st.get(i));
		}
		System.out.println(st.contains(0));
		System.out.println(st.contains(7));
		System.out.println(st.size());
		System.out.println(st.isEmpty());
		System.out.println(st.get(2));
		System.out.println(st.get(1));
		st.delete(0);
		st.delete(1);
		System.out.println(st.size());
		System.out.println(st.isEmpty());
		System.out.println(st.get(1));

	}

}
