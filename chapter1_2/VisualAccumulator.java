package chapter1_2;

import java.awt.Color;
import edu.princeton.cs.algs4.*;

public class VisualAccumulator {
	private double sum = 0;
	private int N = 0;
	
	public VisualAccumulator(){
		this(1000, 1.0);
	}
	public VisualAccumulator(int x, double y){
		StdDraw.setXscale(0, x);
		StdDraw.setYscale(0, y);
		StdDraw.setPenRadius(0.005);
	}
	
	public void accumulator(double val){
		sum += val;
		N++;
		StdDraw.setPenColor(Color.black);
		StdDraw.point(N, val);
		StdDraw.setPenColor(Color.RED);
		StdDraw.point(N, mean());
	}
	
	public double mean(){
		return sum / N;
	}
	
	public String toString(){
		return "Mean (" + N + " values): " + String.format("%7.5f", mean());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 1000;
		double y = 1.0;
		VisualAccumulator a = new VisualAccumulator(N, y);
		for (int i = 0; i < N; i++){
			a.accumulator(Math.random());
		}
		System.out.println(a);

	}

}
