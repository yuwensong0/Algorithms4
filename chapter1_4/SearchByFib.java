package chapter1_4;

public class SearchByFib {
	public static int go(int[] a, int key) {
		int[] f = fib(a.length);
		int n = f[0];
		int m = f[1];
		return go(a, key, 0, a.length - 1, n, m);
	}
	
	private static int go(int[] a, int key, int lo, int hi, int n, int m) {
		if (lo > hi) return -1;
		if (lo == hi) {
			if (a[lo] == key) return lo;
			else return -1;
		} 
		int temp = m - n;
		int mid = lo + temp;
		if (mid > a.length - 1) return go(a, key, lo, mid - 1, n - temp, temp);
		else {
			if (a[mid] > key) return go(a, key, lo, mid - 1, n - temp, temp);
			if (a[mid] < key) return go(a, key, mid + 1, hi, temp, n);
			return mid;
		}
	}
	private static int[] fib(int n) {
		int[] a = new int[2];
		int i = 1;
		int j = 1;
		while (n > j) {
			int temp = j;
			j += i;
			i = temp;
		}
		a[0] = i;
		a[1] = j;
		return a;
	}
	
	public static void main(String[] args) {
		int[] a = fib(14);
		System.out.println(a[0] + " " + a[1]);
		int[] b = {1,2,3,4,5,6,7,8,9,22};
		int po = go(b, 1);
		System.out.println(po);
	}
}
