package chapter3_4;

import chapter1_2.Queue;
import chapter3_1.SequentialSearchST;

public class SeparateChainingHashST<Key, Value> {
	private int N;
	private int M;
	private SequentialSearchST<Key, Value>[] st;
	
	public SeparateChainingHashST() {
		this(997);
	}
	
	public SeparateChainingHashST(int M) {
		this.M = M;
		N = 0;
		st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
		for (int i = 0; i < M; i++) {
			st[i] = new SequentialSearchST<Key, Value>(); //这是否需要删除泛型？
		}
	}
	
	public Value get(Key key) {
		return (Value) st[hash(key)].get(key);
	}
	
	public void put(Key key, Value val) {
		SequentialSearchST<Key, Value> temp = st[hash(key)];
		N -= temp.size();
		temp.put(key, val);
		N += temp.size();
	}
	
	public void delete(Key key) {
		SequentialSearchST<Key, Value> temp = st[hash(key)];
		N -= temp.size();
		temp.delete(key);
		N += temp.size();
	}
	
	public int size() {
		return N;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public boolean contains(Key key) {
		return st[hash(key)].contains(key);
	}
	
	public Iterable<Key> keys() {
		Queue<Key> queue = new Queue<>();
		for (int i = 0; i < M; i++) {
			for(Key key : st[i].keys()) {
				queue.enqueue(key);
			}
		}
		return queue;
	}
	
	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SeparateChainingHashST<Integer, Integer> st = new SeparateChainingHashST<>();
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
