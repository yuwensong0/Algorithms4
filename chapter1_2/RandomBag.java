package chapter1_2;

import java.util.*;

public class RandomBag<E> implements Iterable<E> {
	private E[] bag = (E[]) new Object[1];
	private int N;
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	private void resize(int max) {
		E[] temp = (E[]) new Object[max];
		for (int i = 0; i < N; i++) {
			temp[i] = bag[i];
		}
		bag = temp;
	}
	
	public void add(E e) {
		if (N == bag.length) {
			resize(2 * N);
		}
		bag[N++] = e;
	}
	
	public Iterator<E> iterator() {
		return new RandomBagIterator();
	}
	
	private class RandomBagIterator implements Iterator<E> {
		private int i = 0;
		private void shuffle(E[] a) {
			int N = a.length;
			for (int i = 0; i < N; i++) {
				int r = i + (int) (Math.random() * (N - i));
				E temp = a[i];
				a[i] = a[r];
				a[r] = temp;
			}
		}
		private E[] temp = (E[]) new Object[N];
		public RandomBagIterator() {
			for (int i =0; i < N; i++) {
				temp[i] = bag[i];
			}
			shuffle(temp);
		}
		public boolean hasNext() {
			return i != N;
		}
		
		public E next() {
			return temp[i++];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomBag<Integer> bag = new RandomBag<>();
		for (int i = 0; i < 10; i++) {
			bag.add(i);
		}
		for (int i : bag) {
			System.out.print(i + " ");
		}
	}
}
