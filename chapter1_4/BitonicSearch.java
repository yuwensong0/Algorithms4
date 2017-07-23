package chapter1_4;

public class BitonicSearch {
	public static int go(int[] a, int key) {
		int max = findMax(a);
		int left = binarySearchInc(a, key, 0, max);
		int right = binarySearchDec(a, key, max + 1, a.length - 1);
		if (left >= 0) return left;
		if (right >= 0) return right;
		return -1;
	}
	
	private static int binarySearchInc(int[] a, int key, int lo, int hi) {
		if (lo > hi) return -1;
		int mid = lo + (hi - lo) / 2;
		if (a[mid] > key) return binarySearchInc(a, key, lo, mid - 1);
		if (a[mid] < key) return binarySearchInc(a, key, mid + 1, hi);
		return mid;
	}
	
	private static int binarySearchDec(int[] a, int key, int lo, int hi) {
		if (lo > hi) return -1;
		int mid = lo + (hi - lo) / 2;
		if (a[mid] > key) return binarySearchDec(a, key, mid + 1, hi);
		if (a[mid] < key) return binarySearchDec(a, key, lo, mid - 1);
		return mid;
	}
	
	private static int findMax(int[] a) {
		return findMax(a, 0, a.length - 1);
	}
	
	private static int findMax(int[] a, int lo, int hi) {
		int mid = lo + (hi - lo) / 2;
		if (a[mid] > a[mid - 1] && a[mid] > a[mid + 1]) return mid;
		else {
			if (a[mid - 1] > a[mid + 1]) return findMax(a, lo, mid -1);
			else return findMax(a, mid + 1, hi);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,3,5,7,9,8,6,4,2};
		int i = go(a, 1);
		System.out.println(i);

	}

}
