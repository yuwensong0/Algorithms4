package chapter2_5;

import java.util.*;
import chapter2_4.MinPQ;

public class LPT {
	public static void show(Job[] a, int M) {
		int N = a.length;
		MinPQ<Processor> processorPQ = new MinPQ<>(M);
		for (int i = 0; i < M; i++) {
			processorPQ.insert(new Processor());
		}
		Arrays.sort(a);
		for (int i = N - 1; i >= 0; i--) {
			Processor processor = processorPQ.delMin();
			processor.add(a[i]);
			processorPQ.insert(processor);
		}
		for (int i = 0; i < M; i++) {
			Processor processor = processorPQ.delMin();
			ArrayList<Job> jobs = processor.getJobs();
			System.out.print("processor " + i + " : ");
			System.out.print("totlTime : " + processor.getTotalTime() + "  ");
			for (Job job : jobs) {
				System.out.print(job.getName() + "  " + job.getTime() + ";  ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Job a = new Job("a", 1.0);
		Job b = new Job("b", 0.0);
		Job c = new Job("c", 2.0);
		Job d = new Job("d", 4.0);
		Job e = new Job("e", 2.0);
		Job f = new Job("f", 5.0);
		Job g = new Job("g", 9.0);
		Job[] t = { a, b, c, d, e, f, g };
		show(t, 3);

	}

}
