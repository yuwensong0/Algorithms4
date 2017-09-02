package chapter3_1;

import chapter1_2.Queue;

public class SequentialSearchST<Key, Value> {
	private Node first;
	private int N;

	private class Node {
		Key key;
		Value val;
		Node next;

		public Node(Key key, Value val, Node next) {
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}

	public SequentialSearchST() {
		first = null;
		N = 0;
	}
	
	public boolean contains(Key key) {
		for (Node t = first; t != null; t = t.next) {
			if (key.equals(t.key)) {
				return true;
			}
		}
		return false;
	}

	public Value get(Key key) {
		for (Node temp = first; temp != null; temp = temp.next) {
			if (temp.key.equals(key))
				return temp.val;
		}
		return null;
	}

	public void put(Key key, Value val) {
		for (Node temp = first; temp != null; temp = temp.next) {
			if (temp.key.equals(key)) {
				temp.val = val;
				return;
			}
		}
		first = new Node(key, val, first);
		N++;
	}

	public int size() {
		return N;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public void delete(Key key) {
		if (first == null) {
			return;
		}
		if (first.key.equals(key)) {
			first = first.next;
			N--;
			return;
		}
		for (Node pre = first, temp = first.next; temp != null; temp = temp.next, pre = pre.next) {
			if (temp.key.equals(key)) {
				pre.next = temp.next;
				N--;
				return;
			}
		}
	}
	
	public Iterable<Key> keys() {
		Queue<Key> queue = new Queue<>();
		for (Node temp = first; temp != null; temp = temp.next) {
			queue.enqueue(temp.key);
		}
		return queue;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SequentialSearchST<String, Integer> st = new SequentialSearchST<>();
		System.out.println(st.isEmpty());
		System.out.println(st.size());
		st.put("a", 1);
		st.put("b", 3);
		st.put("c", 4);
		st.put("a", 9);
		for (String key : st.keys()) {
			System.out.println("key : " + key + "  val : " + st.get(key));
		}
		System.out.println(st.isEmpty());
		System.out.println(st.size());
		System.out.println(st.get("a"));
		System.out.println(st.get("r") == null);
		st.delete("a");
		System.out.println(st.isEmpty());
		System.out.println(st.size());
		System.out.println(st.get("a") == null);

	}

}
