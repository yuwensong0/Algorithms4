package chapter1_4;

public class ThrowEggs {
	
	public static int go(int[] a) {
		int hi = firstSearch(a, 1);
		if (hi == a.length) return a.length;
		int posi = binarySearch(a, hi / 2, hi);
		return posi + 1;
		
	}
	
	private static int firstSearch(int[] a, int hi) {
		if (hi >= a.length) return a.length;
		if (a[hi] == 1) return hi;
		return firstSearch(a, 2 * hi);
	}
	
	private static int binarySearch(int[] a, int lo, int hi) {
		if (lo > hi) return -1;
		int mid = lo + (hi - lo) / 2;
		if (a[mid] == 0 && a[mid + 1] ==0) return binarySearch(a, mid + 1, hi);
		if (a[mid] == 1) return binarySearch(a, lo, mid - 1);
		return mid;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {0,0,0,0,1};
		int posia = go(a);
		System.out.println(posia);
		int[] b = {1,1,1,1,1};
		int posib = go(b);
		System.out.println(posib);
		int[] c = {0, 0, 0, 0, 0};
		int posic = go(c);
		System.out.println(posic);
	}

}
