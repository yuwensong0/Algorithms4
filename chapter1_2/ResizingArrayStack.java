package chapter1_2;

import java.util.*;

public class ResizingArrayStack<E> implements Iterable<E>{
	private E[] a = (E[]) new Object[1];
	private int N = 0;
	
	public int size(){
		return N;
	}

	public boolean isEmpty(){
		return N == 0;
	}
	
	private void resize(int max){
		E[] temp = (E[]) new Object[max];
		for (int i = 0; i < N; i++){
			temp[i] = a[i];
		}
		a = temp;
	}
	
	public void push(E e){
		if (a.length == N){
			resize(2 * N);
		}
		a[N++] = e;
	}
	
	public E pop(){
		E e = a[--N];
		a[N] = null;
		if (N > 0 && N == a.length / 4){
			resize(a.length / 2);
		}
		return e;
	}
	
	public Iterator<E> iterator(){
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<E>{
		private int i = N;
		public boolean hasNext(){
			return i > 0;
		}
		public E next(){
			return a[--i];
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResizingArrayStack<Integer> stack = new ResizingArrayStack<>();
		System.out.println(stack.isEmpty());

		for (int i = 0; i < 10; i++){
			stack.push(i);
		}
		for (int i : stack){
			System.out.print(i + " ");
		}
		
		System.out.println();
		System.out.println("size = " + stack.size());
		System.out.println(stack.pop());
		System.out.println("size = " + stack.size());
		System.out.println(stack.isEmpty());

	}

}
