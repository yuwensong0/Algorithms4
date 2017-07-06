package chapter1_1;

import java.util.Arrays;

public class Ex30 {
	public static boolean[][] createArrayByIndex(int n){
		boolean[][] a = new boolean[n][n];
		for (int i = 0; i < a.length; i++){
			for (int j = 0; j < a[i].length; j++){
				if (Euclid.gcd(i+1, j+1) == 1) a[i][j] = true;
				else a[i][j] = false;
			}
		}
		return a;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.deepToString(createArrayByIndex(13)));

	}

}
