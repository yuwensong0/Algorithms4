package chapter2_1;

public class DoubleTest {
	public static void go(String alg, int N, int T) {
		double t1 = SortCompare.timeRandomInput(alg, N, T);
		double t2 = SortCompare.timeRandomInput(alg, 2*N, T);
		System.out.printf("size = %-6d, t1 = %6.4f, t2 = %6.4f, t2/t1 = %6.4f", N, t1, t2, t2/t1);
	}	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 10000; 
		int T = 10000;
		//String alg = "Insertion";
		//String alg = "Selection";
		String alg = "Shell";
		go(alg, N, T);

	}

}
