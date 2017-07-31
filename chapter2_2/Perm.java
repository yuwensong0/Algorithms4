package chapter2_2;

public class Perm {
	public static int[] sort(Comparable[] a) {
		return sort(a, 0, a.length-1);
	}
	
	private static int[] sort(Comparable[] a, int lo, int hi) {
		int N = a.length;
		int[] perm = new int[N];
		for (int i = 0; i < N; i++) {
			perm[i] = i;
		}
		int[] aux = new int[N];
		return sort(a, 0, N-1, aux, perm);
	}
	
	private static int[] sort(Comparable[] a, int lo, int hi, int[] aux, int[] perm) {
		if (lo >= hi) return perm;
		int mid = lo + (hi - lo)/2;
		perm = sort(a, lo, mid, aux, perm);
		perm = sort(a, mid+1, hi, aux, perm);
		perm = merge(a, lo, mid, hi, aux, perm);
		return perm;
	}
	
	private static int[] merge(Comparable[] a, int lo, int mid, int hi, int[] aux, int[] perm) {
		for (int i = lo; i <= hi; i++) {
			aux[i] = perm[i];
		}
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) perm[k] = aux[j++];
			else if (j > hi) perm[k] = aux[i++];
			else if (less(a[aux[j]], a[aux[i]])) {
				perm[k] = aux[j++];
			} else {
				perm[k] = aux[i++];
			}
		}
		return perm;
	}
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Double[] a = {4.0, 3.0, 2.0, 1.0, 0.0};
		int [] perm = sort(a);
		for (int i : perm) {
			System.out.print(i + " ");
		}

	}

}
