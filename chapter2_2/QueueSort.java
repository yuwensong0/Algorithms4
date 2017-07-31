package chapter2_2;

import chapter1_2.Queue;
import edu.princeton.cs.algs4.StdDraw;

public class QueueSort {
	public static void sort(Comparable[] a) {
		go(a);
	}

	private static void go(Comparable[] a) {
		int N = a.length;
		Queue<Queue> queue = new Queue<>();
		Queue<Comparable> e;
		for (int i = 0; i < N; i++) {
			e = new Queue<>();
			e.enqueue(a[i]);
			queue.enqueue(e);
		}
		while (queue.size() != 1) {

			queue.enqueue(merge(queue.dequeue(), queue.dequeue()));
		}
		e = queue.dequeue();
		for (int i = 0; i < N; i++) {
			a[i] = e.dequeue();
		}
		print(a);

	}

	public static void print(Comparable[] a) {
		print(a, -1, -1);
	}

	public static void print(Comparable[] a, int n, int m) {
		int delay = 1;
		StdDraw.clear();
		Comparable max = a[0];
		for (Comparable i : a) {
			if (less(max, i))
				max = i;
		}
		StdDraw.setXscale(-1, a.length);
		for (int i = 0; i < a.length; i++) {
			if (i == n || i == m)
				StdDraw.setPenColor(StdDraw.RED);
			StdDraw.filledRectangle(i, ((double) a[i]) / 2.0, 0.3, ((double) a[i]) / 2.0);
			StdDraw.setPenColor(StdDraw.BLACK);
		}
		try {
			Thread.sleep(delay);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Queue<Comparable> merge(Queue<Comparable> v, Queue<Comparable> w) {
		Queue<Comparable> aux = new Queue<>();
		while (!v.isEmpty() || !w.isEmpty()) {
			if (v.isEmpty()) {
				aux.enqueue(w.dequeue());
			} else if (w.isEmpty()) {
				aux.enqueue(v.dequeue());
			} else if (less(v.peek(), w.peek())) {
				aux.enqueue(v.dequeue());
			} else {
				aux.enqueue(w.dequeue());
			}
		}

		return aux;
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 100;
		Double[] a = new Double[N];
		for (int i = 0; i < a.length; i++) {
			a[i] = Math.random();
		}
		sort(a);
	}
}
