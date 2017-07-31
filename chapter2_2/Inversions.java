package chapter2_2;

public class Inversions {
	public static int count(Comparable[] a) {
		return count(a, 0, a.length-1);
	}
	
	private static int count(Comparable[] a, int lo, int hi) {
		int N = a.length;
		int inversions = 0;
		Comparable[] aux = new Comparable[N];
		return count(a, 0, N-1, aux, inversions);
	}
	
	private static int count(Comparable[] a, int lo, int hi, Comparable[] aux, int inversions) {
		if (lo >= hi) return inversions;
		int mid = lo + (hi - lo)/2;
		inversions += count(a, lo, mid, aux, inversions);
		inversions += count(a, mid+1, hi, aux, inversions);
		return merge(a, lo, mid, hi, aux, inversions);
	}
	
	private static int merge(Comparable[] a, int lo, int mid, int hi, Comparable[] aux, int inversions) {
		for (int i = lo; i <= hi; i++) {
			aux[i] = a[i];
		}
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) a[k] = aux[j++];
			else if (j > hi) a[k] = aux[i++];
			else if (less(a[j], a[i])) {
				inversions += j - k;
				a[k] = aux[j++];
			} else {
				a[k] = aux[i++];
			}
		}
		return inversions;
	}
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Double[] a = {1.2, 1.7, 0.0};
		System.out.println(count(a));

	}

}
