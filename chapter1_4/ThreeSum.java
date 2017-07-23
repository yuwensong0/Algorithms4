package chapter1_4;

public class ThreeSum {
	public static int count(int[] a) {
		int N = a.length;
		int cnt = 0;
		int temp = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				temp = a[i] + a[j];
				if (a[i] > 0 && a[j] > 0 && temp < 0) {
					continue;
				}
				if (a[i] < 0 && a[j] < 0 && temp > 0) {
					continue;
				}
				for (int k = j + 1; k < N; k++) {
					if (temp + a[k] == 0) {
						cnt++;
					}
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
