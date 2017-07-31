package chapter2_2;

import edu.princeton.cs.algs4.StdDraw;

public class MergeOptimize {
	public static void sort(Comparable[] a) {
		Comparable[] aux = new Comparable[a.length];
		sort(a, 0, a.length - 1, aux);
	}

	private static void sort(Comparable[] a, int lo, int hi, Comparable[] aux) {
		if (lo + 10 >= hi) {
			insertion(a, lo, hi);
			return;
		}
		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid, aux);
		sort(a, mid + 1, hi, aux);
		if (less(a[mid + 1], a[mid]))
			merge(a, lo, mid, hi, aux);
		print(a);

	}

	private static void merge(Comparable[] a, int lo, int mid, int hi, Comparable[] aux) {
		// Comparable[] aux = new Comparable[a.length];
		for (int i = lo; i <= hi; i++) {
			aux[i] = a[i];
		}
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (less(aux[i], aux[j]))
				a[k] = aux[i++];
			else
				a[k] = aux[j++];
		}
	}

	private static void insertion(Comparable[] a, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++) {
			for (int j = i; j > lo; j--) {
				if (less(a[j], a[j - 1]))
					exch(a, j, j - 1);
			}
		}
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
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
