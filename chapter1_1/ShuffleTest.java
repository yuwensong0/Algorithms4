package chapter1_1;

public class ShuffleTest {
	public static void shuffle(int[] a){
		int N = a.length;
		for (int i = 0; i < N; i++){
			int r = i + (int)(Math.random() * (N - i));
			int temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}
	
	public static void shuffleTest(int m, int n){
		int[][] re = new int[m][m];
		int[] a = new int[m];
		for (int i = 0; i < n; i++){
			reset(a);
			shuffle(a);
			for (int j = 0; j < a.length; j++){
				re[a[j]][j]++;
			}
		}
		for (int i = 0; i < re.length; i++){
			for (int j = 0; j < re[i].length; j++){
				System.out.print((double)re[i][j] * m / n + "  ");
			}
			System.out.println();
		}
		
	}
	
	public static void reset(int[] a){
		for (int i = 0; i < a.length; i++){
			a[i] = i;
		}
	}
		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		shuffleTest(10, 1000000);

	}

}
