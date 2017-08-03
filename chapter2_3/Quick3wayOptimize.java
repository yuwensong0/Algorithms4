package chapter2_3;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Quick3wayOptimize {
	private static final int INSERTION_SORT_CUTOFF = 8;
	private static final int MEDIAN_OF_3_CUTOFF = 40;

	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
		//print(a);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		if (lo + INSERTION_SORT_CUTOFF >= hi) {
			insertion(a, lo, hi);
			return;
		}
		int n = hi - lo + 1;
		if (n <= MEDIAN_OF_3_CUTOFF) {
			int m = median3(a, lo, lo + (hi - lo), hi);
			exch(a, m, lo);
		} else {
			int eps = n / 8;
			int mid = lo + (hi - lo) / 2;
			int m1 = median3(a, lo, lo + eps, lo + eps + eps);
			int m2 = median3(a, mid - eps, mid, mid + eps);
			int m3 = median3(a, hi - eps - eps, hi - eps, hi);
			int m0 = median3(a, m1, m2, m3);
			exch(a, m0, lo);
		}
		int i = lo;
		int j = hi + 1;
		int p = lo;
		int q = hi + 1;
		Comparable v = a[lo];
		while (true) {
			while (less(a[++i], v))
				if (i == hi)
					break;
			while (less(v, a[--j]))
				;
			if (i == j && eq(v, a[i])) {
				exch(a, j--, --q);
			}
			if (i >= j)
				break;
			exch(a, i, j);
			if (eq(a[i], v))
				exch(a, ++p, i);
			if (eq(a[j], v))
				exch(a, --q, j);
		}
		for (int k = lo; k <= p; k++) {
			exch(a, k, j--);
		}
		for (int k = hi; k >= q; k--) {
			exch(a, k, i++);
		}
		//print(a);
		sort(a, lo, j);
		sort(a, i, hi);

	}

	private static void insertion(Comparable[] a, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++) {
			for (int j = i; j > lo; j--) {
				if (less(a[j], a[j - 1]))
					exch(a, j, j - 1);
			}
		}
	}

	private static int median3(Comparable[] a, int i, int j, int k) {
		return (less(a[i], a[j])) ? (less(a[i], a[k]) ? (less(a[j], a[k]) ? j : k) : i)
				: (less(a[j], a[k]) ? (less(a[i], a[k]) ? i : k) : j);
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

	private static boolean eq(Comparable v, Comparable w) {
		return v.compareTo(w) == 0;
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 300;
		Double[] a = new Double[N];
		for (int i = 0; i < a.length; i++) {
			a[i] = Math.random();
		}
		sort(a);

	}

}
