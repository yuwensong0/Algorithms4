package chapter1_2;

import java.util.*;

public class ResizingArrayQueue<E> implements Iterable<E>{
	private E[] queue = (E[]) new Object[1];
	private int head = 0;
	private int tail = 0;
	private int N = 0;
	public boolean isEmpty(){
		return N == 0;
	}
	
	public int size(){
		return N;
	}
	
	public void resize(int max){
		E[] temp = (E[]) new Object[max];
		int i = 0;
		for (E e : queue){
			temp[i++] = e;
		}
		head = 0;
		tail = N;
		queue = temp;
	}
	
	public void enqueue(E e){
		if (N == queue.length){
			resize(2 * N);
		}
		queue[tail] = e;
		tail++;
		tail %= queue.length;
		N++;
	}
	
	public E dequeue(){
		E e = queue[head];
		queue[head] = null;
		head++;
		head %= queue.length;
		N--;
		if (N > 0 && N == queue.length / 4){
			resize(N * 2);
		}
		return e;
	}
	
	public Iterator<E> iterator(){
		return new ResizingArrayQueueIterator();
	}
	
	private class ResizingArrayQueueIterator implements Iterator<E>{
		private int i = N;
		private int index = head;
		public boolean hasNext(){
			return i != 0;
		}
		public E next(){
			E e = queue[index++];
			index %= queue.length;
			i--;
			return e;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResizingArrayQueue<Integer> queue = new ResizingArrayQueue<>();
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

	}

}
