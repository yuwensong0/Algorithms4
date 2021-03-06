package chapter1_2;

import java.util.*;

public class Queue<E> implements Iterable<E>{
	private Node first = null;
	private Node last = null;
	private int N = 0;
	
	public Queue() {
		
	}
	
	public Queue(Queue<E> q) {
		for (int i = 0; i < q.size(); i++) {
			E e = q.dequeue();
			q.enqueue(e);
			this.enqueue(e);
		}
	}
	private class Node{
		E e;
		Node next;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public int size(){
		return N;
	}
	
	public E peek() {
		if (isEmpty()) return null;
		E e = first.e;
		return e;
	}
	
	public void enqueue(E e){
		Node oldLast = last;
		last = new Node();
		last.e = e;
		last.next = null;
		if (N == 0){
			first = last;
		} else {
			oldLast.next = last;
		}
		N++;
	}
	
	public E dequeue(){
		if (isEmpty()) return null;
		E e = first.e;
		first = first.next;
		if (isEmpty()){
			last = null;
		}
		N--;
		return e;
	}
	
	public Iterator<E> iterator(){
		return new QueueIterator();
	}
	
	private class QueueIterator implements Iterator<E>{
		private Node current = first;
		public boolean hasNext(){
			return current != null;
		}
		public E next(){
			E e = current.e;
			current = current.next;
			return e;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new Queue<>();
		System.out.println(queue.isEmpty());
		for (int i = 0; i < 10; i++){
			queue.enqueue(i);
		}
		for (int i : queue){
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println(queue.size());
		System.out.println(queue.dequeue());
		System.out.println(queue.isEmpty());
		System.out.println(queue.size());
		System.out.println(queue.dequeue());
		for (int i : queue){
			System.out.print(i + " ");
		}
		System.out.println();
		Queue<Integer> r = new Queue<>(queue);
		for (int i : r){
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println(queue.dequeue());
		for (int i : queue){
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i : r){
			System.out.print(i + " ");
		}
		System.out.println();
		r.enqueue(11);
		for (int i : queue){
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i : r){
			System.out.print(i + " ");
		}
		

	}

}
