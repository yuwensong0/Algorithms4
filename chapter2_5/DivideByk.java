package chapter2_5;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class DivideByk {
	public static Comparable select(Comparable[] a, int k) {
		StdRandom.shuffle(a);
		int lo = 0;
		int hi = a.length - 1;
		while (hi > lo) {
			int j = partition(a, lo, hi);
			if (j == k) return a[j];
			else if (j < k) lo = j + 1;
			else hi = j - 1;
		}
		return a[k];
	}
	
	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;

		while (true) {
			while (less(a[++i], a[lo]))
				if (i == hi)
					break;
			while (less(a[lo], a[--j]))
				;
			if (i >= j)
				break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
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
		Double[] a = {1.0, 2.0,0.0, 3.0, 6.0, 2.0,1.1};
		System.out.println(select(a, 0));

	}

}
