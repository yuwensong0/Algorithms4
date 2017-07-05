package chapter1_1;

public class Ex19 {
	private static int M = 100;
	private static long[] cache = new long[M];
	
	public static long F(int N){
		if (N == 0) return 0;
		if (N == 1) return 1;
		return F(N-1) + F(N-2);
	}
	
	public static long FastF(int N){
		if (N == 0) return 0;
		if (N == 1) return 1;
		if (cache[N] != 0) return cache[N];
		cache[N] = FastF(N-1) + FastF(N-2);
		return cache[N];
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i =0; i < 100; i++){
			System.out.println(i + " " + FastF(i));
		}

	}

}
