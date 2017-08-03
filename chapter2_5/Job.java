package chapter2_5;

import java.util.Arrays;

public class Job implements Comparable<Job> {
	private String name;
	private double time;
	
	public Job() {
		
	}
	public Job(String name, double time){
		this.name = name;
		this.time = time;
	}
	
	public String getName() {
		return name;
	}
	
	public double getTime() {
		return time;
	}
	
	public int compareTo(Job that) {
		if (this.time > that.time) return 1;
		if (this.time < that.time) return -1;
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Job a = new Job("a", 1.0);
		Job b = new Job("b", 0.0);
		Job c = new Job("c", 2.0);
		Job[] t = {a, b, c};
		Arrays.sort(t);
		for (Job i : t) {
			System.out.println(i.getName());
		}

	}

}
