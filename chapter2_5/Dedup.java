package chapter2_5;

import chapter2_3.Quick3wayOptimize;
import edu.princeton.cs.algs4.StdRandom;

public class Dedup {
	public static String[] dedup(String[] a) {
		StdRandom.shuffle(a);
		Quick3wayOptimize.sort(a);
		return deleteEqual(a);
	}

	private static String[] deleteEqual(String[] a) {
		if (a == null)
			return null;
		if (a.length <= 1)
			return a;
		int k = 0;
		for (int j = 1, i = 0; j < a.length; j++) {
			if (a[i].equals(a[j])) {
				a[j] = null;
				k++;
			} else {
				i = j;
			}
		}
		String[] t = new String[a.length - k];
		for (int i = 0, j = 0; i < a.length; i++) {
			if (a[i] != null) {
				t[j++] = a[i];
			}
		}
		return t;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = {"a", "a", "a", "a"};
		String[] b = {"a", "d","v", "e"};
		String[] c = {"v", "r", "w", "w"};
		String[] d = {"d"};
		String[] e = {};
		a = dedup(a);
		b = dedup(b);
		c = dedup(c);
		for (String s : a) {
			System.out.print(s +" ");
		}
		System.out.println();
		for (String s : b) {
			System.out.print(s +" ");
		}
		System.out.println();
		for (String s : c) {
			System.out.print(s +" ");
		}
		System.out.println();
		for (String s : d) {
			System.out.print(s +" ");
		}
		System.out.println();
		for (String s : e) {
			System.out.print(s +" ");
		}
		System.out.println();

	}

}
