package chapter2_4;

import edu.princeton.cs.algs4.StdDraw;

public class HeapSort {
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int k = N / 2; k >= 1; k--) {
			sink(a, k, N);
		}
		while (N > 1) {
			exch(a, 1, N--);
			sink(a, 1, N);
			print(a);
		}
	}
	private static void sink(Comparable[] a, int k, int n) {
		while (2*k <= n) {
			int j = 2*k;
			if (j < n && less(a, j, j+1)) j++;
			if (!less(a, k, j)) break;
			exch(a, j, k);
			k = j;
		}
	}

	private static void exch(Object[] a, int i, int j) {
		Object t = a[i-1];
		a[i-1] = a[j-1];
		a[j-1] = t;
	}

	private static boolean less(Comparable[] a, int i, int j) {
		return a[i-1].compareTo(a[j-1]) < 0;
	}
	public static void print(Comparable[] a) {
		print(a, -1, -1);
	}

	public static void print(Comparable[] a, int n, int m) {
		int delay = 1;
		StdDraw.clear();
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
