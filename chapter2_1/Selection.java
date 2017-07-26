package chapter2_1;

import edu.princeton.cs.algs4.StdDraw;

public class Selection {
	public static void sort(Comparable[] a) {
		int N = a.length;
		//print(a);
		for (int i = 0; i < N; i++) {
			int min = i;
			for (int j = i+1; j < N; j++) {
				if (less(a[j], a[min])) {
					min = j;
				}
			}
			//print(a, i, min);
			exch(a, i, min);
			
		}
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
		int delay = 10;
		StdDraw.clear();
		
		
		Comparable max = a[0];
		for (Comparable i : a) {
			if (less(max, i)) max = i;
		}
		StdDraw.setYscale(0, (int) max);
		StdDraw.setXscale(-1, a.length);
		for (int i = 0; i < a.length; i++) {
			if (i == n || i == m) StdDraw.setPenColor(StdDraw.RED);
			StdDraw.filledRectangle(i, ((int)a[i])/2.0, 0.4, ((int)a[i])/2.0);
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
		String[] a = {"S", "O", "R", "T", "E", "X", "A", "M","P", "L", "E"};
		Integer[] b = {2,3,6,1,77,3,5,2,7,3,9,4,2,6};
		//sort(b);
		//show(a);
		Integer[] c = new Integer[100];
		for (int i = 0; i < c.length; i++) {
			c[i] =(int) (Math.random() * 100);
		}
		sort(c);

	}

}
