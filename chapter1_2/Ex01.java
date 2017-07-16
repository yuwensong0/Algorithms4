package chapter1_2;

import edu.princeton.cs.algs4.*;

public class Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N= 10;
		double min = Double.MAX_VALUE;
		int first = 0;
		int second = 0;
		Point2D[] a = new Point2D[N];
		for (int i = 0; i < N; i++){
			a[i] = new Point2D(Math.random(), Math.random());
			StdDraw.setPenRadius(0.005);
			a[i].draw();
		}
		for (int i = 0; i < N; i++){
			for (int j = i + 1; j < N; j++){
				if (a[i].distanceTo(a[j]) < min){
					min = a[i].distanceTo(a[j]);
					first = i;
					second = j;
				}
			}
		}
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.line(a[first].x(), a[first].y(), a[second].x(), a[second].y());
		System.out.println("min = " + min);
	}

}
