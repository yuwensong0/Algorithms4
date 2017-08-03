package chapter2_5;

import java.util.*;

public class California {
	public static class CandidateComparator implements Comparator<String> {
		private static final String ORDER = "RWQOJMVAHBSGZXNTCIEKUPDYFL"; 
		public int compare(String a, String b) {
			int min = Math.min(a.length(), b.length());
			for (int i = 0; i < min; i++) {
				int indexA = ORDER.indexOf(a.charAt(i));
				int indexB = ORDER.indexOf(b.charAt(i));
				if (indexA != indexB) return indexA - indexB;
			}
			return a.length() - b.length();			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] candidate = {"QWE", "ASD", "ZXC", "A", "AA", "PPPP", "AAAAAA"};
		Arrays.sort(candidate, new California.CandidateComparator());
		for (String s : candidate) {
			System.out.println(s);
		}

	}

}
