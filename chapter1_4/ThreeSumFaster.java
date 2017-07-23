package chapter1_4;

public class ThreeSumFaster {
	public static int count(int[] a) {
		return count(a, 0);
	}
	public static int count(int[] a, int target) {
		int cnt = 0;
		for (int i = 0; i < a.length; i++) {
			int temp = target - a[i];
			cnt += TwoSumFaster.count(a, temp);
		}
		return cnt / 3;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {0,0,1,1,1,2,2,3,4,5,5,6};
		int cnt = count(a, 4);
		System.out.println(cnt);
	}

}
