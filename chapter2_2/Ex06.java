package chapter2_2;

import edu.princeton.cs.algs4.StdDraw;

public class Ex06 {
	private static int time;
	private static Comparable[] aux;	
	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length];
		time = 0;
		sort(a, 0, a.length-1);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.point(a.length, time);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.point(a.length, 6*a.length*Math.log(a.length)/(Math.log(2)));
	}
	
	private static void sort(Comparable[] a, int lo, int hi) {
		if (lo >= hi) return;
		int mid = lo + (hi - lo)/2;
		sort(a, lo, mid);
		sort(a, mid+1, hi);
		merge(a, lo, mid, hi);
		//print(a);
	}
	private static void merge(Comparable[] a, int lo, int mid, int hi) {
		for (int i = lo; i <= hi; i++) {
			aux[i] = a[i];
			time += 2;
		}
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				a[k] = aux[j++]; 
				time += 2;
			} else if (j > hi) {
				a[k] = aux[i++];
				time += 2;
			} else if (less(aux[j], aux[i])) {
				a[k] = aux[j++];
				time += 4;
			} else {
				a[k] = aux[i++];
				time += 4;
			}
		}
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
			if (less(max, i)) max = i;
		}
		StdDraw.setXscale(-1, a.length);
		for (int i = 0; i < a.length; i++) {
			if (i == n || i == m) StdDraw.setPenColor(StdDraw.RED);
			StdDraw.filledRectangle(i, ((double)a[i])/2.0, 0.3, ((double)a[i])/2.0);
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
		int N = 10000;
		StdDraw.setXscale(0, N);
		StdDraw.setYscale(0, 6*N*Math.log(N)/(Math.log(2)));
		StdDraw.setPenRadius(0.01);
		for (int i = 1; i <= N; i++) {
			Double[] a = new Double[i];
			for (int k = 0; k < i; k++) {
				a[k] = Math.random();
			}
			sort(a);
		}

	}

}
