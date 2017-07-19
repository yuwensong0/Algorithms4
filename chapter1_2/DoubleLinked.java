package chapter1_2;

import java.util.*;

import com.sun.org.apache.regexp.internal.RE;

public class DoubleLinked<E> implements Iterable<E> {
	private DoubleNode first;
	private DoubleNode last;
	private int N = 0;
	private class DoubleNode{
		E e;
		DoubleNode next;
		DoubleNode prev;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	public void insertAsFirst(E e) {
		if (isEmpty()) {
			first = new DoubleNode();
			first.e = e;
			last = first;
		} else {
			DoubleNode oldFirst = first;
			first = new DoubleNode();
			first.e = e;
			first.next = oldFirst;
			oldFirst.prev = first;
		}
		N++;
	}
	
	public void insertAsLast(E e) {
		if (isEmpty()) {
			last = new DoubleNode();
			last.e = e;
			first = last;
		} else {
			DoubleNode oldLast = last;
			last = new DoubleNode();
			last.e = e;
			last.prev = oldLast;
			oldLast.next = last;
		}
		N++;
	}
	
	public E deleteFirst() {
		if (isEmpty()) {
			return null;
		} else {
			E e = first.e;
			DoubleNode oldFirst = first;
			first = first.next;
			first.prev = null;
			oldFirst.next = null;
			N--;
			return e;
		}
	}
	
	public E deleteLast() {
		if (isEmpty()) {
			return null;
		} else {
			E e = last.e;
			DoubleNode oldLast = last;
			last = last.prev;
			last.next = null;
			oldLast.prev = null;
			N--;
			return e;
		}
	}
	
	public boolean contains(E e) {
		for (E el : this) {
			if (el.equals(e)) {
				return true;
			}
		}
		return false;
	}
	
	public void delete(E e) {
		if (!contains(e)) {
			return;
		}
		DoubleNode rm = first;
		while (!rm.e.equals(e)) {
			rm = rm.next;
		}
		if (rm == first) {
			deleteFirst();
			return;
		}
		if (rm == last) {
			deleteLast();
			return;
		}
		DoubleNode pre = rm.prev;
		pre.next = rm.next;
		rm.next.prev = pre;
	}
	
	public Iterator<E> iterator() {
		return new DoubleLinkedIterator();
	}
	
	private class DoubleLinkedIterator implements Iterator<E> {
		private DoubleNode current = first;
		public boolean hasNext() {
			return current != null;
		}
		public E next() {
			E e = current.e;
			current = current.next;
			return e;
		}
	}
		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
