package chapter1_4;

import java.util.Iterator;

import chapter1_2.Stack;


public class StequeByTwoStack<E> implements Iterable<E> {
	Stack<E> a;
	Stack<E> b;
	public StequeByTwoStack() {
		a = new Stack<>();
		b = new Stack<>();
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public int size() {
		return a.size() + b.size();
	}
	
	public void push(E e) {
		a.push(e);
	}
	
	public E pop() {
		if (a.isEmpty()) {
			while (!b.isEmpty()) {
				a.push(b.pop());
			}
		} 
		return a.pop();
	}
	
	public void enqueue(E e) {
		b.push(e);
	}
	
	public Iterator<E> iterator() {
		return new StequeByTwoStackIterator();
	}
	
	private class StequeByTwoStackIterator implements Iterator<E> {
		private int N = a.size() + b.size();
		private Stack<E> aa = Stack.copy(a);
		private Stack<E> bb = Stack.copy(b);
		public boolean hasNext() {
			return N != 0;
		}
		
		public E next() {
			N--;
			if (aa.isEmpty()) {
				while (!bb.isEmpty()) {
					aa.push(bb.pop());
				}
			} 
			return aa.pop();
		}
	}
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StequeByTwoStack<Integer> a = new StequeByTwoStack<>();
		System.out.println(a.isEmpty());
		System.out.println(a.size());
		a.push(1);
		a.push(3);
		a.push(8);
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
		a.enqueue(2);
		a.enqueue(0);
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println(a.pop());
		System.out.println(a.isEmpty());
		System.out.println(a.size());
		
		
	}

}
