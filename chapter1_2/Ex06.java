package chapter1_2;

public class Ex06 {
	public static boolean rotation(String a, String b){
		String c = b + b;
		if (c.indexOf(a) >= 0) return true;
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(rotation("t", "t"));
		System.out.println(rotation("s1t", "t2s"));

	}

}
