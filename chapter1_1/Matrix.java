package chapter1_1;

import java.util.Arrays;

public class Matrix {
	public static double dot(double[] x, double[] y){
		double re = 0.0;
		for (int i = 0; i < x.length; i++){
			re += x[i] * y[i];
		}
		return re;
	}
	
	public static double[][] mult(double[][] a, double[][] b){
		double[][] c = new double[a.length][b[0].length];
		for (int i = 0; i < c.length; i++){
			for (int j = 0; j < c[i].length; j++){
				for (int inner = 0; inner < b.length; inner++){
					c[i][j] += a[i][inner] * b[inner][j];
				}
			}
		}
		return c;
	}
	
	public static double[][] transpose(double[][] a){
		double[][] b = new double[a[0].length][a.length];
		for (int i = 0; i < a.length; i++){
			for (int j = 0; j < a[i].length; j++){
				b[j][i] = a[i][j];
			}
		}
		return b;
	}
	
	public static double[] mult(double[][] a, double[] x){
		double[] re = new double[a.length];
		for (int i = 0; i < a.length; i++){
			for (int j = 0; j < a[i].length; j++){
				re[i] += a[i][j] * x[j];
			}
		}
		return re;
	}
	
	public static double[] mult(double[] y, double[][] a){
		double[] re = new double[a[0].length];
		for (int i = 0; i < a.length; i++){
			for (int j = 0; j < a[i].length; j++){
				re[j] += a[i][j] * y[i];
			}
		}
		return re;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] x = {1,2,3};
		double[] y = {1,0,2};
		double[] z = {1,2};
		double[][] a = {{1,2}, {0,1}, {1,0}};
		double[][] b = {{1,0,2}, {0,1,1}};
		System.out.println(dot(x, y));
		System.out.println(Arrays.deepToString(mult(a, b)));
		System.out.println(Arrays.toString(mult(a, z)));
		System.out.println(Arrays.toString(mult(b, x)));
		System.out.println(Arrays.deepToString(transpose(a)));
		System.out.println(Arrays.toString(mult(x, a)));
		

	}

}
