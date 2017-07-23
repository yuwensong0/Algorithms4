package chapter1_1;

public class BinarySearch {
	public static int rank(int key, int[] a){
		return rank(key, a, 0, a.length-1, 0);
	}
	
	private static int rank(int key, int[] a, int lo, int hi, int depth){
		if (lo > hi) return -1;
		for (int i = 0; i < depth; i++){
			System.out.print(" ");
		}
		int mid;
		mid = lo + (hi - lo) / 2;
		System.out.println("lo=" + lo + ", hi=" + hi + ", mid=" + mid);
		if (key > a[mid]) return rank(key, a, mid + 1, hi, ++depth);
		else if (key < a[mid]) return rank(key, a, lo, mid - 1, ++depth);
		else if (mid != 1 && a[mid - 1] == a[mid]) return rank(key, a, lo, mid - 1, ++depth);
		else return mid;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,1,1,1,1,1,1,1,1,11};
		System.out.println("result=" + rank(1, a));

	}

}
