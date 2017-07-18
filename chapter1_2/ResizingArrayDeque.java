package chapter1_2;

import java.util.*;

public class ResizingArrayDeque<E> implements Iterable<E> {
	private E[] deque = (E[]) new Object[1];
	private int head = 0;
	private int tail = 0;
	private int N = 0;
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public int size(){
		return N;
	}
	
	private void resize(int max){
		int i = 0;
		E[] temp = (E[]) new Object[max];
		for (E e : deque){
			temp[i++] = e;
		}
		deque = temp;
		head = 0;
		tail = N;
	}
	
	public void pushLeft(E e){
		if (N == deque.length){
			resize(2 * N);
		}
		head = head + deque.length - 1;
		head %= deque.length;
		deque[head] = e;
		N++;
	}
	
	public void pushRight(E e){
		if (N == deque.length){
			resize(2 * N);
		}
		deque[tail++] = e;
		tail %= deque.length;
		N++;
	}
	
	public E popLeft(){
		E e = deque[head];
		deque[head++] = null;
		head %= deque.length;
		N--;
		if (N > 0 && N == deque.length / 4){
			resize(2 * N);
		}
		return e;
	}
	
	public E popRight(){
		tail = tail + deque.length - 1;
		tail %= deque.length;
		E e = deque[tail];
		deque[tail] = null;
		N--;
		if (N > 0 && N == deque.length / 4){
			resize(2 * N);
		}
		return e;
	}
	public Iterator<E> iterator(){
		return new ResizingArrayDequeIterator();
	}
	
	private class ResizingArrayDequeIterator implements Iterator<E>{
		private int i = N;
		private int index = head;
		public boolean hasNext(){
			return i != 0;
		}
		public E next(){
			E e = deque[index++];
			index %= deque.length;
			i--;
			return e;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResizingArrayDeque<Integer> deque = new ResizingArrayDeque<>();
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
