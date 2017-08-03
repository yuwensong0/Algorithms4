package chapter2_5;

import java.util.Arrays;

public class Version implements Comparable<Version> {
	private int[] a;
	private int N;
	private String version;

	public Version() {

	}

	public Version(String s) {
		this.version = s;
		String[] t = s.split("\\.");
		N = t.length;
		a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(t[i]);
		}
	}

	public String getVersion() {
		return version;
	}

	public int compareTo(Version that) {
		int k = 0;
		while (k < N) {
			if (this.a[k] < that.a[k])
				return -1;
			if (this.a[k] > that.a[k])
				return 1;
			k++;
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Version a = new Version("115.10.1");
		Version b = new Version("115.10.2");
		Version c = new Version("115.1.1");
		Version[] versions = { a, b, c };
		Arrays.sort(versions);
		for (Version v : versions) {
			System.out.println(v.getVersion());
		}

	}

}
