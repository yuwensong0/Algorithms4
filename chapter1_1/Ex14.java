package chapter1_1;

public class Ex14 {
	public static int lg(int N) throws Exception{
		if (N <= 0) throw new Exception(N + " less or equal zero");
		int x = 1;
		int n = 0;
		while (x <= N){
			x *= 2;
			n++;
		}
		return --n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		System.out.println(lg(8));
		System.out.println(lg(10));
		System.out.println(lg(0));
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
