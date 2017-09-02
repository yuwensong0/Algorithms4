package chapter3_5;

import chapter1_2.Queue;

public class SequentialSearchSET<Key> {
	private Node first;
	private int N;

	private class Node {
		Key key;
		Node next;

		public Node(Key key, Node next) {
			this.key = key;
			this.next = next;
		}
	}

	public SequentialSearchSET() {
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

	public void add(Key key) {
		for (Node temp = first; temp != null; temp = temp.next) {
			if (temp.key.equals(key)) {
				return;
			}
		}
		first = new Node(key, first);
		N++;
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

	public int size() {
		return N;
	}

	public boolean isEmpty() {
		return N == 0;
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
		SequentialSearchSET<Integer> set = new SequentialSearchSET<>();
		System.out.println(set.isEmpty());
		System.out.println(set.size());
		set.delete(1);
		set.add(4);
		set.add(2);
		set.add(3);
		set.add(7);
		for (int i : set.keys()) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println(set.isEmpty());
		System.out.println(set.size());
		set.delete(3);
		for (int i : set.keys()) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println(set.isEmpty());
		System.out.println(set.size());
		
	}

}
