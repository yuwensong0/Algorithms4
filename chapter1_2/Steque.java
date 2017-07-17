package chapter1_2;

import java.util.*;

public class Steque<E> implements Iterable<E>{
	private Node head = null;
	private Node tail = null;
	private int N = 0;
	private class Node{
		E e;
		Node next;
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public int size(){
		return N;
	}
	
	public void push(E e){
		Node oldHead = head;
		head = new Node();
		head.e = e;
		head.next = oldHead;
		if (N == 0){
			tail = head;
		}
		N++;
	}
	
	public E pop(){
		E e = head.e;
		head = head.next;
		if (N == 1){
			tail = null;
		}
		N--;
		return e;
	}
	
	public void enqueue(E e){
		Node oldTail = tail;
		tail = new Node();
		tail.e = e;
		if (oldTail != null){
			oldTail.next = tail;
		}
		if (N == 0){
			head = tail;
		}
		N++;
	}
	
	public Iterator<E> iterator(){
		return new StequeIterator();
	}
	
	private class StequeIterator implements Iterator<E>{
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
		Steque<Integer> steque = new Steque<>();
		System.out.println(steque.isEmpty());
		steque.push(1);
		steque.push(2);
		for (int i : steque){
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println(steque.isEmpty());
		System.out.println(steque.size());
		steque.enqueue(3);
		for (int i : steque){
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println(steque.pop());
		for (int i : steque){
			System.out.print(i + " ");
		}
		System.out.println();
		
		

	}

}
