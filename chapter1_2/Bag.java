package chapter1_2;

import java.util.*;

public class Bag<E> implements Iterable<E>{
	private Node first;
	private class Node{
		E e;
		Node next;
	}
	
	public void add(E e){
		Node oldFirst = first;
		first = new Node();
		first.e = e;
		first.next = oldFirst;
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

	}

}
