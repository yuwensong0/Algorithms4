package chapter1_1;

public class Ex20 {
	public static double logFactorial(int N){
		if (N == 0) return 0;
		if (N == 1) return 0;
		return logFactorial(N-1) + Math.log(N);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(logFactorial(0));
		System.out.println(logFactorial(4033));

	}

}
