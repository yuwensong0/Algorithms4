package chapter2_1;

import edu.princeton.cs.algs4.StdDraw;

public class Ex12 {
	public static double sort(Comparable[] a) {
		int N = a.length;
		int h = 1;
		int total = 0;
		//print(a);
		while (h < N/3) h = 3*h + 1;
		while (h >= 1) {
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h && less(a[j], a[j-h]); j -=h) {
					//print(a, j, j-h);
					total++;
					exch(a, j, j-h);
					//print(a, j, j-h);
				}
			}
			h /=3;
		}
		//print(a);
		return total*1.0/a.length;
	}
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	public static void print(Comparable[] a) {
		print(a, -1, -1);
	}
	public static void print(Comparable[] a, int n, int m) {
		int delay = 100;
		StdDraw.clear();
		Comparable max = a[0];
		for (Comparable i : a) {
			if (less(max, i)) max = i;
		}
		StdDraw.setYscale();
		StdDraw.setXscale(-1, a.length);
		for (int i = 0; i < a.length; i++) {
			if (i == n || i == m) StdDraw.setPenColor(StdDraw.RED);
			StdDraw.filledRectangle(i, ((double)a[i])/2.0, 0.4, ((double)a[i])/2.0);
			StdDraw.setPenColor(StdDraw.BLACK);
		}
		try {
			Thread.sleep(delay);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i< a.length; i++) {
			if (less(a[i], a[i-1])) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 50;
		Double[] a;
		
		for (int i = 0, j = 100; i < 5; i++) {
			a = new Double[j];
			for (int k = 0; k < a.length; k++) {
				a[k] = Math.random();
			}
			j *= 10;
			System.out.println(sort(a));
		}

	}

}