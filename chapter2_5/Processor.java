package chapter2_5;

import java.util.*;

public class Processor implements Comparable<Processor> {
	private ArrayList<Job> jobs;
	private double totalTime;

	public Processor() {
		jobs = new ArrayList<>();
		totalTime = 0.0;
	}

	public void add(Job job) {
		jobs.add(job);
		totalTime += job.getTime();
	}

	public ArrayList<Job> getJobs() {
		return jobs;
	}

	public double getTotalTime() {
		return totalTime;
	}

	public int compareTo(Processor that) {
		if (this.totalTime > that.totalTime)
			return 1;
		if (this.totalTime < that.totalTime)
			return -1;
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
