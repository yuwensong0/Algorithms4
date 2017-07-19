package chapter1_2;

import java.util.*;

public class QueueByTwoStack<E> implements Iterable<E> {
	private Stack<E> a;
	private Stack<E> b;
	
	public QueueByTwoStack() {
		a = new Stack<>();
		b = new Stack<>();
	}
	
	public boolean isEmpty() {
		return (a.size() + b.size()) == 0;
	}
	
	public int size() {
		return a.size() + b.size();
	}
	
	public void enqueue(E e) {
		a.push(e);
	}
	
	public E dequeue() {
		if (isEmpty()) {
			return null;
		}
		if (!b.isEmpty()) {
			return b.pop();
		} else {
			while (!a.isEmpty()) {
				b.push(a.pop());
			}
			return b.pop();
		}
	}
	
	public Iterator<E> iterator() {
		return new QueueByTwoStackIterator();
	}
	
	private class QueueByTwoStackIterator implements Iterator<E> {
		private int N = a.size() + b.size();
		private Stack<E> aa = Stack.copy(a);
		private Stack<E> bb = Stack.copy(b);
		public boolean hasNext() {
			return N != 0;
		}
		
		public E next() {
			N--;
			if (!bb.isEmpty()) {
				return bb.pop();
			} else {
				while (!aa.isEmpty()) {
					bb.push(aa.pop());
				}
				return bb.pop();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueByTwoStack<Integer> queue = new QueueByTwoStack<>();
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
		
		
		

	}

}
