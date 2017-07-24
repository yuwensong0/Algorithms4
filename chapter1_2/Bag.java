package chapter1_2;

import java.util.*;

public class Bag<E> implements Iterable<E>{
	private Node first;
	int N = 0;
	private class Node{
		E e;
		Node next;
	}
	
	public void add(E e){
		Node oldFirst = first;
		first = new Node();
		first.e = e;
		first.next = oldFirst;
		N++;
	}
	
	public boolean contains(E e) {
		for (E t : this) {
			if (t.equals(e)) return true;
		}
		return false;
	}
	
	public int size() {
		return N;
	}
	
	public Iterator<E> iterator(){
		return new ListIterator();
	}
	private class ListIterator implements Iterator<E>{
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
		Bag<Integer> bag = new Bag<>();
		for (int i = 0; i < 10; i++){
			bag.add(i);
		}
		for (int i : bag){
			System.out.print(i + " ");
		}
		System.out.println(bag.contains(5));
		System.out.println(bag.contains(33));
	}

}
