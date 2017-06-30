package chapter1_1;

import java.util.Arrays;

public class Ex13 {
	public static int[][] transposition(int[][] a){
		int[][] temp = new int[a[0].length][a.length];
		for (int i = 0; i < a.length; i++){
			for (int j = 0; j < a[i].length; j++){
				temp[j][i] = a[i][j];
			}
		}
		return temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int M = 5;
		int N = 4;
		int[][] a = new int[M][N];
		int[][] b = new int[N][M];
		for (int i = 0; i < M; i++){
			for (int j = 0; j < N; j++){
				a[i][j] = i;
			}
		}
		System.out.println(Arrays.deepToString(a));
		b = transposition(a);
		System.out.println(Arrays.deepToString(b));

	}

}
