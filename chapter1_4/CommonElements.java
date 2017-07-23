package chapter1_4;

public class CommonElements {
	public static void go(int[] a, int[] b) {
		int i = 0;
		int j = 0;
		int flag = Integer.MIN_VALUE;
		while (i < a.length && j < b.length) {
			if (a[i] > b[j]) {
				j++;
			} else if (a[i] < b[j]) {
				i++;
			} else {
				if (a[i] != flag) {
					flag = a[i];
					System.out.print(a[i] + " ");
					j++;
					i++;
				} else {
					i++;
					j++;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,3,4,4,5,6,7};
		int[] b = {-1,0,1,1,1,2,2,3,3,4,4,4};
		go(a, b);

	}

}
