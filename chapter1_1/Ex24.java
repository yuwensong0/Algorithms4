package chapter1_1;

public class Ex24 {
	public static int euclidWithDetail(int p, int q){
		if (p > q){
			int temp = p;
			p = q;
			q = temp;
		}
		System.out.println("p=" + p + ", q=" + q);
		if (p == 0) return q;
		return euclidWithDetail(q % p, p);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = euclidWithDetail(1111111, 1234567);
		System.out.println(i);
	}

}
