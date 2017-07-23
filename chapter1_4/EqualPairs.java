package chapter1_4;

import java.util.Arrays;

public class EqualPairs {
	public static int count(int[] a) {
		int sum = 0;
		Arrays.sort(a);
		int temp = a[0];
		int cnt = 1;
		for (int i = 1; i < a.length; i++) {
			if (temp == a[i]) {
				cnt++;
			} else {
				temp = a[i];
				sum += pair(cnt);
				cnt = 1;
			}
		}
		return sum;
	}
	
	private static int pair(int n) {
		return n * (n - 1) / 2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {0,1,2,8,5,3,6,7,2,4,6,2};
		int cnt = count(a);
		System.out.println(cnt);

	}

}
