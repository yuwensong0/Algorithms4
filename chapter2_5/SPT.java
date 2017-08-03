package chapter2_5;

import java.util.Arrays;

public class SPT {
	public static void show(Job[] a) {
		Arrays.sort(a);
		for (Job i : a) {
			System.out.println(i.getName());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Job a = new Job("a", 1.0);
		Job b = new Job("b", 0.0);
		Job c = new Job("c", 2.0);
		Job[] t = {a, b, c};
		show(t);

	}

}
