package chapter1_1;

import java.util.Arrays;

public class Ex15 {
	public static int[] histogram(int[] a, int M){
		int[] re = new int[M];
		for (int i : a){
			re[i]++;
		}
		return re;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int M = 10;
		int N = 15;
		int[] a = new int[N];
		for (int i = 0; i < a.length; i++){
			a[i] = (int)(Math.random() * M);
		}
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(histogram(a, M)));
	}

}
