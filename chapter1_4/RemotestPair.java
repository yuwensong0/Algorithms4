package chapter1_4;

import java.util.Arrays;

public class RemotestPair {
	public static double go(double[] a) {
		Arrays.sort(a);
		double min = Double.MAX_VALUE;
		double max = Double.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (min > a[i]) min = a[i];
			if (max < a[i]) max = a[i];
 		}
		return max - min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] a = {-1.0, 1.0, 2.3, 9.0, 2.2, 1.9, 5.0};
		double max = go(a);
		System.out.printf("max = %6.4f", max);
	}

}
