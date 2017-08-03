package chapter2_5;

import chapter2_2.Inversions;

public class KendallTau {
	public static int distance(int[] a, int[] b) {
		int N = a.length;
		int[] indexA = new int[N];
		for (int i = 0; i < N; i++) {
			indexA[a[i]] = i;
		}
		Integer[] indexBInA = new Integer[N];
		for (int i = 0; i < N; i++) {
			indexBInA[i] = indexA[b[i]];
		}
		return Inversions.count(indexBInA);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {0, 3, 1, 6, 2, 5, 4};
		int[] b = {1, 0, 3, 6, 4, 2, 5};
		System.out.println(distance(a, b));

	}

}
