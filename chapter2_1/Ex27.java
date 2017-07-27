package chapter2_1;

public class Ex27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int T = 100;
		for (int N = 128; true; N *= 2) {
			double t1 = SortCompare.timeRandomInput("Shell", N, T);
			double t2 = SortCompare.timeRandomInput("Insertion", N, T);
			double t3 = SortCompare.timeRandomInput("Selection", N, T);
			System.out.printf("Shell : %6.4f Insertion : %6.4f Selection : %6.4f", t1, t2, t3);
			System.out.println();
		}

	}

}
