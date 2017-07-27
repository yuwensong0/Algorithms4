package chapter2_1;

import chapter1_4.Stopwatch;

public class SortCompare {
	public static double time(String alg, Double[] a) {
		Stopwatch timer = new Stopwatch();
		if (alg.equals("Insertion")) Insertion.sort(a);
		if (alg.equals("Selection")) Selection.sort(a);
		if (alg.equals("Shell")) Shell.sort(a);
		return timer.elapsedTime();
	}
	
	public static double timeRandomInput(String alg, int N, int T) {
		double total = 0.0;
		Double[] a = new Double[N];
		for (int t = 0; t < T; t++) {
			for (int i = 0; i < N; i++) {
				a[i] = Math.random();
			}
			total += time(alg, a);
		}
		return total;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 1000;
		int T = 1000;
		double t1 = timeRandomInput("Shell", N, T);
		double t2 = timeRandomInput("Selection", N ,T);
		System.out.println(t2/t1);

	}

}
