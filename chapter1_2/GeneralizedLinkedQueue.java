package chapter1_2;

public class GeneralizedLinkedQueue<E> {
	private Node first = null;
	private Node tail = null;
	private int N = 0;
	private class Node {
		E e;
		Node next;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public void insert(E e) {
		Node oldTail = tail;
		tail = new Node();
		tail.e = e;
		if (N == 0) {
			first = tail;
			
		} else {
			oldTail.next = tail;
			tail.next = null;}
		N++;
	}
	
	public E delete(int k) {
		if (k <= 0 || k > N) {
			return null;
		}
		if (k == 1) {
			E e = first.e;
			first = first.next;
			return e;
		}
		Node rm = first;
		Node prev = null;
		while (k > 1) {
			prev = rm;
			rm = rm.next;
			k--;
		}
		prev.next = prev.next.next;
		N--;
		return rm.e;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GeneralizedLinkedQueue<Integer> queue = new GeneralizedLinkedQueue<>();
		System.out.println(queue.isEmpty());
		queue.insert(1);
		queue.insert(2);
		queue.insert(3);
		System.out.println(queue.delete(2));
		System.out.println(queue.delete(2));
		System.out.println(queue.delete(2));
		System.out.println(queue.isEmpty());
	}
}
