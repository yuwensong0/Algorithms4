package chapter1_4;

import java.util.*;

public class TwoSumFaster {
	public static int count(int[] a) {
		return count(a, 0);
	}
	public static int count(int[] a, int target) {
		int cnt = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			int temp = target - a[i];
			if (target >= 0 && a[i] < 0 && temp < 0) {
				continue;
			}
			if (target < 0 && a[i] > 0 && temp > 0) {
				continue;
			}
			if (map.containsKey(temp) && !map.containsKey(a[i])) {
				cnt++;
				map.put(a[i], temp);
			}  else {
				map.put(a[i], temp);
			}
		}
		//for (int k : map.keySet()) {
			//System.out.println(k + " : " + map.get(k));
		//}
		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,1,2,2,3,31,1,1,3,0,4,4,-1};
		int cnt = count(a, 3);
		System.out.println(cnt);
		
	}

}
