package chapter2_1;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdDraw;

public class DiffSizeChart {
	public static void go(String alg, int[] a, int T) {
		Arrays.sort(a);
		double t = SortCompare.timeRandomInput(alg, a[a.length - 1], T)/T;
		StdDraw.setXscale(0,  a[a.length - 1]);
		StdDraw.setYscale(0, t);
		StdDraw.setPenRadius(0.01);
		for (int i = 0; i < a.length; i++) {
			if (i == a.length - 1) StdDraw.point(a[i], t);
			else {
				double t1 = SortCompare.timeRandomInput(alg, a[i], T)/T;
				StdDraw.point(a[i], t1);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 10;
		int T = 100;
		int base = 100;
		//String alg = "Insertion";
		String alg = "Shell";
		int[] a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = base;
			base *= 2;
		}
		go(alg, a, T);

	}

}
