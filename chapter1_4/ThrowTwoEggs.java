package chapter1_4;

public class ThrowTwoEggs {
	public static int go(int[] a) {
		int N = firstFloor(a.length);
		int lo = 0;
		int hi = N - 1;
		int F = -1;
		while (lo < a.length) {
			if (hi >= a.length) {
				F = downToUp(a, lo, a.length - 1);
				break;
			} else if (a[hi] == 1) {
				F = downToUp(a, lo, hi);
				break;
			} else {
				N--;
				int temp = hi;
				hi += N;
				lo = temp;
			}
		}
		return F + 1;
	}
	
	private static int downToUp(int[] a, int lo, int hi) {
		int F = -2;
		if (hi < a.length) {
			for (int i = lo; i < hi; i++) {
				if (a[i] == 0 && a[i + 1] == 1) F = i; 
			}
		} else {
			for (int i = lo; i < a.length; i++) {
				if (a[i] == 0 && a[i + 1] == 1) F = i; 
			}
		}
		if (a[a.length - 1] == 0) return a.length;
		return F;
	}
	
	private static int firstFloor(int n) {
		int N = 1;
		while (N * (N + 1) < 2 * n) {
			N++;
		}
		return N;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {0,0,0,0,0};
		int[] b = {1,1,1,1,1,1};
		int[] c = {0,0,0,0,0,0,1,1,1};
		int Fa = go(a);
		int Fb = go(b);
		int Fc = go(c);
		System.out.println("Fa = " + Fa + " Fb = " + Fb + " Fc = " + Fc);
	}
	
}
