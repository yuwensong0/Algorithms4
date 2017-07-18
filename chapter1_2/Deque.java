package chapter1_2;

import java.util.*;

public class Deque<E> implements Iterable<E> {
	private Node head = null;
	private Node tail = null;
	private int N = 0;
	private class Node {
		E e;
		Node prev;
		Node next;
	}
	
	public Deque(){
		
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public int size(){
		return N;
	}
	
	public void pushLeft(E e){
		Node oldHead = head;
		head = new Node();
		head.e = e;
		if (oldHead != null){
			head.next = oldHead;
			head.prev = null;
			oldHead.prev = head;
		} else {
			tail = head;
		}
		N++;
	}
	
	public void pushRight(E e){
		Node oldTail = tail;
		tail = new Node();
		tail.e = e;
		if (oldTail != null){
			tail.prev = oldTail;
			tail.next = null;
			oldTail.next = tail;
		} else {
			head = tail;
		}
		N++;
	}
	
	public E popLeft(){
		E e = head.e;
		Node oldHead = head;
		head = head.next;
		oldHead.next = null;
		head.prev = null;
		N--;
		return e;	
	}
	
	public E popRight(){
		E e = tail.e;
		Node oldTail = tail;
		tail = tail.prev;
		tail.next = null;
		oldTail.prev = null;
		N--;
		return e;
	}
	
	public Iterator<E> iterator(){
		return new DequeIterator();
	}
	
	private class DequeIterator implements Iterator<E>{
		private Node current = head;
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
		Deque<Integer> deque = new Deque<>();
		System.out.println(deque.isEmpty());
		System.out.println(deque.size());
		deque.pushLeft(1);
		deque.pushLeft(2);
		for (int i : deque){
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println(deque.isEmpty());
		System.out.println(deque.size());
		deque.pushRight(3);
		deque.pushRight(4);
		for (int i : deque){
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println(deque.popLeft());
		System.out.println(deque.popRight());
		for (int i : deque){
			System.out.print(i + " ");
		}
		System.out.println();

	}

}
