package chapter1_2;

import java.util.Arrays;

public class RandomQueue<E> {
	private E[] queue = (E[]) new Object[1];
	private int N = 0;
	
	private void resize(int max) {
		E[] temp = (E[]) new Object[max];
		for (int i = 0; i < N; i++) {
			temp[i] = queue[i];
		}
		queue = temp;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public void enqueue(E e) {
		if (N == queue.length) {
			resize(2 * N);
		}
		queue[N++] = e;
	}
	
	public E dequeue() {
		int r = (int) (Math.random() * N);
		E temp = queue[r];
		queue[r] = queue[--N];
		queue[N] = null;
		return temp;
	}
	
	public E sample() {
		int r = (int) (Math.random() * N);
		return queue[r];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomQueue<Integer> queue = new RandomQueue<>();
		int[][] a = new int[4][13];
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < 14; j++) {
				queue.enqueue(j);
			}
		}
		while (!queue.isEmpty()) {
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					a[i][j] = queue.dequeue();
				}
			}
		}
		System.out.println(Arrays.deepToString(a));

	}

}
