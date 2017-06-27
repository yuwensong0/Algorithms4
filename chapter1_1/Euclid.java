package chapter1_1;

public class Euclid {
	public static int gcd(int a, int b){
		if(a > b){
			int temp = a;
			a = b;
			b = temp;
		}
		if(a == 0){
			return b;
		} else {
			return gcd(b % a, a);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int re = Euclid.gcd(13, 8);
		System.out.println("re: " + re);
		int re1 = Euclid.gcd(8, 13);
		System.out.println("re1: " + re1);
		int re2 = Euclid.gcd(12, 18);
		System.out.println("re2: " + re2);
	}

}
