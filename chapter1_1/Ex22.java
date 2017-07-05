package chapter1_1;

public class Ex22 {
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
		if (key > a[mid]) return rank(key, a, mid, hi, ++depth);
		if (key < a[mid]) return rank(key, a, lo, mid, ++depth);
		return mid;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,4,5,7,9,11,23,33,55,77};
		System.out.println("result=" + rank(33, a));

	}

}
