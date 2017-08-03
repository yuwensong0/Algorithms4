package chapter2_5;

import java.util.Arrays;

public class Domain implements Comparable<Domain> {
	private String domain;
	private String[] part;

	public Domain() {

	}

	public Domain(String domain) {
		this.domain = domain;
		part = domain.split("\\.");
	}

	public String toString() {
		return domain;
	}

	public int compareTo(Domain that) {
		int i = this.part.length - 1;
		int j = that.part.length - 1;
		for (; i >= 0 && j >= 0; i--, j--) {
			int re = this.part[i].compareTo(that.part[j]);
			if (re != 0)
				return re;
		}
		return i - j;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Domain a = new Domain("a.b.d");
		Domain b = new Domain("r.s.w.q");
		Domain c = new Domain("a.b.e");
		Domain d = new Domain("a.p.s.e");
		Domain e = new Domain("a.b");
		Domain[] t = { a, b, c, d, e };
		Arrays.sort(t);
		for (Domain domain : t) {
			System.out.println(domain);
		}
	}

}
