package chapter1_4;

import chapter1_2.Bag;
public class Ex44 {
	public static void go(int a) {
		int N = a;
		Bag<Integer> bag = new Bag<>();
		while (true) {
			int i = (int) (Math.random() * N);
			if (!bag.contains(i)) bag.add(i);
			else break;
		}
		System.out.println(bag.size() + " : " + Math.sqrt(Math.PI * N / 2));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 100000;
		int time = 10;
		for (int i = 0; i <= time; i++) {
			go(N);
		}

	}

}
