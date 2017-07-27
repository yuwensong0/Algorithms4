package chapter2_1;

import chapter1_4.Stopwatch;

public class Ex28 {
	public static double time(String alg, Double[] a) {
		Stopwatch timer = new Stopwatch();
		if (alg.equals("Insertion")) Insertion.sort(a);
		if (alg.equals("Selection")) Selection.sort(a);
		if (alg.equals("Shell")) Shell.sort(a);
		if (alg.equals("Ex24")) Ex24.sort(a);
		return timer.elapsedTime();
	}
	
	public static double timeRandomInput(String alg, int N, int T) {
		double total = 0.0;
		Double[] a = new Double[N];
		for (int t = 0; t < T; t++) {
			for (int i = 0; i < N; i++) {
				if (Math.random() >= 0.5) a[i] = 1.0;
				else a[i] = 0.0;
			}
			total += time(alg, a);
		}
		return total;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int T = 1000;
		for (int N = 128; true; N *= 2) {
			double t2 = SortCompare.timeRandomInput("Insertion", N, T);
			double t3 = SortCompare.timeRandomInput("Selection", N, T);
			System.out.println(t3/t2);
		}


	}

}
