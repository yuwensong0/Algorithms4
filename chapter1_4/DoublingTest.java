package chapter1_4;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.Stopwatch;

public class DoublingTest {
	public static double timeTrial(int N) {
		int MAX = 1000000;
		int[] a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = (int) ((Math.random() - 0.5) * MAX);
		}
		Stopwatch timer = new Stopwatch();
		int cnt = ThreeSum.count(a);
		return timer.elapsedTime();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int N = 250; true; N += N) {
			double time = timeTrial(N);
			StdDraw.setXscale(0,  2 * N);
			StdDraw.setYscale(0,  2 * time);
			StdDraw.setPenRadius(0.5);
			StdDraw.point(N,  time);
		}

	}

}
