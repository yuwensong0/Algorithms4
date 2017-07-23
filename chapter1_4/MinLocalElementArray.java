package chapter1_4;

public class MinLocalElementArray {
	public static int go(int[] a) {
		return rank(a, 0, a.length - 1);
	}
	private static int rank(int[] a, int lo, int hi) {
		int mid = lo + (hi - lo) / 2;
		if (mid == 0 && a[mid] < a[mid + 1]) return mid;
		if (mid == a.length - 1 && a[mid] < a[mid - 1]) return mid;
		if (a[mid] < a[mid - 1] && a[mid] < a[mid + 1]) {
			return mid;
		} else {
			if (a[mid - 1] > a[mid + 1]) return rank(a, mid + 1, hi);
			else return rank(a, lo, mid - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,4,5,6};
		int[] b = {6,5,4,3,2,1};
		int[] c = {4,3,2,1,5,6,7};
		int[] d = {1,2,3,4,0};
		System.out.println("a : " + go(a));
		System.out.println("b : " + go(b));
		System.out.println("c : " + go(c));
		System.out.println("d : " + go(d));

		
	}

}
