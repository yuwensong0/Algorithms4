package chapter2_5;

import java.util.Arrays;

public class Frequency {
	public static void show(String[] a) {
		Arrays.sort(a);
		Record[] records = new Record[a.length];
		records[0] = new Record(a[0]);
		int n = 0;
		for (int i = 1; i < a.length; i++) {
			if (a[i].equals(records[n].getWord())) records[n].addFrequence();
			else {
				records[++n] = new Record(a[i]);
			}
		}
		Arrays.sort(records, 0, n+1);
		for (int i = 0; i <= n; i++) {
			System.out.println(records[i].getWord() + "  " + records[i].getFrequence());
		}
		
	}
	private static class Record implements Comparable<Record>{
		private String word;
		private int frequence;
		public Record() {
			this.word = null;
			this.frequence = 1;
		}
		public Record(String word) {
			this.word = word;
			this.frequence = 1;
			
		}
		public String getWord() {
			return word;
		}
		public int getFrequence() {
			return frequence;
		}
		public void addFrequence() {
			frequence++;
		}
		public int compareTo(Record that) {
			if (this.frequence > that.frequence) return -1;
			if (this.frequence < that.frequence) return 1;
			return 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = {"w", "e", "a", "q", "a", "e", "a"};
		show(a);

	}

}
