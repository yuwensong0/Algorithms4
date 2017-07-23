package chapter1_4;

import java.util.Arrays;

public class Closestpair {
	public static double go(double[] a) {
		Arrays.sort(a);
		double min = Double.MAX_VALUE;
		for (int i = 0; i < a.length - 1; i++) {
			double temp = Math.abs(a[i + 1] - a[i]);
			if (min > temp) {
				min = temp;
			}
		}
		return min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] a = {-1.0, 1.0, 2.0, 1.7, 5.0};
		double min = go(a);
		System.out.printf("min = %6.4f", min);

	}

}
