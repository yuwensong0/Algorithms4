package chapter1_1;

public class Ex03 {
	public static boolean get3IntNumber(int x, int y, int z){
		return (x == y) && ( y == z);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean ans1 = get3IntNumber(1,2,3);
		boolean ans2 = get3IntNumber(1,2,2);
		boolean ans3 = get3IntNumber(1,1,1);
		System.out.printf("ans1 = %s, ans2 = %s, ans3 = %s", ans1, ans2, ans3);

	}

}
